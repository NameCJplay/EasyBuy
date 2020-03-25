<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="in" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ArrayList"%>
<%@page import="entity.product_category"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="dao.Product_categoryDao"%>
<%@page import="dao.news_dao"%>
<%@page import="entity.news"%>
<%@page import="dao.ProductDao"%>
<%@page import="entity.Product"%>
<%@page import="entity.comment"%>
<%@page import="dao.CommentDao"%>
<%@page import="dao.recently_dao"%>

<%@page import="entity.recently"%><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>

</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><a href="shoppingcar_Servlet" class="shopping">购物车</a><a href="login.html">登录</a><a href="register.html">注册</a><a href="guestbook.jsp">留言</a></div>
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
			<li class="last"><a href="manage/index.jsp">Investor Relations</a></li>
		</ul>
	</div>
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<div class="box">
			<h2>商品分类</h2>
			<dl>
			<%
			ArrayList<product_category> pclist=new Product_categoryDao().select();			
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
						<dd><a href="product-list.jsp"><%=pj.getEPC_NAME() %></a></dd>
					<%
				}
				}}
			%>
			
			</dl> 
		</div>
		<div class="spacer"></div>
		<%
			recently_dao rd = new recently_dao();
			ProductDao pd = new ProductDao();
			ArrayList<Product> prli = pd.select();
			ArrayList<recently> reli = rd.selectByUid();
			
			
		%>
		<div class="last-view">
			<h2>最近浏览</h2>
			<dl class="clearfix">
				
			<%for(int k=0;k<reli.size();k++){
				recently rc = reli.get(k);
				Product pro = pd.selectbyid(rc.getR_p_id());
				%>
				<dt>
				<a href="recentlyServlet?epid=<%=pro.getEpid() %>">
				<img style="width: 40px" src="images/product/<%=pro.getEpfilename() %>" />
				</a>
				</dt>
				<dd><a href="recentlyServlet?epid=<%=pro.getEpid() %>"><%=pro.getEpname() %></a></dd>
				
				<%
				
				
			} %>

			</dl>
		</div>
	</div>
	
	
	<div class="main">
		<div class="price-off">
			<h2>今日特价</h2>
			<ul class="product clearfix">
				
				<%
				int num = 0;
				for(int i =0 ;i<prli.size();i++){
					Product prd = prli.get(i);
					if(prd.getEpspecialprice().equals("1")){
						if(num<8){
					%>
					<li>
					<dl id="<%=prd.getEpid() %>">
						<dt><a href="recentlyServlet?epid=<%=prd.getEpid() %>" target="_blank"><img src="images/product/<%=prd.getEpfilename() %>" /></a></dt>
						<dd class="title"><a href="recentlyServlet?epid=<%=prd.getEpid() %>" target="_blank"><%=prd.getEpname() %></a></dd>
						<dd class="price">￥<%=prd.getEpprice() %></dd>
					</dl>
				</li>
					
					<%
					num++;
					}
					}}
				%>
				
			</ul>
		</div>
		<%
		CommentDao cd = new CommentDao();
		ArrayList<comment> cdlist = cd.selectall();
		
		%>
		
		<div class="side">
			<div class="news-list">
				<h4>最新公告</h4>
				<ul>
					
					<%for(int i =0;i<cdlist.size();i++){
						comment cs = cdlist.get(i);
						%>
						<li><a href="com_view?comid=<%=cs.getEcid() %>" target="_blank"><%=cs.getEccontent() %></a></li>
						<%
					} %>
				</ul>
			</div>
			<div class="spacer"></div>
			
			<%
			news_dao nd = new news_dao();
			ArrayList<news> nlist = nd.selectall();
			%>
			<div class="news-list">
				<h4>新闻动态</h4>
				<ul>
					<%for(int i =0;i<nlist.size();i++){
						news ns = nlist.get(i);
						%>
						<li><a href="news_view?newid=<%=ns.getEN_ID() %>" target="_blank"><%=ns.getEN_TITLE() %></a></li>
						
						<%
					} %>
					
				</ul>
			</div>
		</div>
		<div class="spacer clear"></div>
		<div class="hot">
			<h2>热卖推荐</h2>
			<ul class="product clearfix">
				
				<%
					for(int b = 0;b<prli.size();b++){
						Product pro = prli.get(b);
						if(pro.getEpspecialbuy().equals("1")){
				%>
				<li>
					<dl id="<%=pro.getEpid() %>">
						<dt><a href="recentlyServlet?epid=<%=pro.getEpid() %>" target="_blank"><img src="images/product/<%=pro.getEpfilename() %>" /></a></dt>
						<dd class="title"><a href="recentlyServlet?epid=<%=pro.getEpid() %>" target="_blank"><%=pro.getEpname() %></a></dd>
						<dd class="price">￥<%=pro.getEpprice() %></dd>
					</dl>
				</li>
				<%
						}
					}
				%>
			</ul>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
