package com.model2.mvc.web.purchase;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model2.mvc.common.Page;
import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;

@Controller
@RequestMapping("/purchase/*")
public class PurchaseController {

	@Autowired
	@Qualifier("purchaseServiceImpl")
	private PurchaseService purchaseService;
	
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
	
	@Value("#{commonProperties['pageSize']}")
	private int pageSize;
	
	@Value("#{commonProperties['pageUnit']}")
	private int pageUnit;
	
	public PurchaseController() {
		// TODO Auto-generated constructor stub
	}
	
//	@RequestMapping("addPurchaseView.do")
	@RequestMapping(value="addPurchase", method=RequestMethod.GET)
	public String addPurchaseView(@RequestParam("prodNo") int prodNo,
												Model model) throws Exception {
		
		System.out.println("@ addPurchaseView @");
		
		Product product = productService.getProduct(prodNo);
		System.out.println(product);
		
		model.addAttribute("product", product);
		
		return "/purchase/addPurchaseView.jsp";
	}

//	@RequestMapping("addPurchase.do")
	@RequestMapping(value="addPurchase", method=RequestMethod.POST)
	public String addPurchase(/*@RequestParam("buyerId") String buyerId,
											   @RequestParam("prodNo") int prodNo,*/
											   @ModelAttribute("purchase") Purchase purchase,
											   /*HttpSession session,*/
											   Model model) throws Exception {
		
		System.out.println("@ addPurchase[POST] @");
		
		purchase = purchaseService.addPurchase(purchase);
		System.out.println(purchase);
		model.addAttribute(purchase);
		return "/purchase/addPurchase.jsp";
	}

//	@RequestMapping("listPurchase.do")
	@RequestMapping(value="listPurchase")
	public String listPurchase(@ModelAttribute("search") Search search,
											  HttpSession session,
											  Model model) throws Exception {
		
		
		int currentPage = 1;
		if(search.getCurrentPage() == 0) {
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);
		
		User user = (User)session.getAttribute("user");
		Map<String, Object> map = purchaseService.getPurchaseList(search, user.getUserId());
		
		Page resultPage = new Page(search.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
		System.out.println(resultPage);
		
		model.addAttribute("list", map.get("purchaseList"));
		model.addAttribute("resultPage", resultPage);
		
		return "/purchase/listPurchase.jsp";
	}
	
//	@RequestMapping("listSale.do")
	@RequestMapping(value="listSale")
	public String listSale(@ModelAttribute("search") Search search,
									Model model) throws Exception {
		
		
		int currentPage = 1;
		if(search.getCurrentPage() == 0) {
			search.setCurrentPage(1);
		}
		
		search.setPageSize(pageSize);
		System.out.println(search);
		
		
		Map<String, Object> map = purchaseService.getSaleList(search);
		System.out.println(map.get("saleList"));
		
		Page resultPage = new Page(search.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
		
		model.addAttribute("list", map.get("saleList"));
		model.addAttribute("resultPage", resultPage);
		
		return "/purchase/listSale.jsp";
	}
	
//	@RequestMapping("updateTranCodeByProd.do")
	@RequestMapping(value="updateTranCodeByProd",method=RequestMethod.GET)
	public String updateTranCodeByProd(@RequestParam("prodNo") int prodNo,
																@RequestParam("tranCode") String tranCode,
																Model model) throws Exception {

		
		System.out.println("updateTranCodeByProd");
		
		Purchase purchase = purchaseService.getPurchaseByProdNo(prodNo);
		purchase.setTranCode(tranCode);
		
		purchaseService.updateTranCode(purchase);
		
		return "/purchase/listSale?menu=manage";
	}
	
//	@RequestMapping("updateTranCode.do")
	@RequestMapping(value="updateTranCode",method=RequestMethod.GET)
	public String updateTranCode(@RequestParam("tranNo") int tranNo,
													@RequestParam("tranCode") String tranCode,
													Model model) throws Exception {
		
		System.out.println("updateTranCode");
		
		Purchase purchase = purchaseService.getPurchase(tranNo);
		
		purchase.setTranCode(tranCode);
		
		purchaseService.updateTranCode(purchase);
		
		return "forward:/purchase/listPurchase";
	}
	
//	@RequestMapping("updatePurchaseView.do")
	@RequestMapping(value="updatePurchaseView")
	public String updatePurchaseView(@RequestParam("tranNo") int tranNo,
															Model model) throws Exception {
		

		System.out.println("updatePurchaseView[POST]");
		System.out.println("tranNo »Æ¿Œ : "+tranNo);
		Purchase purchase = purchaseService.getPurchase(tranNo);
		System.out.println(purchase);
		
		model.addAttribute("purchase", purchase);
		
		return "/purchase/updatePurchaseView.jsp";
	}
	
//	@RequestMapping("updatePurchase.do")
	@RequestMapping(value="updatePurchase", method=RequestMethod.POST)
	public String updatePurchase(@RequestParam("tranNo") int tranNo,
													@ModelAttribute("purchase") Purchase purchase,
													Model model) throws Exception {
		
		System.out.println("updatePurchase[POST]");
		
		purchaseService.updatePurchase(purchase);
		model.addAttribute("purchase", purchaseService.getPurchase(tranNo));
		
		return "forward:/purchase/addPurchase.jsp";
	}
}
