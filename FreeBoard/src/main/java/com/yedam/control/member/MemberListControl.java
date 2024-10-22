package com.yedam.control.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

//인터페이스 구현하는 구현클래스는 인터페이스에 있는 추상 메소드를 반드시 구현해야함.

public class MemberListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) { //exec이라는 메소드에 여러 기능을 넣자! 나중에..
		System.out.println("MemberListControl"); //정상 구현되는지 먼저 확인~~
		MemberService svc = new MemberServiceImpl();
		List<MemberVO> list = svc.memberList();
		
		req.setAttribute("memberList", list); //매개값으로 전달받은 값에 값을 보태어 밑으로 전달함
		
		try {
			// memberList.do로 요청된 페이지에서 memberList.jsp 요청재지정. (url은 do인데, 보여지는 페이지는 jsp라는 말)
			req.getRequestDispatcher("admin/memberList.tiles").forward(req, resp);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
