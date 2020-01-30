<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form>
	<acme:form-textbox code="authenticated.worker.application.form.label.referenceNumber" path="referenceNumber" placeholder="EEEE-JJJJ:WWWW" readonly="${command != 'create'}"/>
	<jstl:if test="${command != 'create'}">
		<acme:form-textbox code="authenticated.worker.application.form.label.status" path="status" readonly="true" />
	</jstl:if>
	<acme:form-textbox code="authenticated.worker.application.form.label.statement" path="statement" readonly="${command != 'create'}"/>
	<acme:form-textbox code="authenticated.worker.application.form.label.skills" path="skills" readonly="${command != 'create'}"/>
	<acme:form-textbox code="authenticated.worker.application.form.label.qualifications" path="qualifications" readonly="${command != 'create'}"/>
	<jstl:if test="${messageRejected!=null && status!='Pending'}">
		<acme:form-textarea code="authenticated.worker.application.list.label.rejectedMessage" path="messageRejected" readonly="${command != 'create'}"/>
		<jstl:if test="${contieneMolet == true || contieneMolet == null }">
			<acme:form-textarea code="authenticated.worker.application.list.label.answerWorker" path="answerWorker"/>
			<acme:form-password code="authenticated.worker.application.list.label.keyPass" path="keyPass"/>
			<acme:form-submit test="${command == 'update'}" code="administrator.companyrecord.form.button.update" action="/worker/application/update"/>
			<acme:form-submit test="${command == 'show'}" code="administrator.companyrecord.form.button.update" action="/worker/application/update"/>
		</jstl:if>
		
	</jstl:if>
	<acme:form-hidden path="id"/>
	
	<acme:form-return code="authenticated.worker.application.form.button.return"/>
	<acme:form-submit test="${command == 'create'}" code="authenticated.worker.application.form.button.create" action="/worker/application/create"/>
	
</acme:form>

