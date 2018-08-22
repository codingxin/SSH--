<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>吉首更新事件列表</title>

<link href="/AdminTianditu/static/showChangde/css/timeline.css"
	rel="stylesheet" type="text/css" />

<script type="text/javascript"
	src="/AdminTianditu/static/showChangde/js/modernizr.js"></script>
<script type="text/javascript"
	src="/AdminTianditu/static/showChangde/js/jquery-1.8.3.min.js"></script>

<link rel="stylesheet"
	href="/AdminTianditu/static/bootstrap/css/bootstrap.min.css" />

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/AdminTianditu/static/bootstrap/js/bootstrap.min.js"></script>


</head>
<body>
	<!-- <iframe src="common_head.jsp" width="1400px" height="100px" aligh="center">
	</iframe>  -->
	<%@ include file="/common_head.jsp"%>
	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/db_tianditu?useUnicode=true&characterEncoding=utf-8"
		user="root" password="123456" />
	<sql:query dataSource="${snapshot}" var="result">
SELECT title,extra,DATE_FORMAT(update_time,'%Y年 %m月 %d日')  update_time
from tianditu where place='吉首市' order by update_time desc;
</sql:query>
	<!-- 	<header>
		<h1>常德更新事件列表</h1>
	</header> -->
	<ol class="breadcrumb">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		当前位置：<li><a href="#">首页</a></li>
		<li><a href="#">吉首更新记录列表</a></li>
	</ol>
	<section id="cd-timeline" class="cd-container"> <c:forEach
		var="row" items="${result.rows}">
		<div class="cd-timeline-block">
			<div class="cd-timeline-img cd-picture">
				<img
					src="/AdminTianditu/static/showChangde/images/cd-icon-picture.svg"
					alt="Picture">
			</div>
			<div class="cd-timeline-content">
				<h2 class="colorh2">
					<c:out value="${row.title}" />
				</h2>
				<p>
					<c:out value="${row.extra}" />
				</p>
				<a href="#" class="cd-read-more">查看更多</a>
				<!-- <span class="cd-date">Jan 14</span> -->
				<span class="cd-date"> <%-- <fmt:formatDate value='${row.timestamp}' pattern='yyyy-MM-dd'/> --%>
					<c:out value="${row.update_time}" />
				</span>
			</div>
		</div>
	</c:forEach> </section>
	
	
	
	
	<%@ include file="/common_footer.jsp"%>
	
<!-- <iframe src="common_footer.jsp" marginwidth=0 marginheight=0  width="100%" height="100%" aligh="center" frameborder="0">
	</iframe>   -->
	<script>
		$(function() {
			var $timeline_block = $('.cd-timeline-block');
			//hide timeline blocks which are outside the viewport
			$timeline_block.each(function() {
				if ($(this).offset().top > $(window).scrollTop()
						+ $(window).height() * 0.75) {
					$(this).find('.cd-timeline-img, .cd-timeline-content')
							.addClass('is-hidden');
				}
			});
			//on scolling, show/animate timeline blocks when enter the viewport
			$(window)
					.on(
							'scroll',
							function() {
								$timeline_block
										.each(function() {
											if ($(this).offset().top <= $(
													window).scrollTop()
													+ $(window).height() * 0.75
													&& $(this)
															.find(
																	'.cd-timeline-img')
															.hasClass(
																	'is-hidden')) {
												$(this)
														.find(
																'.cd-timeline-img, .cd-timeline-content')
														.removeClass(
																'is-hidden')
														.addClass('bounce-in');
											}
										});
							});
		});
	</script>

</body>
</html>
