package aliang.service.test;

import aliang.entity.test.ServiceOrder;

public interface IWorkflowService {
	
	/**
	 * 
	 * 部署流程
	 * @return
	 */
	public String deploye();
	
	/**
	 * 
	 * 启动并且保存订单
	 * @param name
	 * @param serviceOrder
	 */
	public void start(String name,ServiceOrder serviceOrder);
	

}
