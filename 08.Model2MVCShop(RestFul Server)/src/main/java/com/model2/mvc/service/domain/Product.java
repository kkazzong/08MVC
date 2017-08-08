package com.model2.mvc.service.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;


public class Product implements Serializable{
//public class Product {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//	private String fileName;
	private List<String> fileName;
	private String manuDate;
	private int price;
	private String prodDetail;
	private String prodName;
	private int prodNo;
	private Date regDate;
	private String proTranCode;
	
	public Product(){
	}

	public Product(List<String> fileName, String manuDate, int price, String prodDetail, String prodName, int prodNo,
			Date regDate, String proTranCode) {
		super();
		this.fileName = fileName;
		this.manuDate = manuDate;
		this.price = price;
		this.prodDetail = prodDetail;
		this.prodName = prodName;
		this.prodNo = prodNo;
		this.regDate = regDate;
		this.proTranCode = proTranCode;
	}

	public List<String> getFileName() {
		return fileName;
	}

	public String getManuDate() {
		return manuDate;
	}

	public int getPrice() {
		return price;
	}

	public String getProdDetail() {
		return prodDetail;
	}

	public String getProdName() {
		return prodName;
	}

	public int getProdNo() {
		return prodNo;
	}

	public Date getRegDate() {
		return regDate;
	}

	public String getProTranCode() {
		return proTranCode;
	}

	public void setFileName(List<String> fileName) {
		this.fileName = fileName;
	}

	public void setManuDate(String manuDate) {
		this.manuDate = manuDate;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setProdDetail(String prodDetail) {
		this.prodDetail = prodDetail;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public void setProTranCode(String proTranCode) {
		this.proTranCode = proTranCode;
	}

	@Override
	public String toString() {
		return "Product [fileName=" + fileName + ", manuDate=" + manuDate + ", price=" + price + ", prodDetail="
				+ prodDetail + ", prodName=" + prodName + ", prodNo=" + prodNo + ", regDate=" + regDate
				+ ", proTranCode=" + proTranCode + "]";
	}
	
	
	
//	public Product(String fileName, String manuDate, int price, String prodDetail, String prodName, int prodNo,
//			Date regDate, String proTranCode) {
//		super();
//		this.fileName = fileName;
//		this.manuDate = manuDate;
//		this.price = price;
//		this.prodDetail = prodDetail;
//		this.prodName = prodName;
//		this.prodNo = prodNo;
//		this.regDate = regDate;
//		this.proTranCode = proTranCode;
//	}
//
//
//
//	public String getProTranCode() {
//		return proTranCode;
//	}
//	public void setProTranCode(String proTranCode) {
//		this.proTranCode = proTranCode;
//	}
//	public String getFileName() {
//		return fileName;
//	}
//	public void setFileName(String fileName) {
//		this.fileName = fileName;
//	}
//	public String getManuDate() {
//		return manuDate;
//	}
//	public void setManuDate(String manuDate) {
////		manuDate.replaceAll("-", "");
//		this.manuDate = manuDate;
//	}
//	public int getPrice() {
//		return price;
//	}
//	public void setPrice(int price) {
//		this.price = price;
//	}
//	public String getProdDetail() {
//		return prodDetail;
//	}
//	public void setProdDetail(String prodDetail) {
//		this.prodDetail = prodDetail;
//	}
//	public String getProdName() {
//		return prodName;
//	}
//	public void setProdName(String prodName) {
//		this.prodName = prodName;
//	}
//	public int getProdNo() {
//		return prodNo;
//	}
//	public void setProdNo(int prodNo) {
//		this.prodNo = prodNo;
//	}
//	public Date getRegDate() {
//		return regDate;
//	}
//	public void setRegDate(Date regDate) {
//		this.regDate = regDate;
//	}
//
//
//
//	@Override
//	public String toString() {
//		return "Product [fileName=" + fileName + ", manuDate=" + manuDate + ", price=" + price + ", prodDetail="
//				+ prodDetail + ", prodName=" + prodName + ", prodNo=" + prodNo + ", regDate=" + regDate
//				+ ", proTranCode=" + proTranCode + "]";
//	}
	
	

	
	
}