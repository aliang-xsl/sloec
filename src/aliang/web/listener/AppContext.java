package aliang.web.listener;

import org.springframework.context.ApplicationContext;

/**
 * 
 * 托管Spring 容器
 * 
 * @author aliang
 * @version 1.0
 * @created 2014-3-28 下午4:40:32
 */
public class AppContext {

	private AppContext() {
	};

	protected static AppContext oecContext = null;

	private ApplicationContext context = null;

	public static AppContext getInstance() {
		if (oecContext == null) {
			oecContext = new AppContext();
		}
		return oecContext;
	}

	public ApplicationContext getContext() throws Exception {

		if (context != null) {
			return context;
		} else {
			throw new Exception("容器为NULL");
		}

	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}

}
