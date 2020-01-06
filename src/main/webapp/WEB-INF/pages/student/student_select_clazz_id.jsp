<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<select id="clazzId" name="clazzId" class="form-control">
	<c:if test="${!empty clazzList}">
		<c:forEach items="${clazzList}" var="clazz">
			<option value="${clazz.rowId}">${clazz.clazzName}</option>
		</c:forEach>	
	</c:if>
</select>