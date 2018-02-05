package com.bajek.ssfz.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bajek.ssfz.dao.MemberDAO;
import com.bajek.ssfz.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	// MemberDAOImpl 객체를 스프링에서 생성하여 주입시킴
	@Inject
	MemberDAO memberDAO;

	@Override
	public List<MemberVO> memberList(MemberVO vo) {
		return memberDAO.memberList(vo);
	}

	@Override
	public void insertMember(MemberVO vo) {
		memberDAO.insertMember(vo);
	}

	@Override
	public MemberVO viewMember(String userId) {
		return memberDAO.viewMember(userId);
	}

	@Override
	public void deleteMember(String userId) {
		memberDAO.deleteMember(userId);
	}

	@Override
	public void updateMember(MemberVO vo) {
		memberDAO.updateMember(vo);

	}

	// 06. 회원 정보 수정 및 삭제를 위한 비밀번호 체크
	@Override
	public boolean checkPw(String userId, String userPw) {
		return memberDAO.checkPw(userId, userPw);
	}

}
