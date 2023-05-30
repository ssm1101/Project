package co.yedam.product.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.product.mapper.ProductMapper;
import co.yedam.product.service.ProductService;
import co.yedam.product.vo.ProductVO;

public class ProductServiceImplMybatis implements ProductService {
	SqlSession session = DataSource.getInstance().openSession(true);
	ProductMapper mapper = session.getMapper(ProductMapper.class);

	@Override
	public int prodAdd(ProductVO vo) {
		return mapper.prodAdd(vo);
	}

	@Override
	public List<ProductVO> prodList() {
		return mapper.prodList();
	}

	@Override
	public ProductVO prodSearch(int prodId) {
		return mapper.prodSearch(prodId);
	}

	@Override
	public int prodUpdate(ProductVO vo) {
		return mapper.prodUpdate(vo);
	}

	@Override
	public int prodAllDel(int tpIp) {
		return mapper.prodAllDel(tpIp);
	}

	@Override
	public int prodDel(int prodId) {
		return mapper.prodDel(prodId);
	}

	@Override
	public int prodSell(@Param("prodId") int prodId, @Param("count") int count) {
		return mapper.prodSell(prodId, count);
	}

	@Override
	public List<ProductVO> productList(int tpId) {
		return mapper.productList(tpId);
	}

	@Override
	public List<ProductVO> myProduct(String mbId) {
		return mapper.myProduct(mbId);
	}
}
