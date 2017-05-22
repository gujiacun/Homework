<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 	<h1>${product==null?'添加':'编辑'}商品</h1>   -->
	<s:form namespace="/" action="product_saveOrUpdate" method="post">
		<s:hidden name="item.id"></s:hidden>
    名称:<s:textfield name="item.name"></s:textfield> 
    价格:<s:textfield name="item.price"></s:textfield> 
     数量:<s:textfield name="item.stockNum"></s:textfield>
	<!--	<s:submit value="${product ==null?'添加':'编辑'}"/>  -->
	<s:submit value="提交"/>
	</s:form>
</body>
</html>
<!--     价格:<input name="price" value="${requestScope.product.price}"><br> 
    名称:<input name="name" value="${requestScope.product.name}"><br>
    数量:<input name="stockNum" value="${requestScope.product.stockNum}"><br>   -->