<%@page import="entity.Commodity"%>
<%@page import="dao.UserDao"%>
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
					<li>当前用户：管理员</li>
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
					<li><a href="#"><i class="icon-font">&#xe003;</i>所有管理</a>
						<ul class="sub-menu">
							<li><a href="./a"><i class="icon-font">&#xe008;</i>用户列表</a></li>
							<li><a href="./ac"><i class="icon-font">&#xe005;</i>商品列表</a></li>
							<li><a href="./asa"><i class="icon-font">&#xe006;</i>销售报表</a></li>
							<li><a href="./ash"><i class="icon-font">&#xe004;</i>购买记录</a></li>	
						</ul></li>
				</ul>
			</div>
		</div>
		<!--/sidebar-->

		<div class="main-wrap">
			<div class="crumb-wrap">
				<div class="crumb-list">
					<i class="icon-font"></i>首页<span
						class="crumb-step">&gt;</span><span class="crumb-name">销售报表：</span>

				</div>
			</div>
			<div class="result-wrap">
				<form name="myform" id="myform" method="post">
					<div class="result-content">
						<table class="result-tab" width="100%">
							<tr>
								<th>时间</th>
								<th>用户名</th>	
								<th>商品编号</th>
								<th>订单编号</th>
							</tr>
							<c:forEach var="i" items="${hislist}">
								<tr>
									<%
										count += 1;
									%>
									<td>${i.time}</td>
									<td>${i.username}</td>
									<td>${i.id}</td>
									<td>${i.no}</td>
								</tr>
							</c:forEach>
						</table>
						<div class="list-page">
							共条<%=count%>记录
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>