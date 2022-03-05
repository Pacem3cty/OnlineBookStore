<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.sql.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<script type="text/javascript">
<%--表单验证 对空输入和不恰当的输入进行处理 --%>
	function InputCheck()
	{
		if( Register.id.value == "")
			{
				alert("用户编号不能为空！");
				return false;
			}
		else if( Register.loginname.value == "")
		{
			alert("用户名称不能为空！");
			return false;
		}
		else if( Register.password.value == "")
		{
			alert("登录密码不能为空！");
			return false;
		}
		else if(Register.refillpassword.value == ""||Register.refillpassword.value!=Register.password.value)
		{
		alert("两次输入的密码不一致！");
		return false;
		}
	}
</script>
<head>
<meta charset="UTF-8">
<title>购物用户注册</title>
<style type="text/css">
h1{background-color:#ECFFFF;opacity: 0.8;}
a{background-color:#FFECF5;opacity: 0.8;}
table{background-color:#D7FFEE;opacity: 0.8;}
h3{background-color:#FFEEDD;opacity: 0.8;}
</style>
</head>
<body>
	<h1 align="center">购物用户注册</h1>
	<a href="index.jsp">返回主页</a>
	<c:set target="${pageContext.request}" property="characterEncoding" value="UTf-8" />
	<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户注册</h3>
	<form id="Register" action="Register" method="post" onSubmit="return InputCheck()">
	<table>
	<tr>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>用户编号：</td>
					<td><Input type="text" name="id" size=15></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>用户名称：</td>
					<td><Input type="text" name="loginname" size=15></td>
				</tr><tr>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>登录密码：</td>
					<td><Input type="password" name="password" size=15></td>
				</tr><tr>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>确认密码：</td>
					<td><Input type="password" name="refillpassword" size=15></td>
				</tr>
	</table>
	<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;<Input type="submit" name="b" value="注册">&nbsp;&nbsp;&nbsp;&nbsp;<Input type="reset" name="b" value="重填">
	</form>
	<br>
	<script type="text/javascript" src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js" color='144,238,144' zIndex='-10' opacity='50' count='99' src='JS'></script>　
</body>
</HTML>
