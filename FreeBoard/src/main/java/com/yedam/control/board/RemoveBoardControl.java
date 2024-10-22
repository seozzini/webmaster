package com.yedam.control.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class RemoveBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String bno = req.getParameter("bno");

		BoardService svc = new BoardServiceImpl();

		if (req.getMethod().equals("GET")) {
			BoardVO board = svc.searchBoard(Integer.parseInt(bno));

			// req(요청정보)
			req.setAttribute("boardvo", board);
			req.getRequestDispatcher("WEB-INF/jsp/removeForm.jsp").forward(req, resp);

		} else if (req.getMethod().equals("POST")) {
			BoardVO board = new BoardVO();
			board.setBoardNo(Integer.parseInt(bno));

			if (svc.removeBoard(Integer.parseInt(bno))) {
				// 정상처리 - 목록으로 이동
				resp.sendRedirect("boardList.do");
			} else {
				board = svc.searchBoard(Integer.parseInt(bno));

				// req(요청정보)
				req.setAttribute("boardvo", board);
				req.setAttribute("msg", "삭제할 게시글이 없습니다"); //수정 안 된 것은 업데이트 한 게 0이라는 뜻이라서
				req.getRequestDispatcher("WEB-INF/jsp/removeForm.jsp").forward(req, resp);

			}
		}

	}

}
