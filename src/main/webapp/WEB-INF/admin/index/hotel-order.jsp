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
		<title>酒店订单</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin/layui/css/layui.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin/css/admin.css" />
		<style>
			.layui-table{
				 
				  overflow:visible;
				  text-overflow:inherit;
						}
		</style>
	</head>

	<body>
		<div class="wrap-container clearfix iframe-h">
				<div class="column-content-detail">
					<form class="layui-form" action="${pageContext.request.contextPath }/hotelOrder/toPageList" method="post" id="tableTes">
						<div class="layui-form-item">
							<div class="layui-inline tool-btn">
								
								<button class="layui-btn layui-btn-small layui-btn-danger delBtn"  data-url="hotel-add.html"><i class="layui-icon">&#xe640;</i></button>
								<button class="layui-btn layui-btn-small layui-btn-warm" data-url="${pageContext.request.contextPath }/hotel/toPageList" onclick="d();" <c:if test="${desc==1 }">style="background-color:purple;"</c:if><c:if test="${desc==0 }">style="background-color:bule"</c:if>><i class="iconfont">&#xe656;</i></button>
								
								<input type="hidden" name="desc" id="desc" value="${desc }"/> 
								
								
							</div>
							<!-- 
								input的值获取   通过spring 封装成 hotel对象
								
								input 的name值   需要与   hotel的属性对应
							 -->
							<div class="layui-inline">
							
								<input type="text" name="name"  placeholder="请输入酒店名称" autocomplete="off" class="layui-input" value="${name }">
								<input type="hidden" name="page"  placeholder="请输入酒店名称" autocomplete="off" class="layui-input" id="page">
								<input type="hidden" name="size"  placeholder="请输入酒店名称" autocomplete="off" class="layui-input" id="size">
							</div>
							<div class="layui-inline">
								<select name="status" lay-filter="status">
								
									<option value="" <c:if test="${status=='' }">selected</c:if>>请选择一个状态</option>
									<option value="0" <c:if test="${status=='0' }">selected</c:if>>已订</option>
									<option value="1" <c:if test="${status=='1' }">selected</c:if>>已取消</option>
								</select>
							</div>
							<button type="submit" class="layui-btn layui-btn-normal" lay-submit="search">搜索</button>
						</div>
					</form>
					<div class="layui-form" id="table-list">
						<table class="layui-table" lay-even lay-skin="nob" style="table-layout:fixed;word-wrap:break-word;">
							<colgroup>
								<col width="50">
								<col class="hidden-xs" width="50">
								<col class="hidden-xs" width="100">
								<col class="hidden-xs" width="150">
								<col class="hidden-xs" width="150">
								<col  class="hidden-xs" width="250">
								<col width="80">
								<col width="80">
								<col width="150">
							</colgroup>
							<thead>
								<tr>
									<th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose"></th>
									<th class="hidden-xs">订单号</th>
									<th>用户名</th>
									<th>酒店名称</th>
									<th>入住时间</th>
									<th class="hidden-xs">剩余房间数量</th>
									<th class="hidden-xs">状态</th>
									<th >订单时间</th>
									<th width="80">操作</th>
									
								</tr>
							</thead>
							<tbody >
							
								<c:forEach items="${pageBean.list }" var="order">
								<tr>
									<td style="white-space:nowrap;overflow:hidden;text-overflow: ellipsis;">
										<input type="checkbox" name="" lay-skin="primary" data-id="${order.order_id }">
									</td>
									
										<th class="hidden-xs">${order.order_id}</th>
									
										<th>${order.user_name }</th>
										<th>${order.hotel_name }</th>
										
										<th><fmt:formatDate value="${order.hotel_checkin }"  pattern="yyyy-MM-dd hh:mm:ss"/></th>
										<th>${order.room_count }</th>
									 	<th>
											<c:if test="${order.status=='0' }">已订</c:if>
											<c:if test="${order.status== '1'}">已取消</c:if>
											
										</th>
									 	<th>
									 		<fmt:formatDate value="${order.create_time }"  pattern="yyyy-MM-dd hh:mm:ss"/>
									 	</th>
									 
									<td>
										<div class="layui-inline">
											<button class="layui-btn layui-btn-small layui-btn-normal go-btn" data-id="${order.order_id }" data-url="toHotelOrderDetail"><i class="layui-icon">&#xe642;</i></button>
											
											<button class="layui-btn layui-btn-small layui-btn-danger del-btn" data-id ="${order.order_id }" data-url="toUpdate" onclick="check_yes();"><i class="layui-icon">&#xe640;</i></button>
										
										</div>
									</td>
								</tr>
								</c:forEach>
								
							</tbody>
						</table>
						<div class="page-wrap">

							<ul class="pagination">
								<li class="disabled">
									<a <c:if test="${pageBean.pageNum>1 }">href="javascript:;"  onclick="changePage(${pageBean.pageNum-1},${pageBean.size});"</c:if>>«</a>
								</li>
								<c:forEach begin="${pageBean.start }" end="${pageBean.end }" var="p">
			                    	<li>
			                    		<a <c:if test="${pageBean.pageNum==p }">class="layui-bg-blue"</c:if> href="javascript:;" onclick="changePage(${p},${pageBean.size})">${p }</a>
			                    	</li>
			                    </c:forEach>
								<li>
								   <a  <c:if test="${pageBean.pageNum<pageBean.totalPage }">href="javascript:;" onclick="changePage(${pageBean.pageNum+1},${pageBean.size});"</c:if>>»</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
		</div>
		<script src="${pageContext.request.contextPath}/static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/static/admin/js/common.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
		    function check_yes(id){
		    	layer.open({
	    		  title: '审核提示'
	    		  ,content: '确定修改吗？'
	    		  
	    		 
	    		});     
		    		  
		    }
		    
		    function changePage(page,size){
		    	//page=1   size=${pageBean.size}
	     	   //根据传入的参数,将表单的隐藏域赋值,并且进行表单提交
	     	   document.getElementById("page").value=page;
	     	   document.getElementById("size").value=size;
	     	   //console.log(page+";"+size);
	     	   //console.log(document.getElementsByTagName("form")[0]);
	     	   document.getElementsByTagName("form")[0].submit();//提交表单
		    }
		    
		    function d(){
		    	var desc = document.getElementById('desc').value;
		    	console.log(desc+"----------");
		    	if(desc==0){
		    		desc=1;
					
					document.getElementById('desc').value=desc;
					
					document.getElementById('tableTes').submit();//提交表单
					return;
		    	}
		    	if(desc==1){
		    		desc=0;
					
					document.getElementById('desc').value=desc;
					document.getElementById('tableTes').submit();//提交表单
					return;
		    	}
		    }
		    
		    
		
		</script>
	</body>

</html>