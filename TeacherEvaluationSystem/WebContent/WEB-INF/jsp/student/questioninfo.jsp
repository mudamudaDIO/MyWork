<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ssm.entity.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="x-admin-sm">
    
    <head>
        <meta charset="UTF-8">
        <title>添加学生</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/scripts/css/font.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/scripts/css/xadmin.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/js/jquery.min.js" ></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/js/xadmin.js"></script>
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
                        <form action="" id="form">
                            <table class="layui-table layui-form">
                            <c:forEach items="${questions}" var="question">
                            	 <thead>
                                  <tr>
                                    <th style="text-align: left;">${question.question}</th>
                                  </tr>                                 
                                </thead>
                                <tbody>
                                  <tr>
                                    <td style="justify-content: center;text-align: left;">
                                      <input type="radio" name="id${question.question_id}" value="A" lay-skin="primary"><span class="answer">${question.answer_A}</span>
                                      <input type="radio" name="id${question.question_id}" value="B" lay-skin="primary"><span class="answer">${question.answer_B}</span>
                                      <input type="radio" name="id${question.question_id}" value="C" lay-skin="primary"><span class="answer">${question.answer_C}</span>
                                      <input type="radio" name="id${question.question_id}" value="D" lay-skin="primary"><span class="answer">${question.answer_D}</span>
                                    </td>
                                  </tr>
                                </tbody>
                            </c:forEach>
                                                                       
                                <thead>
                                  <tr>
                                    <th style="text-align: left;">你还有什么意见或者建议</th>
                                </thead>
                                <tbody>
                                  <tr>
                                    <td style="justify-content: center;text-align: left;">
                                      <textarea name="text" rows="10" cols="80"></textarea>
                                    </td>
                                  </tr>
                                </tbody>
                            </table>
                            <% User u=(User)session.getAttribute("user"); %>
                            <input type="hidden" value="${teacherid}" name="teacherid">
                            <input type="hidden" value="<%=u.getUserId() %>" name="studentid">
                           </form>
                           <button class="layui-btn" onclick="submit()" style="margin-left: 12%;">已完成，提交</button>                    
                        </div>
                    </div>
                </div>
            </div>
        </div> 
    </body>
    <script>
    	function submit(){
    		var url="${pageContext.request.contextPath}/student/voteTeacher";
    		var parm= $("#form").serialize();
    		$.post(url,parm,function(data){
    			if(data.flag==1){
    				layer.msg('评价成功', {icon: 1},function(){
    					xadmin.father_reload();//刷新父窗口
    				});
    			}else{
    				layer.msg('评价失败', {icon: 1})
    			}
    		})
    	}
      layui.use(['laydate','form'], function(){
        var laydate = layui.laydate;
        var  form = layui.form;


        
        //执行一个laydate实例
        laydate.render({
          elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#end' //指定元素
        });
      })
    </script>
</html>