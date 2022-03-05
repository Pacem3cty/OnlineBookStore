<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.sql.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<script type="text/javascript">
<%--表单验证 对空输入和不恰当的输入进行处理 --%>
	function InputCheck()
	{
		if( Add.id.value == "")
			{
				alert("添加的商品编号不能为空！");
				return false;
			}
		else if( Add.name.value == "")
		{
			alert("添加的商品名称不能为空！");
			return false;
		}
		else if( Add.price.value == "")
		{
			alert("添加的商品单价不能为空！");
			return false;
		}
		else if(Add.price.value >= 0)
			{
				
				return true;
			}
		else
			{//输入字母及其他字符也会报错
			alert("请输入正确的商品单价！");
				return false;
			}
	}
</script>
<head>
<meta charset="UTF-8">
<title>添加商品数据</title>
<style type="text/css">
h1{background-color:#ECFFFF;opacity: 0.8;}
a{background-color:#FFECF5;opacity: 0.8;}
table{background-color:#D7FFEE;opacity: 0.8;}
h3{background-color:#FFEEDD;opacity: 0.8;}
</style>
</head>
<body>
	<h1 align="center">添加商品数据</h1>
	<a href="index_Administrator.jsp">返回主页</a>
	<c:set target="${pageContext.request}" property="characterEncoding" value="UTf-8" />
	<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;添加商品信息</h3>
	<form id="Add" action="GoodsInfoServlet?type=add" method="post" onSubmit="return InputCheck()">
	<table>
	<tr>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>商品编号：</td>
					<td><Input type="text" name="id" size=15></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>商品名称：</td>
					<td><Input type="text" name="name" size=15></td>
				</tr><tr>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>商品单价：</td>
					<td><Input type="text" name="price" size=15></td>
				</tr>
	</table>
	<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;<Input type="submit" name="b" value="提交添加">
	</form>
	<br>
	<script type="text/javascript" src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js" color='102,185,255' zIndex='-10' opacity='50' count='99' src='JS'></script>　
</body>
</HTML>
