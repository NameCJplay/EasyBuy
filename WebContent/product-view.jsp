<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="entity.Product"%>
<%@page import="dao.ProductDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.recently_dao"%>

<%@page import="entity.product_category"%>
<%@page import="dao.Product_categoryDao"%>
<%@page import="entity.EASYBUY_USER"%><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	//获得文本框对象
	   var t = $("#text_box");
	//初始化数量为1,并失效减
	$('#min').attr('disabled',true);
	    //数量增加操作
	    $("#add").click(function(){    
	        t.val(parseInt(t.val())+1);
	        if (parseInt(t.val())!=1){
	            $('#min').attr('disabled',false);
	        }

	    }); 
	    //数量减少操作
	    $("#min").click(function(){
	        t.val(parseInt(t.val())-1);
	        if (parseInt(t.val())==1){
	            $('#min').attr('disabled',true);
	        }

	    });	
});
function gocar(id){
	 var count = $("#text_box").val();
	 
	 $.ajax({
			url:'shoppingcar_addServlet',
			type:'post',
			data:{epid:id,count:count},
			success:function(flag){
				if(flag==1){
					alert('加购成功');
				}
			
			}
			});
}

function goBuy(id){
	var count = $("#text_box").val();
	var price = $("#price").val();
	 $.ajax({
			url:'shopping_oneServlet',
			type:'post',
			data:{epid:id,count:count,price:price},
			success:function(flag){
				
					alert('生成二维码成功');				
					window.location.href="pay_one.jsp?img="+flag;

			}
			});
	
}



</script>
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
			<li class="last"><a href="#">Investor Relations</a></li>
		</ul>
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; <a href="product-list.jsp">图书音像</a> &gt; 图书
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
	</div>
	<%
	Product pro = (Product)request.getAttribute("p");
	EASYBUY_USER user = (EASYBUY_USER)request.getAttribute("user");
	
	
	
	%>

	<div id="product" class="main">
		
		<h1>${p.epname }</h1>
		
		<div class="infos">
			<div class="thumb">
				<img src="images/product/${p.epfilename }" style="width: 296px; height:313px;" />
			</div>
			<div class="buy">
				<p>商城价：<span class="price">￥${p.epprice }</span></p>
				<input type="hidden" id="price" value="${p.epprice }" />
				<p>库　存：
					${p.epstock}
				</p>
				<p>数    量： 
				<input id="min" name="" type="button" value="-" />  
				<input id="text_box" type="text" value="1" style="width:30px;" name="count" />  
				<input id="add" name="" type="button" value="+" /> 
				</p>
				<div class="button"><input type="button" name="button" value="" onclick="goBuy(${p.epid})" />
				<a href="javascript:gocar(${p.epid })">放入购物车</a></div>
			</div>
			<div class="clear"></div>
		</div>
		
		<div class="introduce">
			<h2><strong>商品详情</strong></h2>
			<div class="text">
				<br />
				<br />
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