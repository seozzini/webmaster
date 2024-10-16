package boards;


import java.sql.Date;

public class Member {
	
	//필드
	private String id;
	private String pw;
	private String nickName;
	private String name;
	private String phoneNo;
	private Date regDate;
	private String responsibility;
	
	//생성자
	
	public Member(String id, String pw, String nickName, String name, String phoneNo, Date regDate, String responsibility) {
		this.id = id;
		this.pw = pw;
		this.nickName = nickName;
		this.name = name;
		this.phoneNo = phoneNo;
		this.regDate = regDate;
		this.responsibility = responsibility;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getResponsibility() {
		return responsibility;
	}

	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}

	//메소드
	@Override
	public String toString() {
		return id+" : "+pw+" : "+nickName+" : "+name+" : "+phoneNo+" : "+regDate + " : "+responsibility;
	}	
}

