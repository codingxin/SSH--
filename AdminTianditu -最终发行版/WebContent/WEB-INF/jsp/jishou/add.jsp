<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>无线巡更管理中心</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<base href="<%=basePath%>">

<!-- jQuery 3.1.1 -->
<script src="//cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- Font Awesome -->
<link rel="stylesheet"
	href="//cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css">
<!-- Select2 -->
<link rel="stylesheet"
	href="//cdn.bootcss.com/select2/4.0.3/css/select2.min.css">
<script src="//cdn.bootcss.com/select2/4.0.3/js/select2.min.js"></script>
<!-- bootstrap datepicker -->
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.min.css">
<script
	src="//cdn.bootcss.com/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.min.js"></script>
<script
	src="//cdn.bootcss.com/bootstrap-datepicker/1.6.4/locales/bootstrap-datepicker.zh-CN.min.js"></script>
<!-- Slimscroll -->
<script
	src="//cdn.bootcss.com/jQuery-slimScroll/1.3.8/jquery.slimscroll.min.js"></script>
<!-- Theme style -->
<link rel="stylesheet" href="static/dist/css/AdminLTE.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="static/dist/css/skins/_all-skins.min.css">

<style>
body, button, input, select, textarea, h1, h2, h3, h4, h5, h6 {
	font-family: Microsoft YaHei, "宋体", Tahoma, Helvetica, Arial,
		"\5b8b\4f53", sans-serif;
}

.content-header>.breadcrumb {
	position: relative;
	margin-top: 5px;
	top: 0;
	right: 0;
	float: none;
	background: #d2d6de;
	padding-left: 10px;
}

.content-header>.breadcrumb li:before {
	color: #97a0b3;
}
</style>
</head>
<body>

	<!-- Content Header (Page header) -->
	<section class="content-header">
	<ol class="breadcrumb">
		<li><a href="/AdminTianditu/main/showInfo"><i
				class="fa fa-dashboard"></i> 首页</a></li>
		<li>更新日志管理</li>
		<li class="active">添加日志</li>
	</ol>
	</section>

	<!-- Main content -->
	<section class="content"> <!-- Small boxes (Stat box) -->
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<!-- Horizontal Form -->
			<div class="box box-info">
				<div class="box-header with-border">
					<h3 class="box-title">添加日志</h3>
				</div>
				<!-- /.box-header -->
				<!-- form start -->
				<!--  action="/AdminTianditu/jishou/insert" -->
				<form id="member_add_form" class="form-horizontal" method="post">
					<div class="box-body">
						<div class="form-group">
							<label class="col-sm-2 control-label">更新地点</label>
							<div class="col-sm-10">
								<div class="row">
									<div class="col-sm-6">
										<!--  class="form-control hour" id="start_hour" -->
										<select name="place" class="form-control select2"
											id="update_place" style="width: 100%">
											<option>吉首市</option>
											<option>常德市</option>
											<option>永州市</option>
											<option>株洲市</option>
											<option>岳阳市</option>
											<option>长沙市</option>
											<option>怀化市</option>
											<option>衡阳市</option>
											
											<option>郴州市</option>
								            <option>张家界市</option>
											<option>邵阳市</option>
											<option>益阳市</option>
											
											
											<option>湘潭市</option>
											<option>娄底市</option>
											
										</select>
									</div>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="update_title" class="col-sm-2 control-label">更新标题</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="update_title"
									name="title" maxlength="10" placeholder="请输入更新标题" required>
							</div>
						</div>
						<div class="form-group">
							<label for="update_extra" class="col-sm-2 control-label">更新内容</label>
							<div class="col-sm-10">
								<textarea class="form-control" rows="3" id="update_extra"
									name="extra" placeholder="请输入更新的日志内容"></textarea>
							</div>
						</div>
						<div class="form-group">
							<label for="patrol_date" class="col-sm-2 control-label">日期</label>
							<div class="col-sm-10">
								<input type="date" class="form-control pull-right"
									name="updatetime" id="patrol_date"
									placeholder="请输入xxxx-xx-xx格式日期">
							</div>
						</div>

					</div>
					<!-- /.box-body -->
					<div class="box-footer">
						<button type="reset" class="btn btn-default">重置</button>
						<!--  -->
						<button id="member_add_button" type="submit"
							class="btn btn-info pull-right" data-loading-text="添加中...">添加</button>
					</div>
					<!-- /.box-footer -->
				</form>
			</div>
			<!-- /.box -->
		</div>
	</div>
	</section>
	<!-- /.content -->
	<script type="text/javascript">
		$(function() {
			var $member_add_form = $("#member_add_form");
			$member_add_form
					.submit(function() {
						var $add_btn = $("#member_add_button");
						var md = $("#member_add_form").serialize();
						alert($("#member_add_form").serialize());
						$
								.ajax({
									url : "/AdminTianditu/jishou/insert",
									type : "POST",
									dataType : "json",
									data : md,
									//contentType: "application/json; charset=utf-8",
									beforeSend : function() {
										$add_btn.button("loading");
									},
									complete : function() {
										$add_btn.button("reset");
									},
									success : function(data) {
										alert(data.msg);
										//更新成功后返回列表
										window.location.href = "/AdminTianditu/jishou/showList";
										if (data.success) {
											$member_add_form[0].reset();
										}
									},
									error : function(XMLHttpRequest, textStatus) {
										if (textStatus === "timeout") {
											alert("添加超时！");
										} else {
											alert("添加失败！");
										}
									}
								});
						return false;
					});
		})
	</script>
</body>
</html>
