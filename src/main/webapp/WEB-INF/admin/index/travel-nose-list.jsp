<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html class="iframe-h">

	<head>
		<meta charset="UTF-8">
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>游记列表</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin/layui/css/layui.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin/css/admin.css" />
	</head>

	<body>
		<div class="wrap-container clearfix">
				<div class="column-content-detail">
					<form class="layui-form" action="${pageContext.request.contextPath}/travel/toList" method="post">
						<div class="layui-form-item">
							<div class="layui-inline tool-btn">
								<button class="layui-btn layui-btn-small layui-btn-normal addBtn" data-url="${pageContext.request.contextPath}/travel/toAdd"><i class="layui-icon">&#xe654;</i></button>
								<button class="layui-btn layui-btn-small layui-btn-danger" onclick="deletes()"><i class="layui-icon">&#xe640;</i></button>
								<!-- <button class="layui-btn layui-btn-small layui-btn-warm listOrderBtn hidden-xs" data-url="scenic-add.html"><i class="iconfont">&#xe656;</i></button> -->
							</div>
							<div class="layui-inline">
								<input type="text" name="uName" value="${uName}"  placeholder="用户名称" autocomplete="off" class="layui-input">
								<input id="page" type="hidden" name="pageNum" value="" class="text_search"  />
                    			<input id="size" type="hidden" name="size" value="" class="text_search" />
							</div>
							<div class="layui-inline">
								<input type="text" name="sName"value="${sName}"  placeholder="景点名称" autocomplete="off" class="layui-input">
							</div>
							<div class="layui-inline">
								<select name="status" lay-filter="status">
									<option value="" <c:if test="${status=='' }">selected</c:if>>请选择一个评论状态</option>
									<option value="0" <c:if test="${status=='0' }">selected</c:if>>发表</option>
									<option value="1" <c:if test="${status=='1' }">selected</c:if>>待审核</option>
									<option value=2 <c:if test="${status=='2' }">selected</c:if>>删除</option>
								</select>
							</div>
							
							<button class="layui-btn layui-btn-normal" type="submit" lay-submit="search">搜索</button>
						</div>
					</form>
					<div class="layui-form" id="table-list">
						<table class="layui-table" lay-skin="line" lay-size="lg" id="demo" lay-filter="test">
							<colgroup>
								<col width="50">
								<col class="hidden-xs" width="50">
								<col class="hidden-xs" width="120">
								<col class="hidden-xs" width="120">
								<col width="300">
								<col width="200">
								<%-- <col width="200"> --%>
								<col width="120">
								<col width="120">
								<col width="120">
								<col width="120">
								<col width="200">
							</colgroup>
							<thead>
								<tr>
									<th><input type="checkbox" name="travelId"  lay-skin="primary" lay-filter="allChoose"></th>
									<th class="hidden-ls">ID</th>
									<th>用户名称</th>
									<th  class="hidden-ls">游记景点</th>
									<th>游记内容</th>
									<th>发表时间</th>
									<!-- <th>满意度</th> -->
									<th class="hidden-ls">查看人数</th>
									<th class="hidden-ls">点赞人数</th>
									<th class="hidden-ls">游记状态</th>
									<th class="hidden-ls">审核</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${pageBean.list}" var="travel">
									<tr>	
										<td><input type="checkbox" name="tId" <c:if test="${travel.status=='2' }">readonly="readonly"</c:if> lay-skin="primary" value="${travel.tId }"></td>
										<th class="hidden-ls">${travel.tId }</th>
										<th>${travel.uName }</th>
										<th class="hidden-ls">${travel.sName }</th>
										<th style="overflow:visible;text-overflow:inherit;">${travel.intro }</th>
										<th> <fmt:formatDate value="${travel.createTime}" pattern="yyyy-MM-dd hh:mm:ss"/> </th>
										<!-- <th>
											<div id="test9" class="layui-inline">
												
											</div>
										</th> -->
										<th class="hidden-ls"> ${travel.lookNum }</th>
										<th> ${travel.likeNum }</th>
										<c:if test="${travel.status=='0' }">
											<th>发表</th>
										</c:if>
										
										<c:if test="${travel.status=='1' }">
											<th>待审核</th>
										</c:if>
										
										<c:if test="${travel.status=='2' }">
											<th>删除</th>
										</c:if>
										<th><c:if test="${travel.status=='1' }"><a class="layui-btn layui-btn-radius layui-btn-normal" href="javascript:;" onclick="check_pass(${travel.tId})">审核</a></c:if><c:if test="${travel.status!='1' }"><a class="layui-btn layui-btn-radius layui-btn-disabled">已审核</a></c:if></th>
										
										<td>
											<div class="layui-inline">
												<button class="layui-btn layui-btn-small layui-btn-normal go-btn"  data-id="${travel.tId}" data-url="toUpdate"><i class="layui-icon">&#xe642;</i></button>
												<button class="layui-btn layui-btn-small layui-btn-danger" onclick="delete_trave(this,${travel.tId})"><i class="layui-icon">&#xe640;</i></button>
											</div>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="page-wrap">
							<ul class="pagination">
								<li <c:if test="${pageBean.pageNum==1 }"> class="disabled"</c:if>>
									<a <c:if test="${pageBean.pageNum>1 }"> href="javascript:;" onclick="changePage(${pageBean.pageNum-1},${pageBean.size});"</c:if>>«</a>
								</li>
								<c:forEach begin="${pageBean.start }" end="${pageBean.end }" var="p">
			                    	<li>
			                    		<a <c:if test="${pageBean.pageNum==p }">class="layui-bg-blue"</c:if> href="javascript:;" onclick="changePage(${p},${pageBean.size})">${p }</a>
			                    	</li>
			                    </c:forEach>
								<li <c:if test="${pageBean.pageNum==pageBean.totalPage }"> class="disabled"</c:if>>
								   <a <c:if test="${pageBean.pageNum<pageBean.totalPage }"> href="javascript:;"  onclick="changePage(${pageBean.pageNum+1},${pageBean.size});"</c:if> >»</a>
								</li>
							</ul>
						</div>
						
					</div>
				</div>
		</div>

		<script src="${pageContext.request.contextPath}/static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/static/admin/js/common.js" type="text/javascript"  charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js" type="text/javascript"  charset="utf-8"></script>
		<script type="text/javascript">
		 //分页处理
	        function changePage(page,size){
	     	   //page=1   size=${pageBean.size}
	     	   //根据传入的参数,将表单的隐藏域赋值,并且进行表单提交
	     	   document.getElementById("page").value=page;
	     	   document.getElementById("size").value=size;
	     	   //console.log(page+";"+size);
	     	   //console.log(document.getElementsByTagName("form")[0]);
	     	   document.getElementsByTagName("form")[0].submit();//提交表单
	        }
		 /*
		   	通过审核的按钮
		 */
		 function check_pass(id){
			 
			 layer.confirm('该游记写得很棒！',{
				 btn:['通过审核','取消审核']
			 },function (){
					$.ajax({
					url: 'doStatus',
					data:{id:id},
					type: 'post',
					dataType: 'json',
					success: function (data) {
						console.log(data);
						if(data.count>0){
							layer.open({
							  title: '审核结果'
							  ,content: '审核成功！'
							});  
							location.href="${pageContext.request.contextPath}/travel/toList";
						}else{
							layer.open({
								  title: '审核结果'
								  ,content: '审核操作失败！请联系技术人员。'
								
								}); 
						}
						
					}
	
					});
				 
			 },function(){
				 //取消，不做任何动作
			 })
		 }
		 
		 
		 function delete_trave(obj,id){
			 layer.confirm('删除要慎重！您确定要删除id为：'+id+'的用户吗？',{
				 btn:['确定','取消']
			 },function (){
				//确认删除发送ajax请求
	                $.ajax({
	                    url: '${pageContext.request.contextPath}/travel/doDelete',
	                    type: "post",
	                    data: {
	                        "id": id
	                    },
	                    success: function(d) {
	                        if (d == 1) {
	                        	layer.open({
									  title: '删除结果'
									  ,content: '删除成功！'
									
									}); 
	                        	location.href="${pageContext.request.contextPath}/travel/toList";
	                        } else {
	                            layer.open({
									  title: '删除结果'
									  ,content: '审核操作失败！请联系技术人员。'
									
									}); 
	                        }
	                    }
	                });
				 
			 },function(){
				 //取消，不做任何动作
			 })
		 }
	
		 
		 
		 layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element', 'slider','rate'], function(){
			 var rate = layui.rate;
			 var table = layui.table; //表格

			  //只读
			  rate.render({
			    elem: '#test9'
			    ,value: 4
			    ,readonly: true
			  });
			  
			  //监听行工具事件
			  table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
			    var data = obj.data //获得当前行数据
			    ,layEvent = obj.event; //获得 lay-event 对应的值
			    if(layEvent === 'del'){
			      layer.confirm('真的删除行么', function(index){
			        obj.del(); //删除对应行（tr）的DOM结构
			        layer.close(index);
			        //向服务端发送删除指令
			      });
			    } 
			  });
			  
			  //上传
			  /* upload.render({
			    elem: '#uploadDemo'
			    ,url: '' //上传接口
			    ,done: function(res){
			      console.log(res)
			    }
			  }); */
			  
			});
		 
		 function deletes() {
         	//:checkbox找到所有checkbox  [name='aids']  找到name='aids' 的    :checked 找到被选中的
         	var objs = $(":checkbox[name='tId']:checked");
		 	console.log(objs.length);
         	if(objs.length==0){
         	//console.log($("#operate_result_info").find("span"));
         		//alert("请至少选择一条数据！");
         		//设置msg
         		layer.open({
					  title: '结果'
					  ,content: '至少选择一条数据'
					
					}); 
         		return;
         	}
         	
         	var ids = new Array();
         	
         	objs.each(function(i,obj){
         		/* console.log(parseInt($(obj).val()));
         		ids.push(parseInt($(obj).val())); */
         		ids.push($(obj).val());
         	})
         	//console.log(ids.toString());//[元素1,元素2]
         	
         	$.post(
         			"${pageContext.request.contextPath}/travel/doManyDelete",
         			{"ids":ids.toString()},
         			function(data){
         				if(data.count>0){
         					layer.open({
       						  title: '结果'
       						  ,content: '删除成功！'
       						
       						});
         				}else{
         					layer.open({
       						  title: '结果'
       						  ,content: '删除失败！请联系工作人员。'
       						
       						});
         				}
         				
         			});
         			
		 }
		</script>
	</body>

</html>