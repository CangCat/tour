<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>网站后台管理模版</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin/layui/css/layui.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin/css/admin.css" />
	</head>

	<body>
		<div class="page-content-wrap">
				<form class="layui-form" method="post">
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
				<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
				  <legend>多文件列表上传</legend>
				</fieldset> 
				 
				<div class="layui-upload">
				  <button type="button" class="layui-btn layui-btn-normal" id="testList">选择多文件</button> 
				  <div class="layui-upload-list">
				    <table class="layui-table">
				      <thead>
				        <tr><th>文件名</th>
				        <th>大小</th>
				        <th>状态</th>
				        <th>操作</th>
				      </tr></thead>
				      <tbody id="demoList"></tbody>
				    </table>
				  </div>
				  <button type="button" class="layui-btn" id="testListAction">开始上传</button>
				</div>
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
				
				//监听提交
				form.on('submit(formDemo)', function (data) {
					//return false;
					$.ajax({
					url: 'doUpdate',
					data: data.field,
					type: 'post',
					dataType: 'json',
					success: function (data) {
						console.log(data);
						if(data>0){
							layer.msg("提交成功")
							location.href="${pageContext.request.contextPath}/travel/toUpdate?id=${map.tId}";
						}else{
							layer.msg("提交失败")
						}
						layer.msg("提交成功")
						
					}
	
					});
				});

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
				var $ = layui.jquery
				  ,upload = layui.upload;
				 
				  //多文件列表示例
				  var demoListView = $('#demoList')
				  ,uploadListIns = upload.render({
				    elem: '#testList'
				    ,url: 'uploadFile'
				    ,accept: 'file'
				    ,multiple: true
				    ,auto: false
				    ,size: 5120
				    ,bindAction: '#testListAction'
				    ,choose: function(obj){   
				      var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
				      //读取本地文件
				      obj.preview(function(index, file, result){
				        var tr = $(['<tr id="upload-'+ index +'">'
				          ,'<td>'+ file.name +'</td>'
				          ,'<td>'+ (file.size/1014).toFixed(1) +'kb</td>'
				          ,'<td>等待上传</td>'
				          ,'<td>'
				            ,'<button class="layui-btn layui-btn-mini demo-reload layui-hide">重传</button>'
				            ,'<button class="layui-btn layui-btn-mini layui-btn-danger demo-delete">删除</button>'
				          ,'</td>'
				        ,'</tr>'].join(''));
				        
				        //单个重传
				        tr.find('.demo-reload').on('click', function(){
				          obj.upload(index, file);
				        });
				        
				        //删除
				        tr.find('.demo-delete').on('click', function(){
				          delete files[index]; //删除对应的文件
				          tr.remove();
				          uploadListIns.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
				        });
				        
				        demoListView.append(tr);
				      });
				    }
				    ,done: function(res, index, upload){
				      if(res.code == 0){ //上传成功
				        var tr = demoListView.find('tr#upload-'+ index)
				        ,tds = tr.children();
				        tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
				        tds.eq(3).html(''); //清空操作
				        return delete this.files[index]; //删除文件队列已经上传成功的文件
				      }
				      this.error(index, upload);
				    }
				    ,error: function(index, upload){
				      var tr = demoListView.find('tr#upload-'+ index)
				      ,tds = tr.children();
				      tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
				      tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
				    }
				  });

			});
		</script>
	</body>

</html>