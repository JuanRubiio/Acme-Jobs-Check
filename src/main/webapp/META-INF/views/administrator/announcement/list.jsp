<%@page  language ="java"%>


<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:list>
	<acme:list-column code="administrator.announcement.list.label.title" path="title" width="15%"/>
	<acme:list-column code="administrator.announcement.list.label.moment" path="moment" width="15%"/>
	<acme:list-column code="administrator.announcement.list.label.link" path="link" width="35%"/>
	<acme:list-column code="administrator.announcement.list.label.description" path="description" width="35%"/>
</acme:list>


