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
<!-- 用struts2标签库实现超链接 -->
<s:a namespace="/" action="student_input">添加学生</s:a>
<s:a namespace="/" action="student_input">编辑
    <s:param name="stu.id" value="1"></s:param>
</s:a>
<s:url namespace="/" action="student_input" var="url"> </s:url>  
<a href='<s:property value="#url"/>' >删除</a>
</body> 
</html>