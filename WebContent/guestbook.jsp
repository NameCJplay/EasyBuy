<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="entity.product_category"%>
<%@page import="dao.Product_categoryDao"%>
<%@page import="entity.EASYBUY_USER"%>
<%@page import="entity.comment"%>
<%@page import="dao.CommentDao"%><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><a href="#" class="shopping">购物车</a><a href="login.html">登录</a><a href="register.html">注册</a><a href="guestbook.jsp">留言</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="index.jsp">首页</a></li>
			<li><a href="#">图书</a></li>
			<li><a href="#">百货</a></li>
			<li><a href="#">品牌</a></li>
			<li><a href="#">促销</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="wrap">
		<ul class="clearfix">
			<li class="first"><a href="#">音乐</a></li>
			<li><a href="#">影视</a></li>
			<li><a href="#">少儿</a></li>
			<li><a href="#">动漫</a></li>
			<li><a href="#">小说</a></li>
			<li><a href="#">外语</a></li>
			<li><a href="#">数码相机</a></li>
			<li><a href="#">笔记本</a></li>
			<li><a href="#">羽绒服</a></li>
			<li><a href="#">秋冬靴</a></li>
			<li><a href="#">运动鞋</a></li>
			<li><a href="#">美容护肤</a></li>
			<li><a href="#">家纺用品</a></li>
			<li><a href="#">婴幼奶粉</a></li>
			<li><a href="#">饰品</a></li>
			<li class="last"><a href="#">Investor Relations</a></li>
		</ul>
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 在线留言
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<div class="box">
			<h2>商品分类</h2>
			<dl>
			<%
			
			ArrayList<product_category> pclist=new Product_categoryDao().select();	
			ArrayList<comment> comlist = new CommentDao().selectall();
			

			%>
			<%
			for(int i =0;i<pclist.size();i++){
				product_category p = pclist.get(i);
				if(p.getEPC_PARENT_ID()==0){
					 ArrayList<product_category> pare=
						 new Product_categoryDao().selectpare(p.getEPC_ID());
					%>
					<dt><%=p.getEPC_NAME() %></dt>
					<%
					for(int j =0;j<pare.size();j++){
						product_category pj = pare.get(j);
						%>
						<dd><a href="product-list.html"><%=pj.getEPC_NAME() %></a></dd>
					<%
				}
				}}
			%>
			</dl>
		</div>
	</div>
	<div class="main">
		<div class="guestbook">
			<h2>全部留言</h2>
			<ul>
			<%
			for(int j=comlist.size()-1;j>=comlist.size()-4;j--){
				comment com = comlist.get(j);
				%>
				<li>
					<dl>
						<dt><%=com.getEccontent() %></dt>
						<dd class="author">网友：<%=com.getEc_nick_name() %> <span class="timer"><%=com.getEc_create_time() %></span></dd>
						<dd><%=com.getEcreply() %></dd>
					</dl>
				</li>
			<%
			}
			%>
			</ul>
			<div class="clear"></div>
			<div class="pager">
				<ul class="clearfix">
					
				</ul>
			</div>
			<div id="reply-box">
			
				<form action="ADDcommentServlet" method="post">
					<table>
						<tr>
							<td class="field">昵称：</td>
							<td><input class="text" type="text" name="guestName" value="${user.eu_user_name }" readonly="readonly"/></td>
						</tr>
						<tr>
							<td class="field">留言内容：</td>
							<td><textarea name="guestContent"></textarea></td>
						</tr>
						<tr>
							<td></td>
							<td><label class="ui-blue"><input type="submit" name="submit" value="提交留言" /></label></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
