<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="entity.easybuy_order"%><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/function-manage.js"></script>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
	function Delete(eo_id){
	var boo = confirm('确定删除？');


		if(boo){
			location.href='order_delete?eo_id='+eo_id;
		
		}}
</script>



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
		<h2>订单管理</h2>
		<div class="manage">
			<div class="search">
				<form method="get" action="order_selectlike">
					订单号：<input type="text" class="text" name="orderId" />
					 订货人：<input type="text" class="text" name="userName" /> 
					 <label class="ui-blue">
					 <input type="submit" name="submit" value="查询" />
					 </label>
				</form>
			</div>
			<div class="spacer"></div>
			<table class="list">
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>发货地址</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				
				<%
				String pages = 
					(String)request.getAttribute("page");
				
				ArrayList<easybuy_order> orderlist = 
					(ArrayList<easybuy_order>)request.getAttribute("orderlist");
				
				for(int i = 0;i< orderlist.size() ; i++){
					easybuy_order order = orderlist.get(i);
				
				%>
					<tr id="<%=order.getEo_id() %>">
					<td class="first w4 c"><%=order.getEo_user_id() %></td>
					<td class="w1 c"><%=order.getEo_user_name() %></td>
					<td><%=order.getEo_user_address() %></td>
					<td class="w1 c">
					<%
					if(order.getEo_status()==1){
						%>
						已发货
					<%
					}else if(order.getEo_status()==2){
						%>
						待发货
					<%
					}else if(order.getEo_status()==3){
						%>
						审批中
					<%
					}else if(order.getEo_status()==4){
						%>
						买家已付款
					<%
					}else if(order.getEo_status()==0){
					%>
						买家待付款
					<%
					}
					%>
					</td>
						<td class="w1 c">
						<a href="order_update?eid=<%=order.getEo_id() %>">修改</a> 
						<a href="javascript:Delete(<%=order.getEo_id() %>);">删除</a>
						</td>
					</tr>
				
				
				<%
				}
				%>
				
				
				
			</table>
			<div class="pager">
				<ul class="clearfix">
					<%
					if(pages !=null){
					%>
						<%=pages %>
					<%
					}
					%>
				</ul>
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
