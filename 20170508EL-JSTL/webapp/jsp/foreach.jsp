<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List"
	import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 迭代集合对象的所有成员 -->
	<!-- items:指定要迭代哪一个集合,使用EL表达式来获取数据
      var:接收迭代出来的每个对象,是将其放在page作用域中
     <c:forEach [var="varName"] items="collection" [varStatus="varStatusName"] [begin="begin"]           
         [end="end"] [step="step"]>  
本体内容   
</c:forEach> 
 -->
	<%
	    List<String> list = new ArrayList<String>();
	    list.add("hirate");
	    list.add("manaka");
	    list.add("risa");
	    request.setAttribute("list", list);
	%>
	<c:forEach items="${list}" var="member">
${pageScope.member}<br>
	</c:forEach>
	<c:forEach begin="1" end="10" var="num" step="1">
	${pageScope.num}
	</c:forEach>
</body>
</html>