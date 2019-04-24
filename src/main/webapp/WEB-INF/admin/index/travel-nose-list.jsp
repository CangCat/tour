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
		<title>旅游景点</title>
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
								<button class="layui-btn layui-btn-small layui-btn-danger delBtn"  data-url="scenic-add..html"><i class="layui-icon">&#xe640;</i></button>
								<button class="layui-btn layui-btn-small layui-btn-warm listOrderBtn hidden-xs" data-url="scenic-add.html"><i class="iconfont">&#xe656;</i></button>
							</div>
							<div class="layui-inline">
								<input type="text" name="uName" value="${uName}"  placeholder="评论的用户" autocomplete="off" class="layui-input">
								<input id="page" type="hidden" name="pageNum" value="" class="text_search"  />
                    			<input id="size" type="hidden" name="size" value="" class="text_search" />
							</div>
							<div class="layui-inline">
								<input type="text" name="sName"value="${sName}"  placeholder="评论的景点" autocomplete="off" class="layui-input">
							</div>
							<div class="layui-inline">
								<select name="status" lay-filter="status">
									<option value=""><c:if test="${status=='' }">请选择一个评论状态</c:if></option>
									<option value="0"><c:if test="${status=='0' }">正常</c:if></option>
									<option value="1"><c:if test="${status=='1' }">停止</c:if></option>
									<option value=2><c:if test="${status=='2' }">删除</c:if></option>
								</select>
							</div>
							
							<button class="layui-btn layui-btn-normal" type="submit" lay-submit="search">搜索</button>
						</div>
					</form>
					<div class="layui-form" id="table-list">
						<table class="layui-table" lay-skin="line" lay-size="lg">
							<colgroup>
								<col width="50">
								<col class="hidden-xs" width="50">
								<col class="hidden-xs" width="150">
								<col class="hidden-xs" width="200">
								<col>
								<col width="200">
								<col width="150">
								<col width="150">
								<col width="150">
								<col width="200">
							</colgroup>
							<thead>
								<tr>
									<th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose"></th>
									<th class="hidden-ls">ID</th>
									<th>评论用户</th>
									<th  class="hidden-ls">评论景点</th>
									<th>评论内容</th>
									<th>发表时间</th>
									<th class="hidden-ls">查看人数</th>
									<th class="hidden-ls">评论状态</th>
									<th class="hidden-ls">点赞人数</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${pageBean.list}" var="travel">
									<tr>
										<td><input type="checkbox" name="tId" lay-skin="primary"value="${travel.tId }"></td>
										<th class="hidden-ls">${travel.tId }</th>
										<th>${travel.uName }</th>
										<th class="hidden-ls">${travel.sName }</th>
										<th style="overflow:visible;text-overflow:inherit;">${travel.intro }</th>
										<th> <fmt:formatDate value="${travel.createTime }" pattern="yyyy-MM-dd hh:mm:ss"/> </th>
										<th class="hidden-ls"> ${travel.lookNum }</th>
										<c:if test="${travel.status=='0' }">
											<th>发表</th>
										</c:if>
										
										<c:if test="${travel.status=='1' }">
											<th>未发表</th>
										</c:if>
										
										<c:if test="${travel.status=='2' }">
											<th>删除</th>
										</c:if>
										
										<th> ${travel.likeNum }</th>
										<td>
											<div class="layui-inline">
												<button class="layui-btn layui-btn-small layui-btn-normal go-btn"  data-id="${travel.travelId}" data-url="toUpdate"><i class="layui-icon">&#xe642;</i></button>
												<button class="layui-btn layui-btn-small layui-btn-danger del-btn" data-id="1" data-url="scenic-detail.html"><i class="layui-icon">&#xe640;</i></button>
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
		</script>
	</body>

</html>