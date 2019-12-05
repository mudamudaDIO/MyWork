<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ssm.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生修改密码</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
//实现AJAX异步提交
function change(){
	var NP = $("#newpass").val();
	var RP = $("#respass").val();
	if(RP!=NP){
		alert("重复密码应保持一致！！")
	}else{
		var url ="${pageContext.request.contextPath}/student/changePassSubmit";
		var oldpassword = $("#oldpass").val();
		var newpass = $("#newpass").val();
		if(oldpassword==""||newpass==""){
			alert("密码不能为空！！")
		}else{
			var id=$("#id").val();
			var param = {oldpassword:oldpassword,newpass:newpass,id:id};
			$.post(url,param,function(data){
				alert(data.content);
				if(data.flag==1){
					location.reload();
				}
			});
		}
	}
}
</script>
<link type="text/css" rel="styleSheet"  href="${pageContext.request.contextPath}/scripts/css/changepass.css" />
</head>
<body>
<% User u=(User)session.getAttribute("user"); %>
<div class="main">
<div class="top"></div>
<div class="main_1">
<label>请输入原密码:</label><input type="text" id="oldpass"/><br>
<label>请输入新密码:</label><input type="text" id="newpass"/><br>
<label>请重复新密码:</label><input type="text" id="respass"/><br>
<input type="hidden" value="<%=u.getUserId()%>" id="id">
<input class="button" type="button" value="确认修改" onclick="change()"/>
</div>
</div>
</body>
</html>