package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectMain {

	public static void main(String[] args) {
		// 데이터 조회
		//연결
		Connection conn = null;
		
		//jdbc 등록
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"java",
					"1234"
					);//예외처리:add catch cause 로 해주기***********
			System.out.println("연결성공");
			
			//데이터 조회
			String sql = "select * from boards " +
						 "where bwriter=?"; //조건 변경시 sql문만 바꾸면 됨 where절은 끊어주기 
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"글쓴이1");
			
			ResultSet rs = pstmt.executeQuery(); //결과 담기
			
			//보드 객체 만들기(먼저 Board Class 만든 후 실행)
			while(rs.next()) { //data 가 많으니 while 로 하기
				Board bd = new Board();
				bd.setBno(rs.getInt(1));
				bd.setBtitle(rs.getString(2));
				bd.setBcontent(rs.getString(3));
				bd.setBwriter(rs.getString(5));
				bd.setBdate(rs.getDate(4)); //테이블 순서 맞추기
				
				System.out.println(bd);
			}
			
			pstmt.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (conn != null) { //연결이 되었다면? -끊기 전에 모든 작업을 해야함
				try {
					conn.close();//연결끊기(Database 는 사용 후 꼭 닫아줘야 함)
					System.out.println("연결끊기");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
