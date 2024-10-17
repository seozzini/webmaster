package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//요청 정보에 한글이 포함된 경우 한글 처리해줘야 한다.
		req.setCharacterEncoding("utf-8");
		// title, content, writer 3개 파라미터(boardForm.jsp참고). db등록 -> 결과는 목록으로 보여주기.
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		
		//필드에 값채우기
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		
		BoardService svc = new BoardServiceImpl();
		try {
			// 정상등록 - 글목록 이동
		svc.registerBoard(board);
		resp.sendRedirect("boardList.do");
		}catch(Exception e){
			// 비정상처리 - 등록화면 이동
			req.setAttribute("msg", "등록하는중 오류가 발생했습니다");
			req.getRequestDispatcher("WEB-INF/jsp/boardForm.jsp")//
					.forward(req, resp);
		}
	}

}
