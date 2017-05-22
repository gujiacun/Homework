<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:debug></s:debug>
    <h1>商品信息列表</h1>
    <s:a namespace="/" action="prooduct_saceOrUpdate">添加商品</s:a>
    <table border="1" cellpadding="0" cellspacing="0" width="70%" style="text-align: center;">
        <tr style="background-color: gray;">
            <th>序号</th>
            <th>编号</th>
            <th>名称</th>
            <th>价格</th>
            <th>数量</th>
            <th>操作</th>
        </tr>
        
        <s:iterator value="#request.list" var="item" status="s" >
        <tr>
            <td>
                <s:property value="#s.count"/>
            </td>
            <td>
                <s:property value="#item.id"/>
            </td>
            <td>
                <s:property value="#item.name"/>
            </td>
            <td>
                <s:property value="#item.price"/>
            </td>
            <td>
                <s:property value="#item.stockNum"/><br>
            </td>
            <td>
                <s:a namespace="/" action="product_delete">删除
                    <s:param name="item.id" value="item.id"></s:param>
                    </s:a>|
                <s:a namespace="/" action="product_input">
                <s:param name="item.id" value="item.id"></s:param>
                                                        编辑</s:a>
            </td>
         </tr>
        </s:iterator>
        
        
  <!--       <c:forEach items="${list}" var="product" varStatus="vs">
        <tr style="background-color:${vs.count%2==0?'gray':''} ;">
            <td>${vs.count}</td>
            <td>${product.id }</td>
            <td>${product.name }</td>
            <td>${product.price }</td>
            <td>${product.stockNum }</td>
            <td><a href="/product?cmd=delete&id=${product.id}">删除</a>
                <a href="/product?cmd=edit&id=${product.id}">编辑</a> |
            </td>
        </tr>
        </c:forEach>
         --> 
        
      <!-- 
            <tr style="background-color: ;">
                <td>1</td>
                <td>8</td>
                <td>键盘</td>
                <td>109.00</td>
                <td>100.00</td>
            </tr>
        
            <tr style="background-color: gray;">
                <td>2</td>
                <td>9</td>
                <td>鼠标</td>
                <td>59.00</td>
                <td>200.00</td>
                <td><a href="http://localhost:8080/item?cmd=edit&amp;id=9">编辑</a> |
                    <a href="http://localhost:8080/item?cmd=delete&amp;id=9">删除</a></td>
            </tr>
        
            <tr style="background-color: ;">
                <td>3</td>
                <td>10</td>
                <td>摄像头</td>
                <td>199.00</td>
                <td>200.00</td>
                <td><a href="http://localhost:8080/item?cmd=edit&amp;id=10">编辑</a> |
                    <a href="http://localhost:8080/item?cmd=delete&amp;id=10">删除</a></td>
            </tr>
        
            <tr style="background-color: gray;">
                <td>4</td>
                <td>11</td>
                <td>545</td>
                <td>54.00</td>
                <td>45.00</td>
                    <a href="/product?cmd=delete&id=${stu.id}">删除</a>
                <td><a href="/product?cmd=edit&id=${stu.id}">编辑</a> |
                </td>
            </tr>
         -->  
    </table>
</body>
</html>