<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form readonly="${finalMode}">
	
	<acme:form-textbox code="authenticated.employer.aolet.form.label.text" path="text"/>
	<acme:form-url code="authenticated.employer.aolet.form.label.badge" path="badge"/>
	

	<acme:form-return code="authenticated.employer.aolet.form.button.return"/>
	
</acme:form>

 