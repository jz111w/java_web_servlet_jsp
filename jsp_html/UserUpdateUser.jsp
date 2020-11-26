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
		String username = (String) application.getAttribute("uuu");
	User user = UserDao.selectByUsername(username);
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
					<li>当前用户：<%=username%></li>
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
		<div class="main-wrap">
			<div class="crumb-wrap">
				<div class="crumb-list">
					<i class="icon-font"></i>首页<span class="crumb-step">&gt;</span><span
						class="crumb-name">用户列表：</span>用户修改：
				</div>
			</div>
			<div class="result-wrap">
				<form action="./uuuc" method="post">
					<div class="config-items">
						<div class="config-title">
							<h1>
								<i class="icon-font">&#xe00a;</i>用戶修改
							</h1>
						</div>
						<div class="result-content">
							<table width="100%" class="insert-tab">
								<tbody>
									<tr>
										<th width="15%"><i class="require-red"></i>用戶名：</th>
										<td><%=username%></td>
									</tr>
									<tr>
										<th><i class="require-red">*</i>新密码：</th>
										<td><input type="text" id="" size="85" name="password"
											class="common-text"></td>
									</tr>
									<tr>
										<th><i class="require-red">*</i>电子邮件：</th>
										<td><input type="text" id="" value="<%=user.getEmail()%>"
											size="85" name="email" class="common-text"></td>
									</tr>

									<tr>
										<th></th>
										<td><input type="submit" value="提交"
											class="btn btn-primary btn6 mr10"> <input
											type="button" value="返回" onClick="history.go(-1)"
											class="btn btn6"></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>

				</form>
			</div>
		</div>
		<!--/main-->
	</div>
</body>
</html>