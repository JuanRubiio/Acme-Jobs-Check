<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="authentication.offer.title" path="title"/>
	<acme:form-moment code="authentication.offer.moment" path="moment"/>
	<acme:form-moment code="authentication.offer.deadline" path="deadline"/>
	<acme:form-money code="authentication.offer.reward" path="reward"/>
	<acme:form-money code="authentication.offer.maxPrice" path="maxPrice"/>
	<acme:form-money code="authentication.offer.minPrice" path="minPrice"/>
	<acme:form-textarea code="authentication.offer.text" path="text" />
	

<%-- 	<acme:form-submit code="authentication.offer.create" action="/authenticated/offer/create"/>

		 --%>
  	<acme:form-return code="authentication.offer.return"/>
</acme:form>
