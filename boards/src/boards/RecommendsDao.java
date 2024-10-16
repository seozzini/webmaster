package boards;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecommendsDao extends DAO{
	private static RecommendsDao instance = new RecommendsDao();
	public static RecommendsDao getInstance() {
		return instance;
	}
	
	public Recommends select(String memberId, String boardNo){
		getOpen();
		//데이터 추가
		try {
			String sql = "select no, member_id, board_no, creation_date "
					   + "  from recommends"
					   + " where member_id=? and board_no=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, boardNo);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return new Recommends(rs.getString(1), rs.getString(2),rs.getString(3),rs.getDate(4));
			}else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			close();			
		}
	}
	
	public int rcCnt(String memberId, String boardNo){
		getOpen();
		//데이터 추가
		try {
			String sql = "select no, member_id, board_no, creation_date "
					   + "  from recommends"
					   + " where member_id=? and board_no=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, boardNo);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				
				return 1;
			}else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			close();			
		}
	}
	
	public int insert(Recommends rcmd){
		getOpen();
		//데이터 추가
		try {
			String sql = "insert into recommends (no, member_id, board_no, creation_date) "
					   + " values(SQ_RECOMMENDS.nextval, ?, ?, sysdate)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rcmd.getMemberId());
			pstmt.setString(2, rcmd.getBoardNo());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			close();
		}
	}
	
	public int delete(String no){
		getOpen();
		//데이터 삭제
		try {
			String sql = "delete from recommends "
					   + " where no=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			close();			
		}
	}
}
