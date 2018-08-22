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
<title>长沙时间轴显示</title>
<link rel="stylesheet" type="text/css"
	href="/AdminTianditu/static/showChangsha/css/history.css">
	<script type="text/javascript"
		src="/AdminTianditu/static/showChangsha/js/jquery.js"></script>
	<script type="text/javascript"
		src="/AdminTianditu/static/showChangsha/js/jquery.mousewheel.js"></script>
	<script type="text/javascript"
		src="/AdminTianditu/static/showChangsha/js/jquery.easing.js"></script>
	<script type="text/javascript"
		src="/AdminTianditu/static/showChangsha/js/history.js"></script>
		<link rel="stylesheet"
	href="/AdminTianditu/static/bootstrap/css/bootstrap.min.css" />

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/AdminTianditu/static/bootstrap/js/bootstrap.min.js"></script>
		
</head>
<body>
	<%@ include file="/common_head.jsp"%>
	<!-- <iframe src="show.jsp" width="1400px" height="100px" aligh="center">
	</iframe> -->
	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/db_tianditu?useUnicode=true&characterEncoding=utf-8"
		user="root" password="123456" />
	<sql:query dataSource="${snapshot}" var="result">
SELECT place,title,extra,DATE_FORMAT(update_time,' %m月 %d日') update_time ,year(update_time) nian, month(update_time) yue ,day(update_time) ri
from tianditu where place='常德市' order by update_time desc;
</sql:query>
	
<ol class="breadcrumb">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		当前位置：<li><a href="#">首页</a></li>
		<li><a href="#">常德更新记录列表</a></li>
	</ol>

	<div id="arrow">
		<ul>
			<li class="arrowup"></li>
			<li class="arrowdown"></li>
		</ul>
	</div>

	<div id="history">
		
		<div class="right">
			<div class="title">
				<h2>网站成长史</h2>
				<div id="circle">
					<div class="cmsk"></div>
					<div class="circlecontent">
						<div thisyear="2018" class="timeblock">
							<span class="numf"></span> <span class="nums"></span> <span
								class="numt"></span> <span class="numfo"></span>
							<div class="clear"></div>
						</div>
						<div class="timeyear">YEAR</div>
					</div>
					<a href="#" class="clock"></a>
				</div>
			</div>

			<div id="content">
				<ul class="list">
					<c:forEach var="row" items="${result.rows}">
						<li>
							<div class="liwrap">
								<div class="lileft">
									<div class="date">
										<span class="year">${row.nian}</span> <span class="md">${row.update_time}</span>
									</div>
								</div>

								<div class="point">
									<b></b>
								</div>

								<div class="liright">
									<div class="histt">
										<a href="#">${row.title}</a>
									</div>
									<div class="hisct">${row.extra}</div>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>

			</div>
		</div>
	</div>
	<div style="clear: both; height: 320px;"></div>

		<%@ include file="/common_footer.jsp"%>
</body>
</html>