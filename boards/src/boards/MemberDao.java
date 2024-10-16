package boards;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//���(��ȸ����), ���, ����, ����, �ܰ�
public class MemberDao extends DAO{
	//Connection, getCon, getClose
	
	//�̱��� ���
	private static MemberDao instance = new MemberDao();
	public static MemberDao getInstance() {
		return instance;
	}
	
	Member CheckMember(String id) { //���� ���� ������ ��� ���� String -> Member
		String sql = "select id, pw, nick_name, name, phone_no, reg_date, responsibility "
				   + "  from members"
				   + " where id=?";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				Member member = new Member(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6),rs.getString(7));
				return member;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null;
	}
	
	int checkNickName(String nickName) { //���� ���� ������ ��� ���� String -> Member
		String sql = "select id, pw, nick_name, name, phone_no, reg_date, responsibility "
				   + "  from members"
				   + " where nick_name=?";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, nickName);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0;
	}
	
	//�����ȸ
	List<Member> memberList(){
		String sql = "select id, pw, nick_name, name, phone_no, reg_date, responsibility  "
				   + "  from members ";
		List<Member> result = new ArrayList<>();
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); //��ȸ
			while(rs.next()) {
				Member member = new Member(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6),rs.getString(7));
				result.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
		
	} //end of memberList()
	
	public int insert(Member member){
		getOpen();
		//������ �߰�
		try {
			String sql = "insert into members (id, pw, nick_name, name, phone_no, reg_date, responsibility) "
					   + "values(?, ?, ?, ?, ?, sysdate, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getNickName());
			pstmt.setString(4, member.getName());
			pstmt.setString(5, member.getPhoneNo());
			pstmt.setString(6, member.getResponsibility());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			close();			
		}
	}
}

