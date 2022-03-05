<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set target="${pageContext.request}" property="characterEncoding"
	value="UTF-8" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品信息条件查询结果</title>
<style type="text/css">
h1{background-color:#ECFFFF;opacity: 0.8;}
a{background-color:#FFECF5;opacity: 0.8;}
p{background-color:#ECECFF;opacity: 0.8;}
table{background-color:#D7FFEE;opacity: 0.8;}
h3{background-color:#FFEEDD;opacity: 0.8;}
</style>
</head>
<body>
 <a href="index_Administrator.jsp">返回主页</a>
  <a href="ConditionsQuery.jsp">继续查询</a>
 <br><h3>根据商品名称  ${param.name} 条件查询的结果</h3>
 	 <h3>根据商品编号  ${param.id} 条件查询的结果</h3>
	<p>查询记录共有${requestScope.line}行</p>
	<c:choose>
		<c:when test="${line!=0 }">
			<table align="center" border="1" cellpadding="2" cellspacing="2">
				<tbody>
					<tr align="center">
						<td>商品编号</td>
						<td>商品名称</td>
						<td>商品单价</td>
					</tr>
					<c:forEach var="GoodsInfo" items="${requestScope.query}">
						<tr align="center">
							<td>${GoodsInfo.id}</td>
							<td>${GoodsInfo.name}</td>
							<td>¥${GoodsInfo.price}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
			<br>没有查询到任何记录!
		</c:otherwise>
	</c:choose>
	<script type="text/javascript" src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js" color='102,185,255' zIndex='-10' opacity='50' count='99' src='JS'></script>
</body>
</html>

