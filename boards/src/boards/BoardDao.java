package boards;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDao extends DAO{
	
	public List<Board> list(String bNo){
		getOpen();
		//데이터 추가
		List<Board> listBoard = new ArrayList<>();
		try {
			String sql = "select no, writer_id, writer_nickname, title, content, creation_date, modify_date, b_no"
					   + "      ,(SELECT count(*) FROM recommends WHERE BOARD_NO=a.NO) AS recommend_cnt "
					   + "  from boards a"
					   + " where b_no=?"
					   + " order by creation_date desc, modify_date desc";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bNo);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				listBoard.add(new Board(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6),rs.getDate(7),rs.getString(8), rs.getInt(9)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return listBoard;
	}
	
	public List<Board> favoriteList(){
		getOpen();
		//데이터 추가
		List<Board> listBoard = new ArrayList<>();
		try {
			String sql = "SELECT * \r\n"
						+ "FROM ( \r\n"
						+ "      select no, writer_id, writer_nickname, title, content, creation_date, modify_date, b_no\r\n"
						+ "            ,(SELECT count(*) FROM recommends WHERE BOARD_NO=a.NO) AS recommend_cnt\r\n"
						+ "        FROM boards a \r\n"
						+ "       ORDER BY 8 desc \r\n"
						+ "     ) \r\n"
						+ "WHERE rownum < 6";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				listBoard.add(new Board(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6),rs.getDate(7),rs.getString(8), rs.getInt(9)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return listBoard;
	}
	
	public Board select(String no, String bNo){
		getOpen();
		//데이터 선택
		try {
			String sql = "select no, writer_id, writer_nickname,title, content, creation_date, modify_date, b_no\r\n"
					   + "	    ,(SELECT count(*) FROM recommends b WHERE b.BOARD_NO=a.NO AND b.MEMBER_ID=a.writer_id) AS recommend_cnt \r\n"
					   + "  from boards a "
					   + " where no=? and b_no=? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			pstmt.setString(2, bNo);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return new Board(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6),rs.getDate(7),rs.getString(8), rs.getInt(9));
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			close();			
		}
	}
	
	public int insert(Board board){
		getOpen();
		//데이터 추가
		try {
			String sql = "insert into boards (no, writer_id, writer_nickname, title, content, creation_date, b_no) "
					   + " values(sq_boards.nextval, ?, ?, ?, ?, sysdate, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getWriterId());
			pstmt.setString(2, board.getWriterNickName());
			pstmt.setString(3, board.getTitle());
			pstmt.setString(4, board.getContent());
			pstmt.setString(5, board.getbNo());
			
			int rows = pstmt.executeUpdate();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			close();			
		}
	}
	
	public int update(Board board){
		getOpen();
		//데이터 수정
		try {
			String sql = "update boards set writer_id=?, writer_nickname=?, title=?, content=?, modify_date=sysdate, b_no=? "
					   + " where no=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, board.getWriterId());
			pstmt.setString(2, board.getWriterNickName());
			pstmt.setString(3, board.getTitle());
			pstmt.setString(4, board.getContent());
			pstmt.setString(5, board.getbNo());
			pstmt.setString(6, board.getNo());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			close();			
		}
	}
	
	public int delete(String no, String bNo){
		getOpen();
		//데이터 삭제
		try {
			String sql = "delete from boards "
					   + " where no=? and b_no=? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			pstmt.setString(2, bNo);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			close();			
		}
	}
}
