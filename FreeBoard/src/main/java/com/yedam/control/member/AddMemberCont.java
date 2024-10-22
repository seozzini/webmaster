package com.yedam.control.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class AddMemberCont implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// id,name,phone, pw:'1111' 임의등록
		MemberVO member = new MemberVO();
		member.setMemberId(req.getParameter("id"));
		member.setMemberName(req.getParameter("name"));
		member.setPhone(req.getParameter("phone"));
		member.setPassword("1111");
		
		MemberService svc = new MemberServiceImpl();
		try {
			svc.addMember(member);
			// {"retCode":"OK"}
			resp.getWriter().print("{\"retCode\":\"OK\"}");
		} catch (Exception e) {
			// {"retCode":"FAIL"}
			resp.getWriter().print("{\"retCode\":\"FAIL\"}");
		}

	}

}
