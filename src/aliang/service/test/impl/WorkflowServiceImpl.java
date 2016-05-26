package aliang.service.test.impl;

import javax.annotation.Resource;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.springframework.stereotype.Service;

import aliang.entity.test.ServiceOrder;
import aliang.service.test.IWorkflowService;

@Service(value="workflowService")
public class WorkflowServiceImpl implements IWorkflowService{
	@Resource
	private RepositoryService repositoryService;
	@Resource
	private RuntimeService runtimeService;
	@Resource
	private TaskService taskService;
	@Resource
	private FormService formService;
	@Resource
	private HistoryService historyService;
	
	
	@Override
	public String deploye() {
		Deployment deployment = repositoryService.createDeployment()
				.name("服务单流程")//添加部署的名称
				.addClasspathResource("bpm/ServiceOrder.bpmn")
				.addClasspathResource("bpm/ServiceOrder.png")
				.deploy();//完成部署
		return deployment.getId();
	}


	@Override
	public void start(String name,ServiceOrder serviceOrder) {
		
		//runtimeService.startProcessInstanceByKey("serviceOrder",objId,variables);
		
	}
	
	
	
	
	

}
