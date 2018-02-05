package com.bajek.ssfz.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bajek.ssfz.vo.MemberVO;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	// 회원 등록
	public void insertMember(MemberVO vo) {
		mybatis.insert("MemberDAO.insertMember", vo);
	}

	// 회원 목록
	public List<MemberVO> memberList(MemberVO vo) {
		return mybatis.selectList("MemberDAO.memberList", vo);
	}

	// 회원상세정보
	public MemberVO viewMember(String userId) {
		return mybatis.selectOne("MemberDAO.viewMember", userId);
	}

    public void deleteMember(String userId) {
        mybatis.delete("MemberDAO.deleteMember", userId);
    }
	
	public void updateMember(MemberVO vo) {
		mybatis.update("MemberDAO.updateMember", vo);
	}

	public boolean checkPw(String userId, String userPw) {
		boolean result = false;
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("userPw", userPw);

		int count = mybatis.selectOne("MemberDAO.checkPW", map);
		if (count == 1)
			result = true;
		return result;
	}

}
