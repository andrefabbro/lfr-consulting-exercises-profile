
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
import com.liferay.portal.kernel.util.StringUtil;
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

	private List<ResultRow> resultRows = new ArrayList<ResultRow>();

	private int total = 0;

	private Hits results;

	private String prepareContent(String content) {

		String aux = StringUtil.wrap(content);
		String[] arrcontent = StringUtil.split(aux, StringPool.NEW_LINE);

		return (arrcontent.length > 1) ? arrcontent[0] + StringPool.SPACE +
			StringPool.TRIPLE_PERIOD : arrcontent[0];
	}

	/**
	 * Perform the search against the lucene
	 */
	private void performSearch(
		String keywords, int start, int end, SearchContext searchContext)
		throws IOException, PortletException, SearchException {

		Indexer indexer =
			IndexerRegistryUtil.getIndexer(com.amf.user.profile.model.UserProfile.class);

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

		results = indexer.search(searchContext);
		total = results.getLength();
		resultRows = new ArrayList<ResultRow>();

		// The search process should not hit the database at all, only Lucene
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
				row.getData().put(Field.CONTENT, prepareContent(content));

				pos++;
				resultRows.add(row);
			}
		}
	}

	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response)
		throws IOException, PortletException {

		try {

			ParamUtil.print(request);

			String keywords = request.getParameter("keywords");

			int start = 0;
			int end = 5;

			if (request.getParameter("start") != null)
				start = Integer.valueOf(request.getParameter("start"));
			if (request.getParameter("end") != null)
				end = Integer.valueOf(request.getParameter("end"));

			SearchContext searchContext =
				SearchContextFactory.getInstance(PortalUtil.getHttpServletRequest(request));

			this.performSearch(keywords, start, end, searchContext);

			JSONArray usersJsonArray = JSONFactoryUtil.createJSONArray();

			JSONObject root = JSONFactoryUtil.createJSONObject();
			root.put("start", start);
			root.put("end", end);
			root.put("total", total);

			for (ResultRow row : resultRows) {

				String content =
					prepareContent((String) row.getData().get(Field.CONTENT));

				JSONObject jsonUser = JSONFactoryUtil.createJSONObject();
				jsonUser.put(
					Field.TITLE, (String) row.getData().get(Field.TITLE));
				jsonUser.put(Field.CONTENT, content);

				usersJsonArray.put(jsonUser);
			}

			if (total > 0)
				root.put("results", usersJsonArray);
			
			System.out.println(root.toString());

			PrintWriter out = response.getWriter();
			out.print(root.toString());
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		super.serveResource(request, response);
	}

	@Override
	public void doView(RenderRequest request, RenderResponse response)
		throws IOException, PortletException {

		if (request.getAttribute("resultRows") == null) {
			try {

				String keywords =
					ParamUtil.getString(request, "keywords", StringPool.BLANK);

				int start = ParamUtil.getInteger(request, "start", 0);
				int end = ParamUtil.getInteger(request, "end", 3);

				SearchContext searchContext =
					SearchContextFactory.getInstance(PortalUtil.getHttpServletRequest(request));

				performSearch(keywords, start, end, searchContext);

				request.setAttribute("start", start);
				request.setAttribute("end", end);
				request.setAttribute("total", total);
				request.setAttribute("resultRows", resultRows);

			}
			catch (SearchException e) {
				e.printStackTrace();
			}
		}

		super.doView(request, response);
	}

}
