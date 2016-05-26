package aliang.service.system;

import java.util.List;

import aliang.entity.system.User;


/**
 * 
 *   用户中心
 *  
 * @author aliang    
 * @version 1.0  
 * @created 2014-6-5 下午1:49:07
 */
public interface IUserService {
	
	/**
	 * 
	 * 保存
	 * @param t
	 * @return
	 */
	public Integer save(User t);
	
	/**
	 * 
	 * 按照名字获取用户集
	 * @param user
	 * @return
	 */
	public List<User> getUserByName(User user);
	
	/**
	 * 
	 * 按照用户ID获取用户
	 * @param user
	 * @return
	 */
	public User getUserByID(User user);
	
	/**
	 * 按照字段名和值获取用户
	 * @param fileName
	 * @param value
	 * @return
	 */
	public List<User> getUserByFile(String fileName,Object value);
	

}
