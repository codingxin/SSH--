<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<title>天地图</title>
<link rel="stylesheet"
	href="/AdminTianditu/static/showCommon/font/iconfont.css">
<link rel="stylesheet"
	href="/AdminTianditu/static/showCommon/lib/swiper/css/swiper.min.css">
<link rel="stylesheet"
	href="/AdminTianditu/static/showCommon/css/global.css">
<link rel="stylesheet"
	href="/AdminTianditu/static/showCommon/css/index.css">

</head>
<body>
<!--footer-->	
	<div class="footer" style="height: 200px;width:100%;" color:#00FF00>
		<div class="container">
			<h2 class="footer_top clearfix">
				<dl class="footer_code left">
					<dt>
						<img
							src="http://222.247.40.204:8081/TDTHN/portal/images/erweima.png"
							alt="">
					</dt>

				</dl>
				<dl class=" left">

					<div class="common_footer">主办单位：湖南省国土资源厅</div>
					<div class="common_footer">技术支持：湖南省第三测绘院 & 湖南省国土资源信息中心</div>
					<div class="common_footer">测绘资质号: 甲测资字4300185</div>
					<div class="common_footer">版权所有 © 备案号: 湘ICP备 05000257号</div>
				</dl>
		</div>

		<div class="footer_ban"></div>
	</div>
<body>	
</html>
<script src="js/jquery.js"></script>
<script src="lib/swiper/js/swiper.min.js"></script>
<script src="js/common.js"></script>
<script>
	$(function() {
		//banner
		var swiper = new Swiper('.banner_container', {
			pagination : '.swiper-pagination',
			paginationClickable : '.swiper-pagination',
			nextButton : '.swiper-button-next',
			prevButton : '.swiper-button-prev',
			onlyExternal : false,
			speed : 1000,
			autoplay : 5000,
			loop : true
		});
		_indexFn._hover('.service_list');//æå¡åè¡¨
		_indexFn._hover('.cooperation_list');//åä½æµç¨

		_indexFn._hover('.function_list');//åä½æµç¨

		//å¸¸è§é®é¢
		$('.helps_title').on('click', function() {
			$(this).closest('.helps_item').toggleClass('active');
		});
	});
</script>