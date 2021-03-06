package com.bajek.ssfz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bajek.ssfz.vo.BoardVO;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	public void insertBoard(BoardVO vo) {
		mybatis.insert("BoardDAO.insertBoard", vo);
	}

	public void updateBoard(BoardVO vo) {
		mybatis.update("BoardDAO.updateBoard", vo);
	}

	public void deleteBoard(int seq) {
		mybatis.delete("BoardDAO.deleteBoard", seq);
	}

	public BoardVO getBoard(int seq) {
		return (BoardVO) mybatis.selectOne("BoardDAO.getBoard", seq);
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		return mybatis.selectList("BoardDAO.getBoardList", vo);
	}

	// 게시글 조회수 증가
	public void increaseViewcnt(int seq) throws Exception {
		mybatis.update("BoardDAO.increaseViewcnt", seq);
	}

}
