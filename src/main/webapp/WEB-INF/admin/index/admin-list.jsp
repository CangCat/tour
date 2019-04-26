<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html class="iframe-h">

	<head>
		<meta charset="UTF-8">
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>会员管理页面</title>
		<link rel="stylesheet" type="text/css" href="${path}/static/admin/layui/css/layui.css" />
		<link rel="stylesheet" type="text/css" href="${path}/static/admin/css/admin.css" />
	</head>

	<body>
		<div class="wrap-container clearfix">
				<div class="column-content-detail">
				
				<!-- form开始 -->
					<form class="layui-form" action="${path}/admin/toadmint_list">
						<div class="layui-form-item">
							<div class="layui-inline tool-btn">
								<button class="layui-btn layui-btn-small layui-btn-normal addBtn" data-url="${path}/admin/toadmint_add" ><i class="layui-icon">&#xe654;111</i></button>
								<a class="layui-btn layui-btn-small layui-btn-danger" onclick="listdelete()"  ><i class="layui-icon">&#xe640;222</i></a>
								<button class="layui-btn layui-btn-small layui-btn-warm listOrderBtn hidden-xs" data-url="scenic-add.html"     onclick="px()"  <c:if test="${desc == 1}" >style="background-color: purple;"</c:if><c:if test="${desc == 0}" >style="background-color: blue;"</c:if>><i class="iconfont">&#xe656;3333</i></button>
								<input type="hidden" name="desc" id="desc" value="${desc }"/>
								
								</div>
							<div class="layui-inline">
								<input type="text" name="name"   placeholder="姓名" value="${admin.name }" class="layui-input">
								
								<input id="page" type="hidden" name="page" value="" class="text_search"  />
                    			<input id="size" type="hidden" name="size" value="" class="text_search" />
							</div>
							<div class="layui-inline">
							<!-- 要  与实体类adminStatus对应他才能封装 -->
								<select name="adminStatus" lay-filter="status">
									<option value="" <c:if test="${admin.adminStatus == '' }">selected</c:if>>全部</option>
									<option value="0" <c:if test="${admin.adminStatus == '0' }">selected</c:if>>开通</option>
									<option value="1" <c:if test="${admin.adminStatus == '1' }">selected</c:if>>停用</option>
									
								</select>
							</div>
							<button class="layui-btn layui-btn-normal" lay-submit="search" onclick="sou()" >搜索</button>
						</div>
					</form>
	
	<!-- form结束-->
	
					
					<!-- 这里开始遍历数据 -->
					
					
					<div class="layui-form" id="table-list">
						<table class="layui-table" lay-even lay-skin="nob">
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
									<th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose"></th>
									<th class="hidden-xs">ID</th>
									<th class="hidden-xs">管理员姓名</th>
									<th>登陆名称</th>
									<th>手机号</th>
									<th class="hidden-xs">性别</th>
									<th class="hidden-xs">图片</th>
									<th>管理员状态</th>
									<th class="hidden-xs">注册时间</th>
									<th class="hidden-xs">修改时间</th>
									<th class="hidden-xs">管理员类型</th>
									
									<th>操作</th>
									<!-- 
									<th>状态</th>
									<th>操作</th>
									
									 -->
								</tr>
							</thead>
							
							<tbody>
							
							<!-- 页面循环 -->
							
							<c:forEach   items="${pageBean.list }" var="p">
								<tr>
									<td><input type="checkbox" name="list_deleteorder" lay-skin="primary" class="deletelist"  value="${p.adminId }"></td>
									<th class="hidden-xs">${p.adminId }</th>
									<th class="hidden-xs">${p.name }</th>
									<th class="hidden-xs">${p.loginName }</th>
									<th>${p.tel }</th>
									<th>
									<c:if test="${p.gender == '1' }">男</c:if>
									<c:if test="${p.gender == '0' }">女</c:if>
									</th>
									<th class="hidden-xs">
									
									<img style="width: 30px;height: 25px" src="/img/${p.pic }"/>
									</th>
									<th class="hidden-xs">
									<c:if test="${p.adminStatus == '1' }">停用</c:if>
									<c:if test="${p.adminStatus == '0' }">已开通</c:if>
									</th>
									
									<th><fmt:formatDate value="${p.registerTime }" pattern="yyyy-MM-dd"/></th>
									<th class="hidden-xs">
									<fmt:formatDate value="${p.updateTime }" pattern="yyyy-MM-dd"/>
									</th>
									<th class="hidden-xs">
									<c:if test="${p.adminType == '0' }">开放所有</c:if>
									<c:if test="${p.adminType == '2' }">酒店管理</c:if>
									<c:if test="${p.adminType == '3' }">景区管理</c:if>
									<c:if test="${p.adminType == '4' }">餐厅管理</c:if>
									<c:if test="${p.adminType == '5' }">娱乐管理</c:if>
									<c:if test="${p.adminType == '6' }">待定</c:if>
									
									</th>
									
									
									<td>
										<div class="layui-inline">
											<button class="layui-btn layui-btn-small layui-btn-normal go-btn"  data-url="${path}/admin/toadmint_info?adminId=${p.adminId }" ><i class="layui-icon">&#xe642;</i></button>
											<!--  
											<button class="layui-btn layui-btn-small layui-btn-danger del-btn" onclick="delete(${p.adminId })"><i class="layui-icon">&#xe640;</i></button>
											-->
											<a class="layui-btn layui-btn-small layui-btn-danger" href="${path}/admin/toadmint_delete?adId=${p.adminId }" ><i class="layui-icon">&#xe640;</i></a>
											<!-- href="${path}/admin/toadmint_delete?adId=${p.adminId }" -->
										</div>
									</td>
								</tr>
								
								</c:forEach>
								
							</tbody>
						</table>
						
						
						<div class="page-wrap">
						
						
							<ul class="pagination">
								
								<li class="disabled">
								 <a  <c:if test="${pageBean.pageNum > 1 }">href="javascript:;" onclick="changePage(${pageBean.pageNum-1},${pageBean.size});"</c:if>>«</a>
								</li>
								<c:forEach begin="${pageBean.start }" end="${pageBean.end }" var="pa" >
								<li <c:if test="${pageBean.pageNum == pa }">class="active"</c:if>  >
								<span href="javascript:;"  onclick="changePage(${pa},${pageBean.size})"  >${pa}</span>
								</li>
								</c:forEach>
								<li>
									<a <c:if test="${pageBean.pageNum < pageBean.totalPage }">href="javascript:;" onclick="changePage(${pageBean.pageNum+1},${pageBean.size});"</c:if> >»</a>
								</li>
							</ul>
							
							
							
						</div>
					
					
					</div>
				</div>
		</div>
		<script src="${path}/static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
		<script src="${path}/static/admin/js/common.js" type="text/javascript" charset="utf-8"></script>
		
		<script type="text/javascript" src="${path }/js/jquery.min.js"></script>
		
	
		<script type="text/javascript">
		
		//分页
		function changePage(page,size){
     	   //page=1   size=${pageBean.size}
     	   //根据传入的参数,将表单的隐藏域赋值,并且进行表单提交
     	   document.getElementById("page").value=page;
     	   document.getElementById("size").value=size;
     	   //console.log(page+";"+size);
     	   //console.log(document.getElementsByTagName("form")[0]);
     	   document.getElementsByTagName("form")[0].submit();//提交表单
        }
		
		//收索
		function sou() {
			
			document.getElementsByTagName("form")[0].submit();//提交表单
			
		}
		
		function px(){
			
			var id = document.getElementById('desc').value;
			console.log(id);
			
			
			if(id==1){
				id=0;
				console.log('id等于111111');
				console.log('改变之后的id值'+id);
				document.getElementById('desc').value=id;
				document.getElementsByTagName("form")[0].submit();//提交表单
				return; 
				 
			}
			
			if(id==0){
				id=1;
				console.log('id等于0');
				console.log('改变之后的id值:'+id);
				document.getElementById('desc').value=id;
				document.getElementsByTagName("form")[0].submit();//提交表单
				return; 
				 
			}
			
			
		}
		
		//批量删除
		function listdelete(){
			//这个是jq
			var obj=document.getElementsByName("list_deleteorder");
			
			console.log(obj);
			
			var list = [];
			
			for(k in obj){
				//判断什么  是否被选中      checked（选中）
				if(obj[k].checked){
					//选中就丢到新的数组
					list.push(obj[k].value);
					
				}else{
					
					
				}
				
				console.log(list);
				
			}
			
			//这里写ajax
			
			
			$.ajax({
				
				
				"url":"${path}/admin/toadmint_delete_list",//请求地址
				"type":"post",//发送请求
				"data":{"o_id":list},//传递到后台的参数
				//"dataType":"json",//返回数据类型  游览器自动适配
				"success":function(data){
					
					//if(data=="1"){
						console.log(data);
						
						
						if(data=="1"){
							
							//console.log(111111111);
							
							alert("批量删除成功");
							
							//刷新页面
							location.reload(true);
							return;
							
						}else{
							//console.log(2222222);
							alert("批量删除失败");
							//刷新页面
							location.reload(true);
							return;
							
						}
						
						
						//alert('进入单前ajax并接受到');
						//location.href="${path}/Orders/finallorders";
						
					//}else{
						
						//alert("删除失败");
					//}
					
				}
				
				
			});
			
			
			
		}
		
		</script>
	</body>

</html>