package 도서관리;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDao extends DAO{
	
	public int insert(Book book){
		getOpen();
		//데이터 추가
		try {
			String sql = ""
					   + "insert into book (title, writer, price, bnum) "
					   + "values(?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getWriter());
			pstmt.setInt(3, book.getPrice());
			pstmt.setString(4, book.getBnum());
			
			int rows = pstmt.executeUpdate();
			getClose();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public void select(String title){
		getOpen();
		//데이터 선택
		try {
			String sql = ""
					   + "select * from book "
					   + "where title=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString(1) + " : " + rs.getString(2) + " : " + rs.getInt(3) + " : " + rs.getString(4));
			}	
			
			getClose();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	List<Book> bookList(Search search){
		String sql = "select * from book" + " where price<>0";
		if(search.getTitle() != null) {
			sql += " and title like '%'||?||'%'";
		}
		if(search.getWriter() != null) {
			sql += " and writer like '%'||?||'%'";
		}
		if(search.getPrice() > 0) {
			sql += " and price > ?";
		}
		int param =0;
		List<Book> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			if(search.getTitle() != null || !search.getTitle().equals("")) {
				psmt.setString(param++, search.getTitle());
			}
			if(search.getTitle() != null || !search.getWriter().equals("")) {
				psmt.setString(param++, search.getWriter());
			}
			if(search.getPrice() > 0) {
				psmt.setInt(param++, search.getPrice());
			}
			
			rs = psmt.executeQuery();
			while(rs.next()) {
				Book book = new Book(rs.getString("title"), rs.getString("writer"), rs.getInt("price"), rs.getString("bnum"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	*/
	
	public void list(){
		getOpen();
		//데이터 추가
		try {
			String sql = "select * from book ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString(1) + " : " + rs.getString(2) + " : " + rs.getInt(3) + " : " + rs.getString(4));
			}	
			getClose();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int update(String bnum, String title, int price){
		getOpen();
		//데이터 수정
		try {
			String sql = ""
					   + "update book set price=?, title=? "
					   + "where bnum=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, price);
			pstmt.setString(2, title);
			pstmt.setString(3, bnum);
			
			int rows = pstmt.executeUpdate();
			getClose();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int delete(String title){
		getOpen();
		//데이터 삭제
		try {
			String sql = "delete from book "
					   + "where title=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			
			int rows = pstmt.executeUpdate();
			getClose();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
