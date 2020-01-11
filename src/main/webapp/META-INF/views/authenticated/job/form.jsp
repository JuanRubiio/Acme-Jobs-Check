<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form readonly="true">
	

	<acme:form-textbox code="authenticated.employer.job.form.label.reference" path="reference" placeholder="EEEE-JJJJ"/>
	<acme:form-textbox code="authenticated.employer.job.form.label.title" path="title"/>
<%-- 	<acme:form-select code="authenticated.employer.job.form.label.status" path="status">
		<acme:form-option code="Draft" value="Draft"/>
		<acme:form-option code="Published" value="Published" />
	</acme:form-select> --%>
	<acme:form-textbox code="authenticated.employer.job.form.label.status" path="status"/>
	<acme:form-moment code="authenticated.employer.job.form.label.deadline" path="deadline"/>
	
	<acme:form-url code="authenticated.employer.job.form.label.link" path="link"/>
	<acme:form-money code="authenticated.employer.job.form.label.salary" path="salary"/>
	<acme:form-textarea code="authenticated.employer.job.form.label.description" path="description"/>
	
	<acme:form-checkbox code="authenticated.employer.job.form.label.active" path="active"/>
	<acme:form-hidden path="id"/>


	<acme:form-return code="authenticated.employer.job.form.button.return"/>
	<acme:form-submit code="authenticated.employer.job.form.label.active.duty" action="/authenticated/duty/list?id=${id}" method="get"/>
	<jstl:if test="${!ayuda}">
	<acme:form-submit code="authenticated.employer.job.form.label.active.etiqueta1" action="/authenticated/aolet/show?id=${id}" method="get"/>
	</jstl:if>
	
	<acme:form-submit code="master.menu.anonymous.listAuditRecords" action="/authenticated/audit-record/list-mine?id=${id}" method="get" />
	<jstl:if test="hasRole('Worker')">
		<acme:form-submit test="${command == 'create'}" code="authenticated.worker.application.form.label.application" action="/worker/application/create"/>
	</jstl:if>
	
</acme:form>

 