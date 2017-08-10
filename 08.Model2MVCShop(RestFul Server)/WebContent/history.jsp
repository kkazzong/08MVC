<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page contentType="text/html; charset=EUC-KR" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<html>
<head>

<title>열어본 상품 보기</title>

</head>
<body>
	당신이 열어본 상품을 알고 있다
<br>
<br>

 <c:forEach var="cookies" items="${cookie.history.value}" >
	 <c:set var="cookieValue" value="${fn:split(cookies, ' ')}"/>
	 <c:forEach var="history" items="${cookieValue}">
		 <a href="/product/getProduct?prodNo=${history}&menu=search"
		target="rightFrame">${history}</a>
		 <br>
	 </c:forEach>
 </c:forEach>
</body>
</html>