<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="renderer" content="webkit">
  		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>网站后台管理模版</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin/layui/css/layui.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin/css/admin.css"/>
	</head>
	<body>
	<form class="layui-form column-content-detail" method="post" action="${pageContext.request.contextPath}/travel/doAdd">
		<div class="layui-tab" style="margin: 0;">
			<div class="layui-tab-content">
				<div class="layui-tab-item"></div>
				<div class="layui-tab-item layui-show">
					
					<div class="layui-form-item">
						<label class="layui-form-label">发表景区：</label>
						<div class="layui-input-block">
							<select name="scenicId" lay-verify="required">
								<option value="">请选择景区</option>
								<c:forEach items="${scenic }" var="s">
									<option <c:if test="${t.scenicId==s.scenicId}">checked</c:if> value="${s.scenicId }">${s.scenicName }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">图像上传：</label>
						<div class="layui-input-block">
							<input type="file" name="picture" value="${t.picture }" class="layui-input" >
						</div>
					</div>
					
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">游记内容：</label>
						<div class="layui-input-block">
							<textarea placeholder="发表内容" class="layui-textarea" name="intro" >${t.intro }</textarea>
						</div>
					</div>
					
					<div class="layui-form-item">
						<label class="layui-form-label">满意度：</label>
						<div class="layui-input-block">
							<input type="text" name="prefaction"  value="${t.prefaction }" placeholder="请输入详细地址" autocomplete="off" class="layui-input">
						</div>
					</div>
					
					<div class="layui-form-item">
						<label class="layui-form-label">状态：</label>
						<div class="layui-inline">
							<select name="status" lay-filter="status">
								<option value="">请选择一个评论状态</option>
								<option  <c:if test="${t.status=='0'}">checked</c:if> value="0">正常</option>
								<option  <c:if test="${t.status=='1'}">checked</c:if> value="1">停止</option>
								<option <c:if test="${t.status=='2'}">checked</c:if> value=2>删除</option>
							</select>
						</div>
					</div>
					
					<div class="layui-form-item">
						<label class="layui-form-label">点赞人数：</label>
						<div class="layui-input-block">
							<input type="number" name="likeNum" placeholder="请输入点赞人数" value="${t.likeNum }" autocomplete="off" class="layui-input">
						</div>
					</div>
					
					<div class="layui-form-item">
						<label class="layui-form-label">查看人数：</label>
						<div class="layui-input-block">
							<input type="number" name="lookNum" placeholder="请输入查看人数" value="${t.lookNum }" autocomplete="off" class="layui-input">
						</div>
					</div>
					
					<!-- <div class="layui-form-item layui-form-text">
						<label class="layui-form-label">发表的图片：</label>
						<div class="layui-input-block">
							<textarea class="layui-textarea layui-hide" name="picture" lay-verify="content" id="LAY_demo_editor"></textarea>
						</div>
					</div> -->
				</div>
			</div>
		</div>
		<div class="layui-form-item" style="padding-left: 10px;">
			<div class="layui-input-block">
				<button class="layui-btn layui-btn-normal" type="submit">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
	<script src="${pageContext.request.contextPath}/static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/static/admin/js/common.js" type="text/javascript"  charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js" type="text/javascript"  charset="utf-8"></script>
	<script>
		
	</script>
	</body>
</html>