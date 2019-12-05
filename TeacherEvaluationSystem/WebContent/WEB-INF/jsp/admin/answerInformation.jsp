<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/js/jquery-3.1.1.min.js" ></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/js/xadmin.js"></script>
       <style type="text/css">
       .score{
       float:right;
       text-align:left;
       color: red;
       }
       </style>
       </head>
    <body>
        <div class="x-nav">
          <span class="layui-breadcrumb">
            <a href="">首页</a>
            <a href="">查看评价</a>
            <a>
              <cite>查看评价详情</cite></a>
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
                            <div style="color: red;text-align: left;float: right;">你的平均分数：${answer.score}</div>
                          	 <c:forEach items="${getqu}" var="qu">
                            	 <thead>
                                  <tr>
                                	 <th style="text-align: left; font-size: 14px;font-weight: 900;"> ${qu.question_id} ${qu.question}</th>
                                  </tr>                                 
                                </thead>
                                <tbody>
                                  <tr>
                                    <td style="justify-content: center;text-align: left;">
                                    <c:if test="${qu.answer=='A'}">                              
                                      ${qu.answer_A}<input type="radio" name="id${qu.question_id}" value="A" lay-skin="primary" checked="checked" disabled="disabled">
                                      ${qu.answer_B}<input type="radio" name="id${qu.question_id}" value="B" lay-skin="primary" disabled="disabled">
                                      ${qu.answer_C}<input type="radio" name="id${qu.question_id}" value="C" lay-skin="primary" disabled="disabled">
                                      ${qu.answer_D}<input type="radio" name="id${qu.question_id}" value="D" lay-skin="primary" disabled="disabled">
                                     <label class="score">得分：10分</label>
                                     </c:if>
                                     <c:if test="${qu.answer=='B'}">                              
                                      ${qu.answer_A}<input type="radio" name="id${qu.question_id}" value="A" lay-skin="primary" disabled="disabled" >
                                      ${qu.answer_B}<input type="radio" name="id${qu.question_id}" value="B" lay-skin="primary" checked="checked" disabled="disabled">
                                      ${qu.answer_C}<input type="radio" name="id${qu.question_id}" value="C" lay-skin="primary" disabled="disabled">
                                      ${qu.answer_D}<input type="radio" name="id${qu.question_id}" value="D" lay-skin="primary" disabled="disabled">
                                     <label class="score">得分：8分</label>
                                     </c:if>
                                     <c:if test="${qu.answer=='C'}">                              
                                      ${qu.answer_A}<input type="radio" name="id${qu.question_id}" value="A" lay-skin="primary" disabled="disabled">
                                      ${qu.answer_B}<input type="radio" name="id${qu.question_id}" value="B" lay-skin="primary" disabled="disabled">
                                      ${qu.answer_C}<input type="radio" name="id${qu.question_id}" value="C" lay-skin="primary" checked="checked" disabled="disabled">
                                      ${qu.answer_D}<input type="radio" name="id${qu.question_id}" value="D" lay-skin="primary" disabled="disabled">
                                     <label class="score">得分：6分</label>
                                     </c:if>
                                     <c:if test="${qu.answer=='D'}">                              
                                      ${qu.answer_A}<input type="radio" name="id${qu.question_id}" value="A" lay-skin="primary"  disabled="disabled">
                                      ${qu.answer_B}<input type="radio" name="id${qu.question_id}" value="B" lay-skin="primary" disabled="disabled">
                                      ${qu.answer_C}<input type="radio" name="id${qu.question_id}" value="C" lay-skin="primary" disabled="disabled">
                                      ${qu.answer_D}<input type="radio" name="id${qu.question_id}" value="D" lay-skin="primary" checked="checked" disabled="disabled">
                                    <label class="score">得分：3分</label>
                                     </c:if>
                                    </td>
                                  </tr>
                                </tbody>
                            </c:forEach>
                                                           
                                <thead>
                                  <tr>
                                    <th style="text-align: left;font-size: 14px;font-weight: 900;">ta对ta的意见或者建议</th>
                                </thead>
                                <tbody>
                                  <tr>
                                    <td style="justify-content: center;text-align: left;">
                                      <textarea name="text" id="text" rows="10" cols="80" disabled="disabled">
                                      	${answer.beizu}
                                      </textarea>
                                    </td>
                                  </tr>
                                </tbody>
                            </table>
                            </form>         
                        </div>
                    </div>
                </div>
            </div>
        </div> 
    </body>
    <script>
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

      
      function delAll (argument) {
        var ids = [];

        // 获取选中的id 
        $('tbody input').each(function(index, el) {
            if($(this).prop('checked')){
               ids.push($(this).val())
            }
        });
      }
    </script>
</html>