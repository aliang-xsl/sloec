package aliang.dao.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;

import aliang.entity.BaseEntity;
import aliang.util.Page;

/**
 * 
 * dao基础
 * 
 * @author aliang
 * @version 1.0
 * @created 2014-5-28 上午9:22:52
 */
public interface BaseDao<T extends BaseEntity, K extends Serializable> {
	/**
	 * 
	 * 获取全部
	 * 
	 * @return
	 */
	List<T> getAll();

	/**
	 * 
	 * 根据ID获取实体
	 * 
	 * @param id
	 * @return
	 */
	T get(K id);

	/**
	 * 
	 * 持久实体
	 * 
	 * @param t
	 * @return
	 * @throws HibernateException
	 */
	K save(T t) throws HibernateException;

	/**
	 * 
	 * 修改实体
	 * 
	 * @param t
	 * @throws HibernateException
	 */
	void update(T t) throws HibernateException;

	/**
	 * 
	 * 按照对象删除记录
	 * 
	 * @param t
	 * @throws HibernateException
	 */
	void delete(T t) throws HibernateException;

	/**
	 * 
	 * 按照ID删除记录
	 * 
	 * @param id
	 * @throws HibernateException
	 */
	void delete(K id) throws HibernateException;

	/**
	 * 
	 * 按照某列和相应的值验证是否存在
	 * 
	 * @param cloumName
	 * @param value
	 * @return
	 */
	boolean isExist(String cloumName, Object value);

	/**
	 * 
	 * 获得记录总数
	 * 
	 * @return
	 */
	long getCount();

	/**
	 * 
	 * 获取列最大的值
	 * 
	 * @param cloumName
	 * @return
	 */
	Object findMax(String cloumName);

	/**
	 * 
	 * 按照列和值获取记录
	 * 
	 * @param fieldName
	 * @param value
	 * @return
	 */
	List<T> findByField(String fieldName, Object value);

	/**
	 * 
	 * 按照列和值获取记录总数
	 * 
	 * @param fieldName
	 * @param value
	 * @return
	 */
	long getCountByField(String fieldName, Object value);

	/**
	 * 
	 * 分页
	 * 
	 * @param numOne
	 * @param numTwo
	 * @return
	 */
	List<T> paging(Page<T> page);

}
