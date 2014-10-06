<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ include file="init.jsp"%>
<%
    String redirect = ParamUtil.getString(request, "redirect");
    String keywords = ParamUtil.getString(request, "keywords");
    int total = (Integer) renderRequest.getAttribute("total");
    List<ResultRow> resultRows = (List<ResultRow>) renderRequest.getAttribute("resultRows");
%>

<portlet:actionURL name="searchAction" var="searchActionURL" />

<aui:form action="<%= searchActionURL %>" method="post" name="fm">
    
    <aui:input name="redirect" type="hidden" value="<%= redirect %>" />

    <liferay-ui:header backURL="<%= redirect %>" title="Profile Search" />
    
    <span class="aui-search-bar">
        <aui:input inlineField="<%= true %>" label="" name="keywords" size="120" title="search-entries" type="text" value="<%= keywords %>" />
        <aui:button type="submit" value="search" />
        <aui:button onclick="doSearch();" value="Ajax Request" type="button" name="searchajax" />
    </span>
    
    <div id="searchResults">
    
	    <c:if test="${param.keywords != null}">
	    	<br />
	    	<h3><c:out value="Search Results for: ${param.keywords}" /></h3>
	    </c:if>
	    
	    <br />
	    
	    <c:forEach items="${resultRows}" var="row">
	    	<p>
	    		<a href="/member/-/profile/view/${row.data['title']}">
	    		<strong><c:out value="${row.data['title']}" /></strong>
	    		<br />
	    		<c:out value="${row.data['content']}" />
	    		</a>
	    	</p>
	    </c:forEach>
    
    </div>
    
    <div id="wait"
		style="display:none; width: 69px; height: 89px; border: 1px solid black; position: absolute; top: 50%; left: 50%; padding: 2px;">
		<img src='http://www.w3schools.com/jquery/demo_wait.gif' width="64" height="64" /><br>Loading...
	</div>

</aui:form>

<%
if (Validator.isNotNull(keywords)) {
    String currentURL = PortalUtil.getCurrentURL(request);
    PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, "search") + ": " + keywords, currentURL);
}
%>

<portlet:renderURL var="auiAjaxURL">
	<portlet:param name="mvcPath" value="/html/jsps/aui_ajax.jsp"/>
</portlet:renderURL>

<portlet:resourceURL var="searchAjaxURL">
    <portlet:param name="searchAjaxURL" value="/html/profilesearch/view.jsp" />
</portlet:resourceURL>

<aui:script>
    function doSearch() {
    
    	AUI().use('aui-base','aui-io-request', function(A) {
		
			A.one('#wait').setStyle('display', 'block');
			
			var allRows = "";
			var searchStr = document.getElementById("<portlet:namespace />keywords").value;
			
			A.io.request('<%= searchAjaxURL %>', {
		  		dataType: 'json',
		  		method: 'POST',
		  		data: { 
		  			<portlet:namespace/>keywords: searchStr, 
		  			<portlet:namespace/>start: '0', 
		  			<portlet:namespace/>end: '5'
		  		},
		  		on: {
					success: function() {
						
						var data = this.get('responseData');
						
						A.Array.each(data, function(obj, idx) {
							
							var tableRow = '<p><a href="/member/-/profile/view/' + obj.title + '"><strong>' + obj.title + '</strong><br />' + obj.content + '</a></p>';
		  	                
		  	                allRows = allRows.trim() + tableRow.trim();
		  	                
		  	                A.one('#searchResults').empty();
		  	                A.one('#searchResults').setHTML(allRows.trim());
		  	                A.one('#wait').setStyle('display','none');
		     			});
		    		}
		  		}
			});
		});
		
    }
</aui:script>
