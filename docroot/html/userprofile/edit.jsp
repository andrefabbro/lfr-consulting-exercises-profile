<%@ include file="init.jsp"%>
<%
String firstName = BeanParamUtil.getString(selectedContact, request, "firstName");
String lastName = BeanParamUtil.getString(selectedContact, request, "lastName");
boolean male = BeanParamUtil.getBoolean(selectedContact, request, "male", true);

int birthdayDay = (renderRequest.getAttribute("birthdayDay") != null) ? (Integer) renderRequest.getAttribute("birthdayDay") : 1;
int birthdayMonth = (renderRequest.getAttribute("birthdayMonth") != null) ? (Integer) renderRequest.getAttribute("birthdayMonth") : 1;
int birthdayYear = (renderRequest.getAttribute("birthdayYear") != null) ? (Integer) renderRequest.getAttribute("birthdayYear") : 1970;

String aboutMe = BeanParamUtil.getString(generalProfile, request, "aboutMe");
String favoriteQuotes = BeanParamUtil.getString(generalProfile, request, "favoriteQuotes");

String favoriteMovie = BeanParamUtil.getString(movieInterest, request, "favoriteMovie");
String favoriteGenre = BeanParamUtil.getString(movieInterest, request, "favoriteGenre");
String leastFavMovie = BeanParamUtil.getString(movieInterest, request, "leastFavMovie");
String favoriteActor = BeanParamUtil.getString(movieInterest, request, "favoriteActor");
%>

<liferay-ui:success key="user-profile-updated" message="user-profile-updated-successfully" />
<liferay-ui:success key="user-privacy-settings-updated" message="user-privacy-settings-updated-successfully" />

<liferay-ui:error key="required-field-firstname" message="error-required-firstname" />
<liferay-ui:error key="required-field-lastname" message="error-required-lastname" />
<liferay-ui:error key="required-field-birthday" message="error-required-birthday" />
<liferay-ui:error key="age-not-allowed" message="error-age-not-allowed" />

<portlet:actionURL name="saveProfileAction" var="saveProfileURL" portletMode="view" />
<portlet:renderURL var="viewProfileURL" portletMode="view" />

<aui:form action="<%= saveProfileURL %>" method="post" name="editUserProfileForm">

	<aui:fieldset label="basic_info">
		
		<table>
			<tr>
				<td>
					<aui:input name="first_name" label="first_name" value="<%= firstName %>" type="text" required="true" />
				</td>
				<td>
					<aui:input name="last_name" label="last_name" value="<%= lastName %>" type="text" required="true" />
				</td>
				<td>
					<aui:select label="gender" name="male" required="true">
						<aui:option label="male" value="true" />
						<aui:option label="female" selected="<%= !male %>" value="false" />
					</aui:select>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<aui:field-wrapper label="birthday">
						<liferay-ui:input-date name="birthday" 
							dayParam="birthdayDay"
							dayValue="<%= birthdayDay %>"
							monthParam="birthdayMonth"
							monthValue="<%= birthdayMonth %>"
							yearParam="birthdayYear"
							yearValue="<%= birthdayYear %>" />
					</aui:field-wrapper>
				</td>
			</tr>
		</table>
		
	</aui:fieldset>
	
	<aui:fieldset label="general_profile">
		
		<aui:input name="about_me" label="about_me" value="<%= aboutMe %>" type="textarea" />
		<aui:input name="favorite_quotes" label="favorite_quotes" value="<%= favoriteQuotes %>" type="textarea" />
		
	</aui:fieldset>
	
	<aui:fieldset label="movie_interest">
		
		<aui:input name="favorite_movie" label="favorite_movie" value="<%= favoriteMovie %>" type="text" />
	
		<aui:select label='favorite_genre' name='favorite_genre'>
			<aui:option label='action' value='action' selected='<%= (favoriteGenre.equals("action")) ? true : false  %>' />
			<aui:option label='comedies' value='comedies' selected='<%= (favoriteGenre.equals("comedies")) ? true : false  %>' />
			<aui:option label='documentaries' value='documentaries' selected='<%= (favoriteGenre.equals("documentaries")) ? true : false  %>' />
			<aui:option label='dramas' value='dramas' selected='<%= (favoriteGenre.equals("dramas")) ? true : false  %>' />
			<aui:option label='foreign' value='foreign' selected='<%= (favoriteGenre.equals("foreign")) ? true : false  %>' />
			<aui:option label='horror' value='horror' selected='<%= (favoriteGenre.equals("horror")) ? true : false  %>' />
			<aui:option label='independent' value='independent' selected='<%= (favoriteGenre.equals("independent")) ? true : false  %>' />
			<aui:option label='romance' value='romance' selected='<%= (favoriteGenre.equals("romance")) ? true : false  %>' />
			<aui:option label='spirituality' value='spirituality' selected='<%= (favoriteGenre.equals("spirituality")) ? true : false  %>' />
			<aui:option label='scifi' value='scifi' selected='<%= (favoriteGenre.equals("scifi")) ? true : false  %>' />
			<aui:option label='sports' value='sports' selected='<%= (favoriteGenre.equals("sports")) ? true : false  %>' />
			<aui:option label='thriller' value='thriller' selected='<%= (favoriteGenre.equals("thriller")) ? true : false  %>' />
		</aui:select>
		
		<aui:input name="least_fav_movie" label="least_fav_movie" value="<%= leastFavMovie %>" type="text" />
		
		<aui:input name="favorite_actor" label="favorite_actor" value="<%= favoriteActor %>" type="text" />
		
	</aui:fieldset>
	
	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel" onClick="<%= viewProfileURL.toString() %>" />
	</aui:button-row>

</aui:form>