<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html class="iframe-h">

	<head>
		<meta charset="UTF-8">
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>旅游景点</title>
		<link rel="stylesheet" type="text/css" href="../../static/admin/layui/css/layui.css" />
		<link rel="stylesheet" type="text/css" href="../../static/admin/css/admin.css" />
	</head>

	<body>
		<div class="wrap-container clearfix">
				<div class="column-content-detail">
					<form class="layui-form" action="">
						<div class="layui-form-item">
							<div class="layui-inline tool-btn">
								<button class="layui-btn layui-btn-small layui-btn-normal addBtn" data-url="scenic-add.html"><i class="layui-icon">&#xe654;</i></button>
								<button class="layui-btn layui-btn-small layui-btn-danger delBtn"  data-url="scenic-add.html"><i class="layui-icon">&#xe640;</i></button>
								<button class="layui-btn layui-btn-small layui-btn-warm listOrderBtn hidden-xs" data-url="scenic-add.html"><i class="iconfont">&#xe656;</i></button>
							</div>
							<div class="layui-inline">
								<input type="text" name="title" required lay-verify="required" placeholder="请输入景点" autocomplete="off" class="layui-input">
							</div>
							<div class="layui-inline">
								<select name="states" lay-filter="status">
									<option value="">请选择一个状态</option>
									<option value="010">正常</option>
									<option value="021">停止</option>
									<option value="0571">删除</option>
								</select>
							</div>
							<button class="layui-btn layui-btn-normal" lay-submit="search">搜索</button>
						</div>
					</form>
					<div class="layui-form" id="table-list">
						<table class="layui-table" lay-even lay-skin="nob">
							<colgroup>
								<col width="50">
								<col class="hidden-xs" width="50">
								<col class="hidden-xs" width="100">
								<col>
								<col class="hidden-xs" width="150">
								<col class="hidden-xs" width="150">
								<col width="80">
								<col width="150">
							</colgroup>
							<thead>
								<tr>
									<th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose"></th>
									<th class="hidden-xs">ID</th>
									<th class="hidden-xs">排序</th>
									<th>景区名称</th>
									<th>景区大图</th>
									<th class="hidden-xs">景区简介...</th>
									<th class="hidden-xs">地址</th>
									<th>联系人</th>
									<th class="hidden-xs">联系人手机号</th>
									<th class="hidden-xs">收费金额</th>
									<th class="hidden-xs">开放时间</th>
									<th>状态</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input type="checkbox" name="" lay-skin="primary" data-id="1"></td>
									<th class="hidden-xs">ID</th>
									<th class="hidden-xs">1</th>
									<th>大夫山</th>
									<th>景区大图</th>
									<th class="hidden-xs">景区简介...</th>
									<th class="hidden-xs">地址</th>
									<th>张三</th>
									<th class="hidden-xs">12345678901</th>
									<th class="hidden-xs">68￥</th>
									<th class="hidden-xs">7:00~19:30</th>
									<th>正常运营</th>
									<td>
										<div class="layui-inline">
											<button class="layui-btn layui-btn-small layui-btn-normal go-btn" data-id="1" data-url="scenic-detail.html"><i class="layui-icon">&#xe642;</i></button>
											<button class="layui-btn layui-btn-small layui-btn-danger del-btn" data-id="1" data-url="scenic-detail.html"><i class="layui-icon">&#xe640;</i></button>
										</div>
									</td>
								</tr>
								<tr>
									<td><input type="checkbox" name="" lay-skin="primary" data-id="1"></td>
									<th class="hidden-xs">ID</th>
									<th class="hidden-xs">2</th>
									<th>长隆水上乐园</th>
									<th>景区大图</th>
									<th class="hidden-xs">景区简介...</th>
									<th class="hidden-xs">地址</th>
									<th>张三</th>
									<th class="hidden-xs">12345678901</th>
									<th class="hidden-xs">68￥</th>
									<th class="hidden-xs">7:00~19:30</th>
									<th>正常运营</th>
									<td>
										<div class="layui-inline">
											<button class="layui-btn layui-btn-small layui-btn-normal go-btn" data-id="1" data-url="scenic-detail.html"><i class="layui-icon">&#xe642;</i></button>
											<button class="layui-btn layui-btn-small layui-btn-danger del-btn" data-id="1" data-url="scenic-detail.html"><i class="layui-icon">&#xe640;</i></button>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
						<div class="page-wrap">
							<ul class="pagination">
								<li class="disabled"><span>«</span></li>
								<li class="active"><span>1</span></li>
								<li>
									<a href="#">2</a>
								</li>
								<li>
									<a href="#">»</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
		</div>
		<script src="../../static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
		<script src="../../static/admin/js/common.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>