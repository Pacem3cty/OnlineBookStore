<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
<%--表单验证 对空输入和不恰当的输入进行处理 --%>
	function InputCheck()
	{
		if( Update.id.value == "")
			{
				alert("修改的商品编号不能为空！");
				return false;
			}
		else if( Update.name.value == "")
		{
			alert("修改的商品名称不能为空！");
			return false;
		}
		else if( Update.price.value == "")
		{
			alert("修改的商品单价不能为空！");
			return false;
		}
		else if(Update.price.value >= 0)
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
        <meta http-equiv="Content-Type"
                content="text/html; charset=UTF-8">
        <title>修改信息</title>
        <style type="text/css">
		h1{background-color:#ECFFFF;opacity: 0.8;}
		a{background-color:#FFECF5;opacity: 0.8;}
		table{background-color:#D7FFEE;opacity: 0.8;}
		h3{background-color:#FFEEDD;opacity: 0.8;}
		</style>
    </head>
    <body>
    <h1 align="center">修改商品数据</h1>
     <a href="index_Administrator.jsp">返回主页</a>
       <a href="InfoQueryAll.jsp">返回修改</a>
       <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;修改商品数据</h3>
       <Font size=3>
		<FORM id="Update" action="GoodsInfoServlet?type=modify2" method=post onSubmit="return InputCheck()">
			<table>
			   <tr>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>商品编号：${GI.getId()}<Input type="hidden" name="id" value='${GI.getId()}' size=20 ></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>商品名称：<Input type="text" name="name" 
					value='${GI.getName()}' size=20></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>商品单价：<Input type="text" name="price" 
					value='${GI.getPrice()}' size=20></td>
				</tr>
			</table>
			<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<Input type="submit" name="b" value="提交修改">
		</FORM> </Font>
		<script type="text/javascript" src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js" color='102,185,255' zIndex='-10' opacity='50' count='99' src='JS'></script>
    </body>
</html>

