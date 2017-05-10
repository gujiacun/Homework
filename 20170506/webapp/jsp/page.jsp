<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList"
	import="java.util.List" isErrorPage="false" errorPage="/jsp/error.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>噢噢噢噢</title>
</head>
<body>
	<%--需求：研究JSP的标准指令 --%>
	<%--除了上面三个language,contentType,pageEncoding外,还可加import 包 --%>
	<%--注意这里要加两个包，ide只加了一个包，要手动加一个 --%>
	<%-- 需求:异常处理一:在page.jsp中程序运行时发生错误,跳转到错误页面 --%>
	<%-- 在本页面编写发生错误的代码,在page指令中设置isError="false" errorPage="/jsp/error.jsp" --%>
	<%-- 在error.jsp的page指令中设置isError="true" --%>
	<%-- 需求:异常处理二:在在web.xml进行全局异常处理 --%>
	<%-- 需求:在jsp文件中 给请求对象设置值,并输出请求对象--%>
	<%
	    List<String> list = new ArrayList();
	    int num = 10 / 5;
	    request.setAttribute("name", "Hirate Yurina");
	%>
	<%=request.getAttribute("name") %>
</body>
</html>