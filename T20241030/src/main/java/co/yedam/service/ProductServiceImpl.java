package co.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.mapper.ProductMapper;
import co.yedam.vo.ProductVO;

public class ProductServiceImpl implements ProductService {
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);

	@Override
	public String cheeringMessage() {
		return mapper.selectMessage();
	}

	@Override
	public String hintMessage(String remainTimeString) {
		return mapper.selectHint(remainTimeString);
	}

	@Override
	public List<ProductVO> prodList() {
		return mapper.prodList();
	}
	
	@Override
	public ProductVO selectProd(String prodCode) {
		return mapper.selectProd(prodCode);
	}
}
