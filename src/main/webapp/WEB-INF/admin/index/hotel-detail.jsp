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
		<title>酒店后台管理模版</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin/layui/css/layui.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin/css/admin.css" />
		
	</head>
	
	<body>
		<div class="page-content-wrap">
				<form class="layui-form" action="${pageContext.request.contextPath }/hotel/doHotelDetailUpdate" method="post">
					<div class="layui-tab" style="margin: 0;">
						<ul class="layui-tab-title">
							<li><a href="${pageContext.request.contextPath }/hotel/toPageList">酒店列表</a></li>
							<li class="layui-this">酒店详情</li>
							
						</ul>
						
						<div class="layui-tab-content">
							<div class="layui-tab-item"></div>
							<div class="layui-tab-item layui-show">
							
								
								<div class="layui-form-item">
									<label class="layui-form-label">酒店名称：</label>
									<div class="layui-input-block">
										<input type="text" name="hotelName"  class="layui-input" value="${hoteles.hotelName }">
										<input type="hidden" name="hotelId" value="${hoteles.hotelId }">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">所属景区：</label>
									<div class="layui-input-block">
										<select name="scenicId" lay-verify="required">
											<option value="">请选择景区</option>
											<optgroup label="国内游">
												<c:forEach items="${scenic }" var="s">
												<option value="${s.scenicId }">${s.scenicName }</option>
												</c:forEach>
											</optgroup>
										</select>
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">图像上传：</label>
									<div class="layui-input-block">
										<input type="file" name="hotelPic" class="layui-upload-file" value="">
										<img src="${hoteles.hotelPic }">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">酒店级别：</label>
									<div class="layui-input-block">
										<input type="checkbox" name="hotelClass"  checked value="${hoteles.hotelClass }">
										
									</div>
								</div>
								<div class="layui-form-item layui-form-text">
									<label class="layui-form-label">酒店简介：</label>
									<div class="layui-input-block">
										<textarea placeholder="" class="layui-textarea" name="" >${hoteles.hotelDes  }</textarea>
									</div>
								</div>
								
								<div class="layui-form-item">
									<label class="layui-form-label">详细地址：</label>
									<div class="layui-input-block">
										<input type="text" name="hotelAddress" value="${hoteles.hotelAddress }" placeholder="请输入详细地址" autocomplete="off" class="layui-input">
									</div>
								</div>
								
								<div class="layui-form-item">
									<label class="layui-form-label">联系人：</label>
									<div class="layui-input-block">
										<input type="text" name="hotelLink" value="${hoteles.hotelLink }" required lay-verify="required" placeholder="请输入文章来源" autocomplete="off" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">联系人手机号：</label>
									<div class="layui-input-block">
										<input type="text" name="hotelTel" required lay-verify="required" placeholder="" value="${hoteles.hotelTel }" autocomplete="off" class="layui-input" value="100">
									</div>
								</div>
								
								<div class="layui-form-item">
									<label class="layui-form-label">状态：</label>
									<div class="layui-input-block">
										<input type="text" name="status" required lay-verify="required" placeholder="" value="${hoteles.status }" autocomplete="off" class="layui-input" value="100">
									</div>
								</div>
								
								<div class="layui-form-item">
									<label class="layui-form-label">创建时间：</label>
									<div class="layui-input-block">
										
										<input type="text" name="creatTime" placeholder="" value="<fmt:formatDate value="${hoteles.creatTime }" pattern="yyyy-MM-dd hh:mm:ss"/>" autocomplete="off" class="layui-input" value="100">
									</div>
								</div>
								
								<div class="layui-form-item">
									<label class="layui-form-label">点击数：</label>
									<div class="layui-input-block">
										<input id="test1" type="number" name="hotelCount" required lay-verify="required"  autocomplete="off" class="layui-input" value="${hoteles.hotelCount }">
									</div>
								</div>
								
								<div class="layui-form-item layui-form-text">
									<label class="layui-form-label">酒店详情：</label>
									<div class="layui-input-block">
										<textarea class="layui-textarea layui-hide" name="hotelPic" lay-verify="content" id="LAY_demo_editor">${hoteles.hotelPic }</textarea>
									</div>
								</div>
							
							</div>
						</div>
						
					</div>
					<div class="layui-form-item" style="padding-left: 10px;">
						<div class="layui-input-block">
							<button class="layui-btn layui-btn-normal" type="submit">立即提交</button>
							<button type="reset" class="layui-btn layui-btn-primary">重置</button>
						</div>
					</div>
				</form>
		</div>
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
			
			layui.use(['form', 'jquery', 'laydate', 'layer', 'laypage', 'dialog',  'element', 'upload', 'layedit'], function() {
				var form = layui.form,
					layer = layui.layer,
					$ = layui.jquery,
					laypage = layui.laypage,
					laydate = layui.laydate,
					layedit = layui.layedit,
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