package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class ModifyBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// GET(방식 요청): 수정화면 , POST: 수정처리.
		// 몇번글에 대한 요청인지, 파라미터 선언
		req.setCharacterEncoding("utf-8");
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");

		BoardService svc = new BoardServiceImpl();

		if (req.getMethod().equals("GET")) {
			BoardVO board = svc.searchBoard(Integer.parseInt(bno));

			// req(요청정보)
			req.setAttribute("boardvo", board);
			req.setAttribute("page", page);
			req.setAttribute("searchCondition", sc);
			req.setAttribute("keyword", kw);
			req.getRequestDispatcher("WEB-INF/jsp/modifyForm.jsp").forward(req, resp);

		} else if (req.getMethod().equals("POST")) {
			String title = req.getParameter("title");
			String content = req.getParameter("content");

			BoardVO board = new BoardVO();
			board.setBoardNo(Integer.parseInt(bno));
			board.setTitle(title);
			board.setContent(content);

			if (svc.modifyBoard(board)) {
				// 정상처리 - 목록으로 이동
				resp.sendRedirect("boardList2.do?page="+page+"&searchCondition="+sc+"&keyword="+kw);
			} else {
				board = svc.searchBoard(Integer.parseInt(bno));

				// req(요청정보)
				req.setAttribute("boardvo", board);
				req.setAttribute("msg", "수정할 게시글이 없습니다"); //수정 안 된 것은 업데이트 한 게 0이라는 뜻이라서
				req.getRequestDispatcher("WEB-INF/jsp/modifyForm.jsp").forward(req, resp);

			}
		}

	}

}
