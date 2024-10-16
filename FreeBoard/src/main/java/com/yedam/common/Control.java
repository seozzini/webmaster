package com.yedam.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//인터페이스이므로 메소드만 지정하고 끝낼것임
public interface Control {
	void exec(HttpServletRequest req, HttpServletResponse resp)   //매개값 2개 req 요청정보 담은것, resp 응답처리
			throws ServletException, IOException; //호출하는 곳으로 예외 떠넘김

}
