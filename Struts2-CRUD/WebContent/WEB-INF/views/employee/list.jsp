<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet"
	href="./plugins/bootstrap-3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="./css/base.css">
<link rel="stylesheet" href="./css/style.css">
<script src="./plugins/jquery-1.11.2.min.js"></script>
<script src="./plugins/bootstrap-3.3.5/js/bootstrap.min.js"></script>
<link rel="shortcut icon" href="./imgs/xiaomage.ico" type="image/x-icon">
<title>小码哥员工管理-首页</title>
<script type="text/javascript">
	function goPage(currentPage) {
		//为currentPage设值
		document.getElementById("currentPage").value = currentPage;
		//提交表单
		document.forms[0].submit();
	}
</script>
<script type="text/javascript" src="/plugins/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
	<div class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav navbar-right">
				<li>
					<a href="#">登录</a>
				</li>
				<li>
					<s:a namespace="/" action="emp_input">注册</s:a>
				</li>
				<li>
					<a href="#">注销</a>
				</li>
			</ul>
		</div>
	</div>
	<div class="searchbar">
		<div class="searchbar_container">
			<div class="row">
				<div class="col-xs-3">
					<img alt="" src="imgs/logo.png">
				</div>
			</div>
		</div>
	</div>
	<div class="container index_content">
		<div class="col-xs-12 index_right">
			<div class="content-container">
				<div class="content-container-head">
					<h4>高级查询</h4>
				</div>
			</div>



			<s:form class="form-inline" role="form" namespace="/" action="emp"
				theme="simple">
				<s:hidden name="qo.currentPage" id="currentPage"></s:hidden>
				<div class="form-group">
					<label class="sr-only" for="exampleInputEmail2"></label>

					<s:textfield class="form-control" id="exampleInputEmail2"
						placeholder="姓名" name="qo.username"></s:textfield>
				</div>
				<div class="form-group">
					<label class="sr-only" for="exampleInputEmail2"></label>
					<s:textfield class="form-control" id ="exampleInputEmail2"
						placeholder="邮箱" name="qo.email"></s:textfield>
				</div>
				<div class="form-group">
					<label class="sr-only" for="exampleInputEmail2"></label>
					<s:textfield class="form-control" id="exampleInputEmail2"
						placeholder="开始日期" name="qo.beginHireDate" onclick="WdatePicker()"></s:textfield>
				</div>
				<div class="form-group">
					<label class="sr-only" for="exampleInputEmail2"></label>
					<s:textfield class="form-control" id="exampleInputEmail2"
						placeholder="结束日期" name="qo.endHireDate" onclick="WdatePicker()"></s:textfield>
				</div>
				<s:submit class="btn btn-default" value="搜索"></s:submit>
			</s:form>








			<div class="row" style="padding-top: 20px;">

				<table class="table table-hover">
					<tr>
						<th>编号</th>
						<th>头像</th>
						<th>用户名</th>
						<th>密码</th>
						<th>邮箱</th>
						<th>雇佣日期</th>
						<th>工资</th>
						<th>操&emsp;&emsp;作</th>
					</tr>
					<s:iterator value="#result.listData" var="e">
						<tr>
							<td>
								<s:property value="#e.id" />
							</td>
							<td>
							<img alt="" src="<s:property value="#e.headImg" default="/upload/default.jpg"/>" width="40px">
							</td>
							<td>
								<s:property value="#e.username" />
							</td>
							<td>
								<s:property value="#e.password" />
							</td>
							<td>
								<s:property value="#e.email" />
							</td>
							<td>
								<s:date name="#e.hiredate" format="yyyy-MM-dd" />
							</td>
							<td>
								<s:property value="#e.salary" />
							</td>
							<td>
								<s:a namespace="/" action="emp_input">编辑
									<s:param name="e.id" value="#e.id"></s:param>
								</s:a>
								|
								<s:a namespace="/" action="emp_delete">删除
									<s:param name="e.id" value="#e.id"></s:param>  
								</s:a>
							</td>
						</tr>
					</s:iterator>

				</table>

			</div>
		</div>
		<nav>
		<ul class="pagination">
			<li>
				<a>
					共
					<s:property value="#result.totalCount" />
					条数据 当前页:
					<s:property value="#result.currentPage" />
					/
					<s:property value="#result.totalPage" />
				</a>
			</li>
			<li>
				<s:a href="javascript:goPage(1);">首页</s:a>
			</li>
			<li>
				<s:a href="javascript:goPage(%{#result.prePage});">上一页</s:a>
			</li>
			<li>
				<s:a href="javascript:goPage(%{#result.nextPage});">下一页</s:a>
			</li>
			<li>
				<s:a href="javascript:goPage(%{#result.totalPage});">尾页</s:a>
			</li>
		</ul>
		</nav>
	</div>
	<div class="footer">
		<ul class="list-inline copy-right">
			<li>© 2015－2016 小码哥教育</li>
			<li>广州小码哥Java学院</li>
			<li>专注于高级Java开发工程师的培养</li>
			<li>地址：广州市天河区棠下荷光三横路盛达商务园D座5楼</li>
		</ul>
	</div>

</body>
</html>