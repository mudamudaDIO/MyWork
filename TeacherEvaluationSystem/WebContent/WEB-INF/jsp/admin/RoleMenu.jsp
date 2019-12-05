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
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/js/jquery-3.1.1.min.js"></script>

<script>
	$(function(){
		$('#select').change(function(){
			var num=$(this).val()
			console.log(num)
				$(".layui-card-body").hide()
				$(".u"+num).show();
			
		});
	});
</script>

</head>
<body>
        <div class="x-nav">
          <span class="layui-breadcrumb">
            <a href="">首页</a>
            <a href="">角色管理</a>
            <a>
              <cite>角色菜单</cite></a>
          </span>
          <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
            <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
        </div>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-header">
                            <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
                            <button class="layui-btn" onclick="xadmin.open('添加菜单','addRolesMenu',600,400)"><i class="layui-icon"></i>添加</button>
                            <button class="layui-btn" style="">
                            	<select name="" id="select" style="border: 0; background: #009688;color: white;">
	                            	<option value="3" id="manager">管理员</option>
									<option value="1" id="teacher">教师</option>
									<option value="2" id="student">学生</option>
	                            </select>
                            </button>
                        </div>
                        <!-- 管理员 -->
                        <div class="layui-card-body layui-table-body layui-table-main u3" id="3">
                            <table class="layui-table layui-form">
                                <thead>
                                  <tr>
                                    <th>
                                      <input type="checkbox" lay-filter="checkall" name="" lay-skin="primary">
                                    </th>
                                    <th>ID</th>
                                    <th>角色名</th>              
                                    <th>菜单名</th>
                                    <th>操作</th>
                                  </tr>
                                </thead>
                                <tbody>
                     				<c:forEach items="${AdminPer}" var="admin">
                     					<tr>
                     						<td> <input type="checkbox" value="${admin.id}" lay-filter="check" name="" lay-skin="primary"></td>
                     						<td>${admin.id}</td>
	                     					<td>${admin.role.role_name}</td>
	                     					<td>${admin.per.permission_name}</td>                    					
	                     					<td class="td-manage">
		                                     
		                                      <a title="删除" onclick="member_del(this,'${admin.id}')" href="javascript:;">
		                                        <i class="layui-icon">&#xe640;</i>
		                                      </a>
	                                    	</td>
                                    	</tr>
                     				</c:forEach>	                                                                                     
                                </tbody>
                            </table>
                        </div>
                      	<!-- 教师 -->
                      	<div class="layui-card-body layui-table-body layui-table-main u1" id="1" style="display: none;">
                            <table class="layui-table layui-form">
                                <thead>
                                  <tr>
                                    <th>
                                      <input type="checkbox" lay-filter="checkall" name="" lay-skin="primary">
                                    </th>
                                    <th>ID</th>
                                    <th>角色名</th>              
                                    <th>菜单名</th>
                                    <th>操作</th>
                                  </tr>
                                </thead>
                                <tbody>
                     				<c:forEach items="${TeacherPer}" var="teacher">
                     					<tr>
                     						<td> <input type="checkbox" value="${teacher.id}" lay-filter="check" name="" lay-skin="primary"></td>
                     						<td>${teacher.id}</td>
	                     					<td>${teacher.role.role_name }</td>
	                     					<td>${teacher.per.permission_name}</td>                    					
	                     					<td class="td-manage">
		                                      
		                                      <a title="删除" onclick="member_del(this,'${teacher.id}')" href="javascript:;">
		                                        <i class="layui-icon">&#xe640;</i>
		                                      </a>
	                                    	</td>
                                    	</tr>
                     				</c:forEach>	                                                                                     
                                </tbody>
                            </table>
                        </div>
                        
                        <!-- 学生 -->
                        <div class="layui-card-body layui-table-body layui-table-main u2" id="2" style="display: none;">
                            <table class="layui-table layui-form">
                                <thead>
                                  <tr>
                                    <th>
                                      <input type="checkbox" lay-filter="checkall" name="" lay-skin="primary">
                                    </th>
                                    <th>ID</th>
                                    <th>角色名</th>              
                                    <th>菜单名</th>
                                    <th>操作</th>
                                  </tr>
                                </thead>
                                <tbody>
                     				<c:forEach items="${StudentPer}" var="student">
                     					<tr>
                     						<td> <input type="checkbox" value="${student.id}" lay-filter="check" name="" lay-skin="primary"></td>
                     						<td>${student.id}</td>
	                     					<td>${student.role.role_name}</td>
	                     					<td>${student.per.permission_name}</td>                    					
	                     					<td class="td-manage">
		                                  
		                                      <a title="删除" onclick="member_del(this,'${student.id}')" href="javascript:;">
		                                        <i class="layui-icon">&#xe640;</i>
		                                      </a>
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

      

      /*用户-删除*/
      function member_del(obj,id){
    	  layer.confirm('确认要删除吗？',function(index){
              //发异步删除数据
             parm={id:id}
         	 url= "${pageContext.request.contextPath}/admin/delRoleMenu";
         	 $.post(url,parm,function(data){
         		 if(data.flag==1){
         			$(obj).parents("tr").remove();
	         		layer.msg('删除成功', {icon: 1,time:500});
         		 }else{
         			layer.msg('删除失败', {icon: 5,time:500});
         		 }
         	 });            
          });
      }



      //批量删除
      function delAll (argument) {
    	  var ids = [];
          // 获取选中的id 
          $('tbody input').each(function(index, el) {
              if($(this).prop('checked')){
                 ids.push($(this).val())
              }
          });
          layer.confirm('确认要删除吗？'+ids.toString(),function(index){
              //捉到所有被选中的，发异步进行删除
               $.ajax({
              	url:"${pageContext.request.contextPath}/admin/delMoreRolemenu",
   			    data:{ids:ids},
   			    type:"Post",
   			    dataType: "json",
   			  	traditional:true,
   			    beforeSend:function () {//ajax处理之前出现spin图标
   			    	loading = layer.load(1, {//等待
   	                    shade: [0.1, '#fff'] //0.1透明度的白色背景
   	                });
                   },
   			    success: function (data) {
   			      	if(data.flag==1){
   			      		layer.msg('删除成功', {icon: 1});
   		                $(".layui-form-checked").not('.header').parents('tr').remove();	
   		             	layer.closeAll('loading');
   			      	}else{
   			      		layer.msg('删除失败!',{icon:5,time:1000});
   			      		layer.closeAll('loading');
   			      	}
   			     }
               })      
          });
        }
    </script>
</html>