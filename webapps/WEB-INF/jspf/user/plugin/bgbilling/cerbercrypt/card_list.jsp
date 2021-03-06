<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jspf/taglibs.jsp"%>

<c:set var="uiid" value="${u:uiid()}"/>

<%--
<c:url var="url" value="plugin/bgbilling/proto/npay.do">
	<c:param name="action" value="serviceGet"/>
	<c:param name="contractId" value="${form.param.contractId}"/>
	<c:param name="billingId" value="${form.param.billingId}"/>
	<c:param name="moduleId" value="${form.param.moduleId}"/>
	<c:param name="returnUrl" value="${form.requestUrl}"/>
</c:url>
<button type="button" class="btn-green mb1" title="Добавить абонплату" onclick="openUrlToParent('${url}', $('#${uiid}') )">+</button>
--%>

<table class="data" style="width: 100%;" id="${uiid}">
	<tr>
		<td>Карта</td>
		<td>Период</td>
		<td>Подписка через Web</td>
		<td>Комментарий</td>
	</tr>
	<c:forEach var="item" items="${form.response.data.list}">
		<tr>
			<%--
			<c:url var="editUr" value="${url}">
				<c:param name="id" value="${item.id}"/>			
			</c:url> 
			<c:set var="editCommand" value="openUrlToParent('${editUr}', $('#${uiid}') )"/>
			
			<c:url var="deleteAjaxUrl" value="plugin/bgbilling/proto/npay.do">
				<c:param name="action" value="serviceDelete"/>
				<c:param name="contractId" value="${form.param.conractId}"/>
				<c:param name="billingId" value="${form.param.billingId}"/>
				<c:param name="moduleId" value="${form.param.moduleId}"/>
				<c:param name="id" value="${item.id}"/>
			</c:url>
			<c:set var="deleteAjaxCommandAfter" value="openUrlToParent('${form.requestUrl}',$('#${uiid}'))"/>
			
			<td nowrap="nowrap">
				<%@ include file="/WEB-INF/jspf/edit_buttons.jsp"%>
			</td>
			 --%>
			<td>${item.number}</td>
			<td nowrap="nowrap">${u:formatDate( item.dateFrom, 'ymd' )} - ${u:formatDate( item.dateTo, 'ymd' )}</td>
			<td>${u:formatDate(item.subscrDate, 'ymd')}</td>
			<td>${item.comment}</td>
		</tr>
	</c:forEach>
</table>