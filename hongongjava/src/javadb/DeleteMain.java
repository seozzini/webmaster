package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteMain {

	public static void main(String[] args) {
		// 연결
		Connection conn = null;
		
		//jdbc 등록
		try {
			Class.forName("oracle.jdbc.OracleDriver"); //dbms에서 지원해주는 오라클 드라이버 클래스 확인 후 로딩
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"java",
					"1234"
					);
			System.out.println("연결 성공");
			
			//데이터 삭제
			String sql = "delete from boards where bno=?";//bno:번호에 의해 삭제
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 2); //첫번째 물음표, 2번
			int rows = pstmt.executeUpdate(); //select만 쿼리, 나머지 업데이트
			System.out.println("삭제행 수 :"+rows);
			
			pstmt.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
					System.out.println("연결 끊기");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
