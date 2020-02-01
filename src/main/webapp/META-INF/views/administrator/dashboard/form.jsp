<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form readonly="true"> 
	<acme:form-textbox code="administrator.ratioJobsAolet" path="ratioJobsAolet"/>
	<acme:form-textbox code="administrator.ratioApplicationAnswer" path="ratioApplicationAnswer"/>
	<acme:form-textbox code="administrator.ratioApplicationConfirmation" path="ratioApplicationConfirmation"/>
	
	<acme:form-textbox code="administrator.totalNumberCompanyRecords" path="totalNumberCompanyRecords"/>
	<acme:form-textbox code="administrator.totalNumberAnnonuncements" path="totalNumberAnnonuncements"/>
	<acme:form-textbox code="administrator.totalNumberInvestorRecords" path="totalNumberInvestorRecords"/>
	<acme:form-textbox code="administrator.minRewardActiveRequest" path="minRewardActiveRequest"/>
	<acme:form-textbox code="administrator.maxRewardActiveRequest" path="maxRewardActiveRequest"/>
	<acme:form-textbox code="administrator.avgRewardActiveRequest" path="avgRewardActiveRequest"/>
	<acme:form-textbox code="administrator.desvRewardActiveRequest" path="desvRewardActiveRequest"/>
	<acme:form-textbox code="administrator.minRewardActiveOffer" path="minRewardActiveOffer"/>
	<acme:form-textbox code="administrator.maxRewardActiveOffer" path="maxRewardActiveOffer"/>
	<acme:form-textbox code="administrator.avgRewardActiveOffer" path="avgRewardActiveOffer"/>
	<acme:form-textbox code="administrator.desvRewardActiveOffer" path="desvRewardActiveOffer"/>
	<acme:form-textbox code="administrator.avgNumberJobByEmployer" path="avgNumberJobOEmployer"/>
	<acme:form-textbox code="administrator.avgNumberApplEmployer" path="avgNumberApplEmployer"/>
	<acme:form-textbox code="administrator.avgNumberApplWorker" path="avgNumberApplWorker"/>
	

	<acme:form-return code="administrator.announcement.form.button.return"/>
</acme:form>
