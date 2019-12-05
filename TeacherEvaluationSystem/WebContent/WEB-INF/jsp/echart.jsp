<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>柱状图</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/scripts/css/style.css" media="screen" type="text/css" />
</head>
<body>
	<h1>柱状图</h1>
	<c:forEach items="${echart}" var="echart">
	<div class="skillbar clearfix " data-percent="${echart.score}%"> <!-- 进度条的显示位置 按百分比算 和分数对应-->
		<div class="skillbar-title" style="background: #d35400;">
			<span>${echart.teacher.teacher_name}</span>
		</div>
		<div class="skillbar-bar" style="background: #e67e22;"></div>
		<div class="skill-bar-percent">${echart.score}</div> <!-- 评价分数显示 成绩 -->
	</div>
	</c:forEach>
	<!-- End Skill Bar -->
	<div style="text-align: center; clear: both;"></div>
	<script src='${pageContext.request.contextPath}/scripts/js/jquery.js'></script>
	<script src="${pageContext.request.contextPath}/scripts/js/echart.js"></script>

	<script type="text/javascript">
		setTimeout(function() {
			window.location.reload();//刷新当前页面 10s刷新一次.
		}, 100000)
	</script>
</body>
</html>