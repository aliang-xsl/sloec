package aliang.entity.system;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import aliang.entity.BaseEntity;



/**
 * 
 *   
 *  
 * @author aliang    
 * @version 1.0  
 * @created 2014年7月10日 上午11:13:50
 */
@Entity(name="sys_log")
public class Log extends BaseEntity {
	
	/**  描述  */  
	
	private static final long serialVersionUID = -8522633420550479795L;
	
	

	private String   operationTime;  //操作时间
	
	private String  operationIp;  //操作IP
	
	private String   operationUser;  //操作人信息
	
	private String   operationInfo;  //操作信息
	
	private Long operationUserId;	//操作人ID
	
	@ManyToOne
	@JoinColumn
	private LogType logType;	//日志类型
	
	

	public String getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(String operationTime) {
		this.operationTime = operationTime;
	}

	public String getOperationIp() {
		return operationIp;
	}

	public void setOperationIp(String operationIp) {
		this.operationIp = operationIp;
	}

	public String getOperationUser() {
		return operationUser;
	}

	public void setOperationUser(String operationUser) {
		this.operationUser = operationUser;
	}

	public String getOperationInfo() {
		return operationInfo;
	}

	public void setOperationInfo(String operationInfo) {
		this.operationInfo = operationInfo;
	}

	public Long getOperationUserId() {
		return operationUserId;
	}

	public void setOperationUserId(Long operationUserId) {
		this.operationUserId = operationUserId;
	}

	public LogType getLogType() {
		return logType;
	}

	public void setLogType(LogType logType) {
		this.logType = logType;
	}

	
	
	

}
