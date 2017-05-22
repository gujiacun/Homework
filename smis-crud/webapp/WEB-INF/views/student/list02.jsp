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
<a href="/student02" >添加</a>
<table border="1" cellpadding="0" cellspacing="0">
<tr>
    <th>序号</th>
    <th>编号</th>
    <th>姓名</th>
    <th>年龄</th>
    <th>操作</th>
</tr>
<c:forEach items="${requestScope.list}" var="stu" varStatus="vs">
    <tr>
        <td>${vs.count}</td>
        <td>${stu.id}</td>
        <td>${stu.name}</td>
        <td>${stu.age}</td>
        <td>
            <a href="/student02?cmd=delete&id=${stu.id}">删除</a>
            <a href="/student02?cmd=edit&id=${stu.id}">编辑</a>
        </td>
    </tr>
</c:forEach>
</table>
</body>
</html>