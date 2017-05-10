<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 需求：演示JSTL的准备步骤和逻辑判断标签 -->
<!-- 导包，导标签库，使用标签，但由于标签要从作用域中获取，所以先把值设置到作用域中 -->
<% request.setAttribute("age",17); %>
<!--  单条件判断(if) 结果默认存储在pageScope作用域中,无体，有体-->
<!--  
<c:if test="${age>5}" var="result" scope="request"/>
${requestScope.result}
 -->
<c:if test="${age>18}" var="ret" scope="request">
你真素很努力哦
</c:if>
${requestScope.ret}
<!--  多条件判断:(choose-when-otherwise)${requestScope.result} -->

<c:choose>
<c:when test="${age==15}">
<c:out value="excited!"/>
</c:when>
<c:otherwise>
<c:out value="not excited"/>
</c:otherwise>


</c:choose>


</body>
</html>