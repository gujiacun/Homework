<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 这里就是模仿的购物车，有编号/名称/价格/数量/操作，导入标签库，循环购物车对象里的商品集合，根据列名输出属性 -->
<table border="1" cellspacing="0" cellpadding="0">
    <tr>
        <th>编号</th>
        <th>名称</th>
        <th>价格</th>
        <th>数量</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${SHOPPINGCART_IN_SESSION.items}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.price}</td>
            <td>${item.number}</td>
            <td>
                <a href="/cart?cmd=deleteItem&id=${item.id}">删除</a>
            </td>
            
        </tr>
    </c:forEach>
</table>
总价格：${SHOPPINGCART_IN_SESSION.totalPrice}
</body>
</html>