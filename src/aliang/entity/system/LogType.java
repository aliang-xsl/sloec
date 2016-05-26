package aliang.entity.system;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import aliang.entity.BaseEntity;

/**
 * 
 * 日志类型
 * 
 * @author aliang
 * @version 1.0
 * @created 2014年7月10日 上午11:20:05
 */
@Entity(name = "sys_logType")
public class LogType extends BaseEntity {

	/** 描述 */

	private static final long serialVersionUID = -1298884346182082786L;

	private String info; // 描述

	@OneToMany(mappedBy = "logType")
	private Set<Log> logs;

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	

	public void addLog(Log log) {
		if (logs == null)
			logs = new HashSet<Log>();
		log.setLogType(this);
		logs.add(log);
	}

}
