/**
 * 
 */

package com.amf.user.profile.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.model.ResourcedModel;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;
import java.util.Date;

/**
 * @author andrefabbro
 */
public interface UserProfileModel extends BaseModel<UserProfile>, GroupedModel {

	public long getPrimaryKey();

	public void setPrimaryKey(long primaryKey);

	public long getUserProfileId();

	public void setUserProfileId(long userProfileId);

	public GeneralProfile getGeneralProfile();

	public void setGeneralProfile(GeneralProfile generalProfile);

	public MovieInterest getMovieInterest();

	public void setMovieInterest(MovieInterest movieInterest);

	public Contact getContact();

	public void setContact(Contact contact);
	
	public String getAboutMe();

	public void setAboutMe(String aboutMe);

	@AutoEscape
	public String getFavoriteMovie();

	public void setFavoriteMovie(String favoriteMovie);
	
	@AutoEscape
	public String getFavoriteGenre();
	
	public void setFavoriteGenre(String favoriteGenre);
	
	@AutoEscape
	public String getLeastFavMovie();
	
	public void setLeastFavMovie(String leastFavMovie);
	
	@AutoEscape
	public String getFavoriteActor();
	
	public void setFavoriteActor(String favoriteActor);
	
	@AutoEscape
	public String getFavoriteQuotes();

	public void setFavoriteQuotes(String favoriteQuotes);

	public void createFromAttributes(
		Contact contact, GeneralProfile generalProfile,
		MovieInterest movieInterest);

	@Override
	public long getGroupId();

	@Override
	public void setGroupId(long groupId);

	@Override
	public long getCompanyId();

	@Override
	public void setCompanyId(long companyId);

	@Override
	public long getUserId();

	@Override
	public void setUserId(long userId);

	@Override
	public String getUserUuid()
		throws SystemException;

	@Override
	public void setUserUuid(String userUuid);

	@AutoEscape
	@Override
	public String getUserName();

	@Override
	public void setUserName(String userName);

	@Override
	public Date getCreateDate();

	@Override
	public void setCreateDate(Date createDate);

	@Override
	public Date getModifiedDate();

	@Override
	public void setModifiedDate(Date modifiedDate);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(UserProfile userProfile);

	@Override
	public int hashCode();

	@Override
	public CacheModel<UserProfile> toCacheModel();

	@Override
	public UserProfile toEscapedModel();

	@Override
	public UserProfile toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}
