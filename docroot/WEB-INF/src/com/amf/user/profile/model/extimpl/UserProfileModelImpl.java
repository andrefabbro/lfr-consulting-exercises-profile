/**
 * 
 */

package com.amf.user.profile.model.extimpl;

import com.amf.user.profile.model.GeneralProfile;
import com.amf.user.profile.model.MovieInterest;
import com.amf.user.profile.model.UserProfile;
import com.amf.user.profile.model.UserProfileModel;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;
import java.lang.reflect.Proxy;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author andrefabbro
 */
public class UserProfileModelImpl extends BaseModelImpl<UserProfile>
	implements UserProfileModel {

	private String _userUuid;

	private long _userProfileId;

	private long _groupId;

	private long _companyId;

	private long _userId;

	private String _userName;

	private Contact _contact;

	private GeneralProfile _generalProfile;

	private MovieInterest _movieInterest;

	private String _aboutMe;

	private String _favoriteQuotes;

	private String _favoriteActor;

	private String _leastFavMovie;

	private String _favoriteGenre;

	private String _favoriteMovie;

	@Override
	public void createFromAttributes(
		Contact contact, GeneralProfile generalProfile,
		MovieInterest movieInterest) {

		try {
			setUserUuid(generalProfile.getUserUuid());
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		_userProfileId = generalProfile.getGeneralProfileId();
		_groupId = generalProfile.getGroupId();
		_companyId = generalProfile.getCompanyId();
		_userId = generalProfile.getUserId();
		_userName = generalProfile.getUserName();
		_contact = contact;
		_generalProfile = generalProfile;
		_movieInterest = movieInterest;
		
		_aboutMe = generalProfile.getAboutMe();
		_favoriteQuotes = generalProfile.getFavoriteQuotes();
		_favoriteActor = movieInterest.getFavoriteActor();
		_leastFavMovie = movieInterest.getLeastFavMovie();
		_favoriteGenre = movieInterest.getFavoriteGenre();
		_favoriteMovie = movieInterest.getFavoriteMovie();
	}

	@Override
	public Class<?> getModelClass() {

		return UserProfile.class;
	}

	@Override
	public String getModelClassName() {

		return UserProfile.class.getName();
	}

	@Override
	public long getPrimaryKey() {

		return _userProfileId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {

		setUserProfileId(primaryKey);
	}

	@Override
	public long getUserProfileId() {

		return _userProfileId;
	}

	@Override
	public void setUserProfileId(long userProfileId) {

		_userProfileId = userProfileId;
	}

	@Override
	public GeneralProfile getGeneralProfile() {

		return _generalProfile;
	}

	@Override
	public void setGeneralProfile(GeneralProfile generalProfile) {

		_generalProfile = generalProfile;
	}

	@Override
	public MovieInterest getMovieInterest() {

		return _movieInterest;
	}

	@Override
	public void setMovieInterest(MovieInterest movieInterest) {

		_movieInterest = movieInterest;
	}

	@Override
	public Contact getContact() {

		return _contact;
	}

	@Override
	public void setContact(Contact contact) {

		_contact = contact;
	}

	@Override
	public String getAboutMe() {

		return _aboutMe;
	}

	@Override
	public void setAboutMe(String aboutMe) {

		_aboutMe = aboutMe;
	}

	@Override
	public String getFavoriteMovie() {

		return _favoriteMovie;
	}

	@Override
	public void setFavoriteMovie(String favoriteMovie) {

		_favoriteMovie = favoriteMovie;
	}

	@Override
	public String getFavoriteGenre() {

		return _favoriteGenre;
	}

	@Override
	public void setFavoriteGenre(String favoriteGenre) {

		_favoriteGenre = favoriteGenre;
	}

	@Override
	public String getLeastFavMovie() {

		return _leastFavMovie;
	}

	@Override
	public void setLeastFavMovie(String leastFavMovie) {

		_leastFavMovie = leastFavMovie;
	}

	@Override
	public String getFavoriteActor() {

		return _favoriteActor;
	}

	@Override
	public void setFavoriteActor(String favoriteActor) {

		_favoriteActor = favoriteActor;
	}

	@Override
	public String getFavoriteQuotes() {

		return _favoriteQuotes;
	}

	@Override
	public void setFavoriteQuotes(String favoriteQuotes) {

		_favoriteQuotes = favoriteQuotes;
	}

	@Override
	public long getGroupId() {

		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {

		_groupId = groupId;
	}

	@Override
	public long getCompanyId() {

		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {

		_companyId = companyId;
	}

	@Override
	public long getUserId() {

		return _userId;
	}

	@Override
	public void setUserId(long userId) {

		_userId = userId;
	}

	@Override
	public String getUserUuid()
		throws SystemException {

		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {

		_userUuid = userUuid;
	}

	@JSON
	@Override
	public String getUserName() {

		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {

		_userName = userName;
	}

	@Override
	public Date getCreateDate() {

		_generalProfile.getCreateDate();
		return null;
	}

	@Override
	public void setCreateDate(Date createDate) {

		// TODO Auto-generated method stub

	}

	@Override
	public Date getModifiedDate() {

		_generalProfile.getModifiedDate();
		return null;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {

		// TODO Auto-generated method stub

	}

	@Override
	public Serializable getPrimaryKeyObj() {

		return _userProfileId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {

		setPrimaryKey(((Long) primaryKeyObj).longValue());
	}

	@Override
	public int compareTo(UserProfile userProfile) {

		long primaryKey = userProfile.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public String toXmlString() {

		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.amf.user.profile.model.UserProfile");
		sb.append("</model-name>");

		sb.append("<column><column-name>userProfileId</column-name><column-value><![CDATA[");
		sb.append(getUserProfileId());
		sb.append("]]></column-value></column>");
		sb.append("<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append("<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append("<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append("<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	@Override
	public Object clone() {

		UserProfile userProfileImpl = new UserProfileImpl();

		userProfileImpl.setUserProfileId(getUserProfileId());
		userProfileImpl.setGroupId(getGroupId());
		userProfileImpl.setCompanyId(getCompanyId());
		userProfileImpl.setUserId(getUserId());
		userProfileImpl.setUserName(getUserName());

		userProfileImpl.setContact(getContact());
		userProfileImpl.setGeneralProfile(getGeneralProfile());
		userProfileImpl.setMovieInterest(getMovieInterest());

		userProfileImpl.setAboutMe(getAboutMe());
		userProfileImpl.setFavoriteQuotes(getFavoriteQuotes());
		userProfileImpl.setFavoriteMovie(getFavoriteMovie());
		userProfileImpl.setFavoriteGenre(getFavoriteGenre());
		userProfileImpl.setLeastFavMovie(getLeastFavMovie());
		userProfileImpl.setFavoriteActor(getFavoriteActor());

		userProfileImpl.resetOriginalValues();

		return userProfileImpl;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {

		ExpandoBridge expandoBridge =
			ExpandoBridgeFactoryUtil.getExpandoBridge(
				getCompanyId(), getClass().getName());
		return expandoBridge;
	}

	@Override
	public Map<String, Object> getModelAttributes() {

		Map<String, Object> result = new HashMap<String, Object>();

		result.put("groupId", _groupId);
		result.put("userId", _userId);
		result.put("companyId", _companyId);
		result.put("userName", _userName);
		result.put("generalProfile", getGeneralProfile());
		result.put("contact", getContact());
		result.put("movieInterest", getMovieInterest());

		result.put("aboutMe", _aboutMe);
		result.put("favoriteQuotes", _favoriteQuotes);
		result.put("favoriteMovie", _favoriteMovie);
		result.put("favoriteGenre", _favoriteGenre);
		result.put("leastFavMovie", _leastFavMovie);
		result.put("favoriteActor", _favoriteActor);

		return result;
	}

}
