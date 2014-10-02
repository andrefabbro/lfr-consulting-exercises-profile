/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.amf.user.profile.service.persistence;

import com.amf.user.profile.NoSuchGeneralProfileException;
import com.amf.user.profile.model.GeneralProfile;
import com.amf.user.profile.model.impl.GeneralProfileImpl;
import com.amf.user.profile.model.impl.GeneralProfileModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the general profile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author andrefabbro
 * @see GeneralProfilePersistence
 * @see GeneralProfileUtil
 * @generated
 */
public class GeneralProfilePersistenceImpl extends BasePersistenceImpl<GeneralProfile>
	implements GeneralProfilePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GeneralProfileUtil} to access the general profile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GeneralProfileImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GeneralProfileModelImpl.ENTITY_CACHE_ENABLED,
			GeneralProfileModelImpl.FINDER_CACHE_ENABLED,
			GeneralProfileImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GeneralProfileModelImpl.ENTITY_CACHE_ENABLED,
			GeneralProfileModelImpl.FINDER_CACHE_ENABLED,
			GeneralProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GeneralProfileModelImpl.ENTITY_CACHE_ENABLED,
			GeneralProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_USERID = new FinderPath(GeneralProfileModelImpl.ENTITY_CACHE_ENABLED,
			GeneralProfileModelImpl.FINDER_CACHE_ENABLED,
			GeneralProfileImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUserId", new String[] { Long.class.getName() },
			GeneralProfileModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(GeneralProfileModelImpl.ENTITY_CACHE_ENABLED,
			GeneralProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the general profile where userId = &#63; or throws a {@link com.amf.user.profile.NoSuchGeneralProfileException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching general profile
	 * @throws com.amf.user.profile.NoSuchGeneralProfileException if a matching general profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralProfile findByUserId(long userId)
		throws NoSuchGeneralProfileException, SystemException {
		GeneralProfile generalProfile = fetchByUserId(userId);

		if (generalProfile == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchGeneralProfileException(msg.toString());
		}

		return generalProfile;
	}

	/**
	 * Returns the general profile where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching general profile, or <code>null</code> if a matching general profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralProfile fetchByUserId(long userId) throws SystemException {
		return fetchByUserId(userId, true);
	}

	/**
	 * Returns the general profile where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching general profile, or <code>null</code> if a matching general profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralProfile fetchByUserId(long userId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERID,
					finderArgs, this);
		}

		if (result instanceof GeneralProfile) {
			GeneralProfile generalProfile = (GeneralProfile)result;

			if ((userId != generalProfile.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_GENERALPROFILE_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				List<GeneralProfile> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
						finderArgs, list);
				}
				else {
					GeneralProfile generalProfile = list.get(0);

					result = generalProfile;

					cacheResult(generalProfile);

					if ((generalProfile.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
							finderArgs, generalProfile);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (GeneralProfile)result;
		}
	}

	/**
	 * Removes the general profile where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the general profile that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralProfile removeByUserId(long userId)
		throws NoSuchGeneralProfileException, SystemException {
		GeneralProfile generalProfile = findByUserId(userId);

		return remove(generalProfile);
	}

	/**
	 * Returns the number of general profiles where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching general profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GENERALPROFILE_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "generalProfile.userId = ?";

	public GeneralProfilePersistenceImpl() {
		setModelClass(GeneralProfile.class);
	}

	/**
	 * Caches the general profile in the entity cache if it is enabled.
	 *
	 * @param generalProfile the general profile
	 */
	@Override
	public void cacheResult(GeneralProfile generalProfile) {
		EntityCacheUtil.putResult(GeneralProfileModelImpl.ENTITY_CACHE_ENABLED,
			GeneralProfileImpl.class, generalProfile.getPrimaryKey(),
			generalProfile);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
			new Object[] { generalProfile.getUserId() }, generalProfile);

		generalProfile.resetOriginalValues();
	}

	/**
	 * Caches the general profiles in the entity cache if it is enabled.
	 *
	 * @param generalProfiles the general profiles
	 */
	@Override
	public void cacheResult(List<GeneralProfile> generalProfiles) {
		for (GeneralProfile generalProfile : generalProfiles) {
			if (EntityCacheUtil.getResult(
						GeneralProfileModelImpl.ENTITY_CACHE_ENABLED,
						GeneralProfileImpl.class, generalProfile.getPrimaryKey()) == null) {
				cacheResult(generalProfile);
			}
			else {
				generalProfile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all general profiles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GeneralProfileImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GeneralProfileImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the general profile.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GeneralProfile generalProfile) {
		EntityCacheUtil.removeResult(GeneralProfileModelImpl.ENTITY_CACHE_ENABLED,
			GeneralProfileImpl.class, generalProfile.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(generalProfile);
	}

	@Override
	public void clearCache(List<GeneralProfile> generalProfiles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GeneralProfile generalProfile : generalProfiles) {
			EntityCacheUtil.removeResult(GeneralProfileModelImpl.ENTITY_CACHE_ENABLED,
				GeneralProfileImpl.class, generalProfile.getPrimaryKey());

			clearUniqueFindersCache(generalProfile);
		}
	}

	protected void cacheUniqueFindersCache(GeneralProfile generalProfile) {
		if (generalProfile.isNew()) {
			Object[] args = new Object[] { generalProfile.getUserId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID, args,
				generalProfile);
		}
		else {
			GeneralProfileModelImpl generalProfileModelImpl = (GeneralProfileModelImpl)generalProfile;

			if ((generalProfileModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { generalProfile.getUserId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID, args,
					generalProfile);
			}
		}
	}

	protected void clearUniqueFindersCache(GeneralProfile generalProfile) {
		GeneralProfileModelImpl generalProfileModelImpl = (GeneralProfileModelImpl)generalProfile;

		Object[] args = new Object[] { generalProfile.getUserId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);

		if ((generalProfileModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
			args = new Object[] { generalProfileModelImpl.getOriginalUserId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);
		}
	}

	/**
	 * Creates a new general profile with the primary key. Does not add the general profile to the database.
	 *
	 * @param generalProfileId the primary key for the new general profile
	 * @return the new general profile
	 */
	@Override
	public GeneralProfile create(long generalProfileId) {
		GeneralProfile generalProfile = new GeneralProfileImpl();

		generalProfile.setNew(true);
		generalProfile.setPrimaryKey(generalProfileId);

		return generalProfile;
	}

	/**
	 * Removes the general profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param generalProfileId the primary key of the general profile
	 * @return the general profile that was removed
	 * @throws com.amf.user.profile.NoSuchGeneralProfileException if a general profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralProfile remove(long generalProfileId)
		throws NoSuchGeneralProfileException, SystemException {
		return remove((Serializable)generalProfileId);
	}

	/**
	 * Removes the general profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the general profile
	 * @return the general profile that was removed
	 * @throws com.amf.user.profile.NoSuchGeneralProfileException if a general profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralProfile remove(Serializable primaryKey)
		throws NoSuchGeneralProfileException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GeneralProfile generalProfile = (GeneralProfile)session.get(GeneralProfileImpl.class,
					primaryKey);

			if (generalProfile == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGeneralProfileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(generalProfile);
		}
		catch (NoSuchGeneralProfileException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected GeneralProfile removeImpl(GeneralProfile generalProfile)
		throws SystemException {
		generalProfile = toUnwrappedModel(generalProfile);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(generalProfile)) {
				generalProfile = (GeneralProfile)session.get(GeneralProfileImpl.class,
						generalProfile.getPrimaryKeyObj());
			}

			if (generalProfile != null) {
				session.delete(generalProfile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (generalProfile != null) {
			clearCache(generalProfile);
		}

		return generalProfile;
	}

	@Override
	public GeneralProfile updateImpl(
		com.amf.user.profile.model.GeneralProfile generalProfile)
		throws SystemException {
		generalProfile = toUnwrappedModel(generalProfile);

		boolean isNew = generalProfile.isNew();

		Session session = null;

		try {
			session = openSession();

			if (generalProfile.isNew()) {
				session.save(generalProfile);

				generalProfile.setNew(false);
			}
			else {
				session.merge(generalProfile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !GeneralProfileModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(GeneralProfileModelImpl.ENTITY_CACHE_ENABLED,
			GeneralProfileImpl.class, generalProfile.getPrimaryKey(),
			generalProfile);

		clearUniqueFindersCache(generalProfile);
		cacheUniqueFindersCache(generalProfile);

		return generalProfile;
	}

	protected GeneralProfile toUnwrappedModel(GeneralProfile generalProfile) {
		if (generalProfile instanceof GeneralProfileImpl) {
			return generalProfile;
		}

		GeneralProfileImpl generalProfileImpl = new GeneralProfileImpl();

		generalProfileImpl.setNew(generalProfile.isNew());
		generalProfileImpl.setPrimaryKey(generalProfile.getPrimaryKey());

		generalProfileImpl.setGeneralProfileId(generalProfile.getGeneralProfileId());
		generalProfileImpl.setGroupId(generalProfile.getGroupId());
		generalProfileImpl.setCompanyId(generalProfile.getCompanyId());
		generalProfileImpl.setUserId(generalProfile.getUserId());
		generalProfileImpl.setUserName(generalProfile.getUserName());
		generalProfileImpl.setCreateDate(generalProfile.getCreateDate());
		generalProfileImpl.setModifiedDate(generalProfile.getModifiedDate());
		generalProfileImpl.setAboutMe(generalProfile.getAboutMe());
		generalProfileImpl.setFavoriteQuotes(generalProfile.getFavoriteQuotes());

		return generalProfileImpl;
	}

	/**
	 * Returns the general profile with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the general profile
	 * @return the general profile
	 * @throws com.amf.user.profile.NoSuchGeneralProfileException if a general profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralProfile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGeneralProfileException, SystemException {
		GeneralProfile generalProfile = fetchByPrimaryKey(primaryKey);

		if (generalProfile == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGeneralProfileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return generalProfile;
	}

	/**
	 * Returns the general profile with the primary key or throws a {@link com.amf.user.profile.NoSuchGeneralProfileException} if it could not be found.
	 *
	 * @param generalProfileId the primary key of the general profile
	 * @return the general profile
	 * @throws com.amf.user.profile.NoSuchGeneralProfileException if a general profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralProfile findByPrimaryKey(long generalProfileId)
		throws NoSuchGeneralProfileException, SystemException {
		return findByPrimaryKey((Serializable)generalProfileId);
	}

	/**
	 * Returns the general profile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the general profile
	 * @return the general profile, or <code>null</code> if a general profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralProfile fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GeneralProfile generalProfile = (GeneralProfile)EntityCacheUtil.getResult(GeneralProfileModelImpl.ENTITY_CACHE_ENABLED,
				GeneralProfileImpl.class, primaryKey);

		if (generalProfile == _nullGeneralProfile) {
			return null;
		}

		if (generalProfile == null) {
			Session session = null;

			try {
				session = openSession();

				generalProfile = (GeneralProfile)session.get(GeneralProfileImpl.class,
						primaryKey);

				if (generalProfile != null) {
					cacheResult(generalProfile);
				}
				else {
					EntityCacheUtil.putResult(GeneralProfileModelImpl.ENTITY_CACHE_ENABLED,
						GeneralProfileImpl.class, primaryKey,
						_nullGeneralProfile);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GeneralProfileModelImpl.ENTITY_CACHE_ENABLED,
					GeneralProfileImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return generalProfile;
	}

	/**
	 * Returns the general profile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param generalProfileId the primary key of the general profile
	 * @return the general profile, or <code>null</code> if a general profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralProfile fetchByPrimaryKey(long generalProfileId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)generalProfileId);
	}

	/**
	 * Returns all the general profiles.
	 *
	 * @return the general profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GeneralProfile> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the general profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.amf.user.profile.model.impl.GeneralProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of general profiles
	 * @param end the upper bound of the range of general profiles (not inclusive)
	 * @return the range of general profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GeneralProfile> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the general profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.amf.user.profile.model.impl.GeneralProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of general profiles
	 * @param end the upper bound of the range of general profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of general profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GeneralProfile> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<GeneralProfile> list = (List<GeneralProfile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GENERALPROFILE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GENERALPROFILE;

				if (pagination) {
					sql = sql.concat(GeneralProfileModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GeneralProfile>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GeneralProfile>(list);
				}
				else {
					list = (List<GeneralProfile>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the general profiles from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GeneralProfile generalProfile : findAll()) {
			remove(generalProfile);
		}
	}

	/**
	 * Returns the number of general profiles.
	 *
	 * @return the number of general profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_GENERALPROFILE);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the general profile persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.amf.user.profile.model.GeneralProfile")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GeneralProfile>> listenersList = new ArrayList<ModelListener<GeneralProfile>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GeneralProfile>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(GeneralProfileImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GENERALPROFILE = "SELECT generalProfile FROM GeneralProfile generalProfile";
	private static final String _SQL_SELECT_GENERALPROFILE_WHERE = "SELECT generalProfile FROM GeneralProfile generalProfile WHERE ";
	private static final String _SQL_COUNT_GENERALPROFILE = "SELECT COUNT(generalProfile) FROM GeneralProfile generalProfile";
	private static final String _SQL_COUNT_GENERALPROFILE_WHERE = "SELECT COUNT(generalProfile) FROM GeneralProfile generalProfile WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "generalProfile.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GeneralProfile exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No GeneralProfile exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GeneralProfilePersistenceImpl.class);
	private static GeneralProfile _nullGeneralProfile = new GeneralProfileImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GeneralProfile> toCacheModel() {
				return _nullGeneralProfileCacheModel;
			}
		};

	private static CacheModel<GeneralProfile> _nullGeneralProfileCacheModel = new CacheModel<GeneralProfile>() {
			@Override
			public GeneralProfile toEntityModel() {
				return _nullGeneralProfile;
			}
		};
}