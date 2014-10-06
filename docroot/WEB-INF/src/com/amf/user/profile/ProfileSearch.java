
package com.amf.user.profile;

import com.liferay.portal.kernel.dao.search.ResultRow;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

/**
 * Portlet implementation class ProfileSearch
 */
public class ProfileSearch extends MVCPortlet {

	/**
	 * Perform the search against the lucene
	 */
	private void proccessSearch(PortletRequest request, PortletResponse response)
		throws IOException, PortletException, SearchException {

		String keywords =
			ParamUtil.getString(request, "keywords", StringPool.BLANK);

		// ParamUtil.print(request);
		// System.out.println("keywords: " + keywords);

		int start = ParamUtil.getInteger(request, "start", 0);
		int end = ParamUtil.getInteger(request, "end", 5);

		Indexer indexer =
			IndexerRegistryUtil.getIndexer(com.amf.user.profile.model.UserProfile.class);

		SearchContext searchContext =
			SearchContextFactory.getInstance(PortalUtil.getHttpServletRequest(request));

		StringBuilder query = new StringBuilder("");
		if (!keywords.equals(StringPool.BLANK)) {
			Set<String> fields = new HashSet<String>();

			// TODO: check permissions here???
			fields.add(Field.TITLE);
			fields.add(Field.CONTENT);
			fields.add("aboutMe");
			fields.add("favoriteQuotes");
			fields.add("favoriteMovie");
			fields.add("favoriteGenre");
			fields.add("leastFavMovie");
			fields.add("favoriteActor");

			String connector = StringPool.BLANK;
			for (String field : fields) {
				query.append(connector).append(field).append(":").append("\"").append(
					keywords).append("\"");
				if (connector.equals(StringPool.BLANK))
					connector = " OR ";
			}
		}

		searchContext.setEnd(end);
		searchContext.setKeywords(query.toString());
		searchContext.setStart(start);

		Hits results = indexer.search(searchContext);
		int total = results.getLength();

		List<com.amf.user.profile.model.UserProfile> profiles =
			new ArrayList<com.amf.user.profile.model.UserProfile>();

		List<ResultRow> resultRows = new ArrayList<ResultRow>();

		if (results != null) {

			List<Document> documents = results.toList();

			int pos = 1;
			for (Document doc : documents) {

				long entityId =
					GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
				ResultRow row = new ResultRow(doc, entityId, pos);

				String title = GetterUtil.getString(doc.get(Field.TITLE));
				String content = GetterUtil.getString(doc.get(Field.CONTENT));

				// Position
				row.addText(start + pos + 1 + StringPool.PERIOD);

				row.addText(title);
				if (row.getData() == null)
					row.setData(new HashMap<String, Object>());
				row.getData().put(Field.TITLE, title);
				row.getData().put(Field.CONTENT, content);

				pos++;
				resultRows.add(row);
			}
		}

		request.setAttribute("total", total);
		request.setAttribute("resultRows", resultRows);
	}

	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response)
		throws IOException, PortletException {

		System.out.println("Hello World from Ajax Request!!!!!!!!");
		
		try {
			
			ParamUtil.print(request);
			
			
			String keywords = request.getParameter("keywords");
			
			System.out.println("Keywords: " + keywords);

			this.proccessSearch(request, response);

			JSONObject jsonUser = null;
			JSONArray usersJsonArray = JSONFactoryUtil.createJSONArray();

			List<ResultRow> resultRows =
				(List<ResultRow>) request.getAttribute("resultRows");

			for (ResultRow row : resultRows) {
				jsonUser = JSONFactoryUtil.createJSONObject();
				jsonUser.put(
					Field.TITLE, (String) row.getData().get(Field.TITLE));
				jsonUser.put(
					Field.CONTENT, (String) row.getData().get(Field.CONTENT));

				usersJsonArray.put(jsonUser);
			}

			PrintWriter out = response.getWriter();
			out.print(usersJsonArray.toString());
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		super.serveResource(request, response);
	}

	public void searchAction(ActionRequest request, ActionResponse response)
		throws IOException, PortletException {

		try {
			this.proccessSearch(request, response);
		}
		catch (SearchException e) {
			e.printStackTrace();
		}

		PortalUtil.copyRequestParameters(request, response);
	}

	@Override
	public void doView(RenderRequest request, RenderResponse response)
		throws IOException, PortletException {

		if (request.getAttribute("resultRows") == null) {
			try {
				this.proccessSearch(request, response);
			}
			catch (SearchException e) {
				e.printStackTrace();
			}
		}

		super.doView(request, response);
	}

}
