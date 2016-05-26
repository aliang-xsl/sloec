package aliang.dao.system.impl;

import org.springframework.stereotype.Repository;

import aliang.dao.base.impl.BaseDaoImpl;
import aliang.dao.system.IUserDao;
import aliang.entity.system.User;

/**
 * 
 *   
 *  
 * @author aliang    
 * @version 1.0  
 * @created 2014-5-30 下午5:40:44
 */
@Repository(value="userDao")
public class UserDaoImpl extends BaseDaoImpl<User, Integer> implements IUserDao {

}
