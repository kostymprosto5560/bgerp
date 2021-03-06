<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jspf/taglibs.jsp"%>

<html:form action="/user/plugin/dispatch/dispatch" styleClass="center500">
	<input type="hidden" name="action" value="dispatchUpdate" />
	
	<c:set var="dispatch" value="${form.response.data.dispatch}" scope="page"/>
	
	<h2>ID</h2>
	<input type="text" name="id" style="width: 100%" value="${dispatch.id}" disabled="disabled"/>
	
	<h2>Название</h2>
	<input type="text" name="title" style="width: 100%" value="${dispatch.title}"/>
	
	<h2>Описание</h2>
	<input type="text" name="comment" style="width: 100%" value="${dispatch.comment}"/>			
	
	<div class="mt1">
		<%@ include file="/WEB-INF/jspf/send_and_cancel_form.jsp"%>
	</div>
</html:form>

<c:set var="state" value="Редактор"/>
<%@ include file="/WEB-INF/jspf/shell_state.jsp"%>