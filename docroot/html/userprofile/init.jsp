<%@ include file="/html/common/init.jsp"%>

<%@ page import="com.liferay.portal.model.User"%>
<%@ page import="com.liferay.portal.model.Contact"%>
<%@ page import="com.amf.user.profile.model.GeneralProfile"%>
<%@ page import="com.amf.user.profile.model.MovieInterest"%>
<%@ page import="com.liferay.portal.kernel.bean.BeanParamUtil"%>
<%@ page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ page import="com.liferay.portal.security.permission.ActionKeys" %>
<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors" %>

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