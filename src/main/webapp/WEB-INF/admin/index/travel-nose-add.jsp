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
		<title>网站后台管理模版</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin/layui/css/layui.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin/css/admin.css"/>
	</head>
	<body>
	<form class="layui-form column-content-detail" method="post">
		<div class="layui-tab" style="margin: 0;">
			<ul class="layui-tab-title">
				<li><a href="${pageContext.request.contextPath}/travel/toList">游记列表</a></li>
				<li class="layui-this">游记详情</li>
				
			</ul>
			<div class="layui-tab-content">
				<div class="layui-tab-item"></div>
				<div class="layui-tab-item layui-show">
					<div class="layui-form-item">
						<label class="layui-form-label">发表人：</label>
						<div class="layui-input-block">
							<input type="hidden" name="userId" value="${map.uId }" autocomplete="off" class="layui-input">
							<input type="hidden" name="travelId" value="${map.tId }" autocomplete="off" class="layui-input">
							<input type="text" value="${map.uName }" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">发表景区：</label>
						<div class="layui-input-block">
							<input type="hidden" name="scenicId" value="${map.sId }" autocomplete="off" class="layui-input">
							<input type="text" value="${map.sName }" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">图像上传：</label>
						<div class="layui-input-block">
							<input type="file" name="picture" value="${map.picture }" class="layui-input" >
						</div>
					</div>
					
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">游记内容：</label>
						<div class="layui-input-block">
							<textarea placeholder="发表内容" class="layui-textarea" name="intro">${map.intro}</textarea>
						</div>
					</div>
					
					<div class="layui-form-item">
						<label class="layui-form-label">满意度：</label>
						<div class="layui-input-block">
							<input type="text" name="prefaction" value="${map.prefaction }" placeholder="请输入详细地址" autocomplete="off" class="layui-input">
						</div>
					</div>
					
					<div class="layui-form-item">
						<label class="layui-form-label">状态：</label>
						<div class="layui-inline">
							<select name="status" lay-filter="status">
								<option value="" <c:if test="${map.status=='' }">selected</c:if>>请选择一个评论状态</option>
								<option value="0" <c:if test="${map.status=='0' }">selected</c:if>>正常</option>
								<option value="1" <c:if test="${map.status=='1' }">selected</c:if>>停止</option>
								<option value=2 <c:if test="${map.status=='2' }">selected</c:if>>删除</option>
							</select>
						</div>
					</div>
					
					<div class="layui-form-item">
						<label class="layui-form-label">点赞人数：</label>
						<div class="layui-input-block">
							<input type="number" name="likeNum" placeholder="请输入文章点击数" autocomplete="off" class="layui-input" value="${map.likeNum }">
						</div>
					</div>
					
					<div class="layui-form-item">
						<label class="layui-form-label">查看人数：</label>
						<div class="layui-input-block">
							<input type="number" name="lookNum" placeholder="请输入餐厅点击数" autocomplete="off" class="layui-input" value="${map.lookNum }">
						</div>
					</div>
					
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">发表的图片：</label>
						<div class="layui-input-block">
							<textarea class="layui-textarea layui-hide" name="picture" lay-verify="content" id="LAY_demo_editor"></textarea>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="layui-form-item" style="padding-left: 10px;">
			<div class="layui-input-block">
				<button class="layui-btn layui-btn-normal" type="submit" lay-submit lay-filter="formDemo">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
	<script src="${pageContext.request.contextPath}/static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/static/admin/js/common.js" type="text/javascript" charset="utf-8"></script>
	<script>
		layui.use(['form', 'jquery', 'laydate', 'layer', 'laypage', 'dialog', 'common', 'tool', 'element', 'upload', 'layedit'], function() {
				var form = layui.form,
					layer = layui.layer,
					$ = layui.jquery,
					laypage = layui.laypage,
					laydate = layui.laydate,
					layedit = layui.layedit,
					common = layui.common,
					tool = layui.tool,
					element = layui.element,
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

				/* layui.upload({
					url: '上传接口url',
					success: function(res) {
						console.log(res); //上传成功返回值，必须为json格式
					}
				}); */
			});
	</script>
	</body>
</html>