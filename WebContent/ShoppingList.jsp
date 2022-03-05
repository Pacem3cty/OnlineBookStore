<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>购物订单页面</title>
<style type="text/css">
	h1{background-color:#ECFFFF;opacity: 0.8;}
	a{background-color:#FFECF5;opacity: 0.8;}
	table{background-color:#D7FFEE;opacity: 0.8;}
	p{background-color:#ECECFF;opacity: 0.8;}
	</style>
</head>
<body>
<h1 align="center">购物订单</h1>
  <a href="index.jsp">返回主页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="Cart.jsp">返回购物车页面</a>
  &nbsp;&nbsp;&nbsp;&nbsp;<a href="index_Shopping.jsp">返回购物页面</a><br>
   <p>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   <img src="cart.jpg" height="60px" width="60px">已采购${sumnum}本书籍</p>
    <table align="center" border=1> 
    <tr align="center">
    <td>商品编号</td>
    <td>商品名称</td>
    <td>商品单价</td>
    <td>购买数量</td>
    <td>商品价格</td>
    </tr>
    <c:set value="0" var="sum" />
    <c:if test="${goodsinfoList!= null}">
    <c:forEach items="${goodsinfoList}" var="GIL">
    <c:if test="${GIL.getNum()>0}">
    <tr align="center">
    		<td>${GIL.getId()}</td>
        	<td>${GIL.getName()}</td>
        	<td>¥${GIL.getPrice()}</td>
        	<td>${GIL.getNum()}</td>
        	<td>¥${GIL.getNum()*GIL.getPrice()}</td>
        	<c:set value="${sum + GIL.getNum()*GIL.getPrice()}" var="sum" />
    </tr>
    </c:if>
    </c:forEach>
    </c:if>
  </table>
  <p>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  商品总计：¥${sum}</p>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="">支付订单</a>
  <script type="text/javascript" src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js" color='144,238,144' zIndex='-10' opacity='50' count='99' src='JS'></script>
</body>
</html>