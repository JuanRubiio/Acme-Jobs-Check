<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form readonly="${finalMode}">
	
	<acme:form-textbox code="authenticated.employer.molet.form.label.text" path="text"/>
	<acme:form-url code="authenticated.employer.molet.form.label.key" path="Key"/>
	

	<acme:form-return code="authenticated.employer.molet.form.button.return"/>
	
</acme:form>

 