<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function randomCode2(){
	document.getElementById("randomCode").src="/randomCode";
}
</script>
</head>
<body>
<span style="red;">${errorMsg}</span>
<form action="/login" method="post">
账号:<input placeholder="账号" name="username" /><br>
密码:<input type="password" placeholder="密码" name="password" /><br>
<input type="submit" value="登陆"><br>
验证码：<input name="randomCode" />
<img alt="" src="/randomCode" onclick="randomCode2();" id="randomCode"><br>

<a href="/logout">退出登录</a>
</form>

</body>
</html>