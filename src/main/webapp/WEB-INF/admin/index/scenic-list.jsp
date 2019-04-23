<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE>
<html class="iframe-h">

	<head>
		<meta charset="UTF-8">
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>旅游景点</title>
		<link rel="stylesheet" type="text/css" href="${path}/static/admin/layui/css/layui.css"/>
		<link rel="stylesheet" type="text/css" href="${path}/static/admin/css/admin.css"/>
	</head>

	<body>
		<div class="wrap-container clearfix">
				<div class="column-content-detail">
					<form class="layui-form" action="">
						<div class="layui-form-item">
							<div class="layui-inline tool-btn">
								<button class="layui-btn layui-btn-small layui-btn-normal addBtn" data-url="scenic-add.html"><i class="layui-icon">&#xe654;</i></button>
								<button class="layui-btn layui-btn-small layui-btn-danger delBtn"  data-url="scenic-add.html"><i class="layui-icon">&#xe640;</i></button>
								<button class="layui-btn layui-btn-small layui-btn-warm listOrderBtn hidden-xs" data-url="scenic-add.html"><i class="iconfont">&#xe656;</i></button>
							</div>
							<div class="layui-inline">
								<input type="text" name="title" required lay-verify="required" placeholder="请输入景点" autocomplete="off" class="layui-input">
							</div>
							<div class="layui-inline">
								<select name="states" lay-filter="status">
									<option value="">请选择一个状态</option>
									<option value="010">正常</option>
									<option value="021">停止</option>
									<option value="0571">删除</option>
								</select>
							</div>
							<button class="layui-btn layui-btn-normal" lay-submit="search">搜索</button>
						</div>
					</form>
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
									<th>景区名称</th>
									<th class="hidden-xs">景区简介...</th>
									<th class="hidden-xs">地址</th>
									<th>联系人</th>
									<th class="hidden-xs">联系人手机号</th>
									<th class="hidden-xs">收费金额</th>
									<th class="hidden-xs">开放时间</th>
                                    <th class="hidden-xs">审核状态</th>
                                    <th class="hidden-xs">创建时间</th>
                                    <th class="hidden-xs">修改时间</th>
                                    <th class="hidden-xs">类型一</th>
                                    <th class="hidden-xs">类型二</th>
									<th>状态</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
                            <c:forEach var="scenic" items="${list}">
                                <tr>
                                    <td><input type="checkbox" name="" lay-skin="primary" data-id="1"></td>
                                    <th class="hidden-xs">${scenic.scenicId}</th>
                                    <th>${scenic.scenicName}</th>
                                    <th class="hidden-xs">${scenic.scenicIntro}</th>
                                    <th class="hidden-xs">${scenic.scenicAddress}</th>
                                    <th>${scenic.scenicLink}</th>
                                    <th class="hidden-xs">${scenic.scenicTel}</th>
                                    <th class="hidden-xs">${scenic.scenicCharge}￥</th>

                                    <th class="hidden-xs">
                                            ${scenic.openTime}~${scenic.endTime}
                                    </th>
                                    <th>
                                        <c:if test="${scenic.checkType} == 0">以审核</c:if>
                                        <c:if test="${scenic.checkType} == 1">未审核</c:if>
                                    </th>
                                    <td>
                                        <fmt:formatDate value="${scenic.createTime}"
                                                        pattern="yy-MM-dd"></fmt:formatDate>
                                    </td>
                                    <td>
                                        <fmt:formatDate value="${scenic.updateTime}"
                                                        pattern="yy-MM-dd"></fmt:formatDate>
                                    </td>
                                    <td>
                                        <c:if test="${scenic.typeOne} == 1">
                                            省内游
                                        </c:if>
                                        <c:if test="${scenic.typeOne} == 2">
                                            国内游
                                        </c:if>
                                        <c:if test="${scenic.typeOne} == 3">
                                            港澳台游
                                        </c:if>
                                        <c:if test="${scenic.typeOne} == 4">
                                            国外游
                                        </c:if>
                                    </td>
                                    <td>
                                        <c:if test="${scenic.typeTwo} == 1">
                                            热门主题
                                        </c:if>
                                        <c:if test="${scenic.typeTwo} == 2">
                                            热门目的地
                                        </c:if>
                                        <c:if test="${scenic.typeTwo} == 3">
                                            自由行
                                        </c:if>
                                        <c:if test="${scenic.typeTwo} == 4">
                                            跟团
                                        </c:if>
                                        <c:if test="${scenic.typeTwo} == 5">
                                            邮轮游
                                        </c:if>
                                    </td>
                                    <td>
                                        <c:if test="${scenic.scenicStatus} == 0">正常运营</c:if>
                                        <c:if test="${scenic.scenicStatus} == 1">以删除</c:if>
                                    </td>
                                    <td>
                                        <div class="layui-inline">
                                            <button class="layui-btn layui-btn-small layui-btn-normal go-btn"
                                                    data-id="1" data-url="scenic-detail.html"
                                                    onclick="toAdd(${scenic.scenicId})"><i
                                                    class="layui-icon">&#xe642;</i></button>
                                            <button class="layui-btn layui-btn-small layui-btn-danger del-btn"
                                                    data-id="1" data-url="scenic-detail.html" id="${scenic.scenicId}"><i
                                                    class="layui-icon">&#xe640;</i></button>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
							</tbody>
						</table>
						<div class="page-wrap">
							<ul class="pagination">
								<li class="disabled"><span>«</span></li>
								<li class="active"><span>1</span></li>
								<li>
									<a href="#">2</a>
								</li>
								<li>
									<a href="#">»</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
		</div>
		<script src="${path}/static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
		<script src="${path}/static/admin/js/common.js" type="text/javascript" charset="utf-8"></script>
	</body>

    <script type="text/javascript">

        function toAdd(id) {
            location.href = "${path}/scenic/toScenicAdd/" + id;
        }

    </script>
</html>