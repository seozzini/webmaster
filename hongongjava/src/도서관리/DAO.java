package 도서관리;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	Connection conn = null;
	PreparedStatement psmt;
	ResultSet rs;
	
	// 1. 연결설정 메소드 (void)
	public void getOpen() {
		//database 연결
		//jdbc등록
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			//db 연결
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"java",
					"1234"
					);
			//System.out.println("연결성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getClose() {
		if(conn != null) {
			try {
				conn.close();
//				System.out.println("연결끊기");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
