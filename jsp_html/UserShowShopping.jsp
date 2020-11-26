<%@page import="entity.Shoppingcart"%>
<%@page import="dao.UserDao"%>
<%@page import="entity.User"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>后台管理</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
</head>
<body>
	<%
		int count = 0;
	int total = 0;
	ArrayList<Shoppingcart> slist = (ArrayList<Shoppingcart>) application.getAttribute("slist");
	String userid = (String) application.getAttribute("uuu");
	%>
		<div class="topbar-wrap white">
		<div class="topbar-inner clearfix">
			<div class="topbar-logo-wrap clearfix">
				<h1 class="topbar-logo none">
					<a href="index.html" class="navbar-brand">后台管理</a>
				</h1>
				<ul class="navbar-list clearfix">
					<li><a class="on" href="HomePage.html">首页</a></li>
					<li><a href="HomePage.html" target="_blank">网站首页</a></li>
				</ul>
			</div>
			<div class="top-info-wrap">
				<ul class="top-info-list clearfix">
					<li>当前用户：<%=userid%></li>
					<li><a href="./Login.html">退出</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container clearfix">
		<div class="sidebar-wrap">
			<div class="sidebar-title">
				<h1>菜单</h1>
			</div>
			<div class="sidebar-content">
				<ul class="sidebar-list">
					<li><a href=""><i class="icon-font">&#xe003;</i>所有管理</a>
						<ul class="sub-menu">
							<li><a href="UserHomePage.jsp"><i class="icon-font">&#xe008;</i>用户首页</a></li>
							<li><a href="./usc"><i class="icon-font">&#xe005;</i>全部商品</a></li>
							<li><a href="./uss"><i class="icon-font">&#xe006;</i>购物车</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
		<!--/sidebar-->

		<div class="main-wrap">
			<div class="crumb-wrap">
				<div class="crumb-list">
					<i class="icon-font"></i>首页<span
						class="crumb-step">&gt;</span><span class="crumb-name">购物车：</span>
				</div>
			</div>
			<div class="result-wrap">
				<form name="myform" id="myform" method="post">
					<div class="result-content">
						<table class="result-tab" width="100%">
							<tr>
								<th>时间</th>
								<th>商品</th>
								<th>价格</th>
								<th>操作</th>
								<th>操作</th>
							</tr>
							<c:forEach var="i" items="${slist}">
								<tr>
									<%
										count += 1;
									%>
									<td>${i.num}</td>
									<td>${i.id}</td>
									<td>${i.price}</td>
									<td><a
										href="./UserDeleteAShopping.jsp?deletenum=${i.num }">购买</a></td>
									<td><a href="./ubcs?deletenum=${i.num} ">删除</a></td>
								</tr>
							</c:forEach>
						</table>
						<div class="list-page">
							共条<%=count%>记录
						</div>
					</div>
				</form>
			</div>
			<div class="search-wrap">
				<div class="search-content">
					<table class="search-tab">
						<tr>
							<%
								for (Shoppingcart i : slist) {
								total += Integer.parseInt(i.getPrice());
							}
							%>
							<th>&gt;&gt;&gt;&gt;</th>
							<td><form action="./UserClearShopping.jsp" method="post">
									<input class="btn btn-primary btn2" name="sub" value="购买清空购物车"
										type="submit">
								</form></td>
							<td><form action="./udas" method="post">
									<input class="btn btn-primary btn2" name="sub" value="刪除所有"
										type="submit">
								</form></td>
							<td width="120">总价：<%=total%></td>

						</tr>
					</table>

				</div>
			</div>
		</div>
	</div>
</body>
</html>