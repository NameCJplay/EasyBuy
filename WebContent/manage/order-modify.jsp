<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="od" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="entity.easybuy_order"%><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/function-manage.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="../images/logo.gif" /></div>
	<div class="help"><a href="../index.jsp">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.jsp">首页</a></li>
			<li><a href="user_result">用户</a></li>
			<li><a href="ProductServlet">商品</a></li>
			<li class="current"><a href="order_result">订单</a></li>
			<li><a href="QuerycommentServlet">留言</a></li>
			<li><a href="news_result">新闻</a></li>
		</ul>
	</div>
</div>

			<%
				easybuy_order order = (easybuy_order)request.getAttribute("order");
			
			
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
		<h2>修改订单</h2>
		<div class="manage">
			<form action="order_update2" method="post">
				<table class="form">
					<tr>
						<td class="field">订单ID：</td>
						<td><input type="text" class="text" name="orderId" value="<%=order.getEo_id() %>" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="field">订购人姓名：</td>
						<td><input type="text" class="text" name="name" value="<%=order.getEo_user_name() %>" /></td>
					</tr>
					<tr>
						<td class="field">发货地址：</td>
						<td><input type="text" class="text" name="address" value="<%=order.getEo_user_address() %>" /></td>
					</tr>
					<tr>
						<td class="field">总价格：</td>
						<td><input type="text" class="text" name="cost" value="<%=order.getEo_cost() %>" /></td>
					</tr>
					<tr>
						<td class="field">订单状态：</td>
						<td>
							<select class="text" name="status">
								<%
									if(order.getEo_status()==1){
										%>
										<option value="1" selected="selected">已发货</option>
										<option value="2">待发货</option>	
										<option value="3">审批中</option>
										<option value="4">买家已付款</option>
										<option value="0">买家待付款</option>
									<% 
									}else if(order.getEo_status()==2){
										%>
										<option value="1">已发货</option>
										<option value="2" selected="selected">待发货</option>	
										<option value="3">审批中</option>
										<option value="4">买家已付款</option>
										<option value="0">买家待付款</option>
										<% 	
									}else if(order.getEo_status()==3){
										%>
										<option value="1">已发货</option>
										<option value="2">待发货</option>	
										<option value="3" selected="selected">审批中</option>
										<option value="4">买家已付款</option>
										<option value="0">买家待付款</option>
										<%	
									}else if(order.getEo_status()==4){
										%>
										<option value="1">已发货</option>
										<option value="2">待发货</option>	
										<option value="3">审批中</option>
										<option value="4"  selected="selected">买家已付款</option>
										<option value="0">买家待付款</option>
										<%	
									}else if(order.getEo_status()==0){
										%>
										<option value="1">已发货</option>
										<option value="2">待发货</option>	
										<option value="3">审批中</option>
										<option value="4">买家已付款</option>
										<option value="0"  selected="selected">买家待付款</option><option value="3" selected="selected">审批中</option>
										
										<%	
									}
									%>
							</select>
						
						</td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="更新" /></label></td>
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
