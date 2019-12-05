<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="x-admin-sm">
    
    <head>
        <meta charset="UTF-8">
        <title>添加菜单</title>
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
        <div class="layui-fluid">
            <div class="layui-row">
                <form class="layui-form" id="form">
                    <div class="layui-form-item">
                        <label for="L_email" class="layui-form-label">
                            <span class="x-red">*</span>菜单名</label>
                        <div class="layui-input-inline">
                            <input type="text" id="name" value="${per.permission_name}" name="name" required="" lay-verify="" autocomplete="off" class="layui-input"></div>
                    </div>
                    
                    <div class="layui-form-item">
                        <label for="L_username" class="layui-form-label">
                            <span class="x-red">*</span>地址</label>
                        <div class="layui-input-inline">
                            <input type="text" id="url" value="${per.url}" name="url" required="" lay-verify="nikename" autocomplete="off" class="layui-input"></div>
                    </div>
                    
                     <div class="layui-form-item">
                        <label for="L_username" class="layui-form-label">
                            <span class="x-red">*</span>菜单等级</label>
                        <div class="layui-input-inline">
                        	<select name="grade">
                        		<c:choose>
                        			<c:when test="${per.permission_grade==1}">
                        				<option value="1" selected="selected">1</option>
                        				<option value="2">2</option>
                        			</c:when>
                        			<c:when test="${per.permission_grade==2}">
                        				<option value="1" >1</option>
                        				<option value="2" selected="selected">2</option>
                        			</c:when>
                        			<c:otherwise>
                        				<option value="1">1</option>
                        				<option value="2">2</option>
                        			</c:otherwise>
                        		</c:choose>
                        		
                        	</select> 
                         </div>
                    </div>
                    
                    <div class="layui-form-item">
                        <label for="L_username" class="layui-form-label">
                            <span class="x-red">*</span>父级菜单</label>
                        <div class="layui-input-inline">
                        	<select name="parentnum">
       							<option value="0">无父级</option>
                        		<c:forEach items="${parent}" var="parent">
                        			<c:choose>
                        				<c:when test="${parent.permission_id==per.paretn_num }">
                        					<option value="${parent.permission_id}" selected="selected">${parent.permission_name}</option>
                        				</c:when>
                        				<c:otherwise>
                        					<option value="${parent.permission_id}">${parent.permission_name}</option>
                        				</c:otherwise>
                        			</c:choose>
                        		</c:forEach>
                        	</select>                              
                        </div>
                    </div>
                    
                    <div class="layui-form-item">
                        <label for="L_username" class="layui-form-label">
                            <span class="x-red">*</span>顺序</label>
                        <div class="layui-input-inline">
                            <input type="text" id="sort" value="${per.sort }" name="sort" required="" lay-verify="nikename" autocomplete="off" class="layui-input"></div>
                    </div>
                    
                    <div class="layui-form-item">
                        <label for="L_username" class="layui-form-label">
                            <span class="x-red">*</span>描述</label>
                        <div class="layui-input-inline">
                            <input type="text" id="describe" value="${per.describes }" name="describe" required="" lay-verify="nikename" autocomplete="off" class="layui-input"></div>
                    </div>
                	<input type="hidden" value="${per.permission_id}" name="id">
                    <div class="layui-form-item">
                        <label for="L_repass" class="layui-form-label"></label>
                        <button class="layui-btn" type="button" lay-filter="add" lay-submit="" >修改</button></div>
                </form>
            </div>
        </div>
        <script>
        var isTrue=false;
        layui.use(['form', 'layer','jquery'],
            function() {
                $ = layui.jquery;
                var form = layui.form,
                layer = layui.layer;
                
                //自定义验证规则
                //监听提交
              	
                url= "${pageContext.request.contextPath}/admin/changeMenu";
               	form.on('submit(add)',function(sub){
               		var param = $("#form").serialize();
               		$.post(url,param,function(data){
               			if(data.flag==1){
               				layer.alert('修改成功',{
           						icon:6
           					},
           					function(){
               				  	xadmin.close();//关闭当前frame
               				  	xadmin.father_reload();//刷新父窗口
               				});              				
               			}else{
               				layer.alert("修改失败",{
           						icon:5
           					},
           					function(){
           						xadmin.close();//关闭当前frame
               				  	xadmin.father_reload();//刷新父窗口
           					});
               			}
						
               		});
               		
               	})
            });
        </script>
        <script>
        	var _hmt = _hmt || []; (function() {
                var hm = document.createElement("script");
                hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
                var s = document.getElementsByTagName("script")[0];
                s.parentNode.insertBefore(hm, s);
            })();
        </script>
    </body>

</html>