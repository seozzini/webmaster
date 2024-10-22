package com.yedam.control.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// board.do 요청이 들어오면 실행할 컨트롤 -> 상세조회(bno:게시판 번호 파라미터) -> 조회 ->결과를 board.jsp에서 출력함
		// 파라미터 선언
		// 검색조건(1.파라미터 받기).
		String bno =req.getParameter("bno");
		String page =req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		BoardService svc = new BoardServiceImpl();
		BoardVO board = svc.searchBoard(Integer.parseInt(bno));
		
		//조회해서 어트리뷰트에 값담기
		req.setAttribute("boardvo", board);
		req.setAttribute("page", page);
		// 검색조건(2.attribute 전달하기)
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		
		//오픈할페이지 설정
		req.getRequestDispatcher("WEB-INF/jsp/board.jsp").forward(req, resp);
		
	}

}
