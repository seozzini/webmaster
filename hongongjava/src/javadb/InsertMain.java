package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertMain {

	public static void main(String[] args) {
		// 데이터 추가
		Connection conn = null;
		
		// jdbc 드라이버 등록
		try {
			Class.forName("oracle.jdbc.OracleDriver"); // try/catch

			conn = DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe", "java", "1234");// try/catch
			System.out.println("연결성공");

			// 데이터 추가(SQL 문장 넣기)
			String sql = "" 
						+ "insert into boards (bno,btitle,bcontent,bwriter,bdate) "
						+ "values(seq_bno.nextVal, ?, ?, ?,sysdate)";
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"bno","btitle"});//sql문에 배열만들어두고 추가한 번호 알려고 할 때 추가
			pstmt.setString(1, "눈 오는 밤"); // 첫번째 ?에 제목1이 추가된 것임
			pstmt.setString(2, "눈이 펑펑 내려요"); // content 에 삽입됨
			pstmt.setString(3, "snow");

			
			//Sql 문장 실행
			int rows = pstmt.executeUpdate(); // 실행 후 한 문장을 돌려 줌 select문만 execute고 나머지는 update임
			if (rows == 1) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next()) {
					int bno = rs.getInt(1); //bno 써도 되고, 칼럼 번호 넣어줘도 동일한 결과
					String btitle = rs.getString(2);
					System.out.println("저장된 번호 : " + bno + btitle); //추가된 애가 누구인지 보려는 것 (저장된 번호: 6)
				}
				System.out.println("추가 성공"); // true 일 때
				rs.close(); //자원 닫기
			} else {
				System.out.println("추가 실패"); // false 일 때
			}
			
			pstmt.close(); //자원 닫기

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {// 연결되었다면
				try {
					conn.close();
					System.out.println("연결끊기");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

}
