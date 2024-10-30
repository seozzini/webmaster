package co.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.ProductService;
import co.yedam.service.ProductServiceImpl;
import co.yedam.vo.ProductVO;

public class ProductControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("ProductControl");
		String code = req.getParameter("prdCode");
		
		ProductService svc = new ProductServiceImpl();
		List<ProductVO> product = svc.prodListTop4();
		ProductVO pvo = svc.selectProd(code);
		
		//System.out.println(product.toString());
		req.setAttribute("productvo", product);
		req.setAttribute("prdCode", pvo);
		//오픈할페이지 설정
		req.getRequestDispatcher("product/productInfo.tiles").forward(req, resp);

	}

}
