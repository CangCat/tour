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
								<button class="layui-btn layui-btn-small layui-btn-normal addBtn" data-url="${pageContext.request.contextPath}/comment/toAdd"><i class="layui-icon">&#xe654;</i></button>
								<button class="layui-btn layui-btn-small layui-btn-danger delBtn"  data-url="${pageContext.request.contextPath}/comment/toDel"><i class="layui-icon">&#xe640;</i></button>
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

							
							<table id="table" lay-filter="test" ></table>
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
		<script src="${pageContext.request.contextPath}/static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/static/admin/js/common.js" type="text/javascript" charset="utf-8"></script>
		<!-- 每条数据的工具栏 -->
		<script type="text/html" id="barDemo">
 			 <a class="layui-btn layui-btn-xs" lay-event="edit"  href="${pageContext.request.contextPath}/comment/tomodi?id={{d.commId}}">编辑</a>
 			 <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del" href="${pageContext.request.contextPath}/comment/">删除</a>
  
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
		<script type="text/javascript">
			
			layui.use(['table','jquery'], function(){
				  var table = layui.table;
				  
				  var $ = layui.$;
					//监听表格复选框选择
				  table.on('checkbox(test)', function(obj){
				   
				  var checkStatus = table.checkStatus('idTest'); //idTest 即为基础参数 id 对应的值
				  
				  console.log(checkStatus.data) //获取选中行的数据
				  
				  var os = checkStatus.data;
				  $(os).each(function(i){
					  console.log(os[i].commId) 
					  })
				   
				  });
					
				  
				  
				 
				  //第一个实例
				  table.render({
				    elem: '#table'
				    ,id:'idTest'
				    ,height: 312
				    ,url: 'http://localhost:8080/tour/comment/doList' //数据接口
				    ,page: {limit:5} //开启分页
				    
				    ,cols: [[ //表头
				       { checkbox: true, fixed: true }      
				      ,{field: 'commId', title: 'ID', width:80, fixed: 'left'}
				      ,{field: 'userId', title: 'userId', width:80}
				      ,{field: 'projectId', title: '类别', width:80, }
				      ,{field: 'commIntro', title: '评论内容', width:177} 
				      ,{field: 'commTime', title: '评论时间', width: 80,templet : "<div>{{layui.util.toDateString(d.ordertime, 'yyyy-MM-dd HH:mm:ss')}}</div>"}
				      ,{field: 'perfection', title: '满意度 ', width: 80, }
				      ,{field: 'status', title: '状态', width: 80,templet:'#status' }
				      ,{field: 'lookNum', title: '查看人数', width: 80}
				      ,{field: 'projectType', title: '类型', width: 135, templet:'#projectType' }
				      ,{fixed: 'right', width:300, title: '操作', align:'center', toolbar: '#barDemo'}
				    ]]
				  });
				  
				  
				})
		
			
				     
		</script>

	</body>

</html>