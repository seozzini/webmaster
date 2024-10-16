package boards;

import java.sql.Date;

public class Board {
	private String identifiedPhrase = "Board";
	//필드는 외부 접근 막기 - getter/setter
	private String no;
	private String writerId;
	private String writerNickName;
	private String title;
	private String content;
	private Date createDate;
	private Date modifyDate;
	private String bNo;
	private int recommendCnt;
	
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
	
	public String getWriterNickName() {
		return writerNickName;
	}

	public void setWriterNickName(String writerNickName) {
		this.writerNickName = writerNickName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getbNo() {
		return bNo;
	}

	public void setbNo(String bNo) {
		this.bNo = bNo;
	}

	public int getRecommendCnt() {
		return recommendCnt;
	}

	public void setRecommendCnt(int recommendCnt) {
		this.recommendCnt = recommendCnt;
	}

	//생성자
	public Board(String no, String writerId , String writerNickName
			   , String title, String content
			   , Date createDate, Date modifyDate, String bNo, int recommendCnt) {
		this.no = no;
		this.writerId = writerId;
		this.writerNickName = writerNickName;
		this.title = title;
		this.content = content;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.bNo = bNo;
		this.recommendCnt = recommendCnt;
	}
	
	//메소드
	@Override
	public String toString() {
		return identifiedPhrase + ":" + no + " : " + writerId + " : " + writerNickName + " : "+ title + " : " + createDate+" : "+ modifyDate+" : "+bNo;
	}	
}

