<%@page import="entity.Commodity"%>
<%@page import="entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>修改用户</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
</head>
<body>
<%Commodity commodity1=(Commodity)application.getAttribute("commodity1");
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
					<li><a href="#"><i class="icon-font">&#xe003;</i>后台管理</a>
						<ul class="sub-menu">
							<li><a href="./a"><i class="icon-font">&#xe008;</i>用户列表</a></li>
							<li><a href="./ac"><i class="icon-font">&#xe005;</i>商品列表</a></li>
							<li><a href="./asa"><i class="icon-font">&#xe006;</i>销售报表</a></li>
							<li><a href="./ash"><i class="icon-font">&#xe004;</i>购买记录</a></li>	
						</ul></li>
				</ul>
			</div>
		</div>
		<div class="main-wrap">
			<div class="crumb-wrap">
				<div class="crumb-list">
					<i class="icon-font"></i>首页<span class="crumb-step">&gt;</span><span
						class="crumb-name">商品列表：</span>商品修改：
				</div>
			</div>
			<div class="result-wrap">
				<form action="./auccm" method="post">
					<div class="config-items">
						<div class="config-title">
							<h1>
								<i class="icon-font">&#xe00a;</i>商品修改
							</h1>
						</div>
						<div class="result-content">
							<table width="100%" class="insert-tab">
								<tbody>
									<tr>
										<th width="15%"><i class="require-red"></i>商品编号：</th>
										<td><%=commodity1.getId() %></td>
									</tr>
									<tr>
										<th><i class="require-red">*</i>价格：</th>
										<td><input type="text" id=""
											value="<%=commodity1.getPrice() %>" size="85"
											name="price" class="common-text"></td>
									</tr>
									<tr>
										<th><i class="require-red">*</i>名称：</th>
										<td><input type="text" id=""
											value="<%=commodity1.getName() %>" size="85" name="name"
											class="common-text"></td>
									</tr>
									<tr>
										<th><i class="require-red">*</i>类型：</th>
										<td><input type="text" id=""
											value="<%=commodity1.getType() %>" size="85" name="type"
											class="common-text"></td>
									</tr>
									<tr>
										<th><i class="require-red">*</i>品牌：</th>
										<td><input type="text" id=""
											value="<%=commodity1.getbrand() %>" size="85" name="brand"
											class="common-text"></td>
									</tr>
									<tr>
										<th><i class="require-red">*</i>图片：</th>
										<td><input type="text" id=""
											value="<%=commodity1.getImage() %>" size="85" name="image"
											class="common-text"></td>
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