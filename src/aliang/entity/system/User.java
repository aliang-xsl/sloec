package aliang.entity.system;

import javax.persistence.Entity;

import aliang.entity.BaseEntity;


/**
 * 
 *   
 *  
 * @author aliang    
 * @version 1.0  
 * @created 2014年7月10日 上午11:13:10
 */

@Entity(name="sys_user")
public class User extends BaseEntity {
	
	/**  描述  */  
	
	private static final long serialVersionUID = 1L;
	
	
	private String email;  //邮箱
	
	private String account;  //帐号

	private String nickname;  //昵称
	
	private String passWord; //密码
	
	private String phone;  //电话
	
	private String creataDate;  //创建日期
	
	private Long loginCount;// 登录次数
	
	private String loginIp; // 登录IP
	
	private Integer state;  //是否禁用
	
	private String lastLoginTime;// 最后登录时间
	
	
	
	
	
	
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreataDate() {
		return creataDate;
	}

	public void setCreataDate(String creataDate) {
		this.creataDate = creataDate;
	}

	public Long getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Long loginCount) {
		this.loginCount = loginCount;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	

}
