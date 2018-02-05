package com.bajek.ssfz.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bajek.ssfz.service.BoardService;
import com.bajek.ssfz.vo.BoardVO;

@Controller
@RequestMapping("/board/") // url 요청이 /board/로 시작하는 것은 여기서 처리. ex) board/abc,
public class BoardController {

	@Autowired
	private BoardService boardService;


	
	@RequestMapping(value = "/write")
	public String writeView(){
		return "board/board_write";
	}
	

	@RequestMapping(value = "/insertBoard")
	public String insertBoard(BoardVO vo, RedirectAttributes rttr) throws Exception {
		System.out.println("/board/insertBoard POST방식 입니다.");
		System.out.println(vo.toString());
		boardService.insertBoard(vo);

		// return "/board/succes" 대신 return "redirect:/board/listAll"; 입력합니다.
		// Model 대신 RedirectAttributes를 사용합니다.
		// Model을 사용하게되면 리다이렉트를해도 URL에
		// result=성공이 계속해서 남아 있습니다.
		// RedirectAttributes는 리다이렉트 시점에 한 번만 사용되는 데이터를
		// 만들 수 있습니다.(addFlashAttribute())
		// rttr.addFlashAttribute("msg", "success");를 입력하게 되면
		// 한 번만 사용되는 데이터 + URL 상에는 보이지 않는 숨겨진 데이터의 형태로 전달
		// 되기때문에 URL상에서는 확인이 불가능합니다.

		rttr.addFlashAttribute("msg", "성공");
		return "redirect:/board/list";
	}

	@RequestMapping(value = "/list")
	public String getBoardList(BoardVO vo, Model model) throws Exception {
		System.out.println("전체 글 목록");
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "board/board_list";
	}
	
	
	  // 03. 게시글 상세내용 조회, 게시글 조회수 증가 처리
    // @RequestParam : get/post방식으로 전달된 변수 1개
    // HttpSession 세션객체
    @RequestMapping(value="/view", method=RequestMethod.GET)
    public ModelAndView view(@RequestParam int seq, HttpSession session) throws Exception{
    	
		System.out.println("글 내용보기 "+seq+"번글");

        // 조회수 증가 처리
        boardService.increaseViewcnt(seq, session);
        // 모델(데이터)+뷰(화면)를 함께 전달하는 객체
        ModelAndView mav = new ModelAndView();
        // 뷰의 이름
        mav.setViewName("board/board_view");
        // 뷰에 전달할 데이터
        mav.addObject("board", boardService.getBoard(seq));
        return mav;
    }
	
    // 04. 게시글 수정
    // 폼에서 입력한 내용들은 @ModelAttribute BoardVO vo로 전달됨
    @RequestMapping(value="update.do", method=RequestMethod.POST)
    public String update(@ModelAttribute BoardVO vo) throws Exception{
        boardService.updateBoard(vo);
        return "redirect:/board/list";
    }
    
    // 05. 게시글 삭제
    @RequestMapping("delete.do")
    public String delete(@RequestParam int bno) throws Exception{
        boardService.deleteBoard(bno);
        return "redirect:/board/list";
    }
    
    
    
	
	

}
