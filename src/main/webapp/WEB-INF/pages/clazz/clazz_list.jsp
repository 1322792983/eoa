<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
	<div class="col-sm-12">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">班级名称</th>
					<th scope="col">学生数量</th>
					<th scope="col">学生简介</th>
					<th scope="col">操作</th>
				</tr>
			</thead>
			<tbody>
			<c:if test="${!empty clazzList}">
			<c:forEach items="${clazzList}" var="clazz">
			<tr>
					<th scope="row">${clazz.rowId}</th>
					<td>${clazz.clazzName}</td>
					<td>${clazz.stuCount}</td>
					<td>${clazz.clazzInfo}</td>
					<td>
						<%-- <a href="javascript:goUpdate(${clazz.rowId });">修改</a>
						<a href="javascript:doDelete(${clazz.rowId });">删除</a> --%>
						<a href="javascript:;" data-rowId="${clazz.rowId}" id="update">修改</a>
						<a href="javascript:;" data-rowId="${clazz.rowId}" id="delete">删除</a>
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