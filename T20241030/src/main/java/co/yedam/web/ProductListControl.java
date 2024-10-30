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

public class ProductListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("ProductListControl");
		ProductService svc = new ProductServiceImpl();
		List<ProductVO> list = svc.prodList();
		System.out.println(list.toString());
		
		req.setAttribute("prodList", list);
		
		try {
			req.getRequestDispatcher("product/productList.tiles").forward(req, resp);
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
		

	}



}
