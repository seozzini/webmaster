package boards;

import java.sql.Date;

public class Comments {
	private String identifiedPhrase = "Comments";
	//필드는 외부 접근 막기 - getter/setter
	private String no;
	private String writerId;
	private String content;
	private Date createDate;
	private String boardNo;
	
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}

	//생성자
	public Comments(String no, String writerId
			   , String title, String content
			   , Date createDate, String bNo) {
		this.no = no;
		this.writerId = writerId;
		this.content = content;
		this.createDate = createDate;	
		this.boardNo = bNo;
	}
	
	//메소드
	@Override
	public String toString() {
		return identifiedPhrase + ":" + no + " : " + writerId + " : " + createDate+" : "+ boardNo;
	}	
}

