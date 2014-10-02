<%@ include file="init.jsp"%>
<%
boolean hasUpdateProfilePermission =
	permissionChecker.hasPermission(
		scopeGroupId, "com.amf.user.profile.model", scopeGroupId,
		"UPDATE");

boolean canViewBasicInfo = false;
boolean canViewGeneralProfile = false;
boolean canViewMovieInterest = false;

if (selectedContact != null &&
	permissionChecker.hasPermission(
		scopeGroupId, "com.amf.user.profile.model.BasicInfo",
		selectedContact.getPrimaryKey(), ActionKeys.VIEW))
	canViewBasicInfo = true;

// shows the basic info if the user didnt fill out the profile yet
if (generalProfile == null) canViewBasicInfo = true;

if (generalProfile != null &&
	permissionChecker.hasPermission(
		scopeGroupId, "com.amf.user.profile.model.GeneralProfile",
		generalProfile.getPrimaryKey(), ActionKeys.VIEW))
	canViewGeneralProfile = true;

if (movieInterest != null &&
	permissionChecker.hasPermission(
		scopeGroupId, "com.amf.user.profile.model.MovieInterest",
		generalProfile.getPrimaryKey(), ActionKeys.VIEW))
	canViewMovieInterest = true;
%>

<liferay-ui:success key="user-profile-updated" message="user-profile-updated-successfully" />
<liferay-ui:success key="user-privacy-settings-updated" message="user-privacy-settings-updated-successfully" />

<c:if test="<%= canViewBasicInfo %>">
	<h3><liferay-ui:message key="basic_info" /></h3>
	<div class="extfieldcontainer">
		<p class="extlabel"><liferay-ui:message key="first_name" /></p>
		<p class="extvalue"><%= selectedContact.getFirstName() %></p>
	</div>
	<div class="extfieldcontainer">
		<p class="extlabel"><liferay-ui:message key="last_name" /></p>
		<p class="extvalue"><%= selectedContact.getLastName() %></p>
	</div>
	<div class="extfieldcontainer">
		<p class="extlabel"><liferay-ui:message key="gender" /></p>
		<p class="extvalue"><liferay-ui:message key='<%= selectedContact.getMale() ? "male" : "female" %>' /></p>
	</div>
	<div class="extfieldcontainer">
		<p class="extlabel"><liferay-ui:message key="birthday" /></p>
		<p class="extvalue"><%= selectedContact.getBirthday() %></p>
	</div>
	<div class="extfieldcontainer"></div>
</c:if>

<c:if test="<%= canViewGeneralProfile %>">
	<h3><liferay-ui:message key="general_profile" /></h3>
	<div class="extfieldcontainer">
		<p class="extlabel"><liferay-ui:message key="about_me" /></p>
		<p class="extvalue"><%= generalProfile.getAboutMe() %></p>
	</div>
	<div class="extfieldcontainer">
		<p class="extlabel"><liferay-ui:message key="favorite_quotes" /></p>
		<p class="extvalue"><%= generalProfile.getFavoriteQuotes() %></p>
	</div>
	<div class="extfieldcontainer"></div>
</c:if>

<c:if test="<%= canViewMovieInterest %>">
	<h3><liferay-ui:message key="movie_interest" /></h3>
	<div class="extfieldcontainer">
		<p class="extlabel"><liferay-ui:message key="favorite_movie" /></p>
		<p class="extvalue"><%= movieInterest.getFavoriteMovie() %></p>
	</div>
	<div class="extfieldcontainer">
		<p class="extlabel"><liferay-ui:message key="favorite_genre" /></p>
		<p class="extvalue"><liferay-ui:message key="<%= movieInterest.getFavoriteGenre() %>" /></p>
	</div>
	<div class="extfieldcontainer">
		<p class="extlabel"><liferay-ui:message key="least_fav_movie" /></p>
		<p class="extvalue"><%= movieInterest.getLeastFavMovie() %></p>
	</div>
	<div class="extfieldcontainer">
		<p class="extlabel"><liferay-ui:message key="favorite_actor" /></p>
		<p class="extvalue"><%= movieInterest.getFavoriteActor() %></p>
	</div>
	<div class="extfieldcontainer"></div>
</c:if>

<c:if test="<%= (user != null && selectedContact != null) && (user.getContactId() == selectedContact.getContactId()) %>">
	
	<portlet:renderURL var="editProfile" portletMode="edit" />
	
	<aui:button-row>
		<aui:button value="edit_your_profile" onClick="<%= editProfile %>"/>
	</aui:button-row>
</c:if>
