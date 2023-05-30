package co.yedam.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.yedam.product.vo.ProductVO;

public interface ProductMapper {

	public int prodAdd(ProductVO vo);

	public List<ProductVO> prodList();

	public ProductVO prodSearch(int prodId);

	public int prodUpdate(ProductVO vo);

	public int prodAllDel(int tpId);
	
	public int prodDel(int prodId);

	public int prodSell(@Param("prodId") int prodId, @Param("count") int count);

	public List<ProductVO> productList(int tpId);

	public List<ProductVO> myProduct(String mbId);
}