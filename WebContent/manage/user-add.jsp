<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="java.util.Date"%><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/function-manage.js"></script>
<script type="text/javascript" src="../js/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
$(function(){

	

	var year = $("[name=birthyear]").val();
	var month = $("[name=birthmonth]").val();
	var day = $("[name= birthday]");

	var date = Number(31);

	if(month == 4 || month == 6 || month == 9 || month==11){
		date = 30;
	}else if(month==2){
		if(year % 4 == 0 && year % 100!=0 || year % 400==0){
			date = 29;
		} else {
			date = 28;
		}
	}

	day.empty();

	for(var d = 1; d <= date ;d++){
		day.append("<option value='"+d+"'>"+d+"</option>");
	}

	
	
});

</script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="../images/logo.gif" /></div>
	<div class="help"><a href="../index.jsp">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.jsp">首页</a></li>
			<li class="current"><a href="user_result">用户</a></li>
			<li><a href="ProductServlet">商品</a></li>
			<li><a href="order_result">订单</a></li>
			<li><a href="QuerycommentServlet">留言</a></li>
			<li><a href="news_result">新闻</a></li>
		</ul>
	</div>
</div>
<%
	SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
	String time = sim.format(new Date());
%>
<div id="childNav">
	<div class="welcome wrap">
		${user.eu_user_name }您好，今天是<%=time %>，欢迎回到管理后台。
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>用户管理</dt>
				<dd><em><a href="user-add.jsp">新增</a></em><a href="user_result">用户管理</a></dd>
				<dt>商品信息</dt>
				<dd><em><a href="productClass-add.jsp">新增</a></em><a href="SelectPcServlet">分类管理</a></dd>
				<dd><em><a href="product-add.jsp">新增</a></em><a href="ProductServlet">商品管理</a></dd>
				<dt>订单管理</dt>
				<dd><a href="order_result">订单管理</a></dd>
				<dt>留言管理</dt>
				<dd><a href="QuerycommentServlet">留言管理</a></dd>
				<dt>新闻管理</dt>
				<dd><em><a href="news-add.jsp">新增</a></em><a href="news_result">新闻管理</a></dd>
			</dl>
		</div>
	</div>
	<div class="main">
		<h2>新增用户</h2>
		<div class="manage">
			<form action="user_add" method="post">
				<table class="form">
					<tr>
						<td class="field">用户名：</td>
						<td><input type="text" class="text" name="userName" value="" /></td>
					</tr>
					<tr>
						<td class="field">密码：</td>
						<td><input type="password" class="text" name="passWord" value="" /></td>
					</tr>
					<tr>
						<td class="field">性别：</td>
						<td><input type="radio" name="sex" value="T" checked="checked" />男 <input type="radio" name="sex" value="F" />女</td>
					</tr>
					<tr>
						<td class="field">出生日期：</td>
						<td>
							<select name="birthyear">
									<%for(int i = 2019;i>=1900;i--){
										
										%>
										<option value="<%=i %>"><%=i %></option>
										<%
									} %>
							</select>年
							<select name="birthmonth" onchange="change()">
									<%for(int i = 1;i<=12;i++){
										
										%>
										<option value="<%=i %>"><%=i %></option>
										<%
									} %>
							</select>月
							<select name="birthday">
									
							</select>日
						</td>
					</tr>
					<tr>
						<td class="field">手机号码：</td>
						<td><input type="text" class="text" name="mobile" value="" /></td>
					</tr>
					<tr>
						<td class="field">送货地址：</td>
						<td><input type="text" class="text" name="address" value="" /></td>
					</tr>
					<tr>
						<td class="field">头像：</td>
						<td><input type="file" class="text" name="photo" /></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="添加" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>

</html>
