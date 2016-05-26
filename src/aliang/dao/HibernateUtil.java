package aliang.dao;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "hibernateUtil")
@Scope(value = "singleton")
public class HibernateUtil {

	@Resource
	private SessionFactory sessionFactory = null;

	public Session getSession() {
		if (sessionFactory != null) {
			System.out.println("session创建成功");
			// return sessionFactory.openSession();
			return sessionFactory.getCurrentSession();
		} else
			throw new HibernateException("获取session失败");
	}

}
