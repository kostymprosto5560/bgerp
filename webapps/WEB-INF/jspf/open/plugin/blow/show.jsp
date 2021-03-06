<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jspf/taglibs.jsp"%>

<div id="blow-board">
	<c:set var="boardConf" scope="request" value="${form.response.data.boardConf}"/>
	<c:set var="board" scope="request" value="${form.response.data.board}"/>
	<c:if test="${not empty board}">
		<c:set var="uiid" value="${u:uiid()}"/>
			
		<%@ include file="/WEB-INF/jspf/user/plugin/blow/board/filters.jsp"%>	
			
		<table id="${uiid}" class="data" style="width: 100%;">
			<tr class="head">
				<c:forEach var="column" items="${board.executors}">
					<td>User ${column.id}<%@ include file="/WEB-INF/jspf/user/plugin/blow/board/executor_count.jsp"%></td>
				</c:forEach>
			</tr>
			<c:set var="open" value="1"/>
			<%@ include file="/WEB-INF/jspf/user/plugin/blow/board/table_data.jsp"%>	
		</table>
		
		<script>
		$(function () {
			bgerp.blow.initTable($('#${uiid}'));
		})
		</script>
	</c:if>
</div>