<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form readonly="true">

	<acme:form-textbox code="authenticated.worker.job.form.label.reference" path="reference" placeholder="EEEE-JJJJ"/>
	<acme:form-textbox code="authenticated.worker.job.form.label.title" path="title"/>
	<%-- 	<acme:form-select code="authenticated.worker.job.form.label.status" path="status">
		<acme:form-option code="Draft" value="Draft"/>
		<acme:form-option code="Published" value="Published" />
	</acme:form-select> --%>
	<acme:form-textbox code="authenticated.worker.job.form.label.status" path="status"/>
	<acme:form-moment code="authenticated.worker.job.form.label.deadline" path="deadline"/>
	<acme:form-url code="authenticated.worker.job.form.label.link" path="link"/>
	<acme:form-money code="authenticated.worker.job.form.label.salary" path="salary"/>
	<acme:form-textarea code="authenticated.worker.job.form.label.description" path="description"/>
	<acme:form-checkbox code="authenticated.worker.job.form.label.active" path="active"/>
	
	<acme:form-hidden path="id"/>

<acme:form-return code="authenticated.worker.job.form.button.return"/>
<acme:form-submit code="authenticated.employer.job.form.label.active.duty" action="/worker/duty/list?id=${id}" method="get"/>
<acme:form-submit code="master.menu.anonymous.listAuditRecords" action="/worker/audit-record/list-mine?id=${id}" method="get" />
<acme:form-submit code="authenticated.employer.job.form.label.create" action="/worker/application/create?id=${id}" method="get"/>
<acme:form-submit code="authenticated.employer.job.form.label.active.etiqueta1" action="/worker/etiqueta1/list?id=${id}" method="get"/>
		
</acme:form>

 