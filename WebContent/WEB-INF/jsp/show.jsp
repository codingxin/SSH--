<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>jQuery+css3响应式时间轴页面效果</title>

<link href="/AdminChangde/static/show/css/timeline.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="/AdminChangde/static/show/js/modernizr.js"></script>
<script type="text/javascript" src="/AdminChangde/static/show/js/jquery-1.8.3.min.js"></script>

</head>
<body>
	<header>
		<h1>响应式垂直时间表</h1>
	</header>

	<section id="cd-timeline" class="cd-container">
		<div class="cd-timeline-block">
			<div class="cd-timeline-img cd-picture">
				<img src="/AdminChangde/static/show/images/cd-icon-picture.svg" alt="Picture">
			</div><!-- cd-timeline-img -->

			<div class="cd-timeline-content">
				<h2>17素材网 1</h2>
				<p>17素材网专注于提供免费素材下载,其内容涵盖设计素材,PSD素材,矢量素材,图片素材,图标素材,设计字体等免费素材.下载免费素材尽在17素材网免费素材网</p>
				<a href="http://www.sucaijiayuan.com" class="cd-read-more">阅读更多</a>
				<span class="cd-date">Jan 14</span>
			</div> <!-- cd-timeline-content -->
		</div> <!-- cd-timeline-block -->

		<div class="cd-timeline-block">
			<div class="cd-timeline-img cd-movie">
				<img src="images/cd-icon-movie.svg" alt="Movie">
			</div> <!-- cd-timeline-img -->

			<div class="cd-timeline-content">
				<h2>17素材网 2</h2>
				<p>17素材网专注于提供免费素材下载,其内容涵盖设计素材,PSD素材,矢量素材,图片素材,图标素材,设计字体等免费素材.下载免费素材尽在17素材网免费素材网</p>
				<a href="http://www.sucaijiayuan.com" class="cd-read-more">阅读更多</a>
				<span class="cd-date">Jan 18</span>
			</div> <!-- cd-timeline-content -->
		</div> <!-- cd-timeline-block -->

		<div class="cd-timeline-block">
			<div class="cd-timeline-img cd-picture">
				<img src="images/cd-icon-picture.svg" alt="Picture">
			</div> <!-- cd-timeline-img -->

			<div class="cd-timeline-content">
				<h2>17素材网 3</h2>
				<p>17素材网专注于提供免费素材下载,其内容涵盖设计素材,PSD素材,矢量素材,图片素材,图标素材,设计字体等免费素材.下载免费素材尽在17素材网免费素材网</p>
				<a href="http://www.sucaijiayuan.com" class="cd-read-more">阅读更多</a>
				<span class="cd-date">Jan 24</span>
			</div> <!-- cd-timeline-content -->
		</div> <!-- cd-timeline-block -->

		<div class="cd-timeline-block">
			<div class="cd-timeline-img cd-location">
				<img src="/AdminChangde/static/show/images/cd-icon-location.svg" alt="Location">
			</div> <!-- cd-timeline-img -->

			<div class="cd-timeline-content">
				<h2>17素材网 4</h2>
				<p>17素材网专注于提供免费素材下载,其内容涵盖设计素材,PSD素材,矢量素材,图片素材,图标素材,设计字体等免费素材.下载免费素材尽在17素材网免费素材网</p>
				<a href="http://www.sucaijiayuan.com" class="cd-read-more">阅读更多</a>
				<span class="cd-date">Feb 14</span>
			</div> <!-- cd-timeline-content -->
		</div> <!-- cd-timeline-block -->

		<div class="cd-timeline-block">
			<div class="cd-timeline-img cd-location">
				<img src="/AdminChangde/static/show/images/cd-icon-location.svg" alt="Location">
			</div> <!-- cd-timeline-img -->

			<div class="cd-timeline-content">
				<h2>17素材网 5</h2>
				<p>17素材网专注于提供免费素材下载,其内容涵盖设计素材,PSD素材,矢量素材,图片素材,图标素材,设计字体等免费素材.下载免费素材尽在17素材网免费素材网</p>
				<a href="http://www.sucaijiayuan.com" class="cd-read-more">阅读更多</a>
				<span class="cd-date">Feb 18</span>
			</div> <!-- cd-timeline-content -->
		</div> <!-- cd-timeline-block -->

		<div class="cd-timeline-block">
			<div class="cd-timeline-img cd-movie">
				<img src="/AdminChangde/static/show/images/cd-icon-movie.svg" alt="Movie">
			</div> <!-- cd-timeline-img -->

			<div class="cd-timeline-content">
				<h2>17素材网 6</h2>
				<p>17素材网专注于提供免费素材下载,其内容涵盖设计素材,PSD素材,矢量素材,图片素材,图标素材,设计字体等免费素材.下载免费素材尽在17素材网免费素材网</p>
                <a href="http://www.sucaijiayuan.com" class="cd-read-more">阅读更多</a>
				<span class="cd-date">Feb 26</span>
			</div> <!-- cd-timeline-content -->
		</div> <!-- cd-timeline-block -->
	</section> <!-- cd-timeline -->
				
<script>
$(function(){
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
