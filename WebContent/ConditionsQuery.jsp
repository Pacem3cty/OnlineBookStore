<%@ page contentType="text/html;charset=Utf-8" %>
<HTML>
<script type="text/javascript">//JavaScript表单验证
function CheckNameInput()//必填项输入验证 对空对象进行处理
{
	if(Name.name.value == "")
	{
		alert("商品名称不能为空！");
		return false;
	}
	else
		return true;
}
function CheckIdInput()//必填项输入验证 对空对象进行处理
{
	if(ID.id.value == "")
	{
		alert("商品编号不能为空！");
		return false;
	}
	else
		return true;
}
</script>
<head>
<meta charset="UTF-8">
<title>条件查询数据</title>
<style type="text/css">
h1{background-color:#ECFFFF;opacity: 0.8;}
a{background-color:#FFECF5;opacity: 0.8;}
 p{background-color:#ECECFF;opacity: 0.8;}
</style>
</head>
<BODY>
 <h1 align="center">条件查询商品信息</h1>
 <a href="index_Administrator.jsp">返回主页</a>
 <form id="Name" action="GoodsInfoServlet" method="post" onSubmit="return CheckNameInput()">
 <p>根据商品名称模糊查询商品信息:
 <p>输入商品名称:
  <Input type=text name="name">
  <Input type=submit name="g" value="查询">
  <Input type=hidden name="type" value="searchname">
</Form><br>
 <form id="ID" action="GoodsInfoServlet" method="post" onSubmit="return CheckIdInput()">
 <p>根据商品编号精确查询商品信息:
 <p>输入商品编号:
  <Input type=text name="id">
  <Input type=submit name="g" value="查询">
  <Input type=hidden name="type" value="searchid">
</Form>
<script type="text/javascript" src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js" color='102,185,255' zIndex='-10' opacity='50' count='99' src='JS'></script>　
</BODY></HTML>
