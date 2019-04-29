<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="renderer" content="webkit">
  		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>酒店订单添加后台管理模版</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin/layui/css/layui.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin/css/admin.css"/>
	</head>
	<body>
	<form class="layui-form column-content-detail" method="post" action="${pageContext.request.contextPath}/room/doRoomAdd">
					<div class="layui-tab" style="margin: 0;">
						<div class="layui-tab-content">
							<div class="layui-tab-item"></div>
							<div class="layui-tab-item layui-show">
								
								
								<div class="layui-form-item">
									<label class="layui-form-label">订单号：</label>
									<div class="layui-input-block">
										
										<input type="text" name="roomId" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
										
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">房间名：</label>
									<div class="layui-input-block">
										
										<input type="text" name="roomName" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
										
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">价格：</label>
									<div class="layui-input-block">
										
										<input type="text" name="roomPrice" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
										
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">房间类型：</label>
									<div class="layui-input-block">
										
										<input type="text" name="roomRemark" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
										
									</div>
								</div>
								
								<div class="layui-form-item">
									<label class="layui-form-label">图像上传：</label>
									<div class="layui-input-block">
										<input type="file" name="roomPic" class="layui-upload-file">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">酒店名：</label>
									<div class="layui-input-block">
										
										<select name="hotelId" lay-verify="required">
											<option value="">请选择酒店名</option>
											
											<optgroup label="国内游">
												<c:forEach items="${hotel }" var="h">
												<option value="${h.hotelId }">${h.hotelName }</option>
												</c:forEach>
												
											</optgroup>
										</select>
										
									</div>
								</div>
								
						</div>
					</div>
					<div class="layui-form-item" style="padding-left: 10px;">
						<div class="layui-input-block">
							<button class="layui-btn layui-btn-normal" lay-submit lay-filter="formDemo" type="submit" >立即提交</button>
							<button type="reset" class="layui-btn layui-btn-primary">重置</button>
						</div>
					</div>
				</form>
	<script src="${pageContext.request.contextPath}/static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/static/admin/js/common.js" type="text/javascript" charset="utf-8"></script>
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
		
			
		
		
	</script>
	</body>
</html>