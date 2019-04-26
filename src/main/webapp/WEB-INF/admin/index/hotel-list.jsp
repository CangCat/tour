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
		<title>酒店</title>
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
					<form class="layui-form" action="${pageContext.request.contextPath }/hotel/toPageList" method="post" id="tableTes">
						<div class="layui-form-item">
							<div class="layui-inline tool-btn">
								<button class="layui-btn layui-btn-small layui-btn-normal addBtn" data-url="hotel-add.html"><i class="layui-icon">&#xe654;</i></button>
								<button class="layui-btn layui-btn-small layui-btn-danger delBtn"  data-url="hotel-add.html"><i class="layui-icon">&#xe640;</i></button>
								<%-- <button class="layui-btn layui-btn-small layui-btn-warm listOrderBtn hidden-xs" data-url="${pageContext.request.contextPath }/hotel/toPageList" onclick="desc();" <c:if test="${desc==1 }">style="background-color:purple;"</c:if><c:if test="${desc==0 }">style="background-color:bule"</c:if>><i class="iconfont">&#xe656;</i></button>
								
								<input type="hidden" name="desc" id="desc" value="${desc }"/> --%>
								
								
								<button lay-filter="desc" class="layui-btn layui-btn-small layui-btn-warm listOrderBtn hidden-xs" data-url="${pageContext.request.contextPath }/hotel/toPageList" onclick="desc();" value="desc"><i class="iconfont">&#xe656;</i></button>
								
							</div>
							<!-- 
								input的值获取   通过spring 封装成 hotel对象
								
								input 的name值   需要与   hotel的属性对应
							 -->
							<div class="layui-inline">
							
								<input type="text" name="name"  placeholder="请输入酒店名称" autocomplete="off" class="layui-input" value="${name }">
							</div>
							<div class="layui-inline">
								<select name="status" lay-filter="status">
								
									<option value="" <c:if test="${status=='' }">selected</c:if>>请选择一个状态</option>
									<option value="0" <c:if test="${status=='0' }">selected</c:if>>营业</option>
									<option value="1" <c:if test="${status=='1' }">selected</c:if>>等待审核</option>
									<option value="2" <c:if test="${status=='2' }">selected</c:if>>注销</option>
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
									<th class="hidden-xs">ID</th>
									<th>酒店名称</th>
									<th>所属景点名字</th>
									<th>酒店大图</th>
									<th class="hidden-xs">酒店简介...</th>
									<th class="hidden-xs">地址</th>
									<th>联系人</th>
									<th class="hidden-xs">联系人手机号</th>
									<th>点击数</th>
									<th>状态</th>
									<th>审核</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody >
							
								<c:forEach items="${pageBean.list }" var="h">
								<tr>
									<td style="white-space:nowrap;overflow:hidden;text-overflow: ellipsis;">
										<input type="checkbox" name="" lay-skin="primary" data-id="1">
									</td>
									
										<th class="hidden-xs">${h.hotelId }</th>
									
										<th>${h.hotelName }</th>
										<c:forEach items="${scenic }" var="s">
											<c:if test="${h.scenicId==s.scenicId }">
												<th>${s.scenicName }</th>
											</c:if>
											
										</c:forEach>
										<th>${h.hotelPic }</th>
										<th class="hidden-xs" style="overflow:visible;text-overflow:inherit;">${h.hotelDes }</th>
										<th class="hidden-xs">${h.hotelAddress }</th>
										<th>${h.hotelLink }</th>
										<th class="hidden-xs">${h.hotelTel }</th>
										
										<th>${h.hotelCount }</th>
										<th>
											<c:if test="${h.status=='0' }">营业</c:if>
											<c:if test="${h.status== '1'}">等待审核</c:if>
											<c:if test="${h.status=='2' }">已注销</c:if>
										</th>
										
										<th>
											<c:if test="${h.status== '1'}"><button class="layui-btn layui-btn-radius layui-btn-normal" onclick="check_yes(${h.hotelId});">等待审核</button></c:if>
											<c:if test="${h.status=='0' }"><a class="layui-btn layui-btn-radius layui-btn-disabled">已审核</a></c:if>
										</th>
									 
									<td>
										<div class="layui-inline">
											<button class="layui-btn layui-btn-small layui-btn-normal go-btn" data-id="${h.hotelId }" data-url="toHotelDetail"><i class="layui-icon">&#xe642;</i></button>
											<button class="layui-btn layui-btn-small layui-btn-danger del-btn" data-id="${h.hotelId }" data-url="toUpdate" onclick="check_yes();"><i class="layui-icon">&#xe640;</i></button>
										</div>
									</td>
								</tr>
								</c:forEach>
								<!-- <tr>
									<td><input type="checkbox" name="" lay-skin="primary" data-id="1"></td>
									<th class="hidden-xs">ID</th>
									<th class="hidden-xs">2</th>
									<th>长隆水上乐园</th>
									<th>景区大图</th>
									<th class="hidden-xs">景区简介...</th>
									<th class="hidden-xs">地址</th>
									<th>张三</th>
									<th class="hidden-xs">12345678901</th>
									<th class="hidden-xs">68￥</th>
									<th class="hidden-xs">7:00~19:30</th>
									<th>正常运营</th>
									<td>
										<div class="layui-inline">
											<button class="layui-btn layui-btn-small layui-btn-normal go-btn" data-id="1" data-url="hotel-detail.html"><i class="layui-icon">&#xe642;</i></button>
											<button class="layui-btn layui-btn-small layui-btn-danger del-btn" data-id="1" data-url="hotel-detail.html"><i class="layui-icon">&#xe640;</i></button>
										</div>
									</td>
								</tr>  -->
								
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
		    
		    
		    
		    function d(){
		    	var id = document.getElementById('desc').value;
		    	if(desc==0){
		    		id=1;
					
					document.getElementById('desc').value=id;
					document.getElementsByTagName("form")[0].submit();//提交表单
					return; 
		    	}
		    	if(desc==1){
		    		id=0;
					
					document.getElementById('desc').value=id;
					document.getElementsByTagName("form")[0].submit();//提交表单
					return; 
		    	}
		    }
		    
		    
		
		</script>
	</body>

</html>