<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List" import="src.com._520it.pss.member.Member"
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>keyakizaka成员列表</title>
</head>
<body>
	<h2>keyakizaka成员列表</h2>
	<% List<Member> members = (List<Member>)request.getAttribute("members"); %>
	<table border="1" cellpading="0" cellspacing="0">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>age</th>
			<th>action</th>
		</tr>
		<% 
		for(Member member : members){
		    %>
		    <tr>
		    <td><%=member.getId() %></td>
		    <td><%=member.getName() %></td>
		    <td><%=member.getAge() %></td>
		    <td><a href="/jsp/del.jsp">删除</a></td>
		    </tr>
		    <%
		}
		%>
		
	</table>
</body>
</html>