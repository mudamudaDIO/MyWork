<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/scripts/css/font.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/scripts/css/xadmin.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/js/jquery-3.1.1.min.js" ></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/js/xadmin.js"></script>
<title>查看评教结果</title>
<script type="text/javascript">
function adventure(vote_id) {
	window.location.href="${pageContext.request.contextPath}/teacher/getadventure?vote_id="+vote_id;
}
</script>
</head>
<body>
<div class="x-nav">
          <span class="layui-breadcrumb">
            <a href="">首页</a>
            <a href="">演示</a>
            <a>
              <cite>导航元素</cite></a>
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
                            <tr>
							<th>投票者</th><th>投票职业</th><th>操作</th>
							</tr>
                            <c:forEach items="${getscore}" var="getscore">
                                  <tr>
                                    <td style="justify-content: center;text-align: left;">
                                     ${getscore.teacher.teacher_name}
                                     </td>
									<td>
									<c:if test="${getscore.type==1}">
									教师
									</c:if>
									<c:if test="${getscore.type==2}">
									学生
									</c:if>
									</td>
									<td>
									<button  class="layui-btn" lay-filter="add" lay-submit="" onclick="adventure(${getscore.vote_id})">查看评价</button>
									</td>
                                  </tr>
                            </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
</body>
</html>