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
					<%-- <form class="layui-form" action="${pageContext.request.contextPath }/room/toPageList" method="post" > --%>
						<div class="layui-form-item">
							<div class="layui-inline tool-btn">
								<button class="layui-btn layui-btn-small layui-btn-normal addBtn" data-url="toRoomAdd"><i class="layui-icon">&#xe654;</i></button>
							</div>
							<!-- 
								input的值获取   通过spring 封装成 hotel对象
								
								input 的name值   需要与   hotel的属性对应
							 -->
							
							
						</div>
					<!-- </form> -->
					<div class="layui-form" id="table-list">
						<table class="layui-table" lay-even lay-skin="nob" style="table-layout:fixed;word-wrap:break-word;">
							<colgroup>
								<col width="80">
								<col class="hidden-xs" width="50">
								<col class="hidden-xs" width="100">
								<col class="hidden-xs" width="150">
								<col class="hidden-xs" width="150">
								<col  class="hidden-xs" width="250">
								<col width="80">
								
							</colgroup>
							<thead>
								<tr>
									
									<th>序号</th>
									<th >房间号</th>
									<th>房间名</th>
									<th>价格</th>
									<th>房间类型</th>
									<th class="hidden-xs">房间图片</th>
									<th class="hidden-xs">酒店名</th>
									
									
								</tr>
							</thead>
							<tbody >
							
								<c:forEach items="${pageBean.list }" var="room" varStatus="st">
								<tr>
									
										<th>${st.count }</th>
										<th class="hidden-xs">${room.room_id}</th>
									
										<th>${room.room_name }</th>
										<th>${room.room_price }</th>
										
										<th>${room.room_remark }</th>
									 	
									 	<th>${room.room_pic }</th>
									 	<th>${room.hotel_name }</th>
									 
									
								</tr>
								</c:forEach>
								
							</tbody>
						</table>
						<div class="page-wrap">

							<ul class="pagination">
								<li class="disabled">
									<a <c:if test="${pageBean.pageNum>1 }">href="${pageContext.request.contextPath }/room/toPageList?page=${pageBean.pageNum-1}&size=${pageBean.size}" </c:if>>«</a>
								</li>
								<c:forEach begin="${pageBean.start }" end="${pageBean.end }" var="p">
			                    	<li>
			                    		<a <c:if test="${pageBean.pageNum==p }">class="layui-bg-blue"</c:if>  href="${pageContext.request.contextPath}/room/toPageList?p=${p }&size=${pageBean.size }">${p }</a>
			                    	</li>
			                    </c:forEach>
								<li>
								   <a  <c:if test="${pageBean.pageNum<pageBean.totalPage }">href="${pageContext.request.contextPath }/room/toPageList?page=${pageBean.pageNum+1}&size=${pageBean.size}" </c:if>>»</a>
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
		    
		    
		    
		
		</script>
	</body>

</html>