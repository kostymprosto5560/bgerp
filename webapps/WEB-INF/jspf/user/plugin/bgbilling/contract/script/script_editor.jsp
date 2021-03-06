<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jspf/taglibs.jsp"%>

<c:set var="uiid" value="${u:uiid()}"/>
<c:set var="script" value="${form.response.data.script}"/>

<h1>Редактор</h1>

<form action="plugin/bgbilling/proto/contract.do" id="${uiid}">
	<input type="hidden" name="action" value="updateScript"/>
	<input type="hidden" name="billingId" value="${form.param.billingId}"/> 
	<input type="hidden" name="contractId" value="${form.param.contractId}"/>
	<input type="hidden" name="scriptId" value="${script.id}"/>

	<div class="in-table-cell mb1">
		<div style="width: 100%;">
			<u:sc>
				<c:set var="list" value="${form.response.data.scriptTypeList}"/>
				<c:set var="hiddenName" value="scriptTypeId"/>
				<c:set var="value" value="${script.typeId}"/>
				<c:set var="style" value="width: 100%;"/>
				<c:set var="placeholder" value="Скрипт"/>
				<%@ include file="/WEB-INF/jspf/select_single.jsp"%>	
			</u:sc>
		</div>	
		
		<div style="white-space:nowrap;" class="pl1">
			c
			<c:set var="editable" value="true"/>
			<input type="text" name="dateFrom" value="${script.dateFrom}" id="${uiid}-dateFrom"/>	
			<c:set var="selector" value="#${uiid}-dateFrom"/>	
			<%@ include file="/WEB-INF/jspf/datetimepicker.jsp"%>
			по
			<c:set var="editable" value="true"/>
			<input type="text" name="dateTo" value="${script.dateTo}" id="${uiid}-dateTo"/>	
			<c:set var="selector" value="#${uiid}-dateTo"/>	
			<%@ include file="/WEB-INF/jspf/datetimepicker.jsp"%>
		</div>
	</div>
	
	Комментарий:
	<textarea name="comment" rows="4" cols="10" style="width:100%; resize: vertical;">${script.comment}</textarea>
	
	<div class="mt1">
		<button type="button" class="btn-grey" onclick="if(sendAJAXCommand(formUrl(this.form))) { openUrlToParent('${form.returnUrl}',$('#${uiid}')); }">OK</button>
		<button type="button" class="btn-grey ml1" onclick="openUrlToParent('${form.returnUrl}',$('#${uiid}'));">Oтмена</button>
	</div>
</form>