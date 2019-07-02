<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>图标管理</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/public.css" media="all" />
</head>
<body class="childrenBody">
	<blockquote class="layui-elem-quote">
		layuiCMS 2.0当前共引入<span class="layui-red iconsLength"></span>个外部图标。<span class="layui-word-aux">【点击可复制】此页面并非后台模版需要的，只是为了让大家了解都引入了哪些外部图标，实际应用中可删除。</span>
	</blockquote>
	<textarea id="copyText"></textarea>
	<ul class="icons layui-row"></ul>

	<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/page/systemSetting/icons.js"></script>
</body>
</html>