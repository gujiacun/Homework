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
	<h1>供应商信息编辑</h1>
	<s:form id="supplier_saveOrUpdate"  action="supplier_saveOrUpdate" method="post" namespace="/">
		<s:hidden name="s.id"/>
		
		<table>
			<tr>
				<td>编码</td>
				<td><s:textfield name="s.number"   /></td>
			</tr>
			<tr>
				<td>名称</td>

				<td><s:textfield name="s.name" /></td>
			</tr>
			<tr>
				<td>城市</td>
				<td><s:textfield name="s.city" /></td>
			</tr>
			<tr>
				<td>信誉</td>
				<td><s:textfield name="s.credit" /></td>
			</tr>
			<tr>
				<td><s:submit value="%{id==null?'添加':'编辑'}" /></td>
			</tr>
		</table>
	</s:form>




</body>
</html>