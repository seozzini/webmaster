package com.yedam.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

@WebServlet("*.do") //.do만 하면 프론트컨트롤러 실행되도록 url 지정해둠.
public class FrontController extends HttpServlet {
	
	Map<String, Control> map; //key는 url패턴이므로 String,common에 control인터페이스만들어서 value로 control구현클래스가 밸류값!
	
	public FrontController() {
		//System.out.println("객체 생성");
		map = new HashMap<>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// System.out.println("init호출");
		map.put("/memberList.do", new MemberListControl());
		
		// 회원등록 1)등록화면 2)등록처리
		// 1)등록화면
		map.put("/memberAddForm.do", new MemberAddFormControl());
		map.put("/memberAdd.do", new MemberAddControl());
		
		//게시판 관련.
		map.put("/boardList.do", new BoardListControl()); //글 목록보기
		map.put("/board.do", new BoardControl()); //상세화면보기
		map.put("/addBoardForm.do", new AddBoardFrom()); //화면 열어주는 control
		map.put("/addBoard.do", new AddBoardControl()); //게시글등록하는 control
		map.put("/modifyBoard.do", new ModifyBoardControl());//게시글 수정(수정화면->변경처리) control 요청방식에 따라 다름(get:화면열기 post:data수정)
		map.put("/removeBoard.do", new RemoveBoardControl());//게시글 삭제
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// System.out.println("service호출");
		// 요청페이지가 뭔지? 알면 거기에 담긴 객체 반환 가능
		String uri = req.getRequestURI(); // uri: 전체 url에서 괄호부분 제외 (http://localhost) /FreeBoard/add.do 프로젝트이름,마지막 반환되는페이지
		String context = req.getContextPath(); // /FreeBoard 프로젝트 이름 반환
		String page = uri.substring(context.length()); // substring통해 uri-context = /add.do
		
		Control control = map.get(page); //키값 넣으면 밸류값 가져오는 메소드
		control.exec(req, resp); //컨트롤은 exec 메소드 가지고 있을 것임
	}
}
