<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,model.DBUtil,dao.GoodsInfoDao,model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type"
                content="text/html; charset=UTF-8">
        <title>删改商品信息</title>
        <style type="text/css">
		h1{background-color:#ECFFFF;opacity: 0.8;}
		a{background-color:#FFECF5;opacity: 0.8;}
		table{background-color:#D7FFEE;opacity: 0.8;}
		</style>
    </head>
    <body>
    <h1 align="center">删改商品信息</h1>
     <a href="index_Administrator.jsp">返回主页</a>
   
        <table align="center" style="text-align: left; width: 70%;" border=""
               cellpadding="2" cellspacing="2">
            <tbody>
            <tr align="center">
            			<td>商品编号</td>
						<td>商品名称</td>
						<td>商品单价</td>
						<td>数据操作</td>
					</tr>
					 <c:if test="${goodsinfoList!= null}">
					    <c:forEach items="${goodsinfoList}" var="GIL">
					    <tr align="center">
					    		<td>${GIL.getId()}</td>
					        	<td>${GIL.getName()}</td>
					        	<td>¥${GIL.getPrice()}</td>
					        	<td><a href='GoodsInfoServlet?id=${GIL.getId()}&&type=del'>删除</a><br>
					        	<a href='GoodsInfoServlet?id=${GIL.getId()}&&type=modify1'>修改</a></td>
					    </tr>
					    </c:forEach>
					  </c:if>
					  <script type="text/javascript" src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js" color='102,185,255' zIndex='-10' opacity='50' count='99' src='JS'></script>　
            </tbody>
        </table>
    </body>
</html>

