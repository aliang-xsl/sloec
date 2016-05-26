package aliang.service.system.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import aliang.dao.system.IUserDao;
import aliang.entity.system.User;
import aliang.service.system.IUserService;

/**
 *   
 *  
 * @author aliang    
 * @version 1.0  
 * @created 2014-6-5 下午1:58:18
 */
@Service(value="userService")
public class UserServiceImpl implements IUserService {

	/*@Resource
	private IUserDao userDao;*/
	
	@Override
	public Integer save(User t) {
		
		/*return	userDao.save(t);*/
		return	null;
		 
	}

	@Override
	public List<User> getUserByName(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByID(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUserByFile(String fileName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

}
