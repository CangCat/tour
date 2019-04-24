<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="renderer" content="webkit">
  		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>è¯è®ºç®¡ç</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin/layui/css/layui.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin/css/admin.css"/>
	</head>
	<body>
	<form class="layui-form column-content-detail">
					<div class="layui-tab" style="margin: 0;">
						<div class="layui-tab-content">
							<div class="layui-tab-item"></div>
							<div class="layui-tab-item layui-show">
								<div class="layui-form-item">
									<label class="layui-form-label">èååç§°ï¼</label>
									<div class="layui-input-block">
										<input type="text" name="name" required lay-verify="required" placeholder="è¯·è¾å¥èååç§°" autocomplete="off" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">é¤ååç±»ï¼</label>
									<div class="layui-input-block">
										<select name="category" lay-verify="required">
											<option value="">è¯·éæ©æå±é¤å</option>
											<optgroup label="å½åæ¸¸">
												<option value="1" selected="">æé½ä¸åé¦</option>
												<option value="2">äº¬åç¬¬ä¸å¨</option>
											</optgroup>
										</select>
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">å¾åä¸ä¼ ï¼</label>
									<div class="layui-input-block">
										<input type="file" name="fileï¼å¯éä¾¿å®ä¹ï¼" class="layui-upload-file">
									</div>
								</div>
								<div class="layui-form-item layui-form-text">
									<label class="layui-form-label">èåç®ä»ï¼</label>
									<div class="layui-input-block">
										<textarea placeholder="è¯·è¾å¥åå®¹" class="layui-textarea"></textarea>
									</div>
								</div>
								
								<div class="layui-form-item">
									<label class="layui-form-label">èç³»çµè¯ï¼</label>
									<div class="layui-input-block">
										<input type="text" name="listorder" required lay-verify="required" placeholder="è¯·è¾å¥æåº" autocomplete="off" class="layui-input" value="100">
									</div>
								</div>
								
								
								<div class="layui-form-item">
									<label class="layui-form-label">ç¶æï¼</label>
									<div class="layui-input-block">
										<input type="text" name="count" required lay-verify="required" placeholder="è¯·è¾å¥æç« ç¹å»æ°" autocomplete="off" class="layui-input" value="100">
									</div>
								</div>
							
								
								<div class="layui-form-item layui-form-text">
									<label class="layui-form-label">èåè¯¦æï¼</label>
									<div class="layui-input-block">
										<textarea class="layui-textarea layui-hide" name="content" lay-verify="content" id="LAY_demo_editor"></textarea>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="layui-form-item" style="padding-left: 10px;">
						<div class="layui-input-block">
							<button class="layui-btn layui-btn-normal" lay-submit lay-filter="formDemo">ç«å³æäº¤</button>
							<button type="reset" class="layui-btn layui-btn-primary">éç½®</button>
						</div>
					</div>
				</form>
		<script type="text/javascript">
			var SCOPE = {
				static: '/static',
				index: '/admin/category/index.html',
				add: 'add.html',
				save: '/admin/category/save.html',
				edit: 'add.html',
				updateEdit: '/admin/category/updateedit.html',
				status: '/admin/category/updatestatus.html',
				del: '/admin/category/del.html',
				delAll: '/admin/category/deleteall.html',
				listOrderAll: '/admin/category/listorderall.html'
			}
		</script>
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

				//è·åå½åiframeçnameå¼
				var iframeObj = $(window.frameElement).attr('name');
				//åå»ºä¸ä¸ªç¼è¾å¨
				var editIndex = layedit.build('LAY_demo_editor', {
					tool: ['strong' //å ç²
						, 'italic' //æä½
						, 'underline' //ä¸åçº¿
						, 'del' //å é¤çº¿
						, '|' //åå²çº¿
						, 'left' //å·¦å¯¹é½
						, 'center' //å±ä¸­å¯¹é½
						, 'right' //å³å¯¹é½
						, 'link' //è¶é¾æ¥
						, 'unlink' //æ¸é¤é¾æ¥
						, 'image' //æå¥å¾ç
					],
					height: 100
				})
				//å¨é
				form.on('checkbox(allChoose)', function(data) {
					var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]');
					child.each(function(index, item) {
						item.checked = data.elem.checked;
					});
					form.render('checkbox');
				});
				form.render();

				layui.upload({
					url: 'ä¸ä¼ æ¥å£url',
					success: function(res) {
						console.log(res); //ä¸ä¼ æåè¿åå¼ï¼å¿é¡»ä¸ºjsonæ ¼å¼
					}
				});
			});
	</script>
	</body>
</html>