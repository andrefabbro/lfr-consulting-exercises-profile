/**
 * 
 */

package com.amf.user.profile.model.extimpl;

import com.amf.user.profile.model.GeneralProfile;
import com.amf.user.profile.model.MovieInterest;
import com.amf.user.profile.model.UserProfile;
import com.amf.user.profile.model.UserProfileModel;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;
import java.util.Date;

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

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCreateDate(Date createDate) {

		// TODO Auto-generated method stub

	}

	@Override
	public Date getModifiedDate() {

		// TODO Auto-generated method stub
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

		userProfileImpl.resetOriginalValues();

		return userProfileImpl;
	}

}
