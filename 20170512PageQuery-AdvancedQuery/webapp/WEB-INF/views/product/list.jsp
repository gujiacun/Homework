<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function goPage(currentPage) {
		document.getElementById("currentPage").value = currentPage
		document.forms[0].submit()
	}
</script>
</head>
<body>
	<h1>商品信息列表</h1>
	<!-- 为什么用get无法得到结果，用post可以？ -->
	<form action="/product" method="post">
		<input type="hidden" name="currentPage" id="currentPage"> 
		名字：<input type="text" name="name" value="${qo.name}" /> 
		价格： <input type="text" name="minPrice" value="${qo.minPrice}" /> —— 
		<input type="text" name="maxPrice" value="${qo.maxPrice}" /> 
		分类： <select name="type">
			<option value="-1">请选择</option>
			<option value="1" ${qo.type==1?"selected='selected'":""}>有线</option>
			<option value="2" ${qo.type==2?"selected='selected'":""}>无线</option>
			<option value="3" ${qo.type==3?"selected='selected'":""}>苹果</option>
		</select> <br> 关键字：<input type="text" name="keywords"
			value="${qo.keywords}" style="width: 500px;" placeholder="名称/品牌" /> 
			<input type="submit" value="搜索" /> <br> 
			<a href="/product?cmd=edit">添加商品</a>
		<table border="1" cellpadding="0" cellspacing="0" width="70%"
			style="text-align: center;">
			<tr style="background-color: gray;">
				<th>序号</th>
				<th>编号</th>
				<th>名称</th>
				<th>价格</th>
				<th>数量</th>
				<th>类型</th>
				<th>品牌</th>
				<th>操作</th>
			</tr>
			<c:if test="${empty result.listData}">
				<tr align="center">
					<td colspan="7">抱歉，找不到您所需要的数据，请重新输入</td>
				</tr>
			</c:if>
			<c:forEach items="${result.listData}" var="product" varStatus="vs">
				<tr style="background-color:${vs.count%2==0?'gray':''} ;">
					<td>${vs.count}</td>
					<td>${product.id }</td>
					<td>${product.name }</td>
					<td>${product.price }</td>
					<td>${product.stockNum }</td>
					<td><c:choose>
							<c:when test="${product.type==1 }">有线</c:when>
							<c:when test="${product.type==2 }">无线</c:when>
							<c:when test="${product.type==3 }">苹果</c:when>
						</c:choose></td>
					<td>${product.brand }</td>
					<td><a href="/product?cmd=delete&id=${product.id}">删除</a> | 
					<a href="/product?cmd=edit&id=${product.id}">编辑</a></td>
				</tr>
			</c:forEach>
			<tr align="center">
				<td colspan="8">共${result.totalCount}条数据
					页次：${result.currentPage}/${result.totalPages} 
					<a href="javascript:goPage(1)">首页</a> 
					<a href="javascript:goPage(${result.prePage});">上页</a> 
					<a href="javascript:goPage(${result.nextPage});">下页</a> 
					<a href="javascript:goPage(${result.totalPages});">尾页</a> 
					<input name="currentPage" id="currentPage" value="${result.currentPage}"
					type="number" min="1" max="${result.totalPages}" /> 
				    <input type="submit" value="跳转" /> 
				    每页显示 <select name="pageSize" onchange="goPage(1);">
						<option ${qo.pageSize==5?"selected='selected'":""}>5</option>
						<option ${qo.pageSize==10?"selected='selected'":""}>10</option>
						<option ${qo.pageSize==15?"selected='selected'":""}>15</option>
				</select>条数据
				</td>
			</tr>
		</table>
	</form>
</body>
</html>