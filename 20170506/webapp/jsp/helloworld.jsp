<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    现在时间为<%=new java.util.Date().toLocaleString()%>>
    <!-- 这是html的注释 -->
    <!-- 在浏览器中输入http://localhost/jsp/helloworld.jsp -->
    <%-- 这是jsp的注释 --%>
    <%String name = "Hirate Yurina"; %>
    <%=name %>
    <%=request.getParameter("username")%>
</body>
</html>