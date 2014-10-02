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

import com.amf.user.profile.NoSuchMovieInterestException;
import com.amf.user.profile.model.MovieInterest;
import com.amf.user.profile.model.impl.MovieInterestImpl;
import com.amf.user.profile.model.impl.MovieInterestModelImpl;

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
 * The persistence implementation for the movie interest service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author andrefabbro
 * @see MovieInterestPersistence
 * @see MovieInterestUtil
 * @generated
 */
public class MovieInterestPersistenceImpl extends BasePersistenceImpl<MovieInterest>
	implements MovieInterestPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MovieInterestUtil} to access the movie interest persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MovieInterestImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MovieInterestModelImpl.ENTITY_CACHE_ENABLED,
			MovieInterestModelImpl.FINDER_CACHE_ENABLED,
			MovieInterestImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MovieInterestModelImpl.ENTITY_CACHE_ENABLED,
			MovieInterestModelImpl.FINDER_CACHE_ENABLED,
			MovieInterestImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MovieInterestModelImpl.ENTITY_CACHE_ENABLED,
			MovieInterestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_USERID = new FinderPath(MovieInterestModelImpl.ENTITY_CACHE_ENABLED,
			MovieInterestModelImpl.FINDER_CACHE_ENABLED,
			MovieInterestImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByUserId",
			new String[] { Long.class.getName() },
			MovieInterestModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(MovieInterestModelImpl.ENTITY_CACHE_ENABLED,
			MovieInterestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the movie interest where userId = &#63; or throws a {@link com.amf.user.profile.NoSuchMovieInterestException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching movie interest
	 * @throws com.amf.user.profile.NoSuchMovieInterestException if a matching movie interest could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MovieInterest findByUserId(long userId)
		throws NoSuchMovieInterestException, SystemException {
		MovieInterest movieInterest = fetchByUserId(userId);

		if (movieInterest == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchMovieInterestException(msg.toString());
		}

		return movieInterest;
	}

	/**
	 * Returns the movie interest where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching movie interest, or <code>null</code> if a matching movie interest could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MovieInterest fetchByUserId(long userId) throws SystemException {
		return fetchByUserId(userId, true);
	}

	/**
	 * Returns the movie interest where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching movie interest, or <code>null</code> if a matching movie interest could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MovieInterest fetchByUserId(long userId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERID,
					finderArgs, this);
		}

		if (result instanceof MovieInterest) {
			MovieInterest movieInterest = (MovieInterest)result;

			if ((userId != movieInterest.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_MOVIEINTEREST_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				List<MovieInterest> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
						finderArgs, list);
				}
				else {
					MovieInterest movieInterest = list.get(0);

					result = movieInterest;

					cacheResult(movieInterest);

					if ((movieInterest.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
							finderArgs, movieInterest);
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
			return (MovieInterest)result;
		}
	}

	/**
	 * Removes the movie interest where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the movie interest that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MovieInterest removeByUserId(long userId)
		throws NoSuchMovieInterestException, SystemException {
		MovieInterest movieInterest = findByUserId(userId);

		return remove(movieInterest);
	}

	/**
	 * Returns the number of movie interests where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching movie interests
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

			query.append(_SQL_COUNT_MOVIEINTEREST_WHERE);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "movieInterest.userId = ?";

	public MovieInterestPersistenceImpl() {
		setModelClass(MovieInterest.class);
	}

	/**
	 * Caches the movie interest in the entity cache if it is enabled.
	 *
	 * @param movieInterest the movie interest
	 */
	@Override
	public void cacheResult(MovieInterest movieInterest) {
		EntityCacheUtil.putResult(MovieInterestModelImpl.ENTITY_CACHE_ENABLED,
			MovieInterestImpl.class, movieInterest.getPrimaryKey(),
			movieInterest);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
			new Object[] { movieInterest.getUserId() }, movieInterest);

		movieInterest.resetOriginalValues();
	}

	/**
	 * Caches the movie interests in the entity cache if it is enabled.
	 *
	 * @param movieInterests the movie interests
	 */
	@Override
	public void cacheResult(List<MovieInterest> movieInterests) {
		for (MovieInterest movieInterest : movieInterests) {
			if (EntityCacheUtil.getResult(
						MovieInterestModelImpl.ENTITY_CACHE_ENABLED,
						MovieInterestImpl.class, movieInterest.getPrimaryKey()) == null) {
				cacheResult(movieInterest);
			}
			else {
				movieInterest.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all movie interests.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MovieInterestImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MovieInterestImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the movie interest.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MovieInterest movieInterest) {
		EntityCacheUtil.removeResult(MovieInterestModelImpl.ENTITY_CACHE_ENABLED,
			MovieInterestImpl.class, movieInterest.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(movieInterest);
	}

	@Override
	public void clearCache(List<MovieInterest> movieInterests) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MovieInterest movieInterest : movieInterests) {
			EntityCacheUtil.removeResult(MovieInterestModelImpl.ENTITY_CACHE_ENABLED,
				MovieInterestImpl.class, movieInterest.getPrimaryKey());

			clearUniqueFindersCache(movieInterest);
		}
	}

	protected void cacheUniqueFindersCache(MovieInterest movieInterest) {
		if (movieInterest.isNew()) {
			Object[] args = new Object[] { movieInterest.getUserId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID, args,
				movieInterest);
		}
		else {
			MovieInterestModelImpl movieInterestModelImpl = (MovieInterestModelImpl)movieInterest;

			if ((movieInterestModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { movieInterest.getUserId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID, args,
					movieInterest);
			}
		}
	}

	protected void clearUniqueFindersCache(MovieInterest movieInterest) {
		MovieInterestModelImpl movieInterestModelImpl = (MovieInterestModelImpl)movieInterest;

		Object[] args = new Object[] { movieInterest.getUserId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);

		if ((movieInterestModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
			args = new Object[] { movieInterestModelImpl.getOriginalUserId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);
		}
	}

	/**
	 * Creates a new movie interest with the primary key. Does not add the movie interest to the database.
	 *
	 * @param movieInterestId the primary key for the new movie interest
	 * @return the new movie interest
	 */
	@Override
	public MovieInterest create(long movieInterestId) {
		MovieInterest movieInterest = new MovieInterestImpl();

		movieInterest.setNew(true);
		movieInterest.setPrimaryKey(movieInterestId);

		return movieInterest;
	}

	/**
	 * Removes the movie interest with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param movieInterestId the primary key of the movie interest
	 * @return the movie interest that was removed
	 * @throws com.amf.user.profile.NoSuchMovieInterestException if a movie interest with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MovieInterest remove(long movieInterestId)
		throws NoSuchMovieInterestException, SystemException {
		return remove((Serializable)movieInterestId);
	}

	/**
	 * Removes the movie interest with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the movie interest
	 * @return the movie interest that was removed
	 * @throws com.amf.user.profile.NoSuchMovieInterestException if a movie interest with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MovieInterest remove(Serializable primaryKey)
		throws NoSuchMovieInterestException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MovieInterest movieInterest = (MovieInterest)session.get(MovieInterestImpl.class,
					primaryKey);

			if (movieInterest == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMovieInterestException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(movieInterest);
		}
		catch (NoSuchMovieInterestException nsee) {
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
	protected MovieInterest removeImpl(MovieInterest movieInterest)
		throws SystemException {
		movieInterest = toUnwrappedModel(movieInterest);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(movieInterest)) {
				movieInterest = (MovieInterest)session.get(MovieInterestImpl.class,
						movieInterest.getPrimaryKeyObj());
			}

			if (movieInterest != null) {
				session.delete(movieInterest);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (movieInterest != null) {
			clearCache(movieInterest);
		}

		return movieInterest;
	}

	@Override
	public MovieInterest updateImpl(
		com.amf.user.profile.model.MovieInterest movieInterest)
		throws SystemException {
		movieInterest = toUnwrappedModel(movieInterest);

		boolean isNew = movieInterest.isNew();

		Session session = null;

		try {
			session = openSession();

			if (movieInterest.isNew()) {
				session.save(movieInterest);

				movieInterest.setNew(false);
			}
			else {
				session.merge(movieInterest);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MovieInterestModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(MovieInterestModelImpl.ENTITY_CACHE_ENABLED,
			MovieInterestImpl.class, movieInterest.getPrimaryKey(),
			movieInterest);

		clearUniqueFindersCache(movieInterest);
		cacheUniqueFindersCache(movieInterest);

		return movieInterest;
	}

	protected MovieInterest toUnwrappedModel(MovieInterest movieInterest) {
		if (movieInterest instanceof MovieInterestImpl) {
			return movieInterest;
		}

		MovieInterestImpl movieInterestImpl = new MovieInterestImpl();

		movieInterestImpl.setNew(movieInterest.isNew());
		movieInterestImpl.setPrimaryKey(movieInterest.getPrimaryKey());

		movieInterestImpl.setMovieInterestId(movieInterest.getMovieInterestId());
		movieInterestImpl.setGroupId(movieInterest.getGroupId());
		movieInterestImpl.setCompanyId(movieInterest.getCompanyId());
		movieInterestImpl.setUserId(movieInterest.getUserId());
		movieInterestImpl.setUserName(movieInterest.getUserName());
		movieInterestImpl.setCreateDate(movieInterest.getCreateDate());
		movieInterestImpl.setModifiedDate(movieInterest.getModifiedDate());
		movieInterestImpl.setFavoriteMovie(movieInterest.getFavoriteMovie());
		movieInterestImpl.setFavoriteGenre(movieInterest.getFavoriteGenre());
		movieInterestImpl.setLeastFavMovie(movieInterest.getLeastFavMovie());
		movieInterestImpl.setFavoriteActor(movieInterest.getFavoriteActor());

		return movieInterestImpl;
	}

	/**
	 * Returns the movie interest with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the movie interest
	 * @return the movie interest
	 * @throws com.amf.user.profile.NoSuchMovieInterestException if a movie interest with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MovieInterest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMovieInterestException, SystemException {
		MovieInterest movieInterest = fetchByPrimaryKey(primaryKey);

		if (movieInterest == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMovieInterestException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return movieInterest;
	}

	/**
	 * Returns the movie interest with the primary key or throws a {@link com.amf.user.profile.NoSuchMovieInterestException} if it could not be found.
	 *
	 * @param movieInterestId the primary key of the movie interest
	 * @return the movie interest
	 * @throws com.amf.user.profile.NoSuchMovieInterestException if a movie interest with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MovieInterest findByPrimaryKey(long movieInterestId)
		throws NoSuchMovieInterestException, SystemException {
		return findByPrimaryKey((Serializable)movieInterestId);
	}

	/**
	 * Returns the movie interest with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the movie interest
	 * @return the movie interest, or <code>null</code> if a movie interest with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MovieInterest fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		MovieInterest movieInterest = (MovieInterest)EntityCacheUtil.getResult(MovieInterestModelImpl.ENTITY_CACHE_ENABLED,
				MovieInterestImpl.class, primaryKey);

		if (movieInterest == _nullMovieInterest) {
			return null;
		}

		if (movieInterest == null) {
			Session session = null;

			try {
				session = openSession();

				movieInterest = (MovieInterest)session.get(MovieInterestImpl.class,
						primaryKey);

				if (movieInterest != null) {
					cacheResult(movieInterest);
				}
				else {
					EntityCacheUtil.putResult(MovieInterestModelImpl.ENTITY_CACHE_ENABLED,
						MovieInterestImpl.class, primaryKey, _nullMovieInterest);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MovieInterestModelImpl.ENTITY_CACHE_ENABLED,
					MovieInterestImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return movieInterest;
	}

	/**
	 * Returns the movie interest with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param movieInterestId the primary key of the movie interest
	 * @return the movie interest, or <code>null</code> if a movie interest with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MovieInterest fetchByPrimaryKey(long movieInterestId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)movieInterestId);
	}

	/**
	 * Returns all the movie interests.
	 *
	 * @return the movie interests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MovieInterest> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the movie interests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.amf.user.profile.model.impl.MovieInterestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of movie interests
	 * @param end the upper bound of the range of movie interests (not inclusive)
	 * @return the range of movie interests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MovieInterest> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the movie interests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.amf.user.profile.model.impl.MovieInterestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of movie interests
	 * @param end the upper bound of the range of movie interests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of movie interests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MovieInterest> findAll(int start, int end,
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

		List<MovieInterest> list = (List<MovieInterest>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MOVIEINTEREST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MOVIEINTEREST;

				if (pagination) {
					sql = sql.concat(MovieInterestModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MovieInterest>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MovieInterest>(list);
				}
				else {
					list = (List<MovieInterest>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the movie interests from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MovieInterest movieInterest : findAll()) {
			remove(movieInterest);
		}
	}

	/**
	 * Returns the number of movie interests.
	 *
	 * @return the number of movie interests
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

				Query q = session.createQuery(_SQL_COUNT_MOVIEINTEREST);

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
	 * Initializes the movie interest persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.amf.user.profile.model.MovieInterest")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MovieInterest>> listenersList = new ArrayList<ModelListener<MovieInterest>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MovieInterest>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MovieInterestImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MOVIEINTEREST = "SELECT movieInterest FROM MovieInterest movieInterest";
	private static final String _SQL_SELECT_MOVIEINTEREST_WHERE = "SELECT movieInterest FROM MovieInterest movieInterest WHERE ";
	private static final String _SQL_COUNT_MOVIEINTEREST = "SELECT COUNT(movieInterest) FROM MovieInterest movieInterest";
	private static final String _SQL_COUNT_MOVIEINTEREST_WHERE = "SELECT COUNT(movieInterest) FROM MovieInterest movieInterest WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "movieInterest.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MovieInterest exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MovieInterest exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MovieInterestPersistenceImpl.class);
	private static MovieInterest _nullMovieInterest = new MovieInterestImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MovieInterest> toCacheModel() {
				return _nullMovieInterestCacheModel;
			}
		};

	private static CacheModel<MovieInterest> _nullMovieInterestCacheModel = new CacheModel<MovieInterest>() {
			@Override
			public MovieInterest toEntityModel() {
				return _nullMovieInterest;
			}
		};
}