<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="x-admin-sm">
<head>
<meta charset="UTF-8">
<title>教师综合评价系统</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/scripts/css/font.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/scripts/css/xadmin.css">
<script src="${pageContext.request.contextPath}/scripts/lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/js/xadmin.js"></script>
<script>
            // 是否开启刷新记忆tab功能
            // var is_remember = false;
        </script>
</head>
<body>
        <div class="x-nav">
          <span class="layui-breadcrumb">
            <a href="">首页</a>
            <a href="">评价管理</a>
            <a>
              <cite>教师评价</cite></a>
          </span>
          <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
            <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
        </div>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">                         
                        <div class="layui-card-body layui-table-body layui-table-main">
                            <table class="layui-table layui-form">
                                <thead>
                                  <tr>
                                    <th>姓名</th>
                                    <th>所在学院</th>
                                    <th>所教科目</th>              
                                    <th>评价</th>
                                  </tr>
                                </thead>
                                <tbody>
                     				<c:forEach items="${teachers}" var="t">                     					
		                     					<tr>
		                     						<td>${t.teacher_name}</td>
		                     						<td>${t.ins.ins_name}</td>
			                     					<td>${t.subject.subject_name}</td>
			                     					<td>
			                     						<c:if test="${t.isvote==false}">
			                     							<button  class="layui-btn" lay-filter="add" lay-submit="" onclick="pinjia(${t.teacher_id})">开始评价</button>
			                     						</c:if>
			                     						<c:if test="${t.isvote==true}">
			                     							<button  class="layui-btn" lay-filter="add" lay-submit="" >已&nbsp;&nbsp;评&nbsp;&nbsp;价</button>
			                     						</c:if>
			                     					</td>	           
		                                    	</tr>
		                                   
                     				</c:forEach>	                                                                                     
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
    </body>
    <script>
      function pinjia(id){
    	  url="${pageContext.request.contextPath}/student/question";
    	  window.location.href=url+"?id="+id;
      }
    
      layui.use(['laydate','form'], function(){
        var laydate = layui.laydate;
        var  form = layui.form;


        // 监听全选
        form.on('checkbox(checkall)', function(data){

          if(data.elem.checked){
            $('tbody input').prop('checked',true);
          }else{
            $('tbody input').prop('checked',false);
          }
          form.render('checkbox');
        }); 
        
        //执行一个laydate实例
        laydate.render({
          elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#end' //指定元素
        });
      });
    </script>
</html>