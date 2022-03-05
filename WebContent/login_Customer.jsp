<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<script type="text/javascript">//JavaScript表单验证
function CheckFormInput()//必填项输入验证 对空对象进行处理
{
	if(Form.loginname.value == "")
	{
		alert("用户名称不能为空！");
		return false;
	}
	else if(Form.password.value == "")
	{
		alert("登录密码不能为空！");
		return false;
	}
	else
		return true;
}
</script>
<head>
<meta charset="utf-8">
<title>购物登录页面</title>
<style type="text/css">
h1{background-color:#ECFFFF;opacity: 0.8;}
a{background-color:#FFECF5;opacity: 0.8;}
table{background-color:#D7FFEE;opacity: 0.8;}
 p{background-color:#ECECFF;opacity: 0.8;}
</style>
</head>
<body>
  <h1 align="center">购物登录</h1>
  <a href="index.jsp">返回主页</a>
  <p>请登录</p>
  <form id="Form" action="CheckloginServlet?type=Customer" method="post" onSubmit="return CheckFormInput()">
   <table>
	<tr>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>用户名称：</td>
					<td><Input type="text" name="loginname" size=15></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>登录密码：</td>
					<td><Input type="password" name="password" size=15></td>
				</tr>
	</table>
	<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;<Input type="submit" name="b" value="登录">&nbsp;&nbsp;&nbsp;&nbsp;<Input type="reset" name="b" value="重填">&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="register_Customer.jsp">立即注册</a>
	</form>
  <script type="text/javascript" src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js" color='144,238,144' zIndex='-10' opacity='50' count='99' src='JS'></script>　
</body>
</html>