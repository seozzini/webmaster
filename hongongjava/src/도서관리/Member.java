package 도서관리;

import java.sql.Date;

public class Member {
	
	//필드
	private String memberId;
	private String password;
	private String memberName;
	
	//생성자
	public Member() {};
	
	public Member(String memberId, String password, String memberName, String phone) {
		super();
		this.memberId = memberId;
		this.password = password;
		this.memberName = memberName;
		this.phone = phone;
	}
	
	
	
	//메소드
	public String getMemberId() {
		return memberId;
	}
	
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getResponsibility() {
		return responsibility;
	}
	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	
	private String phone;
	private String responsibility;
	private Date creationDate;
	
	//메소드
	@Override
	public String toString() {
		return memberId+"\t| "+password+"\t| "+memberName+"\t| "+phone+"\t| "+responsibility+"\t| "+creationDate;
	}	
}
