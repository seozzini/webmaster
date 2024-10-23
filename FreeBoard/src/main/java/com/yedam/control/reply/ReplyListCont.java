package com.yedam.control.reply;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class ReplyListCont implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//게시글번호(bno), 페이지번호(page)
		resp.setContentType("text/json;charset=utf-8");
		
		String bno = req.getParameter("bno"); //게시글 번호 파라미터로 받기
		String page = req.getParameter("page"); 
		
		ReplyService svc = new ReplyServiceImpl(); //목록 가져오기
		
		List<ReplyVO> list = svc.replyList(Integer.parseInt(bno),Integer.parseInt(page));//List컬렉션으로 반환됨
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(list); //자바객체 -> json문자열 변경
		
		resp.getWriter().print(json);
	}

}
