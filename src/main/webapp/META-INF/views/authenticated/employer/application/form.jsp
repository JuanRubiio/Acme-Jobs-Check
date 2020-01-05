<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form>
	<acme:form-textbox code="authenticated.employer.application.form.label.referenceNumber" path="referenceNumber" placeholder="EEEE-JJJJ:WWWW" readonly="true"/>
	<acme:form-select code="authenticated.employer.application.form.label.status" path="status">
	<jstl:choose>
			<jstl:when test="${status == 'Pending' }">
				<jstl:set var="pendingSelected" value="true" />
			</jstl:when>
			<jstl:otherwise>
				<jstl:set var="pendingSelected" value="false" />
			</jstl:otherwise>
		</jstl:choose>
		<jstl:choose>
			<jstl:when test="${status == 'Accepted' }">
				<jstl:set var="acceptedSelected" value="true" />
			</jstl:when>
			<jstl:otherwise>
				<jstl:set var="acceptedSelected" value="false" />
			</jstl:otherwise>
		</jstl:choose>
		<jstl:choose>
			<jstl:when test="${status == 'Rejected' }">
				<jstl:set var="rejectedSelected" value="true" />
			</jstl:when>
			<jstl:otherwise>
				<jstl:set var="rejectedSelected" value="false" />
			</jstl:otherwise>
		</jstl:choose>
		<acme:form-option code="Pending" value="Pending" selected="${pendingSelected}"/>
		<acme:form-option code="Accepted" value="Accepted" selected="${acceptedSelected}"/>
		<acme:form-option code="Rejected" value="Rejected" selected="${rejectedSelected}"/>
	</acme:form-select> 
	<acme:form-textbox code="authenticated.employer.application.form.label.statement" path="statement" readonly="true"/>
	<acme:form-textbox code="authenticated.employer.application.form.label.skills" path="skills" readonly="true"/>
	<acme:form-textbox code="authenticated.employer.application.form.label.qualifications" path="qualifications" readonly="true"/>	
	
	<acme:form-textbox code="authenticated.employer.application.form.label.messageRejected" path="messageRejected"/>
	
	
		<jstl:if test="${confirmation=='' && status !='Pending'}">	
		<acme:form-textbox code="authenticated.employer.application.form.label.answerWorker" path="answerWorker" readonly="true"/>
		</jstl:if>
		<jstl:if test="${confirmation!='' && status !='Pending'}">
			<acme:form-password code="authenticated.employer.application.form.label.cc" path="cc"/>
			<jstl:if test="${confirmation==cc}">
				<acme:form-textbox code="authenticated.employer.application.form.label.answerWorker" path="answerWorker" readonly="true"/>
			</jstl:if>
		</jstl:if>
	
	
	<acme:form-hidden path="id"/>
	
	<acme:form-return code="authenticated.employer.application.form.button.return"/>
	<acme:form-submit code="authenticated.employer.application.form.label.worker" action="/employer/worker/show?id=${id}" method="get"/>
	<acme:form-submit test="${command == 'show'}" code="authenticated.employer.application.form.button.update" action="/employer/application/update"/>
	<acme:form-submit test="${command == 'update'}" code="authenticated.employer.application.form.button.update2" action="/employer/application/update"/>
</acme:form>

