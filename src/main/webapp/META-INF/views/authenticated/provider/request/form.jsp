<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="authenticated.request.title" path="title"/>
	
	<jstl:if test="${command != 'create' }">
	
		<acme:form-moment code="authenticated.request.moment" path="moment" readonly="true"/>
	
	</jstl:if>
	
	<acme:form-textbox code="authenticated.request.ticker" path="ticker" placeholder="RXXXX-99999"/>
	
	<acme:form-moment code="authenticated.request.deadline" path="deadline"/>
	<acme:form-textbox code="authenticated.request.text" path="text"/>
	<acme:form-money code="authenticated.request.reward" path="reward"/>
	<acme:form-checkbox code="authenticated.request.confirmation" path="confirmation"/>

	<acme:form-submit test="${command == 'create'}" code="authenticated.provider.form.button.create" action="/provider/request/create"/>

  	<acme:form-return code="authenticated.request.return"/>
</acme:form>
