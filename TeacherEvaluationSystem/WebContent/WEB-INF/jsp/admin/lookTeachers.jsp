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
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/js/jquery.min.js" ></script>
<script src="${pageContext.request.contextPath}/scripts/lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/js/xadmin.js"></script>
<script>
            // 是否开启刷新记忆tab功能
            // var is_remember = false;
        </script>
        <style type="text/css">
        	.btn{width:70px; color:#fff;background-color:#3598dc; height:28px; line-height:20px!important;cursor:pointer;border:0;margin-left:20px; margin-left:-71px;}
        	.btn:hover{background-color:#63bfff;color:#fff;}
        	.file{filter:alpha(opacity:0);opacity: 0;height:30px; width:70px;float:left;margin-left:-71px;}
        </style>
</head>
<body>
        <div class="x-nav">
          <span class="layui-breadcrumb">
            <a href="">首页</a>
            <a href="">教师管理</a>
            <a>
              <cite>查看教师</cite></a>
          </span>
          <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
            <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
        </div>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                    	<!-- 搜索框 -->
                        <div class="layui-card-body ">
                            <div style="float:left">
                            	<div class="layui-inline layui-show-xs-block">
                                    <input type="text" name="username" id="teacher_text"  placeholder="请输入教师工号" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <button class="layui-btn"   lay-submit="" lay-filter="sreach" onclick="search()"><i class="layui-icon">&#xe615;</i></button>
                                </div>
                            </div>
                                
                          
                            <!-- 从excel导入数据 -->
                            <form  id="formexcel" method="post" enctype="multipart/form-data" style="margin-left:220px;">
                            	<input type="text" id="textfield" class="layui-input" style="width:200px; float:left;" />
						        <input type="button" class="layui-btn" value="浏览..." style="width:70px; color:#fff;height:30px; line-height:20px!important;cursor:pointer;border:0;margin-left:10px;float:left;"/> 
						        <input type="file" name="file" class="file" id="file" onchange="document.getElementById('textfield').value=this.files[0].name" /> 
							    <div class="layui-inline" style="margin-left:10px;">
									<button type="button" onClick="importUsers();" class="layui-btn" > 导入数据</button>
								</div>
							</form>
							
                        </div>

                        
                        <div class="layui-card-header">
                            <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
                            <button class="layui-btn" onclick="xadmin.open('添加用户','./addTeacher',600,400)"><i class="layui-icon"></i>添加</button>
                        </div>
                        
                        <div class="layui-card-body layui-table-body layui-table-main">
                            <table class="layui-table layui-form">
                                <thead>
                                  <tr>
                                    <th>
                                      <input type="checkbox" lay-filter="checkall" name="" lay-skin="primary">
                                    </th>
                                    <th>工号</th>
                                    <th>姓名</th>
                                    <th>所在院系</th>
                                    <th>所教课程</th>
                                    <th>操作</th>
                                  </tr>
                                </thead>
                                <c:if test="${teacher==null}">
	                             	<tbody>
	                     				<c:forEach items="${Teachers}" var="teacher">
	                     					<tr>
	                     						<td> <input type="checkbox" value="${teacher.teacher_id}" lay-filter="check" name="" lay-skin="primary"></td>
	                     						<td>${teacher.teacher_id}</td>
		                     					<td>${teacher.teacher_name}</td>
		                     					<td>${teacher.ins.ins_name}</td>
		                     					<td>${teacher.subject.subject_name}</td>
		                     					<td class="td-manage">
			                                      <a title="编辑"  onclick="xadmin.open('编辑','updateTeacher?id=${teacher.teacher_id}',600,400)" href="javascript:;">
			                                        <i class="layui-icon">&#xe642;</i>
			                             	      </a>
			  	                                   <a onclick="rePass(${teacher.teacher_id})" title="重置密码" href="javascript:;">
			                                        <i class="layui-icon">&#xe631;</i>
			                                      </a>
			                                      <a title="删除" onclick="member_del(this,'${teacher.teacher_id}')" href="javascript:;">
			                                        <i class="layui-icon">&#xe640;</i>
			                                      </a>
		                                    	</td>
	                                    	</tr>
	                     				</c:forEach>	                                                                                     
	                                </tbody>
                                  </c:if>
                                  <c:if test="${teacher!=null }">
                                  		<tbody>	                     				
	                     					<tr>
	                     						<td> <input type="checkbox" value="${teacher.teacher_id}" lay-filter="check" name="" lay-skin="primary"></td>
	                     						<td>${teacher.teacher_id}</td>
		                     					<td>${teacher.teacher_name}</td>
		                     					<td>${teacher.ins.ins_name}</td>
		                     					<td>${teacher.subject.subject_name}</td>
		                     					<td class="td-manage">
			                                      <a title="编辑"  onclick="xadmin.open('编辑','updateTeacher?id=${teacher.teacher_id}',600,400)" href="javascript:;">
			                                        <i class="layui-icon">&#xe642;</i>
			                             	      </a>
			  	                                   <a onclick="rePass(${teacher.teacher_id})" title="重置密码" href="javascript:;">
			                                        <i class="layui-icon">&#xe631;</i>
			                                      </a>
			                                      <a title="删除" onclick="member_del(this,'${teacher.teacher_id}')" href="javascript:;">
			                                        <i class="layui-icon">&#xe640;</i>
			                                      </a>
		                                    	</td>
	                                    	</tr>                                                                                     
	                                </tbody>
                                  </c:if>
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
         	 url= "${pageContext.request.contextPath}/admin/delTeacher";
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
	/*用户-重置密码*/
	function rePass(id){
		layer.confirm('确认要重置该教师的密码吗？',function(index){
            //发异步修改数据
         parm={id:id}
       	 url= "${pageContext.request.contextPath}/admin/changePass";
       	 $.post(url,parm,function(data){
       		 if(data.flag==1){
       			  layer.msg('重置成功!',{icon:1,time:1000});
       			  xadmin.father_reload();//刷新父窗口
       		 }
       	 })
        });
	}

	/*批量删除*/
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
            	url:"${pageContext.request.contextPath}/admin/delMoreTeacher",
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
      
      
      	/*验证上传文件的框*/
		function importUsers(){    	
			var fileName=$("#file").val();
    	 	 //验证不为空
			if(fileName=='') {
		          layer.msg('请选择文件！',{
		          	icon:7,
		          	time:1500
		          }); 
		          return false;
		    }
			//验证文件格式
			var fileType = (fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length)).toLowerCase();
			if (fileType != 'xlsx') {
				layer.msg('文件格式不正确！',{
					   icon:2,
					   time:1500
					 });
					return false;
			}
			/*上传文件到后台*/
			var fileObj = document.getElementsByName("file")[0].files[0]; // js 获取文件对象
			var fileName=$("#file").val();//获取文件名
			var formFile = new FormData();
			formFile.append("file", fileObj); //加入文件对象
			formFile.append("basePath", ""); //加入文件对象
			var data = formFile;
			$.ajax({
			    url:"${pageContext.request.contextPath}/admin/addMoreTeacher",
			    data:data,
			    type:"Post",
			    dataType: "json",
			    async: true,
			    cache: false,
			    processData: false,//用于对data参数进行序列化处理 这里必须false
			    contentType: false, //必须
			    beforeSend:function () {//ajax处理之前出现spin图标
			    	loading = layer.load(1, {//等待
	                    shade: [0.1, '#fff'] //0.1透明度的白色背景
	                });
                },
			    success: function (data) {
			      	if(data.flag==1){
			      		layer.msg('导入成功!',{icon:1,time:1000},function(){
			      			location.reload()//刷新
			      			//xadmin.father_reload();//刷新父窗口
			      		});			 
			      	}else{
			      		layer.msg('导入失败!',{icon:5,time:1000});
			      	}
			     }
			  });
			      		
			} 
      	
      	/*搜索框*/
      	function search(){
      		var text=$("#teacher_text").val();
      		if(text==""){
      			layer.msg('搜索内容不能为空!',{icon:5,time:1000});
      		}else{
      			window.location.href="${pageContext.request.contextPath}/admin/lookTeacherByID?id="+text;
      		}
      		
      	}
      	
      	
    </script>
</html>