<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>购物页面</title>
<style type="text/css">
	h1{background-color:#ECFFFF;opacity: 0.8;}
	a{background-color:#FFECF5;opacity: 0.8;}
	table{background-color:#D7FFEE;opacity: 0.8;}
	p{background-color:#ECECFF;opacity: 0.8;}
	</style>
</head>
<body>
<jsp:useBean id="GoodsInfo" class="model.GoodsInfo"></jsp:useBean>
<h1 align="center">购物界面</h1>
<p>欢迎您！${sessionScope.loginname}!</p>
  <a href="index.jsp">返回主页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="login_Customer.jsp">退出登录</a><br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <img src="cart.jpg" height="60px" width="60px">
  <a href="Cart.jsp">已采购 ${sessionScope.sumnum} 本书籍</a><br><br>
    <table align="center" border=1> 
    <tr align="center">
    <td>商品编号</td>
    <td>商品名称</td>
    <td>商品价格</td>
    <td>        </td>
    </tr>
    <c:if test="${goodsinfoList!= null}">
    <c:forEach items="${goodsinfoList}" var="GIL">
    <tr align="center">
    		<td>${GIL.getId()}</td>
        	<td>${GIL.getName()}</td>
        	<td>¥${GIL.getPrice()}</td>
        	<td><a href="ShoppingServlet?id=${GIL.getId()}">购买</a></td>
    </tr>
    </c:forEach>
    </c:if>
  </table>
  <script type="text/javascript" src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js" color='144,238,144' zIndex='-10' opacity='50' count='99' src='JS'></script>
</body>
</html>