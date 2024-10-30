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
		// TODO Auto-generated method stub
		String code = req.getParameter("prdCode");
		
		ProductService svc = new ProductServiceImpl();
		List<ProductVO> product = svc.prodList();
		
		req.setAttribute("productvo", product);
		req.setAttribute("prdCode", code);
		//오픈할페이지 설정
		req.getRequestDispatcher("product/productList.tiles").forward(req, resp);

	}

}
