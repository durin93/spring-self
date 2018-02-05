package com.bajek.ssfz.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.bajek.ssfz.vo.BoardVO;

public interface BoardService {

	public void insertBoard(BoardVO vo) throws Exception;

	public void updateBoard(BoardVO vo) throws Exception;

	public void deleteBoard(int seq) throws Exception;

	public BoardVO getBoard(int seq) throws Exception;

	public List<BoardVO> getBoardList(BoardVO vo) throws Exception;

	public void increaseViewcnt(int bno, HttpSession session) throws Exception;

}
