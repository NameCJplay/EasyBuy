<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="car"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="entity.t_shopping_car"%>
<%@page import="entity.Product"%>
<%@page import="dao.ProductDao"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
function Delete(id){
	var boo = confirm('确定删除？');
		if(boo){

			$.ajax({
				url:'shoppingcar_deleteServlet?id='+id,
				type:'get',
				success:function(flag){
					if(flag==1){
					$("#"+id).empty();
				}
				}
			});

			
		
		}}
</script>
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
	您现在的位置：<a href="index.html">易买网</a> &gt; 购物车
</div>
<div class="wrap">
	<div id="shopping">
		<form action="shoppingServlet"  method="post">
			<table>
				<tr>
					<th>商品名称</th>
					<th>商品价格</th>
					<th>购买数量</th>
					<th>操作</th>
				</tr>
				<%
				ProductDao pdd = new ProductDao();
				
				ArrayList<t_shopping_car> carlist =
					(ArrayList<t_shopping_car>)request.getAttribute("carlist");
				
				
				
				%>
				<%
				for(int i = 0;i<carlist.size();i++){
					t_shopping_car tc = carlist.get(i);
					Product pd = pdd.selectbyid(tc.getC_g_id());
					
					%>
				<tr id="<%=tc.getC_id() %>">
				
					<td class="thumb"><img  style="width: 90px;height: 90px;" src="images/product/<%=pd.getEpfilename() %>" /><a href="recentlyServlet?epid=<%=pd.getEpid() %>"><%=pd.getEpname() %></a></td>
					<td class="price" id="price_id_1">
						<span>￥<%=pd.getEpprice() %></span>
						<input type="hidden" value="<%=pd.getEpprice() %>" name="price" />
						<input type="hidden" value="<%=pd.getEpid() %>" name="id" />
						<input type="hidden" value="<%=tc.getC_id() %>" name="carid" />
					</td>
					<td class="number">
						<dl>
							<dt><input id="number_id_1" type="text" name="number" value="<%=tc.getC_g_count() %>" /></dt>
							<dd onclick="">修改</dd>
						</dl>
					</td>
					<td class="delete"><a href="javascript:Delete(<%=tc.getC_id() %>)">删除</a></td>
				</tr>
					
					
					<%
				}
				%>
				
				
				
				
				
			
			</table>
			<div class="button"><input type="submit" value="" /></div>
		</form>
	</div>
	<script type="text/javascript">
		document.write("Cookie中记录的购物车商品ID："+ getCookie("product") + "，可以在动态页面中进行读取");
	</script>
</div>
<div id="footer">
	Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
