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
		<title>会员后台管理模版</title>
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
		    	<form class="layui-form"  style="width: 90%;padding-top: 20px;" method="post" enctype="multipart/form-data" action="${path}/user/doUserInfo" >
		    	<!-- 第一个form---开始 -->
					  <div class="layui-form-item">
					    <label class="layui-form-label">ID：</label>
					    <div class="layui-input-block">
					      <input type="text" name="userId" disabled autocomplete="off" class="layui-input layui-disabled" value="${user.userId }">
					    </div>
					  </div>
					  <div class="layui-form-item">
					    <label class="layui-form-label">邮箱：</label>
					    <div class="layui-input-block">
					      <input type="text" name="email" disabled autocomplete="off" class="layui-input layui-disabled" value="${user.email }">
					  	 <input type="hidden" name="userId" value="${user.userId }">
					    <input type="hidden" name="email" value="${user.email }">
					    <input type="hidden" name="password" value="${user.password }">
					    <input type="hidden" name="registerTime  " value="${user.registerTime   }">
					    </div>
					  </div>
					   <div class="layui-form-item">
					    <label class="layui-form-label">姓名：</label>
					    <div class="layui-input-block">
					      <input type="text" name="userName" required  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input" value="${user.userName }">
					    </div>
					  </div>
					  <div class="layui-form-item">
					    <label class="layui-form-label">手机：</label>
					    <div class="layui-input-block">
					      <input type="text" name="tel" required  lay-verify="required" placeholder="请输入手机号码" autocomplete="off" class="layui-input" value="${user.tel }">
					    </div>
					  </div>
					  <div class="layui-form-item layui-form-text">
					    <label class="layui-form-label">图片：</label>
					    <div class="layui-input-block">
					      <!-- 图片修改 -->
					      <input type="file" name="file"  >
					    </div>
					  </div>
					  
					  
					  <!-- 性别 -->
					  <div class="layui-form-item">
						<label class="layui-form-label">状态：</label>
						<div class="layui-input-block">
							<select name="gender" lay-verify="required"  value="user.gender">
									<option value="0" selected="">女</option>
									<option value="2">男</option>
							</select>
						</div>
					</div>
					
					<div class="layui-form-item">
						<label class="layui-form-label">状态：</label>
						<div class="layui-input-block">
							<select name="userStatus" lay-verify="required" value="user.userStatus">
									<option value="0" selected="">注册</option>
									<option value="2">删除</option>
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
		    	<form class="layui-form"  style="width: 90%;padding-top: 20px;" onsubmit="return toVaild()"  action="${path}/user/doadmint_info_password" >
				  <div class="layui-form-item">
				    <label class="layui-form-label">用户名：</label>
				    <div class="layui-input-block">
				      <input type="text" name="userName" disabled autocomplete="off" class="layui-input layui-disabled" value="${user.userName }">
				    	
				    	
				    	
				    	<input type="hidden" name="userId"  id="userId" value="${user.userId }">
				    	<input type="hidden" name="userName" value="${user.userName }">
				    	<input type="hidden" name="email"  id="loginName" value="${user.email }">
				     	<input type="hidden" name="tel" value="${user.tel }">
				     	<input type="hidden" name="gender" value="${user.gender }">
				     	<input type="hidden" name="userStatus" value="${user.userStatus }">
				     	<input type="hidden" name="pic" value="${user.pic }">
					    <!-- 注册 -->
					    <input type="hidden" name="registerTime" value="${user.registerTime }">
					    
				    
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
			url:"${path}/user/toadmint_info_passw",
			data:{"pwd1":$("#pwd").val(),"userId":$("#userId").val(),},
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