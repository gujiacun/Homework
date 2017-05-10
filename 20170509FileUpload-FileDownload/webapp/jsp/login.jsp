<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/upload" method="post" encType="multipart/form-data">
	<span style="color:red;">${errorMsg}</span>
		账号:<input type="text" name="text" /><br /> 
		头像:<input type="file"
			name="headImg" /><br /> 
		头像2:<input type="file"
			name="headImg" /><br /> 
			<input type="submit" name="regis" value="注册" /><br />
	</form>
</body>
</html>