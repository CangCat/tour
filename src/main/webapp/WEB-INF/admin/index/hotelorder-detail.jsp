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
		<title>酒店订单后台管理模版</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin/layui/css/layui.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin/css/admin.css" />
		
	</head>
	
	<body>
		<div class="page-content-wrap">
				<form class="layui-form" action="${pageContext.request.contextPath }/hotelOrder/doHotelOrderUpdate" method="post">
					<div class="layui-tab" style="margin: 0;">
						<ul class="layui-tab-title">
							<li><a href="${pageContext.request.contextPath }/hotelOrder/toPageList">酒店列表</a></li>
							<li class="layui-this">酒店详情</li>
							
						</ul>
						
						<div class="layui-tab-content">
							<div class="layui-tab-item"></div>
							<div class="layui-tab-item layui-show">
							
								
								<div class="layui-form-item">
									<label class="layui-form-label">订单号：</label>
									
									<div class="layui-input-block">
										<input type="text" name="orderId" readonly="readonly" class="layui-input" value="${order.orderId }">
										
									</div> 
									
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">用户名字：</label>
									<div class="layui-input-block">
										
										<input type="text" name="userName" readonly="readonly" class="layui-input" value="${user.userName }">								
										
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">酒店名字：</label>
									<div class="layui-input-block">
										<input type="text" name="hotelName" readonly="readonly" class="layui-input" value="${hotel.hotelName }">
									</div>
								</div>
								
								<div class="layui-form-item">
									<label class="layui-form-label">入住时间：</label>
									<div class="layui-input-block">
										
										<input type="text" name="hotelCheckin" placeholder="" value="<fmt:formatDate value="${order.hotelCheckin}" pattern="yyyy-MM-dd hh:mm:ss"/>" autocomplete="off" class="layui-input" value="100">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">酒店房间数：</label>
									<div class="layui-input-block">
										
										<input type="text"  name="roomCount" placeholder="" value="${order.roomCount}" autocomplete="off" class="layui-input" value="100">
									</div>
								</div>
								<div class="layui-form-item">
								
									<label class="layui-form-label">订单状态：</label>
									<div class="layui-input-block">
									   <input name="status" type="radio" <c:if test="${order.status=='0' }">checked</c:if> value='0'>已订
									   <input name="status" type="radio" <c:if test="${order.status=='1' }">checked</c:if> value='1'>已取消
									</div> 
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">订购时间：</label>
									<div class="layui-input-block">
										
										<input type="text" name="hotelCheckin" placeholder="" value="<fmt:formatDate value="${order.createTime}" pattern="yyyy-MM-dd hh:mm:ss"/>" autocomplete="off" class="layui-input" value="100">
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