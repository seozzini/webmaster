package boards;

import java.sql.Date;

public class Recommends {
	private String identifiedPhrase = "Recommends";
	//�ʵ�� �ܺ� ���� ���� - getter/setter
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

	//������
	public Recommends(String no, String memberId
			        , String boardNo, Date createDate) {
		this.no = no;
		this.memberId = memberId;
		this.boardNo = boardNo;
		this.createDate = createDate;
	}
	
	//�޼ҵ�
	@Override
	public String toString() {
		return identifiedPhrase + ":" + no + " : " + memberId + " : " + boardNo + " : " + createDate+" : "+ createDate;
	}	
}

