<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>商品信息列表</h1>
    <a href="/product?cmd=edit">添加商品</a>
    <table border="1" cellpadding="0" cellspacing="0" width="70%" style="text-align: center;">
        <tr style="background-color: gray;">
            <th>序号</th>
            <th>编号</th>
            <th>名称</th>
            <th>价格</th>
            <th>数量</th>
            <th>操作</th>
        </tr>
        
        <c:forEach items="${list}" var="product" varStatus="vs">
        <tr style="background-color:${vs.count%2==0?'gray':''} ;">
            <td>${vs.count}</td>
            <td>${product.id }</td>
            <td>${product.name }</td>
            <td>${product.price }</td>
            <td>${product.stockNum }</td>
            <td><a href="/product?cmd=delete&id=${product.id}">删除</a>
                <a href="/product?cmd=edit&id=${product.id}">编辑</a> |
            </td>
        </tr>
        </c:forEach>
        
 
    </table>
</body>
</html>