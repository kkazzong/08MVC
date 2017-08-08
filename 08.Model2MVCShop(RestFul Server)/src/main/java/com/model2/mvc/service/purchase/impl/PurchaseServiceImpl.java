package com.model2.mvc.service.purchase.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.purchase.PurchaseDAO;
import com.model2.mvc.service.purchase.PurchaseService;

@Service("purchaseServiceImpl")
public class PurchaseServiceImpl implements PurchaseService {
	
	@Autowired
	@Qualifier("purchaseDAOImpl")
	PurchaseDAO purchaseDAO;
	
	public PurchaseServiceImpl() {
		System.out.println("::"+getClass()+"default constructor");
	}

	@Override
	public Purchase addPurchase(Purchase purchase) throws Exception {
		return purchaseDAO.addPurchase(purchase);
	}

	@Override
	public Purchase getPurchase(int tranNo) throws Exception {
		return purchaseDAO.getPurchase(tranNo);
	}

//	@Override
//	public Purchase getPurchaseByProdNo(Purchase purchase) throws Exception {
//		return purchaseDAO.getPurchaseByProdNo(purchase);
//	}
	
	@Override
	public Purchase getPurchaseByProdNo(int prodNo) throws Exception {
		return purchaseDAO.getPurchaseByProdNo(prodNo);
	}

	@Override
	public Map<String, Object> getPurchaseList(Search search, String buyerId) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("purchaseList", purchaseDAO.getPurchaseList(search, buyerId));
		Map<String, Object> tempMap = new HashMap<String, Object>();
		tempMap.put("search", search);
		tempMap.put("userId", buyerId);
		map.put("totalCount", purchaseDAO.getTotalCount(tempMap));
		return map;
	}

	@Override
	public Map<String, Object> getSaleList(Search search) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("saleList", purchaseDAO.getSaleList(search));
		Map<String, Object> tempMap = new HashMap<String, Object>();
		tempMap.put("search", search);
//		tempMap.put("userId", buyerId);
		map.put("totalCount", purchaseDAO.getTotalCount(tempMap));
		return map;
	}

	@Override
	public void updatePurchase(Purchase purchase) throws Exception {
		purchaseDAO.updatePurchase(purchase);
	}

	@Override
	public void updateTranCode(Purchase purchase) throws Exception {
		purchaseDAO.updateTranCode(purchase);
	}

	public void setPurchaseDAO(PurchaseDAO purchaseDAO) {
		this.purchaseDAO = purchaseDAO;
	}

	
}
