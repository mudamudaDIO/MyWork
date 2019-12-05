<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师个人信息</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/js/jquery-3.1.1.min.js"></script>
<link type="text/css" rel="styleSheet"  href="${pageContext.request.contextPath}/scripts/css/Tperson.css" />
</head>
<body>
<div class="main">
<div class="top">教师信息</div>
<table>
<c:forEach items="${teachermsg}" var="msg">
<tr>
<th>教师姓名:</th>
<td colspan="2">${msg.teacher_name}</td>
</tr>
<tr>
<th>所在学院:</th>
<td colspan="2">${msg.ins.ins_name}</td>
</tr>
<tr>
<th>所教科目:</th>
<td colspan="2">${msg.subject.subject_name}</td>
</tr>
<tr>
</c:forEach>
</table>
</div>
</body>
</html>