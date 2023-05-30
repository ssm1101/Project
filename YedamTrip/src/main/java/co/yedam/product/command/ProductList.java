package co.yedam.product.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;
import co.yedam.product.service.ProductService;
import co.yedam.product.service.impl.ProductServiceImplMybatis;
import co.yedam.product.vo.ProductVO;

public class ProductList implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession(true);
		Object obj = session.getAttribute("id");
		String id = (String)obj;
		
		ProductService service = new ProductServiceImplMybatis();
		List<ProductVO> list = service.myProduct(id);
		
		req.setAttribute("productList", list);
		
		

		return "seller/product/productList.tiles";
	}
}