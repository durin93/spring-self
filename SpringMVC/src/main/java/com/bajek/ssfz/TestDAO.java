//package com.bajek.ssfz;
//
//import javax.inject.Inject;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import com.bajek.ssfz.dao.MemberDAO;
//import com.bajek.ssfz.vo.MemberVO;
//
//@Controller
//public class TestDAO {
//    
//    @Inject
//    private MemberDAO dao;
//    
//    @RequestMapping(value = "/testDAO", method = RequestMethod.GET)
//    public void testDAO(){
//        MemberVO vo = new MemberVO();
//        vo.setUser_id("durin22");
//        vo.setUser_pw("1234");
//        vo.setUser_email("github.com/durin93");
//        
//        dao.insertUser(vo);
//    }
//}
//
