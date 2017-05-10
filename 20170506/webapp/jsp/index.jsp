<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 需求：定义一个number,若大于5就在页面输出num大于5,若小于5输出num小于5 --%>
	<%
	    int num = 8;
	    if (num > 5) {
	%>
	<%="num大于5"%>
	<%
	    } else if (num < 5) {
	%>
	<%="num小于5"%>
	<%
	    }
	%>

</body>
</html>