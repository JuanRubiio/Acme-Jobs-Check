<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form readonly="${finalMode}">
	
	<acme:form-textbox code="authenticated.employer.etiqueta1.form.label.text" path="text"/>
	<acme:form-url code="authenticated.employer.etiqueta1.form.label.atributoEtiqueta1" path="badge"/>
	

	<acme:form-return code="authenticated.employer.etiqueta1.form.button.return"/>
	
</acme:form>

 