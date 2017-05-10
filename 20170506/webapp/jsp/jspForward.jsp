<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- 需求:在JSP页面中显示跳转到某页面 -->
<body>
	<jsp:forward page="/jsp/helloworld.jsp">
		<jsp:param value="Risa" name="username"/>
	</jsp:forward>
</body>
</html>