<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com._520it._01_el.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	    User user = new User();
	    request.setAttribute("user", user);
	%>
	<!-- 访问对象中的属性 -->
	${user.name}<br>
	${user.age}<br>
	${user.hobby[1]}<br>
	${user.list[0]}<br>
	${user.map.name}<br>
	${user.map["name"]}<br>
	${user["name"]}
	<!-- 使用EL表达式去获取到上下文路径 -->
	${pageContext.request.contextPath}
<!-- 判断是否为空 -->	
${empty user}
</body>
</html>