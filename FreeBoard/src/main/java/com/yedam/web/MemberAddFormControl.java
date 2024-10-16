package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class MemberAddFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// jsp open(데이터 가져올 필요없이 화면만 열어주는 기능)
		req.getRequestDispatcher("WEB-INF/jsp/memberAddForm.jsp").forward(req, resp);  //트라이캐치 불편 예외떠넘김
		
	}

}
