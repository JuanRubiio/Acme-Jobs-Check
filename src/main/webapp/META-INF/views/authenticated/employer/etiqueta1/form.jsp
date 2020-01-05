<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form readonly="${finalMode}">
	
	<acme:form-textbox code="authenticated.employer.etiqueta1.form.label.text" path="text"/>
	<acme:form-url code="authenticated.employer.etiqueta1.form.label.atributoEtiqueta1" path="atributoEtiqueta1"/>
	

	<acme:form-return code="authenticated.employer.etiqueta1.form.button.return"/>
	<jstl:if test="${!finalMode}">
		<acme:form-submit test="${command == 'create'}" code="authenticated.employer.etiqueta1.form.button.create" action="/employer/etiqueta1/create"/>
		<acme:form-submit test="${command == 'show'}" code="authenticated.employer.etiqueta1.form.button.update" action="/employer/etiqueta1/update"/>
		<acme:form-submit test="${command == 'show'}" code="authenticated.employer.etiqueta1.form.button.delete" action="/employer/etiqueta1/delete"/>
		<acme:form-submit test="${command == 'update'}" code="authenticated.employer.etiqueta1.form.button.update" action="/employer/etiqueta1/update"/>
		<acme:form-submit test="${command == 'delete'}" code="authenticated.employer.etiqueta1.form.button.delete" action="/employer/etiqueta1/delete"/>
	
	</jstl:if>	
</acme:form>

 