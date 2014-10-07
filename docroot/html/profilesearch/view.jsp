<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ include file="init.jsp"%>
<%
    String redirect = ParamUtil.getString(request, "redirect");
    String keywords = ParamUtil.getString(request, "keywords");
    int start = (Integer) renderRequest.getAttribute("start");
    int end = (Integer) renderRequest.getAttribute("end");
    int total = (Integer) renderRequest.getAttribute("total");
    List<ResultRow> resultRows = (List<ResultRow>) renderRequest.getAttribute("resultRows");
    int delta = 3;
    int startlastpage = total - (total % delta);
    int nextend = delta*2;
%>
<style type="text/css">
	a:hover { cursor:pointer; }
</style>

<aui:form name="fm">
    
    <aui:input name="redirect" type="hidden" value="<%= redirect %>" />

    <liferay-ui:header backURL="<%= redirect %>" title="Profile Search" />
    
    <span class="aui-search-bar">
        <aui:input inlineField="<%= true %>" label="" name="keywords" size="120" title="search-entries" type="text" value="<%= keywords %>" />
        <aui:button onclick="doSearch(0, 3);" value="Search" type="button" name="searchajax" />
    </span>
    <div id="searchHeader"></div>
    <div id="searchResults">
	    <c:if test="${param.keywords != null}">
	    	<h3><c:out value="Search Results for: ${param.keywords}" /></h3>
	    </c:if>
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
    <div id="pagination">
    	Showing <%=start+1 %> - <%=end %> of <%=total %> Results<br/>
    	First | Previous |
    	<c:choose>
			<c:when test="${total <= delta}">Next | </c:when>
			<c:otherwise><a onclick="doSearch(<%= delta %>, <%= nextend %>)">Next</a> | </c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${startlastpage >= total}">Last</c:when>
			<c:otherwise><a onclick="doSearch(<%= startlastpage %>, <%= total %>)">Last</a></c:otherwise>
		</c:choose>
    </div>
    
    <div id="wait"
		style="display:none; width: 69px; height: 89px; border: 1px solid black; position: absolute; top: 50%; left: 50%; padding: 2px;">
		<img src='http://www.w3schools.com/jquery/demo_wait.gif' width="64" height="64" /><br>Loading...
	</div>
	
	<div id="no-results-message" style="display:none;">
		<liferay-ui:message key="no-members-found-with-criteria" />
	</div>

</aui:form>

<portlet:resourceURL var="searchAjaxURL">
    <portlet:param name="searchAjaxURL" value="/html/profilesearch/view.jsp" />
</portlet:resourceURL>

<aui:script>
    function doSearch(start, end) {
    
    	AUI().use('aui-base','aui-io-request', function(A) {
		
			A.one('#wait').setStyle('display', 'block');
			
			var allRows = "";
			var searchStr = document.getElementById("<portlet:namespace />keywords").value;
			
			A.io.request('<%= searchAjaxURL %>', {
		  		dataType: 'json',
		  		method: 'POST',
		  		data: { 
		  			<portlet:namespace/>keywords: searchStr, 
		  			<portlet:namespace/>start: start, 
		  			<portlet:namespace/>end: end
		  		},
		  		on: {
					success: function() {
						
						var data = this.get('responseData');
						
						A.one('#searchHeader').empty();
						if(searchStr != '') A.one('#searchHeader').setHTML('<h3>Search Results for: ' + searchStr + '</h3>');
						
						A.one('#pagination').empty();
						
						if(data.total >= 0) {
						
							A.one('#no-results-message').setStyle('display', 'none');
							
							var delta = <%=delta%>;
							var startlastpage = data.total - (data.total % delta);
							
							var pagination = 'Showing ' + (data.start+1) + ' - ' + ((data.end >= data.total) ? data.total : data.end) + ' of ' + data.total + ' Results';
							
							var firstbtn = (data.start == 0) ? 'First | ' : '<a onclick="doSearch(0, ' + delta + ')">First</a> | ';
							var previousbtn = (data.start == 0) ? 'Previous | ' : '<a onclick="doSearch(' + (data.start - delta) + ', ' + (data.end - delta) + ')">Previous</a> | ';
							var nextbtn = (data.total > data.end) ? '<a onclick="doSearch(' + (data.start + delta) + ', ' + (data.end + delta) + ')">Next</a> | ' : 'Next | ';
							var lastbtn = (data.end >= data.total) ? 'Last' : '<a onclick="doSearch(' + startlastpage + ', ' + (startlastpage + delta) + ')">Last</a>';
							
							A.one('#pagination').setHTML(pagination + '<br/>' + firstbtn + previousbtn + nextbtn + lastbtn);
							
							A.Array.each(data.results, function(obj, idx) {
								
								var tableRow = '<p><a href="/member/-/profile/view/' + obj.title + '"><strong>' + obj.title + '</strong><br />' + obj.content + '</a></p>';
			  	                
			  	                allRows = allRows.trim() + tableRow.trim();
			  	                
			  	                A.one('#searchResults').empty();
			  	                A.one('#searchResults').setHTML(allRows.trim());
			  	                A.one('#wait').setStyle('display','none');
			     			});
						} else {
							A.one('#no-results-message').setStyle('display', 'block');
						}
		    		}
		  		}
			});
		});
		
    }
</aui:script>
