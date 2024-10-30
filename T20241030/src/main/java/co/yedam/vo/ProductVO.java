package co.yedam.vo;

import lombok.Data;


@Data
public class ProductVO {
		private String prdCode; // -- P001, P002
		private String prdName; //--상품명.
		private String prdDesc; // --상품의 설명.
		private int originPrice; // --원가격
		private int salePrice; // --할인가격	
		private int starPoint;//  --별점.
		private String prodImage;// --상품이미지명.
		private String creationDate;// --생성일자.
	}



	
	
			
