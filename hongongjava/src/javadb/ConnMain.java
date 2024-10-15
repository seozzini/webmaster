package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnMain {

	public static void main(String[] args) {
		// database 연결
		// jdbc 등록
		Connection conn = null; // 연결위한 변수
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			// db 연결
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"java",
					"1234"
					);
			System.out.println("연결성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();//왜 연결이 안되었는지 에러코드를 봐야하니 문구 안넣고 그대로 두기.
		} finally {
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
