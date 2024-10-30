package co.yedam.service;

import java.util.List;

import co.yedam.vo.ProductVO;

public interface ProductService {
	String cheeringMessage();
	String hintMessage(String remainTimeString);
	
	//전체 목록
	List<ProductVO> prodList();
	
	//TOP4
	List<ProductVO> prodListTop4();
	
	//상세
	ProductVO selectProd(String prodCode);
	
	
}
