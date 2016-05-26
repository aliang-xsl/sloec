package aliang.entity.base;

import aliang.entity.BaseEntity;

/**
 * 
 *   存放 只包含键值的数据
 *  
 * @author aliang    
 * @version 1.0  
 * @created 2014年7月10日 上午11:16:04
 */
public class Key extends BaseEntity {
	
	/**  描述  */  
	
	private static final long serialVersionUID = -8768395720837810492L;
	

	private String code;
	
	private String describe;
	
	private String type;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	

}
