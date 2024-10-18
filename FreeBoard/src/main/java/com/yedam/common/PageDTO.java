package com.yedam.common;

import lombok.Data;

@Data
public class PageDTO {

	private int startPage, endPage;
	private boolean prev, next;
	private int page; // 현재 페이지.
	
	//생성자 안에 계산하는 코드를 넣자.
	public PageDTO(int page, int totalCnt) { //매개값 두개 필요.
//		int totalCnt = 134;
		this.page = page;
		this.endPage = (int) Math.ceil(page / 10.0) * 10; //10을 곱한 이유는 현재 페이지 기준
		this.startPage = this.endPage - 9 ;
		
		int realEnd = (int) Math.ceil(totalCnt / 5.0); //건수 계산 => 최종페이지.
		this.endPage = this.endPage > realEnd ? realEnd : this.endPage;
		
		this.prev = this.startPage > 1 ;
		this.next = this.endPage < realEnd;
	}

}
