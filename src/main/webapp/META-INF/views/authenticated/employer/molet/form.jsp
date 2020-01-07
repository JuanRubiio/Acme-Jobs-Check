<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form readonly="${finalMode}">
	
	<acme:form-textbox code="authenticated.employer.molet.form.label.text" path="text"/>
	<acme:form-url code="authenticated.employer.molet.form.label.key" path="key"/>
	

	<acme:form-return code="authenticated.employer.molet.form.button.return"/>
	<jstl:if test="${!finalMode}">
		<acme:form-submit test="${command == 'create'}" code="authenticated.employer.molet.form.button.create" action="/employer/molet/create"/>
		<acme:form-submit test="${command == 'show'}" code="authenticated.employer.molet.form.button.update" action="/employer/molet/update"/>
		<acme:form-submit test="${command == 'show'}" code="authenticated.employer.molet.form.button.delete" action="/employer/molet/delete"/>
		<acme:form-submit test="${command == 'update'}" code="authenticated.employer.molet.form.button.update" action="/employer/molet/update"/>
		<acme:form-submit test="${command == 'delete'}" code="authenticated.employer.molet.form.button.delete" action="/employer/molet/delete"/>
	
	</jstl:if>	
</acme:form>

 