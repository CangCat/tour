<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="renderer" content="webkit">
  		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>旅游主页</title>
		<link rel="stylesheet" type="text/css" href="${path }/static/admin/layui/css/layui.css"/>
		<script type="text/javascript" src="${path }/js/jquery-3.3.1.min.js"></script>
		<script src="${path}/static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
		<script src="${path}/static/admin/js/common.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body class="layui-layout-body">
		<div class="layui-layout layui-layout-admin ">
			<div class="layui-header layui-bg-green">
				<div class="layui-logo" style="color: white;">世界辣么大</div>
				<!-- 头部区域（可配合layui已有的水平导航） -->
				<!-- <ul class="layui-nav layui-layout-left ">
					<li class="layui-nav-item"><a href="">首页</a></li>
					<li class="layui-nav-item"><a href="">前端首页</a></li>
					</li>
				</ul> -->
				<ul class="layui-nav layui-layout-right">
					<li class="layui-nav-item">
						<a href="javascript:;">
							<img src="http://t.cn/RCzsdCq" class="layui-nav-img"> 贤心
						</a>
						<dl class="layui-nav-child">
							<dd><a onclick="tabChange('基本资料','tabAdmin','${path}/travel/toList')">游记管理</a></dd>
							<dd><a onclick="tabChange('安全设置','tabRepwd','${path}/function/toList')')">安全设置</a></dd>
						</dl>
					</li>
					<a href="login.html"><li class="layui-nav-item"><a href="">退了</a></li>
				</ul>
			</div>

			<div class="layui-side layui-bg-black">
				<div class="layui-side-scroll">
					<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
					<ul class="layui-nav layui-nav-tree" lay-filter="test">
						<li class="layui-nav-item">
							<a href="javascript:;">网站管理</a>
							<dl class="layui-nav-child">
								<dd><a href="javascript:;" onclick="tabChange('首页轮播','tabCarousel','${path}/travel/toList')">首页轮播</a></dd>
								<dd><a href="javascript:;">页面底部</a></dd>
								<!--<dd><a href="">超链接</a></dd>-->
							</dl>
						</li>
						<li class="layui-nav-item"><a onclick="tabChange('歌曲管理','tabSong','${path}/travel/toList')">歌曲管理</a></li>
						<li class="layui-nav-item"><a onclick="tabChange('专辑管理','tabCD','${path}/travel/toList')">专辑管理</a></li>
						<li class="layui-nav-item"><a onclick="tabChange('歌单管理','tabSongList','${path}/travel/toList')">歌单管理</a></li>
						<li class="layui-nav-item"><a onclick="tabChange('歌手管理','tabSinger','${path}/travel/toList')">歌手管理</a></li>
						<li class="layui-nav-item"><a onclick="tabChange('用户管理','tabUser','${path}/travel/toList')">用户管理</a></li>
					</ul>
				</div>
			</div>

			<div class="layui-body">
				<!-- 内容主体区域 -->
				<div style="padding: 15px;">

					<div class="layui-tab" lay-filter="demo" lay-allowclose="true">
						<ul class="layui-tab-title">
							<li class="layui-this" lay-id="tabIndex">首页</li>
						</ul>
						<div class="layui-tab-content">
							<div class="layui-tab-item layui-show">
								<iframe scrolling="yes" frameborder="0" src="${path}/function/toList" style="height:900px;" width="100%"></iframe>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="layui-footer">
				<!-- 底部固定区域 -->
				© layui.com - 底部固定区域
			</div>
		</div>

		<script>
			//JavaScript代码区域
			layui.use('element', function() {
				var $ = layui.jquery,
					element = layui.element;

			});

			tabChange = function(title, id, src) {
				layui.use('element', function() {
					var $ = layui.jquery,
						element = layui.element;

					if (!$('li[lay-id=' + id + ']').is('li')) {
						//删除
						element.tabDelete('demo', id);
						//添加
						element.tabAdd('demo', {
							title: title,
							content: '<iframe scrolling="no" frameborder="0" src="' + src + '" style="height: 1000px;" width="1300px;"></iframe>' //支持传入html
								,
							id: id
						});
					}
					//切换
					element.tabChange('demo', id);
				});
			}
		</script>
	</body>

</html>