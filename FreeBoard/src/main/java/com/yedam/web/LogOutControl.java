package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;

public class LogOutControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// session 삭제.
		HttpSession session = req.getSession(); //세션값 가져오기
		session.invalidate(); //세션값 삭제
		
		req.getRequestDispatcher("WEB-INF/jsp/loginForm.jsp").forward(req, resp);

	}

}
