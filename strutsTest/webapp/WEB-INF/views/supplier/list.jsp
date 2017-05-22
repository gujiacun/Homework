<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function gopage(currentPage) {
		document.getElementById("qo.currentPage").value = currentPage;
		document.forms[0].submit();
	}
</script>
</head>
<body>
	<div align="center">
		<h1>供应商信息列表</h1>
		<s:form id="supplier" name="supplier" action="" method="post"
			namespace="/">
			<s:hidden name="qo.currentPage" value="1" id="qo.currentPage" />
			<br /> 信誉:
			<s:textfield name="qo.minCredit" />
			-
			<s:textfield name="qo.maxCredit" />
			关键字：
			<s:textfield name="qo.keyword" />
			<s:submit value="查询" />
			<s:a action="supplier_input" namespace="/">添加</s:a>
			<table border="1" cellpadding="0" cellspacing="0"
				style="text-align: center;" align="center" width="70%">
				<tr>
					<th>编码</th>
					<th>名称</th>
					<th>城市</th>
					<th>信誉</th>
					<th>操作</th>
				</tr>

				<s:iterator value="#result.listData" var="res">
					<tr>
						<td><s:property value="#res.number" /></td>
						<td><s:property value="#res.name" /></td>
						<td><s:property value="#res.city" /></td>
						<td><s:property value="#res.credit" /></td>

						<td><s:a namespace="/" action="supplier_input">编辑   
						      <s:param name="s.id" value="#res.id"></s:param>
							</s:a> <s:a namespace="/" action="supplier_delete">删除 <s:param
									name="s.id" value="#res.id"></s:param>
							</s:a></td>
					</tr>
				</s:iterator>



			</table>
			<div>
				<a> 共<s:property value="#result.totalcount" /> 条数据 当前页: <s:property
						value="#result.currentPage" /> / <s:property
						value="#result.totalpage" />
				</a>
				<s:a href="javascript:gopage(1)">首页</s:a>
				<s:a href="javascript:gopage(%{#result.prePage})">上一页
				</s:a>
				<s:a href="javascript:gopage(%{#result.nextPage})">下一页</s:a>
				<s:a href="javascript:gopage(%{#result.totalpage})">尾页</s:a>
			</div>
		</s:form>
		


	</div>
</body>
</html>