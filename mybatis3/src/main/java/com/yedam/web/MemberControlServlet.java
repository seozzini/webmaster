package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.dao.MemberMapper;
import com.yedam.vo.Member;

// 서블릿 생성 생명주기: 객체생성 -> init -> service -> destroy(서버가 종료될시)

@WebServlet("/member.action") // 호출URL
public class MemberControlServlet extends HttpServlet {

	public MemberControlServlet() {
		System.out.println("MemberControl 객체 생성"); // 최초요청시에만
	}

	@Override // HttpServlet클래스가 가진 메소드 오버라이딩
	public void init(ServletConfig config) throws ServletException {
		System.out.println("최초요청이면 init 실행"); // 최초요청시에만
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		System.out.println("서블릿을 요청할때마다 실행"); // 매번실행(기능은 여기에) & doget, dopost 모두 실행함(구분하고 싶으면 안에 기능 넣어야 함)

		// 매퍼복붙
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		MemberMapper dao = sqlSession.getMapper(MemberMapper.class);

		// 변수선언
		String id = req.getParameter("mid"); // http://localhost/mybatis3/member.action?mid=user01 //물음표 뒤에가 파라미터, 파라미터
												// 값을 읽어오면, 변수에저장

		// get: 조회화면, post:삭제처리.
		// req(요청정보)에 있는 겟메소드는 요청정보 구분하는 메소드임
		
		if (req.getMethod().equals("GET")) { // 단건조회.

			// MemberMapper.java로 이동 및 selectMember 단건조회 만듦 -> 메소드 이름 카피 후 MemberMapper.xml로
			// 이동 후 쿼리작성

			// id값은 member변수가 가짐(get으로 원하는값 가져오기)
			Member member = dao.selectMember(id);
			// 값이 없으면 조회된 정보가 없습니다 출력
			if (member == null) {
				resp.getWriter().print("조회된 정보가 없습니다");
				return;
			}
			// 값이 있으면 표 형식으로 출력
			String str = "<h3>회원정보</h3>";
			str += "<form action='member.action' method='post'>"; // method: 연결방식
			// form안의 input은 모두 파라미터임 /name은 파라미터의 이름(mid 멤버아이디)
			str += "<input type='hidden' name='mid' value='" + member.getMemberId() + "'>";
			str += "<table border='1'>"; // 줄맞추려고
			str += "<tr><th>회원아이디</th><td>" + member.getMemberId() + "</td></tr>";
			str += "<tr><th>회원이름</th><td>" + member.getMemberName() + "</td></tr>";
			str += "<tr><th>회원연락처</th><td>" + member.getPhone() + "</td></tr>";
			str += "<tr><td colspan='2'><input type='submit'></td></tr>";
			str += "</table>";
			str += "</form>";
			str += "<a href = 'MemberListServlet'>목록으로</a>";
			resp.getWriter().print(str);
		} else if (req.getMethod().equals("POST")) {// 삭제처리.
			if (dao.deleteMember(id) == 1) { // 정상 삭제처리시
				resp.getWriter().print("<p>삭제완료</p>");
			} else { // 삭제안될시
				resp.getWriter().print("<p>삭제할 회원없음.</p>");
			}
			resp.getWriter().print("<a href = 'MemberListServlet'>목록으로</a>"); // 목록으로 가기
		}
		;
	}

	@Override
	public void destroy() {
		System.out.println("서버가 종료될때 한번 실행");
	}
}
