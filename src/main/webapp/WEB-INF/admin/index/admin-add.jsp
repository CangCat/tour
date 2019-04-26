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
		<title>添加管理员后台管理</title>
		<link rel="stylesheet" type="text/css" href="${path}/static/admin/layui/css/layui.css"/>
		<link rel="stylesheet" type="text/css" href="${path}/static/admin/css/admin.css"/>
	</head>
	<body>
	
	
	
	
	
	<form class="layui-form column-content-detail" id="form" action="${path}/admin/doadmint_add" method="post" enctype="multipart/form-data" >
					<div class="layui-tab" style="margin: 0;">
						<div class="layui-tab-content">
							<div class="layui-tab-item"></div>
							<div class="layui-tab-item layui-show">
								<div class="layui-form-item">
									<label class="layui-form-label">管理员姓名：</label>
									<div class="layui-input-block">
										<input type="text" name="name" required lay-verify="required" placeholder="请输入管理员姓名" autocomplete="off" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">登陆名：</label>
									<div class="layui-input-block">
										<input type="text" name="loginName" required lay-verify="required" placeholder="请输入管理员姓名" autocomplete="off" class="layui-input">
									</div>
								</div>
								
								<div class="layui-form-item">
									<label class="layui-form-label">登陆密码：</label>
									<div class="layui-input-block">
										<input type="password" name="password" required lay-verify="required" placeholder="请输入管理员姓名" autocomplete="off" class="layui-input">
									</div>
								</div>
								
								
								<div class="layui-form-item">
									<label class="layui-form-label">性别：</label>
									<div class="layui-input-block">
										<select name="gender" lay-verify="required">
												<option value="1" selected="">男</option>
												<option value="0">女</option>
										</select>
									</div>
								</div>
								
								<div class="layui-form-item">
									<label class="layui-form-label">图像上传：</label>
									<div class="layui-input-block">
										<input type="file" name="file"  >
									</div>
								</div>
								
								<div class="layui-form-item">
									<label class="layui-form-label">联系电话：</label>
									<div class="layui-input-block">
										<input type="text" name="tel" required lay-verify="required" placeholder="请输入电话号码" autocomplete="off" class="layui-input" value="">
									</div>
								</div>
								
								
								<div class="layui-form-item">
									<label class="layui-form-label">权限：</label>
									<div class="layui-input-block">
										<select name="adminType" lay-verify="required">
												<option value="0" selected="">开放所有</option>
												<option value="2">酒店管理</option>
												<option value="3">景区管理</option>
												<option value="4">餐厅管理</option>
												<option value="5">娱乐管理</option>
												<option value="6">待定</option>
										</select>
									</div>
								</div>
								
							</div>
						</div>
					</div>
					
					<!-- 按钮 -->
					
					
					<div class="layui-form-item" style="padding-left: 10px;">
						<div class="layui-input-block">
							<button class="layui-btn layui-btn-normal" lay-submit lay-filter="formDemo"   type="submit">立即提交</button>
							<button type="reset" class="layui-btn layui-btn-primary">重置</button>
						</div>
					</div>
					
				</form>
	<script src="${path}/static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
	<script src="${path}/static/admin/js/common.js" type="text/javascript" charset="utf-8"></script>
	<script>
		layui.use(['form', 'jquery', 'laydate', 'layer', 'laypage', 'dialog', 'common', 'tool', 'element', 'upload', 'layedit'], function() {
				var form = layui.form(),
					layer = layui.layer,
					$ = layui.jquery,
					laypage = layui.laypage,
					laydate = layui.laydate,
					layedit = layui.layedit,
					common = layui.common,
					tool = layui.tool,
					element = layui.element(),
					dialog = layui.dialog;

				//获取当前iframe的name值
				var iframeObj = $(window.frameElement).attr('name');
				//创建一个编辑器
				var editIndex = layedit.build('LAY_demo_editor', {
					tool: ['strong' //加粗
						, 'italic' //斜体
						, 'underline' //下划线
						, 'del' //删除线
						, '|' //分割线
						, 'left' //左对齐
						, 'center' //居中对齐
						, 'right' //右对齐
						, 'link' //超链接
						, 'unlink' //清除链接
						, 'image' //插入图片
					],
					height: 100
				})
				//全选
				form.on('checkbox(allChoose)', function(data) {
					var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]');
					child.each(function(index, item) {
						item.checked = data.elem.checked;
					});
					form.render('checkbox');
				});
				form.render();

				layui.upload({
					url: '上传接口url',
					success: function(res) {
						console.log(res); //上传成功返回值，必须为json格式
					}
				});
			});
		
		
		function submit() {
			
			document.getElementById("form").submit();
			
		}
	</script>
	</body>
</html>