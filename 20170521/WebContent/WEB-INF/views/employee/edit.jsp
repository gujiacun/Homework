<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
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
<title>小码哥员工管理-注册</title>
</head>
<body>
    <div class="container">
    <div style="width:800px;margin-left:auto;margin-right:auto;" >
        <div class="row">
            <div class="col-xs-4 accont_logo"></div>
        </div>
        <div class="row">
            <div class="col-xs-8">
            <s:property value="fieldErrors.username[0]"/>
                <s:form id="account_register" name="account_register" action="employee_saveOrUpdate"
                    namespace="/" class="form-horizontal" enctype="multipart/form-data">
                    <s:hidden name="e.id"></s:hidden>
                <!--     <div class="form-group">   -->
                        <label for="account_register_account_username"
                            class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-4">
                            <s:textfield name="e.username"
                                id="account_register_account_username" class="form-control"
                                placeholder="请输入用户名" />
                        </div>
                    <div class="form-group">
                        <label for="account_register_account_username"
                            class="col-sm-2 control-label">头像</label>
                        <div class="col-sm-4">
                            <s:file name="headImg"
                                 class="form-control"
                                placeholder="请上传头像" />
                        </div>
                        <div class="col-sm-6"></div>
                    </div>
                    <div class="form-group">
                        <!-- 假如是编辑页面，id不空，不显示密码栏，另外有专门的页面让用户修改密码；假如是注册页面，id是空的，所以显示密码一栏让用户输入-->
                        <s:if test="e.id==null">
                        <label for="account.password" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-4">
                            
                            <s:password name="e.password" showPassword="true" 
                                id="account_register_account_password" class="form-control"
                                placeholder="请输入密码" />
                        </div>
                        </s:if>
                        <div class="col-sm-6"></div>
                    </div>
                    <div class="form-group">
                        <label for="account.email" class="col-sm-2 control-label">邮箱</label>
                        <div class="col-sm-4">
                            <s:textfield  name="e.email" 
                                id="account_register_account_email" class="form-control"
                                placeholder="请输入邮箱" />
                        </div>
                        <div class="col-sm-6"></div>
                    </div>

                    <div class="form-group">
                        <label for="account_register_account_hireDate"
                            class="col-sm-2 control-label">雇佣日期</label>
                        <div class="col-sm-4">
                            <s:textfield name="e.hiredate"
                                id="account_register_account_hireDate" class="form-control"
                                placeholder="请输入雇佣日期" />
                        </div>
                        <div class="col-sm-6"></div>
                    </div>
                    <div class="form-group">
                        <label for="account_register_account_salary"
                            class="col-sm-2 control-label">工资</label>
                        <div class="col-sm-4">
                            <s:textfield name="e.salary"
                                id="account_register_account_salary" class="form-control"
                                placeholder="请输入工资" />
                        </div>
                        <div class="col-sm-6"></div>
                    </div>
                    
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-10">
                            <s:submit id="account_register_0" value="%{e.id==null?'添加':'编辑'}"
                                class="btn btn-success login_btn" />

                        </div>
                    </div>
                </s:form>
            </div>
        </div>
        </div>
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