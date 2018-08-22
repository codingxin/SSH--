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


	<!--å¯¼èª-->
	<div class="top_nav_box" height="200px">
		<div class="container">
			<div class="clearfix">
				<div class="logo left">
					<a href="javascript:;"> <img
						src="/AdminTianditu/static/showCommon/images/logo.png" alt="">
					</a>
				</div>
				<ul class="nav_list left clearfix" >
					<li class="item active"><a href="#" class="nav_name">首页</a></li>
					<li class="item"><a
						href="http://cd.dzmap.cn/portal/map/index.html" class="nav_name">在线地图</a>
					</li>
					<li class="item"><a
						href="http://cd.dzmap.cn/portal/news/index.html" class="nav_name">新闻公告</a>
					</li>
					<li class="item"><a
						href="http://cd.dzmap.cn/portal/api/index.html" class="nav_name">地图API</a>
					</li>
					<li class="item"><a
						href="http://cd.dzmap.cn/portal/services/index.html"
						class="nav_name">综合服务</a></li>
					<li class="item"><a
						href="http://cd.dzmap.cn/portal/diy/index.html" class="nav_name">轻松绘</a>
					</li>
					<li class="item"><a
						href="http://cd.dzmap.cn/portal/city/index.html" class="nav_name">市县直通</a>
					</li>
					<li class="item"><a href="#" class="nav_name">常德数据</a></li>
					<li class="item"><a href="#" class="nav_name">联系我们</a></li>
				</ul>
			</div>

		</div>

	</div>

</body>


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