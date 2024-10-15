package chap06;

public class Book {
	//필드
	private String bookTitle;
	private String bookNum;
	private int bookPrice;
	//생성자
	public Book(String bookTitle,String bookNum,int bookPrice){
		this.bookTitle = bookTitle;
		this.bookNum = bookNum;
		this.bookPrice = bookPrice;
	};
	//메소드
	String getBookTitle() {
		return bookTitle;
	}
	String getBookNum() {
		return bookNum;
	}
	int getBookPrice() {
		return bookPrice;
	}

}
