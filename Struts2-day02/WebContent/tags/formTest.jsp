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
<s:form namespace="/" action="saveOrUpdate" method="post" theme="simple">
    账号：<s:textfield name="usernme"></s:textfield><br>
 密码：<s:password name="password"></s:password><br>
 性别：<s:radio list="#{'1':'man','2':'woman','3':'unknown'}" name="gender" value="3"></s:radio><br>
  兴趣：<s:checkboxlist list="#{'1':'hirate','2':'risa','3':'manaka'}" name="hobbies" ></s:checkboxlist><br>
  城市：<s:select list="#{'1':'GZ','2':'BJ','3':'SH'}" headerKey="-1" headerValue="--请选择--"></s:select><br>
  个人简介：<s:textarea></s:textarea><br>
    <s:submit value="注册"></s:submit>
 </s:form>
</body>
</html>