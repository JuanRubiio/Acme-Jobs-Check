<%@page  language ="java"%>


<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:list>
	<acme:list-column code="authenticated.employer.etiqueta1.form.label.text" path="text" width="30%"/>	
	<acme:list-column code="authenticated.employer.etiqueta1.form.label.atributoEtiqueta1" path="badge" width="70%"/>
</acme:list>

<acme:form-return code="authenticated.employer.etiqueta1.form.button.return"/>
