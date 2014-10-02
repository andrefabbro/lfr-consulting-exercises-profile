<%@ include file="/html/common/init.jsp"%>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<%
	// String redirect = ParamUtil.getString(request, "redirect");
	String redirect = PortalUtil.getCurrentURL(renderRequest);

	long userId = themeDisplay.getUserId();
	long companyId = themeDisplay.getCompanyId();

	Contact selectedContact =
		(Contact) renderRequest.getAttribute("selectedContact");
	GeneralProfile generalProfile =
		(GeneralProfile) renderRequest.getAttribute("generalProfile");
	MovieInterest movieInterest =
		(MovieInterest) renderRequest.getAttribute("movieInterest");
%>