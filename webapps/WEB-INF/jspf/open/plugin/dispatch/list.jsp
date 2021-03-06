<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jspf/taglibs.jsp"%>

<div class="center1020">
	<div id="title"><h1>Рассылки</h1></div>
	<div class="pl2 pr2">
		<c:set var="config" value="${u:getConfig(ctxSetup, 'ru.bgcrm.plugin.dispatch.Config')}"/>   	   	
   	   
		<table class="data" style="width: 100%;" id="${tableUiid}">
			<tr>
				<td width="250">Наименование</td>
				<td width="100%">Описание</td>
			</tr>
			<c:forEach var="item" items="${form.response.data.list}">
				<tr>
					<td>${item.title}</td>
					<td>${item.comment}</td>
				</tr>
			</c:forEach>
		</table>
		
		<html:form action="/open/plugin/dispatch/dispatch" styleClass="mt1 in-mr1">
			<input type="hidden" name="action" value="subscribe"/>
			<input type="text" name="email" placeholder="E-Mail" size="30"/>
			<button class="btn-grey" type="button" onclick="bgerp.ajax.post(formUrl(this.form)).done(function () {alert('На указанный адрес выслана инструкция')})">Подписка</button>
		</html:form>
    </div>    
</div>
