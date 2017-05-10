<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 需求1：往4大作用域添加共享数据(setAttribute),作用域中取出数据(getAttribute), -->
<!-- 需求2：用pageContext的findAttribute，再把前4句逐一注释，观察浏览器变化 -->
<% pageContext.setAttribute("name","Manaka"); 
 request.setAttribute("name","Risa"); 
 session.setAttribute("name","Hirate"); 
 application.setAttribute("name","Kobayash"); %>
<!-- 注意：这里的jsp文件被放在了jsp文件夹内,要在浏览器前加/jsp才能访问 -->
pageContext:<%=pageContext.getAttribute("name") %><br>
request:<%=request.getAttribute("name") %><br>
session:<%=session.getAttribute("name") %><br>
application:<%=application.getAttribute("name") %><br>
findAttribute:<%=pageContext.findAttribute("name") %><br>
<!-- 需求3:若有值就显示，否则显示空字符串 -->
<%=pageContext.findAttribute("name")==null?"":pageContext.findAttribute("name") %><br>
<!-- 以上可以用EL表达式写为 -->
${name}<br>
<!-- 从指定的作用域中拿指定名称的属性 -->
${requestScope.name}<br>
${applicationScope.name}










</body>
</html>