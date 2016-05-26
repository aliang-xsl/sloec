package aliang.web.listener;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 
 * 
 * 用于Spring容器启动 托管容器
 * 
 * @author aliang
 * @version 1.0
 * @created 2014-3-28 下午4:30:17
 */
@Component(value = "appContext")
public class MyApplicationContextAware implements ApplicationContextAware {

	private static Logger logger = Logger
			.getLogger(MyApplicationContextAware.class);

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		
		AppContext.getInstance().setContext(context);
		
		logger.info("Spring 容器托管！！！！！！！！！！！！！！！");


	}

}
