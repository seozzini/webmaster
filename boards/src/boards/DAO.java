package boards;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	Connection conn = null;
	PreparedStatement psmt;
	ResultSet rs;
	
	// 1. ���ἳ�� �޼ҵ� (void)
	public void getOpen() {
		//database ����
		//jdbc���
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			//db ����
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.0.21:1521:xe",	//jdbc url
					"board",	//account / schema
					"1234"		//password
					);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close() {
		if(conn != null) {
			try {
				conn.close();
//				System.out.println("�������");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

