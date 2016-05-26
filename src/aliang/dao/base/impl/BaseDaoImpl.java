package aliang.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import aliang.dao.HibernateUtil;
import aliang.dao.base.BaseDao;
import aliang.entity.BaseEntity;
import aliang.util.Page;


public abstract class BaseDaoImpl<T extends BaseEntity, K extends Serializable>
		implements BaseDao<T, K> {

	private Class<T> entityClass;

	@Resource
	private HibernateUtil hibernateUtil;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {

		entityClass = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		return hibernateUtil.getSession()
				.createQuery(String.format("from %s", entityClass.getName()))
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(K id) {

		return (T) hibernateUtil.getSession().get(entityClass, id);

	}

	@SuppressWarnings("unchecked")
	@Override
	public K save(T t) throws HibernateException {

		return (K) hibernateUtil.getSession().save(t);
	}

	@Override
	public void update(T t) throws HibernateException {
		hibernateUtil.getSession().update(t);
	}

	@Override
	public void delete(T t) throws HibernateException {
		hibernateUtil.getSession().delete(t);
	}

	@Override
	public void delete(K id) throws HibernateException {
		hibernateUtil.getSession().delete(
				hibernateUtil.getSession().get(entityClass, id));
	}

	@Override
	public boolean isExist(String cloumName, Object value) {
		Query query = hibernateUtil.getSession().createQuery(
				String.format("form %s where %s=:value", entityClass.getName(),
						cloumName));

		query.setParameter("value", value);
		if (query.list().size() > 0)
			return true;
		else
			return false;
	}

	@Override
	public long getCount() {
		return (Long) hibernateUtil
				.getSession()
				.createQuery(
						String.format("select count(t) from %s t",
								entityClass.getName())).uniqueResult();
	}

	@Override
	public Object findMax(String cloumName) {
		return hibernateUtil
				.getSession()
				.createQuery(
						String.format("select max(t.%s)from %s t", cloumName,
								entityClass.getName())).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByField(String fieldName, Object value) {
		Session session = hibernateUtil.getSession();

		String hql = String.format(" from %s t where %s=:value",
				entityClass.getName(), fieldName);

		Query query = session.createQuery(hql);

		query.setParameter("value", value);

		return query.list();
	}

	@Override
	public long getCountByField(String fieldName, Object value) {
		Session session = hibernateUtil.getSession();
		String hql = String.format(
				"select count(t) from s% t where t.%s=:value",
				entityClass.getName(), fieldName);
		Query query = session.createQuery(hql);
		query.setParameter("value", value);
		return (Long) query.uniqueResult();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> paging(Page<T> page) {

		Query query = hibernateUtil.getSession().createQuery(
				String.format("from %s", entityClass.getName()));

		query.setFirstResult(Integer.valueOf(page.getStartPage().toString()));
		query.setMaxResults(Integer.valueOf(page.getEndPage().toString()));

		return query.list();
	}

}
