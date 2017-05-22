<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com._520it._01_tags.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	    List<String> list = new ArrayList<String>();
	    list.add("a");
	    list.add("b");
	    list.add("c");
	    request.setAttribute("list", list);
	    
	    List<User> list2 = new ArrayList<User>();
	    User u1 = new User(1L,"hirate",15);
	    User u2 = new User(2L,"risa",18);
	    User u3 = new User(3L,"manaka",18);
	    list2.add(u1);
	    list2.add(u2);
	    list2.add(u3);
	    request.setAttribute("list2", list2);
	%>
	<s:debug></s:debug>
	<s:iterator value="#request.list" var="item" status="s">
		<s:property value="#s.count" />---<s:property value="#item" />
		<br>
	</s:iterator>
	<s:iterator begin="1" end="10" step="2" var="num" status="ss">
		<s:property value="#ss.count" />---<s:property value="#num" />
	</s:iterator>
	
	<br>
	<s:iterator value="#request.list2" var="user">
	   <s:property value="#user.id"/>
	   <s:property value="#user.name"/>
	   <s:property value="#user.age"/>
	   <br>
	</s:iterator>
	
	<br>
	<s:iterator value="#request.list2">
	   <s:property value="id"/>
	   <s:property value="name"/>
	   <s:property value="age"/>
	   <br>
	</s:iterator>
</body>
</html>