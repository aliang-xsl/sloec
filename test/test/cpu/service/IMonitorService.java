package test.cpu.service;

import test.cpu.bean.MonitorInfoBean;

/**
 * 
 * 获取系统信息的业务逻辑类接口.   
 *  
 * @author aliang    
 * @version 1.0  
 * @created 2014年9月23日 下午5:42:26
 */
public interface IMonitorService {

	/**
	 * 
	 * 获得当前的监控对象.  
     * @return 返回构造好的监控对象  
	 * @throws Exception
	 */
    public MonitorInfoBean getMonitorInfoBean() throws Exception;   
    
}
