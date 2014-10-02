<%@ include file="init.jsp"%>
<%
String basic_info = (renderRequest.getAttribute("basic_info") != null) ? (String) renderRequest.getAttribute("basic_info") : StringPool.BLANK;
String general_profile = (renderRequest.getAttribute("general_profile") != null) ? (String) renderRequest.getAttribute("general_profile") : StringPool.BLANK;
String movie_interest = (renderRequest.getAttribute("movie_interest") != null) ? (String) renderRequest.getAttribute("movie_interest") : StringPool.BLANK;
%>

<liferay-ui:error key="you-have-to-edit-your-profile-first" message="error-you-have-to-edit-your-profile-first" />

<c:if test="<%= SessionErrors.isEmpty(renderRequest) %>">

	<portlet:actionURL name="savePrivacyAction" var="savePrivacyURL" portletMode="view" />
	
	<aui:form action="<%= savePrivacyURL %>" method="post" name="editPrivacyFrm">
	
		<aui:fieldset label="settings">
			
			<aui:field-wrapper name='basic_info'>
				<aui:input name='basic_info' type='radio' value='0' checked='<%= basic_info.equals("0") %>' label='private' />
				<aui:input name='basic_info' type='radio' value='1' checked='<%= basic_info.equals("1") %>' label='protected' />
				<aui:input name='basic_info' type='radio' value='2' checked='<%= basic_info.equals("2") %>' label='public' />
			</aui:field-wrapper>
			
			<aui:field-wrapper name='general_profile'>
				<aui:input name='general_profile' type='radio' value='0' checked='<%= general_profile.equals("0") %>' label='private' />
				<aui:input name='general_profile' type='radio' value='1' checked='<%= general_profile.equals("1") %>' label='protected' />
				<aui:input name='general_profile' type='radio' value='2' checked='<%= general_profile.equals("2") %>' label='public' />
			</aui:field-wrapper>
			
			<aui:field-wrapper name='movie_interest'>
				<aui:input name='movie_interest' type='radio' value='0' checked='<%= movie_interest.equals("0") %>' label='private' />
				<aui:input name='movie_interest' type='radio' value='1' checked='<%= movie_interest.equals("1") %>' label='protected' />
				<aui:input name='movie_interest' type='radio' value='2' checked='<%= movie_interest.equals("2") %>' label='public' />
			</aui:field-wrapper>
			
		</aui:fieldset>
		
		<aui:button-row>
			<aui:button type="submit" />
			<aui:button type="cancel" />
		</aui:button-row>
	</aui:form>

</c:if>