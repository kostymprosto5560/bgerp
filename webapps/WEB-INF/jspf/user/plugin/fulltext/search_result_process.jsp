<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jspf/taglibs.jsp"%>

<%@ include file="search_common.jsp"%>

<table style="width: 100%;" class="data mt1">
	<tr>
		<td width="30">ID</td>
		<td>Описание</td>
	</tr>
	<c:forEach var="item" items="${form.response.data.list}">
		<tr>
			<td>${item.id}</td>
			<td><ui:process-link id="${item.id}" text="${item.description}"/></td>
		</tr>
	</c:forEach>
</table>