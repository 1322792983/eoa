<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div class="col-sm-12">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">角色名称</th>
					<th scope="col">角色级别</th>
					<th scope="col">角色简介</th>
					<th scope="col">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty roleList}">
					<c:forEach items="${roleList}" var="role" varStatus="status">
						<tr>
							<th scope="row">${status.index+1}</th>
							<td>${role.roleName}</td>
							<td>
								<c:if test="${role.roleKind ==1}">一级</c:if> 
								<c:if test="${role.roleKind ==2}">二级</c:if>
								<c:if test="${role.roleKind ==3}">三级</c:if>
							</td>
							<td>${role.roleInfo}</td>
							<td>
								<a href="javascript:goUpdate(${role.rowId})">修改</a> 
								<!-- data-XXX H5以后允许自定义元素的属性 -->
								<a href="javascript:;" data-rowId="${role.rowId}" id="deleteA">删除</a>
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