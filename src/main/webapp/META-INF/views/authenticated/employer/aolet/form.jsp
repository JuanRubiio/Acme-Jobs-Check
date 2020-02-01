<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form readonly="${finalMode}">
	
	<acme:form-textbox code="authenticated.employer.aolet.form.label.text" path="text"/>
	<acme:form-url code="authenticated.employer.aolet.form.label.badge" path="badge"/>
	

	<acme:form-return code="authenticated.employer.aolet.form.button.return"/>
	<jstl:if test="${!finalMode}">
		<acme:form-submit test="${command == 'create'}" code="authenticated.employer.aolet.form.button.create" action="/employer/aolet/create"/>
		<acme:form-submit test="${command == 'show'}" code="authenticated.employer.aolet.form.button.update" action="/employer/aolet/update"/>
		<acme:form-submit test="${command == 'show'}" code="authenticated.employer.aolet.form.button.delete" action="/employer/aolet/delete"/>
		<acme:form-submit test="${command == 'update'}" code="authenticated.employer.aolet.form.button.update" action="/employer/aolet/update"/>
		<acme:form-submit test="${command == 'delete'}" code="authenticated.employer.aolet.form.button.delete" action="/employer/aolet/delete"/>
	
	</jstl:if>	
</acme:form>

 