package test.http;

import javax.annotation.Resource;

import org.activiti.engine.impl.db.DbSchemaCreate;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import aliang.service.test.IWorkflowService;



@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })  
/*@Transactional(readOnly=true)  */
public class Test {
	
	
	@Resource
	private IWorkflowService workflowService;
	

	
	
	@org.junit.Test
	public void deploye(){
		String id = workflowService.deploye();
		System.out.println(id);
		
	}
	

}
