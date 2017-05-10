<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/jsp/head.jsp">
<jsp:param value="xxx" name="xx"/>
</jsp:include>
<br>
这是页面主体啊
<br>
<jsp:include page="/jsp/foot.jsp">
<jsp:param value="xxx" name="xx"/>
</jsp:include>
</body>
</html>