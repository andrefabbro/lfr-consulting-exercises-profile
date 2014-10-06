/**
 * 
 */

package com.amf.user.profile.model.extimpl;

import com.amf.user.profile.model.UserProfile;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.expando.model.ExpandoBridge;

import java.lang.reflect.Proxy;
import java.util.Locale;
import java.util.Map;

/**
 * @author andrefabbro
 */
public class UserProfileImpl extends UserProfileBaseImpl {

	public UserProfileImpl() {

	}

	@Override
	public boolean isCachedModel() {
		return super.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return super.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return super.isNew();
	}

	@Override
	public void resetOriginalValues() {
		super.resetOriginalValues();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		super.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel) {
		super.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		super.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		super.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		super.setModelAttributes(attributes);
	}

	@Override
	public void setNew(boolean n) {
		super.setNew(n);
	}

	@Override
	public CacheModel<UserProfile> toCacheModel() {
		return super.toCacheModel();
	}

	@Override
	public UserProfile toEscapedModel() {

		if (isEscapedModel()) {
			return this;
		}
		else {
			return (UserProfile) Proxy.newProxyInstance(
				UserProfile.class.getClassLoader(), new Class[] {
					UserProfile.class
				}, new AutoEscapeBeanHandler(this));
		}
	}

	@Override
	public UserProfile toUnescapedModel() {
		return this;
	}

	@Override
	protected Locale getLocale(String languageId) {

		// TODO Auto-generated method stub
		return super.getLocale(languageId);
	}

}
