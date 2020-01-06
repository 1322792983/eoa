<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
	<div class="col-sm-12">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">班级主键</th>
					<th scope="col">学生编号</th>
					<th scope="col">学生名称</th>
					<th scope="col">学生性别</th>
					<th scope="col">学生生日</th>
					<th scope="col">操作</th>
				</tr>
			</thead>
			<tbody>
			<c:if test="${!empty studentList}">
			<c:forEach items="${studentList}" var="student">
			<tr>
					<th scope="row">${student.rowId}</th>
					<td>${student.clazzId}</td>
					<td>${student.stuCode}</td>
					<td>${student.stuName}</td>
					<td>${student.stuSex == 1 ? '男':'女'}</td>
					<td>${student.stuBirthday}</td>
					<td>
						<a href="javascript:;" data-rowId="${student.rowId}" id="update">修改</a>
						<a href="javascript:;" data-rowId="${student.rowId}" id="delete">删除</a>
					</td>
				</tr>
			</c:forEach>	
			</c:if>
			</tbody>
		</table>
	</div>
</div>
<%-- 引入分页 --%>
<%@ include file="/page.jsp"%>