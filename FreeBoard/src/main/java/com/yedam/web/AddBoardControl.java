package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//요청 정보에 한글이 포함된 경우 한글 처리해줘야 한다.
		req.setCharacterEncoding("utf-8");
		String savePath = req.getServletContext().getRealPath("images"); //context: 프로젝트 이름
		int maxSize = 1024 * 1025 * 5; //5MB
		
		//Multipart요청에 대한 처리로 변경.
		MultipartRequest mr = new MultipartRequest(// 객체생성. 매개값 필요
				req         // 1.요청정보
				,savePath   // 2.저장경로
				,maxSize    // 3.파일 최대 크기
				,"utf-8"    // 4.encoding 방식.
				,new DefaultFileRenamePolicy()  // 5.리네임정책(을 구현한 클래스 인스턴스/같은 이름이면 덮어쓰기)
				);
		
	
		// title, content, writer 3개 파라미터(boardForm.jsp참고). db등록 -> 결과는 목록으로 보여주기.
		// key=value&key=value text처리.
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		String writer = mr.getParameter("writer");
		String img = mr.getFilesystemName("img");
		
		//필드에 값채우기
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		board.setImg(img);
		
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

