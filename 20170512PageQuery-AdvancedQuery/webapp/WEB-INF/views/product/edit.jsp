<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>${product==null?'添加':'编辑'}商品</h1>
    <form action="/product?cmd=saveOrUpdate" method="post">
    <input name="id" type="hidden" value="${requestScope.product.id}">
    名称:<input name="name" value="${requestScope.product.name}"><br> 
    价格:<input name="price" value="${requestScope.product.price}"><br> 
    数量:<input name="stockNum" value="${requestScope.product.stockNum}"><br>
    <input type="submit" value="${product ==null?'添加':'编辑'}">
    </form>
</body>
</html>