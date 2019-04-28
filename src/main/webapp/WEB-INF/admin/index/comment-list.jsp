<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="iframe-h">

<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>酒店f</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/admin/layui/css/layui.css"
	media="all" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/admin/css/admin.css" />
</head>

<body>
	<div class="wrap-container clearfix">
		<div class="column-content-detail">
			<form class="layui-form" action="" id="commForm">
				<div class="layui-form-item">

					<div class="layui-inline">
						<input type="text" name="commIntro" id="commIntroSearch" required
							lay-verify="required" placeholder="请输入景点" autocomplete="off"
							class="layui-input">
					</div>
					<div class="layui-inline">
						<select name="status" id="statusSel" lay-filter="status">
							<option value="">请选择一个状态</option>
							<option value="0">正常</option>
							<option value="1">不显示</option>
						</select>
					</div>
					<button class="layui-btn layui-btn-normal" lay-submit="search"
						type="button" id="submit">搜索</button>
				</div>


				<table id="table" lay-filter="test"></table>
				<div class="layui-form" id="table-list">

					<!-- <div class="page-wrap">
							<ul class="pagination">
								<li class="disabled"><span>Â«</span></li>
								<li class="active"><span>1</span></li>
								<li>
									<a href="#">2</a>
								</li>
								<li>
									<a href="#">Â»</a>
								</li>
							</ul>
						</div> -->
				</div>
			</form>
			<button class="layui-btn" data-type="getCheckData">获取选中行数据</button>
		</div>
	</div>
	<script
		src="${pageContext.request.contextPath}/static/admin/layui/layui.js"
		type="text/javascript" charset="utf-8"></script>
	<script
		src="${pageContext.request.contextPath}/static/admin/js/common.js"
		type="text/javascript" charset="utf-8"></script>
	<!-- 每条数据的工具栏 -->
	<script type="text/html" id="barDemo">
 			 <a class="layui-btn layui-btn-xs" lay-event="edit"  href="${pageContext.request.contextPath}/comment/tomodi?id={{d.commId}}">编辑</a>
 			 <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del" method="offset" data-type="auto" href="javascript:;">删除</a>
  
 			 <!-- 这里同样支持 laytpl 语法，如： -->
 			 {{#  if(d.auth > 2){ }}
  			  <a class="layui-btn layui-btn-xs" lay-event="check">审核</a>
  			{{#  } }}
		</script>
	<script type="text/html" id="status">
  			{{#  if(d.status == 0){ }}
   			    显示
 			 
 			 {{#  } else { }}
				不显示
			 {{# } }}
		</script>

	<script type="text/html" id="projectType">
  			{{#  if(d.projectType == 1){ }}
   			    景区
 			 {{#  } else if(d.projectType == 2) { }}
   			 酒店
 			 {{#  } else { }}
				餐厅
			 {{# } }}
		</script>
	<script type="text/html" id="toolbarDemo">
 			 <div class="layui-btn-container">
   			 	<button class="layui-btn layui-btn-sm" lay-event="add">添加</button>
   				<button class="layui-btn layui-btn-sm" lay-event="delete">删除</button>
    			<button class="layui-btn layui-btn-sm" lay-event="update">编辑</button>
 			 </div>
	    </script>



	<script type="text/javascript">
		layui
				.use(
						[ 'table', 'jquery', 'layer' ],
						function() {
							var table = layui.table;
							var layer = layui.layer;
							var $ = layui.$;

							table.on('checkbox(test)', function(obj) {
								var checkStatus = table.checkStatus('idTest');
								console.log(checkStatus.data);
								var os = checkStatus.data;
								$(os).each(function(i) {
									console.log(os[i].commId);
								})
							})

							table
									.on(
											'toolbar(test)',
											function(obj) {
												var checkStatus = table
														.checkStatus(obj.config.id);
												switch (obj.event) {

												case 'delete':
													layer.msg('删除');
													var os = checkStatus.data;
													var list = "";
													for (var i = 0; i < os.length; i++) {
														list += os[i].commId
																+ ",";
													}
													console.log(list);
													window.location.href = "${pageContext.request.contextPath}/comment/toDel?list="
															+ list;
													break;

												case 'update':
													layer.msg('编辑');
													break;
												}
												;
											});

							//第一个实例
							table
									.render({
										elem : '#table',
										id : 'idTest',
										height : 412,
										toolbar : '#toolbarDemo',
										url : 'http://localhost:8080/tour/comment/doList' //数据接口
										,
										page : {
											limit : 7
										} //开启分页

										,
										cols : [ [ //表头
												{
													checkbox : true,
													fixed : true,
													name : "checkbox",
													templet : "#id"
												},
												{
													field : 'commId',
													title : 'ID',
													width : 80,
													fixed : 'left'
												},
												{
													field : 'userId',
													title : 'userId',
													width : 80
												},
												{
													field : 'projectId',
													title : '类别',
													width : 80,
												},
												{
													field : 'commIntro',
													title : '评论内容',
													width : 277
												},
												{
													field : 'commTime',
													title : '评论时间',
													width : 180,
													templet : "<div>{{layui.util.toDateString(d.ordertime, 'yyyy-MM-dd HH:mm:ss')}}</div>"
												}, {
													field : 'perfection',
													title : '满意度 ',
													width : 80,
												}, {
													field : 'status',
													title : '评论状态',
													width : 80,
													templet : '#status'
												}, {
													field : 'lookNum',
													title : '查看人数',
													width : 80
												}, {
													field : 'projectType',
													title : '类型',
													width : 135,
													templet : '#projectType'
												}, {
													fixed : 'right',
													width : 300,
													title : '操作',
													align : 'center',
													toolbar : '#barDemo'
												} ] ]
									});

							$('#submit').click(function() {

								table.reload('idTest', {
									where : {

										status : $('#statusSel').val(),
										commIntro : $('#commIntroSearch').val()
 
									},
									page : {curr:1}
									
								})

							})

						})
	</script>

</body>

</html>