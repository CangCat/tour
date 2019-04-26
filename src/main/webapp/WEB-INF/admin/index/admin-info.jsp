
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="renderer" content="webkit">
  		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>网站后台管理模版</title>
		<link rel="stylesheet" type="text/css" href="${path}/static/admin/layui/css/layui.css"/>
		<link rel="stylesheet" type="text/css" href="${path}/static/admin/css/admin.css"/>
	</head>
	<body>
		<div class="layui-tab page-content-wrap">
		  <ul class="layui-tab-title">
		    <li class="layui-this">修改资料</li>
		    <li>修改密码</li>
		  </ul>
		  <div class="layui-tab-content">
		    <div class="layui-tab-item layui-show">
		    	<!-- post 才能提交图片 -->
		    	<form class="layui-form"  style="width: 90%;padding-top: 20px;" method="post" enctype="multipart/form-data" action="${path}/admin/doadmint_info" >
		    	<!-- 第一个form---开始 -->
			    	
			    	
			    	
					  <div class="layui-form-item">
					    <label class="layui-form-label">ID：</label>
					    <div class="layui-input-block">
					      <input type="text" name="adminId" disabled autocomplete="off" class="layui-input layui-disabled" value="${admin.adminId }">
					    </div>
					  </div>
					  <div class="layui-form-item">
					    <label class="layui-form-label">登录名：</label>
					    <div class="layui-input-block">
					      <input type="text" name="loginName" disabled autocomplete="off" class="layui-input layui-disabled" value="${admin.loginName }">
					  	 
					  	 
					  	 <input type="hidden" name="adminId" value="${admin.adminId }">
					    <input type="hidden" name="loginName" value="${admin.loginName }">
					    <input type="hidden" name="password" value="${admin.password }">
					    <input type="hidden" name="gender" value="${admin.gender }">
					    <input type="hidden" name="registerTime  " value="${admin.registerTime   }">
					    <input type="hidden" name="adminType" value="${admin.adminType  }">
					    
					    </div>
					  </div>
					   <div class="layui-form-item">
					    <label class="layui-form-label">姓名：</label>
					    <div class="layui-input-block">
					      <input type="text" name="name" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input" value="${admin.name }">
					    </div>
					  </div>
					  <div class="layui-form-item">
					    <label class="layui-form-label">手机：</label>
					    <div class="layui-input-block">
					      <input type="text" name="tel" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input" value="${admin.tel }">
					    </div>
					  </div>
					  <div class="layui-form-item layui-form-text">
					    <label class="layui-form-label">图片：</label>
					    <div class="layui-input-block">
					      <!-- 图片修改 -->
					      <input type="file" name="file"  >
					    </div>
					  </div>
					  
					  
					  <!-- 加状态与类型 -->
					  <div class="layui-form-item">
									<label class="layui-form-label">状态：</label>
									<div class="layui-input-block">
										<select name="adminStatus" lay-verify="required">
												<option value="0" selected="">开通</option>
												<option value="2">停用</option>
										</select>
						</div>
					</div>
					
					${admin.adminType }
					
					
					<div class="layui-form-item">
						<label class="layui-form-label">状态：</label>
						<div class="layui-input-block">
							<select name="adminType" lay-verify="required">
									<option value="0" selected="">开放所有</option>
									<option value="2">酒店管理</option>
									<option value="3">景区管理</option>
									<option value="4">餐厅管理</option>
									<option value="5">娱乐管理</option>
									<option value="6">待定</option>
									
							</select>
						</div>
					</div>
					
					
					
					  
					  
					  <div class="layui-form-item">
					    <div class="layui-input-block">
					      <button class="layui-btn layui-btn-normal" lay-submit lay-filter="adminInfo" type="submit">立即提交</button>
					    </div>
					  </div>
					  
				  <!-- 第一个form---end -->
				</form>
		    </div>
		    
		    
		    
		    <!-- 
		    ---
		    ---第二个页面
		    ---
		     -->
		    <div class="layui-tab-item">
		    	<form class="layui-form"  style="width: 90%;padding-top: 20px;" onsubmit="return toVaild()"  action="${path}/admin/doadmint_info_password" >
				  <div class="layui-form-item">
				    <label class="layui-form-label">用户名：</label>
				    <div class="layui-input-block">
				      <input type="text" name="loginName1" disabled autocomplete="off" class="layui-input layui-disabled" value="${admin.loginName }">
				    	
				    	<input type="hidden" name="registerTime" value="${admin.registerTime }">
				    	<input type="hidden" name="loginName"  id="loginName" value="${admin.loginName }">
				     	<input type="hidden" name="adminId" value="${admin.adminId }">
				     	<input type="hidden" name="name" value="${admin.name }">
				     	<input type="hidden" name="tel" value="${admin.tel }">
				     	<input type="hidden" name="pic" value="${admin.pic }">
					    <input type="hidden" name="gender" value="${admin.gender }">
					    <input type="hidden" name="adminStatus" value="${admin.adminStatus }">
					    <input type="hidden" name="registerTime  " value="${admin.registerTime   }">
					    <input type="hidden" name="adminType" value="${admin.adminType  }">
				    
				    </div>
				  </div>
				  <div class="layui-form-item">
				    <label class="layui-form-label">旧密码：</label>
				    <div class="layui-input-block">
				      <input type="password" name="password1" onchange="yanzhen()" id="pwd"  required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input" >
				    	<span id="pwdyz"></span>
				    </div>
				  </div>
				  <div class="layui-form-item">
				    <label class="layui-form-label">新密码：</label>
				    <div class="layui-input-block">
				      <input type="password" name="password"  id="pwd2" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
				    
				    </div>
				  </div>
				  <div class="layui-form-item">
				    <label class="layui-form-label">重复密码：</label>
				    <div class="layui-input-block">
				      <input type="password" name="password3" id="pwd3"  required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
				   	<span id="pwdyz1"></span>
				    </div>
				  </div>
				  <div class="layui-form-item">
				    <div class="layui-input-block">
				      <button class="layui-btn layui-btn-normal" lay-submit lay-filter="adminPassword" type="submit">立即提交</button>
				    </div>
				  </div>
				</form>
		    </div>
		  </div>
		</div>
	<script src="${path}/static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
	
	<script type="text/javascript" src="${path}/js/jquery.min.js"></script>
	
	<script>
		//Demo
		layui.use(['form','element'], function(){
		  var form = layui.form();
		  var element = layui.element();
		  form.render();
		  //监听信息提交
		  form.on('submit(adminInfo)', function(data){
		    layer.msg(JSON.stringify(data.field));
		    return false;
		  });
		  //监听密码提交
		   form.on('submit(adminPassword)', function(data){
		    layer.msg(JSON.stringify(data.field));
		    return false;
		  });
		});
		
		
		
	</script>
	
	<script type="text/javascript">
	
	function yanzhen(){
		
		$.ajax({
			url:"${path}/admin/toadmint_info_passw",
			data:{"pwd1":$("#pwd").val(),"loginName":$("#loginName").val(),},
			type:"post",
			success:function(data){
				console.log(data);
				if(data==1){
					console.log(111111111);
					
					$("#pwdyz").html(" ");
					var str ="<i class='layui-icon layui-icon-close-fill' style='color:red'></i>";
					$("#pwdyz").html(str);
				}
				
				if(data==0){
					console.log(222222);
					$("#pwdyz").html(" ");
					var str ="<i class='layui-icon layui-icon-ok-circle' style='color:green'></i>";
					$("#pwdyz").html(str);
				}
				
			}
		});
		
	}
	
	
	function toVaild(){
		
		var a = $("#pwd2").val();
		var b = $("#pwd3").val();
		
		if(a == b){
             alert("密码修改成功");
             return true;
        }
        else{
        	
            alert("新密码与重复密码不一致");
            $("#pwdyz1").html(" ");
            var str ="<i class='layui-icon layui-icon-close-fill' style='color:red'></i>";
			$("#pwdyz1").html(str);
			
            return false;
       }
		
	}
	
	</script>
	
	</body>
</html>