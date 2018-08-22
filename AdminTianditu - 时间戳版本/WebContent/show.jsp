<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>常德更新事件列表</title>

<link href="/AdminTianditu/static/show/css/timeline.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="/AdminTianditu/static/show/js/modernizr.js"></script>
<script type="text/javascript" src="/AdminTianditu/static/show/js/jquery-1.8.3.min.js"></script>

</head>
<body>
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/db_tianditu?useUnicode=true&characterEncoding=utf-8"
     user="root"  password="123456"/>
<sql:query dataSource="${snapshot}" var="result">
SELECT title,extra,DATE_FORMAT(update_time,'%Y年 %m月 %d日')  update_time
from tianditu where place='常德' order by update_time;
</sql:query>
	<header>
		<h1>常德更新事件列表</h1>
	</header>
<section id="cd-timeline" class="cd-container">
<c:forEach var="row" items="${result.rows}">
   <div class="cd-timeline-block">
			<div class="cd-timeline-img cd-picture">
				<img src="/AdminTianditu/static/show/images/cd-icon-picture.svg" alt="Picture">
			</div>
			<div class="cd-timeline-content">
				<h2><c:out value="${row.title}"/></h2>
				<p><c:out value="${row.extra}"/></p>
				<a href="http://www.sucaijiayuan.com" class="cd-read-more">查看更多</a>
				<!-- <span class="cd-date">Jan 14</span> -->
				<span class="cd-date"><%-- <fmt:formatDate value='${row.timestamp}' pattern='yyyy-MM-dd'/> --%>
				<c:out value="${row.update_time}"/>
				</span>
			</div> 
		</div>
</c:forEach>
</section> 

<!-- <section id="cd-timeline" class="cd-container">
	     1 
		<div class="cd-timeline-block">
			<div class="cd-timeline-img cd-picture">
				<img src="/AdminTianditu/static/show/images/cd-icon-picture.svg" alt="Picture">
			</div>

			<div class="cd-timeline-content">
				<h2>17素材网 1</h2>
				<p>17素材网专注于提供免费素材下载,其内容涵盖设计素材,PSD素材,矢量素材,图片素材,图标素材,设计字体等免费素材.下载免费素材尽在17素材网免费素材网</p>
				<a href="http://www.sucaijiayuan.com" class="cd-read-more">阅读更多</a>
				<span class="cd-date">Jan 14</span>
			</div> 
		</div>

   		 2 
		<div class="cd-timeline-block">
			<div class="cd-timeline-img cd-movie">
				<img src="images/cd-icon-movie.svg" alt="Movie">
			</div> 

			<div class="cd-timeline-content">
				<h2>17素材网 2</h2>
				<p>17素材网专注于提供免费素材下载,其内容涵盖设计素材,PSD素材,矢量素材,图片素材,图标素材,设计字体等免费素材.下载免费素材尽在17素材网免费素材网</p>
				<a href="http://www.sucaijiayuan.com" class="cd-read-more">阅读更多</a>
				<span class="cd-date">Jan 18</span>
			</div> 
		</div> 

 		 3 	
		<div class="cd-timeline-block">
			<div class="cd-timeline-img cd-picture">
				<img src="images/cd-icon-picture.svg" alt="Picture">
			</div> 

			<div class="cd-timeline-content">
				<h2>17素材网 3</h2>
				<p>17素材网专注于提供免费素材下载,其内容涵盖设计素材,PSD素材,矢量素材,图片素材,图标素材,设计字体等免费素材.下载免费素材尽在17素材网免费素材网</p>
				<a href="http://www.sucaijiayuan.com" class="cd-read-more">阅读更多</a>
				<span class="cd-date">Jan 24</span>
			</div> 
		</div> 

		<div class="cd-timeline-block">
			<div class="cd-timeline-img cd-location">
				<img src="/AdminTianditu/static/show/images/cd-icon-location.svg" alt="Location">
			</div> 

			<div class="cd-timeline-content">
				<h2>17素材网 4</h2>
				<p>17素材网专注于提供免费素材下载,其内容涵盖设计素材,PSD素材,矢量素材,图片素材,图标素材,设计字体等免费素材.下载免费素材尽在17素材网免费素材网</p>
				<a href="http://www.sucaijiayuan.com" class="cd-read-more">阅读更多</a>
				<span class="cd-date">Feb 14</span>
			</div> 
		</div> 

		
		
	</section>  -->
				 
<script>
<!-- $(function(){
	var $timeline_block = $('.cd-timeline-block');
	//hide timeline blocks which are outside the viewport
	$timeline_block.each(function(){
		if($(this).offset().top > $(window).scrollTop()+$(window).height()*0.75) {
			$(this).find('.cd-timeline-img, .cd-timeline-content').addClass('is-hidden');
		}
	});
	//on scolling, show/animate timeline blocks when enter the viewport
	$(window).on('scroll', function(){
		$timeline_block.each(function(){
			if( $(this).offset().top <= $(window).scrollTop()+$(window).height()*0.75 && $(this).find('.cd-timeline-img').hasClass('is-hidden') ) {
				$(this).find('.cd-timeline-img, .cd-timeline-content').removeClass('is-hidden').addClass('bounce-in');
			}
		});
	});
});
</script> 

</body>
</html>
