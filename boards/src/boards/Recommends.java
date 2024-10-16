package boards;

import java.sql.Date;

public class Recommends {
	private String identifiedPhrase = "Recommends";
	//필드는 외부 접근 막기 - getter/setter
	private String no;
	private String memberId;
	private String boardNo;
	private Date createDate;
	
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	//생성자
	public Recommends(String no, String memberId
			        , String boardNo, Date createDate) {
		this.no = no;
		this.memberId = memberId;
		this.boardNo = boardNo;
		this.createDate = createDate;
	}
	
	//메소드
	@Override
	public String toString() {
		return identifiedPhrase + ":" + no + " : " + memberId + " : " + boardNo + " : " + createDate+" : "+ createDate;
	}	
}

