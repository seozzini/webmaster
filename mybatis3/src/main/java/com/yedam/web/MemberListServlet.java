package com.yedam.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.dao.MemberMapper;
import com.yedam.vo.Member;

//IOC (제어의 역전)
//객체생성 -> init()->service() -> destroy() : 서블릿의 생명주기.

/**
 * Servlet implementation class MemberListServlet
 */
@WebServlet("/MemberListServlet")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("웹브라우저");
		
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		MemberMapper dao = sqlSession.getMapper(MemberMapper.class);
		
		List<Member> result = dao.members();
		
		String str = "";
		str += "<h3>회원목록</h3>";
		str += "<table border='1'>";
		
		str += "<thead>";
		str += "<tr>";
		str += "<th>회원아이디</th>";
		str += "<th>회원이름</th>";
		str += "<th>회원연락처</th>";
		str += "</tr>";
		str += "</thead>";
		
		str += "<tbody>";
		for(Member val : result) {
		str += "<tr><td><a href='member.action?mid="+val.getMemberId()+"'>"//
				+val.getMemberId() +"</a></td>"; //링크로 찍어봄
		str += "<td>" + val.getMemberName()+"</td>";
		str += "<td>" +val.getPhone()+"</td></tr>";
		}
		str += "</tbody>";
		str += "</table>";
		
		response.getWriter().print(str);
	}
		
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		doGet(request,response);
	}

}
