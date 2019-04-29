<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>娱乐列表</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin/layui/css/layui.css" />
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin/css/admin.css" />
</head>
<body>
 
<table class="layui-table" id="test" lay-filter="test" lay-data="{id:'list'}"></table>
 
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
    <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
    <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
  </div>
</script>
 
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
              
          
<script src="${pageContext.request.contextPath}/static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/admin/js/common.js" type="text/javascript"  charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 --> 
<script type="text/html" id="img_function">
	<img scr="{{d.fun_pic}}">
</script>
<script>
layui.use('table', function(){
  var table = layui.table;
  
  table.render({
    elem: '#test'
    ,url:'${pageContext.request.contextPath}/function/doList'
    ,toolbar: '#toolbarDemo'
    ,title: '娱乐数据表'
	,id: 'list'
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
      ,{field:'fun_id', title:'ID', width:80, fixed: 'left', unresize: true, sort: true}
      ,{field:'scenic_name', title:'景点', width:120, edit: 'text'}
      ,{field:'fun_name', title:'娱乐名称', width:180, edit: 'text', sort: true}
      ,{field:'fun_address', title:'地点', width:180}
      ,{field:'fun_pic', title:'大图',templet:'#img_function',width:180}
      ,{field:'status', title:'状态',templet: function(row) {
          if (row.status == 0) {
              return "正常"
          } else if (row.status == 1) {
              return "申请"
          }else if (row.status ==2){
          	return "删除"
          }
      }, width:180, sort: true}
      ,{field:'create_time', title:'创建时间', width:180}
      ,{field:'fun_intro', title:'详细信息', width:300, sort: true}
      ,{field:'fun_time', title:'开放时间', width:180}
      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
    ]]
    /* , response: {
    	statusName: 'code' //数据状态的字段名称，默认：code
    	, statusCode: 0 //成功的状态码，默认：0
    	, msgName: 'msg' //状态信息的字段名称，默认：msg
    	, countName: 'count' //数据总数的字段名称，默认：count
    	, dataName: 'map' //数据列表的字段名称，默认：data
    	} */
    ,page: true
  });
  
  //头工具栏事件
  table.on('toolbar(test)', function(obj){
    var checkStatus = table.checkStatus(obj.config.id);
    switch(obj.event){
      case 'getCheckData':
        var data = checkStatus.data;
        var id_str = "";
        

        if (data.length > 0) {
	        for (var i = 0; i < data.length; i++) {
	        	//layer.alert(JSON.stringify(data[i].fun_id));
	        	//console.log(JSON.stringify(data[i].fun_id));
	        	id_str += data[i].id + ',';
       		
	        }
       	 	id_str = id_str.substr(0, id_str.length-1);
       	 	
       	 	$.ajax({
       	 		url:'${pageContext.request.contextPath}/function/doManyDelete',
       	 		data:{},
       	 	});
        }
        
      break;
      case 'getCheckLength':
        var data = checkStatus.data;
        layer.msg('选中了：'+ data.length + ' 个');
      break;
      case 'isAll':
        layer.msg(checkStatus.isAll ? '全选': '未全选');
      break;
    };
  });
  
  //监听行工具事件
  table.on('tool(test)', function(obj){
    var data = obj.data;
    //console.log(obj)
    if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
        obj.del();
        layer.close(index);
      });
    } else if(obj.event === 'edit'){
      layer.prompt({
        formType: 2
        ,value: data.email
      }, function(value, index){
        obj.update({
          email: value
        });
        layer.close(index);
      });
    }
  });
});
</script>

</body>
</html>