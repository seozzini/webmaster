package com.yedam.control.member;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class MemberAddControl implements Control{

	//파라미터
	//?mid=user111&mname=홍길순3&passwd=1111&phone=010-1133-4455
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("MemberAddControl");
		String id = req.getParameter("mid");
		String nm = req.getParameter("mname");
		String pw = req.getParameter("passwd");
		String pn = req.getParameter("phone");
		
		//VO에 값채워주기
		MemberVO mvo = new MemberVO();
		mvo.setMemberId(id);
		mvo.setMemberName(nm);
		mvo.setPassword(pw);
		mvo.setPhone(pn);
		
		MemberService svc = new MemberServiceImpl();
		try {
		svc.addMember(mvo);
			// 목록페이지로 이동.(값이 잘 등록되면)
			//페이지 지정방식: 포워드, 리다이렉트 두 개 있음
			resp.sendRedirect("memberList.do");
		} catch(Exception e) {
			// 등록화면으로 이동.(등록되지 않으면)
			e.printStackTrace();
			resp.sendRedirect("memberAddForm.do");
		}
		
	}

}
