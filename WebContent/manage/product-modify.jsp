<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/function-manage.js"></script>
<script type="text/javascript" src="../js/jquery-1.8.0.min.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="../images/logo.gif" /></div>
	<div class="help"><a href="../index.jsp">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.jsp">首页</a></li>
			<li><a href="user_result">用户</a></li>
			<li class="current"><a href="ProductServlet">商品</a></li>
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
		<h2>修改商品</h2>
		<div class="manage">
			<form action="UpdateProServlet" method="post" enctype="multipart/form-data">
				<input type="hidden" class="text" name="productid" value="${pro.epid }" />
				<table class="form">
					
					<tr>
						<td class="field">商品名称：</td>
						<td><input type="text" class="text" name="productdesc" value="${pro.epname }" /></td>
					</tr>
					<tr>
						<td class="field">所属分类：</td>
						<td>
							<select name="parentId">
								<c:forEach items="${pcatelist}" var="catelist">
									<c:if test="${catelist.EPC_PARENT_ID>0 }">
										<c:if test="${catelist.EPC_ID==pro.pcate.EPC_ID }">
											<option selected="selected" value="${catelist.EPC_ID }">${catelist.EPC_NAME }</option>
										</c:if>
										<c:if test="${catelist.EPC_ID!=pro.pcate.EPC_ID }">
											<option value="${catelist.EPC_ID }">${catelist.EPC_NAME }</option>
										</c:if>
									</c:if>
								</c:forEach>
								
							</select>
						</td>
					</tr>
					<tr>
						<td class="field">商品图片：</td>
						<td><input type="file" class="text" name="photo" value="${pro.epfilename }"/></td>
					</tr>
					<tr>
						<td class="field">商品价格：</td>
						<td><input type="text" class="text tiny" name="productPrice" value="${pro.epprice }" /> 元</td>
					</tr>
					<tr>
						<td class="field">品牌：</td>
						<td><input type="text" class="text" name="productName" value="${pro.epname }" /></td>
					</tr>
					<tr>
						<td class="field">库存：</td>
						<td><input type="text" class="text tiny" name="productstock" value="${pro.epstock }"/></td>
					</tr>
					<tr>
						<td class="field">是否特价：<br/>
						(1-为特价，0-为不特价)</td>
						<td><input type="text" class="text tiny" name="producttejia" value="${pro.epspecialprice }" /></td>
					</tr>
					<tr>
						<td class="field">是否特卖：<br/>
						(1-为特卖，0-为不特卖)</td>
						<td><input type="text" class="text tiny" name="producttemai" value="${pro.epspecialbuy }" /></td>
					</tr>
					<tr>
						<td class="field">条码号：</td>
						<td><input type="text" class="text" name="productchildid" value="${pro.epcchildid }"/></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="提交" /></label></td>
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
>