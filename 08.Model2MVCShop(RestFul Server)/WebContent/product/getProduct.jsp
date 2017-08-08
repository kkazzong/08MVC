<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.model2.mvc.service.domain.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--
	Product product = (Product)request.getAttribute("product");
	User user = (User)session.getAttribute("user");
	String menu = request.getParameter("menu");
--%>
<html>
<head>
<title>상품상세보기</title>

<link rel="stylesheet" href="/css/admin.css" type="text/css">

<script type="text/javascript" src="../javascript/calendar.js">
</script>

<script type="text/javascript">
<!--
function fncAddProduct(){
	//Form 유효성 검증
 	var name = document.detailForm.prodName.value;
	var detail = document.detailForm.prodDetail.value;
	var manuDate = document.detailForm.manuDate.value;
	var price = document.detailForm.price.value;

	if(name == null || name.length<1){
		alert("상품명은 반드시 입력하여야 합니다.");
		return;
	}
	if(detail == null || detail.length<1){
		alert("상품상세정보는 반드시 입력하여야 합니다.");
		return;
	}
	if(manuDate == null || manuDate.length<1){
		alert("제조일자는 반드시 입력하셔야 합니다.");
		return;
	}
	if(price == null || price.length<1){
		alert("가격은 반드시 입력하셔야 합니다.");
		return;
	}
		
	document.detailForm.action='/product/updateProduct';
	document.detailForm.submit();
}
-->

</script>
</head>

<body bgcolor="#ffffff" text="#000000">

<form name="detailForm" method="post">

<input type="hidden" name="prodNo" value="${product.prodNo }"/> 
<%--<input type="hidden" name="prodNo" value="<%= product.getProdNo() %>"/> --%>

<table width="100%" height="37" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td width="15" height="37">
			<img src="/images/ct_ttl_img01.gif" width="15" height="37"/>
		</td>
		<td background="/images/ct_ttl_img02.gif" width="100%" style="padding-left: 10px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="93%" class="ct_ttl01">상품상세조회</td>
					<td width="20%" align="right">&nbsp;</td>
				</tr>
			</table>
		</td>
		<td width="12" height="37">
			<img src="/images/ct_ttl_img03.gif" width="12" height="37"/>
		</td>
	</tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0"	style="margin-top: 13px;">
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">
			상품번호 <img src="/images/ct_icon_red.gif" width="3" height="3" align="absmiddle"/>
		</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<td class="ct_write01">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<%--<td width="105"><%= product.getProdNo() %></td> --%>
					<td width="105">${product.prodNo}</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">
			상품명 <img src="/images/ct_icon_red.gif" width="3" height="3" align="absmiddle"/>
		</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<%--<td class="ct_write01"><%= product.getProdName() %></td> --%>
		<td class="ct_write01">${product.prodName}</td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">
			상품이미지 <img 	src="/images/ct_icon_red.gif" width="3" height="3" align="absmiddle"/>
		</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<td class="ct_write01">
			<%--<img src = "<%= product.getFileName() %>"/> --%>
			<c:forEach var="fileName" items="${product.fileName}">
				<img src = "../images/uploadFiles/${fileName}" width="300" height="300"/>
			</c:forEach>
		</td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">
			상품상세정보 <img src="/images/ct_icon_red.gif" width="3" height="3" align="absmiddle"/>
		</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<%--<td class="ct_write01"><%= product.getProdDetail() %></td> --%>
		<td class="ct_write01">${product.prodDetail}</td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">제조일자</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<%--<td class="ct_write01"><%= product.getManuDate() %></td> --%>
		<td class="ct_write01">${product.manuDate}</td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">가격</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<%--<td class="ct_write01"><%= product.getPrice() %></td>--%>
		<td class="ct_write01">${product.price}</td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">등록일자</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<%--<td class="ct_write01"><%= product.getRegDate() %></td>--%>
		<td class="ct_write01">${product.regDate}</td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
</table>


<table width="100%" border="0" cellspacing="0" cellpadding="0"	style="margin-top: 10px;">
	<tr>
		<td width="53%"></td>
		<td align="right">
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<c:if test="${param.menu == 'search' && !empty user}">
					<%-- <c:if test="${menu == 'search' && !empty user}"> --%>
					<c:if test="${product.proTranCode == 0 or product.proTranCode == null}">
					<td width="17" height="23">
					<%-- if(menu.equals("search") && user != null) { --%>
						<img src="/images/ct_btnbg01.gif" width="17" height="23"/>
					</td>
					<td background="/images/ct_btnbg02.gif" class="ct_btn01"	style="padding-top: 3px;">
						<%--<a href="/addPurchaseView.do?prod_no=<%= product.getProdNo() %>">구매</a> --%>
						<%-- <a href="/addPurchaseView.do?prodNo=${product.prodNo}">구매</a> --%>
						<a href="/purchase/addPurchase?prodNo=${product.prodNo}">구매</a>
					</td>
					<td width="14" height="23">
						<img src="/images/ct_btnbg03.gif" width="14" height="23"/>
					</td>
					</c:if>
					<%-- } --%>
					<c:if test="${product.proTranCode == 1}">
					<td width="17" height="23">
					<%-- if(menu.equals("search") && user != null) { --%>
						<img src="/images/ct_btnbg01.gif" width="17" height="23"/>
					</td>
						<td background="/images/ct_btnbg02.gif" class="ct_btn01"	style="padding-top: 3px;">
							<%-- <a href="/updatePurchaseView.do?tranNo=${param.tranNo}">구매정보수정</a> --%>
							<%-- <a href="/purchase/updatePurchaseView?tranNo=${param.tranNo}">구매정보수정</a> --%>
							<a href="/purchase/updatePurchaseView?tranNo=${param.tranNo}">구매정보수정</a>
						</td>
						<td width="14" height="23">
						<img src="/images/ct_btnbg03.gif" width="14" height="23"/>
					</td>
					</c:if>
					</c:if>
					<td width="30"></td>
					<td width="17" height="23">
						<img src="/images/ct_btnbg01.gif"width="17" height="23"/>
					</td>
					<td background="/images/ct_btnbg02.gif" class="ct_btn01" style="padding-top: 3px;">
					<%-- if(menu.equals("manage")) { --%>	
					<c:if test="${param.menu == 'manage'}">
					<%-- <c:if test="${menu == 'manage'}"> --%>
						<!-- <a href="/listProduct.do?menu=manage">확인</a> -->
						<a href="/product/listProduct?menu=manage">확인</a>
					</c:if>
					<%-- } else { --%>
					<c:if test="${param.menu == 'search'}">	
				<%-- 	<c:if test="${menu == 'search'}"> --%>	
						<a href="javascript:history.go(-1)">이전</a>
					<%-- } --%>
					</c:if>
					</td>
					<td width="14" height="23">
						<img src="/images/ct_btnbg03.gif" width="14" height="23"/>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>

</body>
</html>
