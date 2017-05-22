<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成员列表</title>
</head>
<body>
	<h1>成员统计</h1>
	<a href="/student?cmd=edit">添加</a>
	
	<table border="1" cellpading="0" cellspacing="0" style="text-align:center;">
		<tr>
			<th>序号</th>
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${requestScope.list}" var="stu" varStatus="vs">
		<tr style="background-color:${vs.count%2==0?'grey':''};">
		<!-- varStatus:可以从该对象上查看是遍历到了第几个元素,count 表示当前遍历集合的元素个数 -->
		<td>${vs.count}</td>
		<td>${stu.id}</td>
		<td>${stu.name}</td>
		<td>${stu.age}</td>
		<td>
		  <a href="/student?cmd=delete&id=${stu.id}">删除</a>
		  <a href="/student?cmd=edit&id=${stu.id}">编辑</a>
		</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>