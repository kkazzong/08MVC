package com.model2.mvc.web.product;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model2.mvc.common.Page;
import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;

@RestController
@RequestMapping("/product/*")
public class ProductRestController {
	
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
	
	@Value("#{commonProperties['pageSize']}")
	int pageSize;
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	
	public ProductRestController() {
		System.out.println(":: ProductRESTController default CONSTRUCTOR ::");
	}
	
	@RequestMapping(value="json/addProduct", method=RequestMethod.POST)
	public Product addProduct(@RequestBody Product product) throws Exception {
		
		System.out.println(">>>[From Client]<<<");
		System.out.println(product);
		
		product.setManuDate(product.getManuDate().replaceAll("-", ""));
		productService.addProduct(product);
		
		Product returnProduct = productService.getProduct(product.getProdNo());

		System.out.println(">>>>[To Client]<<<<");
		System.out.println(returnProduct);
		
		return returnProduct;
	}
	
	@RequestMapping(value="json/getProduct/{prodNo}/{menu}", method=RequestMethod.GET)
	public Product getProduct(@PathVariable int prodNo,
											  @PathVariable String menu) throws Exception {
		
		System.out.println(">>[From Client]<<");
		System.out.println("prodNo : "+prodNo+", menu : "+menu);
		
		if(menu.equals("search")) {
			
			Product returnProduct = productService.getProduct(prodNo);
			System.out.println(">>>>[To Client]<<<<");
			System.out.println(returnProduct);
			
			return returnProduct; 
			
		} else if(menu.equals("manage")) {
			
			//tmp
			//return this.updateProductView();
			
		}
		return null;
	}
	
	@RequestMapping(value="json/listProduct/*", method=RequestMethod.GET)
	public Map listProduct(/*@PathVariable String menu*/) throws Exception {
		
		System.out.println(">>[From Client]<<");
		System.out.println();
		
		Search search = new Search();
		search.setCurrentPage(1);
		search.setPageSize(pageSize);
		
		
		Map<String, Object> map = productService.getProductList(search);
		
		Page page = new Page(search.getCurrentPage(), (Integer)map.get("totalCount"), pageUnit, pageSize);
		System.out.println(page);
		
		System.out.println(">>[To Client]<<");
		System.out.println(map.get("totalCount"));
		System.out.println(map.get("productList"));
		
		return map;
	}
	
	@RequestMapping(value="json/updateProduct", method=RequestMethod.GET)
	public Product updateProductView() throws Exception {
		
		int prodNo = 10001;
		Product returnProduct = productService.getProduct(prodNo);
		
		System.out.println(">>>>[To Client]<<<<");
		System.out.println(returnProduct);
		
		return returnProduct;
	}
	
	@RequestMapping(value="json/updateProduct", method=RequestMethod.POST)
	public Product updateProduct(@RequestBody Product product) throws Exception {
		
		System.out.println(">>>[From Client]<<<");
		System.out.println(product);
		
		product.setManuDate(product.getManuDate().replaceAll("-", ""));
		productService.updateProduct(product);
		
		Product returnProduct = productService.getProduct(product.getProdNo());
		
		System.out.println(">>>>[To Client]<<<<");
		System.out.println(returnProduct);
		
		return returnProduct;
	}
	
	/*@RequestMapping(value="json/deleteProduct/{prodNo}", method=RequestMethod.GET)
	public int deleteProduct(@PathVariable int prodNo) throws Exception {
		
		System.out.println(">>>[From Client]<<<");
		System.out.println("prodNo : "+prodNo);
		
		int complete = productService.deleteProduct(prodNo);
		
		System.out.println(">>>>[To Client]<<<<");
		System.out.println("삭제되엇니 : "+complete);
		
		return complete;
	}*/
	
	@RequestMapping(value="json/deleteProduct/{prodNo}", method=RequestMethod.GET)
	public Map deleteProduct(@PathVariable int prodNo) throws Exception {
		
		System.out.println(">>>[From Client]<<<");
		System.out.println("prodNo : "+prodNo);
		
		int complete = productService.deleteProduct(prodNo);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("complete", complete);
		if(complete == 1) {
			map.put("message", "삭제되었습니다");
		} else {
			map.put("message", "삭제실패");
		}
		System.out.println(">>>>[To Client]<<<<");
		System.out.println("삭제되엇니 : "+map.get("message"));
		
		return map;
	}
}
