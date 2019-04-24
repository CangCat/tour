<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="iframe-h">

	<head>
		<meta charset="UTF-8">
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>éåº</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin/layui/css/layui.css" media="all" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin/css/admin.css" />
	</head>

	<body>
		<div class="wrap-container clearfix">
				<div class="column-content-detail">
					<form class="layui-form" action="">
						<div class="layui-form-item">
							<div class="layui-inline tool-btn">
								<button class="layui-btn layui-btn-small layui-btn-normal addBtn" data-url="comment-add.html"><i class="layui-icon">&#xe654;</i></button>
								<button class="layui-btn layui-btn-small layui-btn-danger delBtn"  data-url="comment-add.html"><i class="layui-icon">&#xe640;</i></button>
								<button class="layui-btn layui-btn-small layui-btn-warm listOrderBtn hidden-xs" data-url="comment-add.html"><i class="iconfont">&#xe656;</i></button>
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
					
				</div>
		</div>
		<script src="${pageContext.request.contextPath}/static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/static/admin/js/common.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			
			layui.use('table', function(){
				  var table = layui.table;
				  
				  //第一个实例
				  table.render({
				    elem: '#table'
				    ,height: 312
				    ,url: 'http://localhost:8080/tour/comment/doList' //数据接口
				    ,page: {limit:5} //开启分页
				    ,cols: [[ //表头
				      {field: 'commId', title: 'ID', width:80, fixed: 'left'}
				      ,{field: 'userId', title: 'userId', width:80}
				      ,{field: 'projectId', title: '类别', width:80, }
				      ,{field: 'commIntro', title: '评论内容', width:177} 
				      ,{field: 'commTime', title: '评论时间', width: 80}
				      ,{field: 'perfection', title: '满意度 ', width: 80, }
				      ,{field: 'status', title: '状态', width: 80, }
				      ,{field: 'lookNum', title: '查看人数', width: 80}
				      ,{field: 'projectType', title: '类型', width: 135, }
				    ]]
				  });
				  
				});
		
		
		</script>
	</body>

</html>