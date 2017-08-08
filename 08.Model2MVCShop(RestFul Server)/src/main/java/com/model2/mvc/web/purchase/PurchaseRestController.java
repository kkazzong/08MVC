package com.model2.mvc.web.purchase;

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
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.purchase.PurchaseService;

@RestController
@RequestMapping("/purchase/*")
public class PurchaseRestController {

	@Autowired
	@Qualifier("purchaseServiceImpl")
	private PurchaseService purchaseService;
	
	@Value("#{commonProperties['pageSize']}")
	int pageSize;
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	
	public PurchaseRestController() {
		System.out.println(":: purchaseRESTController default CONSTRUCTOR ::");
	}

	@RequestMapping(value="json/addPurchase", method=RequestMethod.POST) 
	public Purchase addPurchase(@RequestBody Purchase purchase) throws Exception {
		
		System.out.println(">>>[From Client]<<<");
		System.out.println(purchase);
		
		Purchase returnPurchase = purchaseService.addPurchase(purchase);
		
		System.out.println(">>>[To Client]<<<");
		System.out.println(returnPurchase);
		
		return returnPurchase;
	}
	
	@RequestMapping(value="json/getPurchase/{tranNo}", method=RequestMethod.GET)
	public Purchase getPurchase(@PathVariable int tranNo) throws Exception {
		
		System.out.println(">>>[From Client]<<<");
		System.out.println("tranNo : "+tranNo);
		
		Purchase returnPurchase = purchaseService.getPurchase(tranNo);
		
		System.out.println(">>>[To Client]<<<");
		System.out.println(returnPurchase);
		
		return returnPurchase;
	}
	
	@RequestMapping(value="json/listPurchase/{buyerId}", method=RequestMethod.GET)
	public Map listPurchase(@PathVariable String buyerId) throws Exception {
		
		System.out.println(">>>[From Client]<<<");
		System.out.println("buyerId : "+buyerId);
		
		Search search = new Search();
		search.setCurrentPage(1);
		search.setPageSize(pageSize);
		
		Map<String, Object> map = purchaseService.getPurchaseList(search, buyerId);
		
		Page page = new Page(search.getCurrentPage(), (Integer)map.get("totalCount"), pageUnit, pageSize);
		System.out.println(page);
		
		System.out.println(">>>[To Client]<<<");
		System.out.println(map);
		
		return map;
	}
	
	@RequestMapping(value="json/listSale", method=RequestMethod.GET)
	public Map listSale() throws Exception {
		
		Search search = new Search();
		search.setCurrentPage(1);
		search.setPageSize(pageSize);
		
		Map<String, Object> map = purchaseService.getSaleList(search);
		
		Page page = new Page(search.getCurrentPage(), (Integer)map.get("totalCount"), pageUnit, pageSize);
		System.out.println(page);
		
		System.out.println(">>>[To Client]<<<");
		System.out.println(map);
		
		return map;
	}
	
	@RequestMapping(value="json/updatePurchase/{tranNo}", method=RequestMethod.POST)
	public Purchase updatePurchase(@PathVariable int tranNo,
														 @RequestBody Purchase purchase) throws Exception {
		
		System.out.println(">>>[From Client]<<<");
		System.out.println("tranNo : "+tranNo);
		System.out.println(purchase);
		
		purchaseService.updatePurchase(purchase);
		
		Purchase returnPurchase = purchaseService.getPurchase(tranNo);
		
		System.out.println(">>>[To Client]<<<");
		System.out.println(returnPurchase);
		
		return returnPurchase;
	}
	
	@RequestMapping(value="json/updateTranCode/{tranNo}/{tranCode}", method=RequestMethod.GET)
	public Purchase updateTranCode(@PathVariable int tranNo,
														  @PathVariable String tranCode) throws Exception {
		
		System.out.println(">>>[From Client]<<<");
		System.out.println("tranNo : "+tranNo+", tranCode : "+tranCode);
		
		Purchase purchase = purchaseService.getPurchase(tranNo);
		purchase.setTranCode(tranCode);
		
		purchaseService.updateTranCode(purchase);
		
		Purchase returnPurchase = purchaseService.getPurchase(tranNo);
		
		System.out.println(">>>[To Client]<<<");
		System.out.println(returnPurchase);
		
		return returnPurchase;
	}
}
