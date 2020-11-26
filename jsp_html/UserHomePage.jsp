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
					<i class="icon-font">&#xe06b;</i><span>欢迎来到小键盘商店</span>
				</div>
			</div>
			<div class="result-wrap">
				<div class="result-title">
					<h1>快捷操作</h1>
				</div>
				<div class="result-content">
					<div class="short-wrap">
						<a href="UserUpdateUser.jsp"><i class="icon-font">&#xe001;</i>修改密码和邮箱</a>
						<a href="./udeu"><i class="icon-font">&#xe005;</i>注销</a>
					</div>
				</div>
			</div>
			<div class="result-wrap">
				<div class="result-title">
					<h1>系统基本信息</h1>
				</div>
				<div class="result-content">
					<ul class="sys-info-list">
						<li><label class="res-lab">用户名</label><span class="res-info"><%=userid%></span>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>