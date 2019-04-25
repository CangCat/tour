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
		<script type="text/javascript">
			//获取路径
			var pathName = window.document.location.pathname;
			//截取，得到项目名称
			var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
			console.log(projectName)
		</script>
		<link rel="stylesheet" type="text/css" href="${path}/static/admin/layui/css/layui.css"/>
		<link rel="stylesheet" type="text/css" href="${path}/static/admin/css/admin.css"/>
	</head>

	<body>
		<div class="wrap-container clearfix">
				<div class="column-content-detail">
					<form class="layui-form" action="">
						<div class="layui-form-item">
							<div class="layui-inline tool-btn">
								<button class="layui-btn layui-btn-small layui-btn-normal addBtn"
										data-url="${path}/scenic/toScenicAdd"><i class="layui-icon">&#xe654;</i>
								</button>
                                <button class="layui-btn layui-btn-small layui-btn-danger delBtn"
                                        data-url="${path}/scenic/deleteByIds"><i class="layui-icon">&#xe640;</i>
                                </button>
								<button class="layui-btn layui-btn-small layui-btn-warm listOrderBtn hidden-xs" data-url="scenic-add.html"><i class="iconfont">&#xe656;</i></button>
							</div>
							<div class="layui-inline">
								<!--required lay-verify="required"-->
								<input type="text" name="title" placeholder="请输入景点" autocomplete="off"
									   class="layui-input">
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
						<%--<table class="layui-table" lay-even lay-skin="nob">
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
                                    <td><input type="checkbox" name="checkbox" lay-skin="primary"
                                               data-id="${scenic.scenicId}"></td>
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
													data-id="${scenic.scenicId}"
													data-url="${path}/scenic/toScenicDetail/${scenic.scenicId}"><i
                                                    class="layui-icon">&#xe642;</i></button>
                                            <button class="layui-btn layui-btn-small layui-btn-danger del-btn"
													data-id="${scenic.scenicId}"
													data-url="${path}/scenic/deleteByPrimaryKey"><i
                                                    class="layui-icon">&#xe640;</i></button>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
							</tbody>
						</table>--%>
						<table class="layui-table" id="table" lay-filter="test" lay-data="{id:'list'}"></table>
						<%--<div class="page-wrap">
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
						</div>--%>
					</div>
				</div>
		</div>
		<script src="${path}/static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
		<script src="${path}/static/admin/js/common.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="${path}/js/jquery.min.js"></script>
	</body>

    <script type="text/javascript">

		layui.use('table', function () {
			var table = layui.table;

			table.on('checkbox(test)', function (obj) {
				var checkStatus = table.checkStatus('list');
				console.log(checkStatus.data);
				var os = checkStatus.data;
				$(os).each(function (i) {
					console.log(os[i].scenicId);
				})
			})


			table.render({
				elem: '#table'
				, height: 486
				, url: '${path}/scenic/doList' //数据接口
				, page: true /*{limit:5}*/ //开启分页
				, id: 'list'
				, cols: [[ //表头
					{}
					,{checkbox: true, fixed: true, name: "checkbox", templet: "#id"}
					, {field: 'scenicId', title: 'ID', width: 50, fixed: 'left', id: "id"}
					, {field: 'scenicName', title: '景区名称', width: 80}
					, {field: 'scenicIntro', title: '景区简介', width: 80}
					, {field: 'scenicAddress', title: '地址', width: 80}
					, {field: 'scenicLink', title: '联系人', width: 80}
					, {field: 'scenicTel', title: '联系人电话', width: 80}
					, {field: 'scenicCharge', title: '票价/元', width: 80}
					, {field: 'openTime', title: '开发时间', width: 80}
					, {field: 'endTime', title: '结束时间', width: 80}
					, {field: 'checkType', title: '审核状态', width: 80, templet: "#checkType"}
					, {
						field: 'createTime',
						title: '创建时间',
						width: 135,
						templet: "<div>{{layui.util.toDateString(d.ordertime, 'yyyy-MM-dd')}}</div>"
					}
					, {
						field: 'updateTime',
						title: '修改时间',
						width: 135,
						templet: "<div>{{layui.util.toDateString(d.ordertime, 'yyyy-MM-dd')}}</div>"
					}
					, {field: 'typeOne', title: '分类一', width: 80}
					, {field: 'typeTwo', title: '分类二', width: 80}
					, {field: 'scenicStatus', title: '状态', width: 80}
					, {fixed: 'right', width: 130, title: '操作', align: 'center', toolbar: '#caozuo'}
				]]
			});


		});
    </script>
	<script type="text/html" id="checkType">
		{{#   if(d.checkType == 0){ }}
		以审核
		{{#  } else if(d.checkType == 1) { }}
		未审核
		{{# } }}
	</script>

	<script type="text/html" id="caozuo">
		<a class="layui-btn layui-btn-xs" lay-event="edit"
		   href="${pageContext.request.contextPath}/scenic/toUpdate/{{d.scenicId}}">编辑</a>
		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"
		   href="${pageContext.request.contextPath}/scenic/deleteByPrimaryKey/{{d.scenicId}}">删除</a>

		<!-- 这里同样支持 laytpl 语法，如： -->
		{{#  if(d.auth > 2){ }}
		<a class="layui-btn layui-btn-xs" lay-event="check">审核</a>
		{{#  } }}

	</script>


</html>