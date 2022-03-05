<%@ page language="java" contentType="text/html;charset=utf-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>商品数据管理主页</title>
<style type="text/css">
h1{background-color:#ECFFFF;opacity: 0.8;}
a{background-color:#FFECF5;opacity: 0.8;}
 p{background-color:#ECECFF;opacity: 0.8;}
</style>
</head>
  <body>
  <h1 align="center">商品数据管理</h1><br>
  <p>欢迎您！${sessionScope.loginname}!</p>
  <a href="index.jsp">返回主页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="login_Administrator.jsp">退出登录</a>
    <h2 align="center">
	<a href="GoodsInfoServlet?type=searchallInit">顺序查询</a><br><br>
	<a href="ConditionsQuery.jsp">条件查询</a><br><br>
	<a href="AddInfo.jsp">添加数据</a><br><br>
	<a href="GoodsInfoServlet?type=infoqueryallInit">删改数据</a><br><br>
    </h2>
  <script type="text/javascript" src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js" color='102,185,255' zIndex='-10' opacity='50' count='99' src='JS'></script>　
  </body>
</html>