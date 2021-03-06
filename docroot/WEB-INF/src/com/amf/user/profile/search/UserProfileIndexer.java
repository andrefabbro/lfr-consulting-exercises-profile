/**
 * 
 */

package com.amf.user.profile.search;

import com.amf.user.profile.model.UserProfile;
import com.amf.user.profile.service.UserProfilePersistenceUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.DocumentImpl;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.PermissionChecker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletURL;

/**
 * @author andrefabbro
 */
public class UserProfileIndexer extends BaseIndexer {

	public static final String PORTLET_ID = "user-profile";

	public static final String[] CLASS_NAMES = {
		UserProfile.class.getName()
	};

	public UserProfileIndexer() {

		setFilterSearch(true);
		setPermissionAware(true);
	}

	@Override
	public boolean hasPermission(
		PermissionChecker permissionChecker, String entryClassName,
		long entryClassPK, String actionId)
		throws Exception {

		// TODO: change!
		// return UserProfileTOPermission.contains(permissionChecker,
		// entryClassPK, ActionKeys.VIEW);
		return true;
	}

	@Override
	public String[] getClassNames() {

		return CLASS_NAMES;
	}

	@Override
	public String getPortletId() {

		return PORTLET_ID;
	}

	@Override
	protected void doDelete(Object obj)
		throws Exception {

		UserProfile entity = (UserProfile) obj;
		Document document = new DocumentImpl();

		document.addUID(PORTLET_ID, entity.getPrimaryKey());

		String searchEngineId = SearchEngineUtil.getDefaultSearchEngineId();
		SearchEngineUtil.deleteDocument(
			searchEngineId, entity.getCompanyId(), document.get(Field.UID));
	}

	@Override
	protected Document doGetDocument(Object obj)
		throws Exception {

		UserProfile entity = (UserProfile) obj;

		Document document = getBaseModelDocument(PORTLET_ID, entity);
		
		// document.addUID(PORTLET_ID, entity.getPrimaryKey());

		document.addKeyword(Field.GROUP_ID, getSiteGroupId(entity.getGroupId()));
		document.addKeyword(Field.SCOPE_GROUP_ID, entity.getGroupId());
		document.addKeyword(Field.USER_ID, entity.getUserId());
		document.addKeyword(Field.USER_NAME, entity.getContact().getFullName());

		document.addText(Field.TITLE, entity.getUserName());
		document.addText(Field.DESCRIPTION, entity.getContact().getFullName());

		// content is the about me
		document.addText(Field.CONTENT, entity.getGeneralProfile().getAboutMe());

		// document.addText("firstName", entity.getContact().getFirstName());
		// document.addText("lastName", entity.getContact().getLastName());

		document.addText(
			"favoriteQuotes", entity.getGeneralProfile().getFavoriteQuotes());
		document.addText(
			"favoriteMovie", entity.getMovieInterest().getFavoriteMovie());
		document.addText(
			"favoriteGenre", entity.getMovieInterest().getFavoriteGenre());
		document.addText(
			"leastFavMovie", entity.getMovieInterest().getLeastFavMovie());
		document.addText(
			"favoriteActor", entity.getMovieInterest().getFavoriteActor());

		System.out.println("Document lucene created with successfully");

		return document;
	}

	@Override
	protected Summary doGetSummary(
		Document document, Locale locale, String snippet, PortletURL portletURL)
		throws Exception {

		String title = document.get(Field.TITLE);

		String content = snippet;

		if (Validator.isNull(snippet)) {
			content = document.get(Field.DESCRIPTION);

			if (Validator.isNull(content)) {
				content = StringUtil.shorten(document.get(Field.CONTENT), 200);
			}
		}

		// TODO: verificar aqui para direcionar para a pagina correta
		String entityId = document.get(Field.ENTRY_CLASS_PK);

		portletURL.setParameter("mvcPath", "/html/profilesearch/view.jsp");
		portletURL.setParameter("entityId", entityId);

		return new Summary(title, content, portletURL);
	}

	@Override
	protected void doReindex(Object obj)
		throws Exception {

		UserProfile entity = (UserProfile) obj;
		String searchEngineId = SearchEngineUtil.getDefaultSearchEngineId();

		Document document = getDocument(entity);

		SearchEngineUtil.updateDocument(
			searchEngineId, entity.getCompanyId(), document);
	}

	@Override
	protected void doReindex(String className, long classPK)
		throws Exception {

		UserProfile entity = UserProfilePersistenceUtil.getUserProfile(classPK);
		doReindex(entity);
	}

	@Override
	protected void doReindex(String[] ids)
		throws Exception {

		long companyId = GetterUtil.getLong(ids[0]);

		doReindexAll(companyId);
	}

	private void doReindexAll(long companyId)
		throws Exception {

		int count = UserProfilePersistenceUtil.getUserProfileCount();

		int pages = count / Indexer.DEFAULT_INTERVAL;

		for (int i = 0; i <= pages; i++) {
			int start = (i * Indexer.DEFAULT_INTERVAL);
			int end = start + Indexer.DEFAULT_INTERVAL;

			reindexEntity(companyId, start, end);
		}
	}

	protected void reindexEntity(long companyId, int start, int end)
		throws Exception {

		List<UserProfile> entities =
			UserProfilePersistenceUtil.getUserProfiles(start, end);

		if (entities.isEmpty()) {
			return;
		}

		Collection<Document> documents = new ArrayList<Document>();

		for (UserProfile entity : entities) {
			Document document = getDocument(entity);

			documents.add(document);
		}

		String searchEngineId = SearchEngineUtil.getDefaultSearchEngineId();
		SearchEngineUtil.updateDocuments(searchEngineId, companyId, documents);
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {

		return PORTLET_ID;
	}

}
