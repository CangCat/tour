<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="renderer" content="webkit">
  		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>网站后台管理模版</title>
		<link rel="stylesheet" type="text/css" href="../../static/admin/layui/css/layui.css"/>
		<link rel="stylesheet" type="text/css" href="../../static/admin/css/admin.css"/>
	</head>
	<body>
	<form class="layui-form column-content-detail">
					<div class="layui-tab" style="margin: 0;">
						<div class="layui-tab-content">
							<div class="layui-tab-item"></div>
							<div class="layui-tab-item layui-show">
								<div class="layui-form-item">
									<label class="layui-form-label">景点名称：</label>
									<div class="layui-input-block">
										<input type="text" name="name" required lay-verify="required" placeholder="请输入文章名称" autocomplete="off" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">景区分类：</label>
									<div class="layui-input-block">
										<select name="category" lay-verify="required">
											<option value="">请选择分类</option>
											<optgroup label="国内游">
												<option value="1" selected="">国内游</option>
												<option value="2">国外游</option>
											</optgroup>
										</select>
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">图像上传：</label>
									<div class="layui-input-block">
										<input type="file" name="file（可随便定义）" class="layui-upload-file">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">标签：</label>
									<div class="layui-input-block">
										<input type="checkbox" name="label[tj]" title="热门主题" checked>
										<input type="checkbox" name="label[zd]" title="热门目的地">
										<input type="checkbox" name="label[hot]" title="自由行">
										<input type="checkbox" name="label[zd]" title="跟团游">
										<input type="checkbox" name="label[hot]" title="邮轮游">
									</div>
								</div>
								<div class="layui-form-item layui-form-text">
									<label class="layui-form-label">景点简介：</label>
									<div class="layui-input-block">
										<textarea placeholder="请输入内容" class="layui-textarea"></textarea>
									</div>
								</div>
								
								<div class="layui-form-item">
									<label class="layui-form-label">详细地址：</label>
									<div class="layui-input-block">
										<input type="text" name="laiyuan" placeholder="请输入详细地址" autocomplete="off" class="layui-input">
									</div>
								</div>
								
								<div class="layui-form-item">
									<label class="layui-form-label">联系人：</label>
									<div class="layui-input-block">
										<input type="text" name="laiyuan" required lay-verify="required" placeholder="请输入文章来源" autocomplete="off" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">联系人手机号：</label>
									<div class="layui-input-block">
										<input type="text" name="listorder" required lay-verify="required" placeholder="请输入排序" autocomplete="off" class="layui-input" value="100">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">收费金额：</label>
									<div class="layui-input-block">
										<input type="number" name="listorder" required lay-verify="required" placeholder="请输入排序" autocomplete="off" class="layui-input" value="100">
									</div>
								</div>
								
								<div class="layui-form-item">
									<label class="layui-form-label">开放时间：</label>
									<div class="layui-input-block">
										<input type="datetime" name="listorder" required lay-verify="required" placeholder="请输入排序" autocomplete="off" class="layui-input" value="100">
									</div>
								</div>
								
								<div class="layui-form-item">
									<label class="layui-form-label">结束时间：</label>
									<div class="layui-input-block">
										<input type="datetime" name="listorder" required lay-verify="required" placeholder="请输入排序" autocomplete="off" class="layui-input" value="100">
									</div>
								</div>
								
								<div class="layui-form-item">
									<label class="layui-form-label">状态：</label>
									<div class="layui-input-block">
										<input type="text" name="count" required lay-verify="required" placeholder="请输入文章点击数" autocomplete="off" class="layui-input" value="100">
									</div>
								</div>
							
								<div class="layui-form-item">
									<label class="layui-form-label">点击数：</label>
									<div class="layui-input-block">
										<input type="number" name="count" required lay-verify="required" placeholder="请输入文章点击数" autocomplete="off" class="layui-input" value="100">
									</div>
								</div>
								
								<div class="layui-form-item layui-form-text">
									<label class="layui-form-label">景点详情：</label>
									<div class="layui-input-block">
										<textarea class="layui-textarea layui-hide" name="content" lay-verify="content" id="LAY_demo_editor"></textarea>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="layui-form-item" style="padding-left: 10px;">
						<div class="layui-input-block">
							<button class="layui-btn layui-btn-normal" lay-submit lay-filter="formDemo">立即提交</button>
							<button type="reset" class="layui-btn layui-btn-primary">重置</button>
						</div>
					</div>
				</form>
	<script src="../../static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
	<script src="../../static/admin/js/common.js" type="text/javascript" charset="utf-8"></script>
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