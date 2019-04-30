<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html class="iframe-h">

	<head>
		<meta charset="UTF-8">
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>酒店</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/admin/layui/css/layui.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/admin/css/admin.css" />
		
	</head>

	<body>
		<div class="wrap-container clearfix">
				<div class="column-content-detail">
					<form class="layui-form" action="">
						<div class="layui-form-item">
							
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
					</form>
					<div class="layui-form" id="table-list">
						<%-- <table class="layui-table" lay-even lay-skin="nob" lay-data="{url:'${pageContext.request.contextPath }/res/doList', page:true, id:'test'}" lay-filter="test">
							<colgroup>
								<col width="50">
								<col class="hidden-xs" width="50">
								<col class="hidden-xs" width="100">
								<col>
								<col class="hidden-xs" width="150">
								<col class="hidden-xs" width="150">
								<col width="80">
								<col width="150">
							</colgroup>
							<thead>
								<tr>
									<th lay-data="{type:'checkbox'}"></th>
									<th class="hidden-xs" lay-data="{field: 'restId'}"><input value="121">ID</th>
									<th class="hidden-xs" lay-data="{field: 'restName'}">餐厅名</th>
									<th lay-data="{field: 'scenic', templet: '#scenic'}">景区名称</th>
									<th lay-data="{field: 'restPic'}">餐厅大图</th>
									<th class="hidden-xs" lay-data="{field: 'restIntro'}">餐厅简介...</th>
									<th class="hidden-xs" lay-data="{field: 'restAddress'}">地址</th>
									<th lay-data="{field: 'createTime'}">创建时间</th>
									<th class="hidden-xs" lay-data="{field: 'restTel'}">联系方式</th>
									<th lay-data="{field: 'status',templet: '#status'}">状态</th>
									<th lay-data="{field: 'right',align:'center', toolbar: '#barDemo'}">操作</th>
								</tr>
							</thead>
							
						</table> --%>
						<table id="table" class="layui-table" lay-even lay-skin="nob" lay-filter="test"></table> 
					</div>
				</div>
		</div>
		<script src="${pageContext.request.contextPath }/static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath }/static/admin/layui/layui.all.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath }/static/admin/js/common.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
		layui.use('table', function() {
			var table = layui.table;
	

			table.render({
				elem: '#table'
				,height: 600
				,url: '${pageContext.request.contextPath }/res/doList' //数据接口
				,toolbar: 'default'
				,totalRow: true
				,cellMinWidth: 80
				,page: true /*{limit:5}*/ //开启分页
				,cols: [[ //表头
				     {type:'checkbox'} 
					,{field: 'restId', title: 'ID',sort: true}
					,{field: 'restName', title: '餐厅名称',sort: true}
					,{field: 'scenic', title: '景区名称',  templet: '#scenic',sort: true}
					,{field: 'restAddress', title: '地址'}
					,{field: 'restPic', title: '餐厅大图'}
					,{field: 'restTel', title: '联系人电话'}
					,{field: 'restIntro', title: '餐厅简介'}
					,{field: 'createTime', title: '创建时间',templet:"<div>{{layui.util.toDateString(d.ordertime, 'yyyy-MM-dd HH:mm:ss')}}</div>"}
					,{field: 'status', title: '状态',   templet: "#status",sort: true}
					,{fixed: 'right', title: '操作', align:'center', toolbar: '#barDemo'}
				]]
			});
			
			table.on('toolbar(test)', function(obj){
			    var checkStatus = table.checkStatus(obj.config.id)
			    ,data = checkStatus.data; //获取选中的数据
			    switch(obj.event){
			      case 'add':
			    	  window.location.href="/tour/res/toAdd"
			      break;
			      case 'update':
			        if(data.length === 0){
			          layer.msg('请选择一行');
			        } else if(data.length > 1){
			          layer.msg('只能同时编辑一个');
			        } else {
			          window.location.href="/tour/res/toAdd?restId="+checkStatus.data[0].restId;
			        }
			      break;
			      case 'delete':
			        if(data.length === 0){
			          layer.msg('请选择一行');
			        } else {
			          var ids='';
			          for(var i=0 ;i<data.length;i++){
			        	  ids+=checkStatus.data[i].restId+",";
			          }
			          layer.msg('删除'+ids);
			          window.location.href="/tour/res/deleteAll?ids="+ids;
			        }
			      break;
			    };
			  });
		});
		
		
    </script> 
   		
		<script type="text/html" id="barDemo">
 			 <div class="layui-inline">
				<button class="layui-btn layui-btn-small layui-btn-normal go-btn" data-id="{{d.restId}}" data-url="${pageContext.request.contextPath }/res/toDetail"><i class="layui-icon">&#xe642;</i></button>
				<button class="layui-btn layui-btn-small layui-btn-danger del-btn" data-id="{{d.restId}}" data-url="${pageContext.request.contextPath }/res/delete"><i class="layui-icon">&#xe640;</i></button>
			</div>
		</script>
		<script type="text/html" id="cbox">
				<input type="checkbox" name="checkbox" lay-skin="primary" data-id="{{d.restId}}">
		</script>
		<script type="text/html" id="status">
			{{#   if(d.status == 0){ }}
				营业
			{{#  } else if(d.status == 3) { }}
				删除
			{{# } }}
		</script>
		<script type="text/html" id="scenic">
			{{#   if(d.scenic != null){ }}
				<div>{{d.scenic.scenicName}}</div>
			{{#  } else if(d.status == 10) { }}
			{{# } }}
		</script>
		<script type="text/html">
			table.on('checkbox(test)', function(obj){
  				console.log(obj.checked); //当前是否选中状态
  				console.log(obj.data); //选中行的相关数据
  				console.log(obj.type); //如果触发的是全选，则为：all，如果触发的是单选，则为：one
			});
		</script>
	</body>
	
</html>