<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品信息</title>
</head>
<body>
    <h1>商品信息</h1>
    <form action="/cart?cmd=addItem" method="post">
            名称：<select name="name">
            <option>锤子</option>
            <option>魅族</option>
            <option>小米</option>
    </select>
            数量：<input name="number">
    <input type="submit" value="付款">
    </form>
</body>
</html>