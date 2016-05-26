package aliang.util;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

/**
 * 
 * 分页  
 *  
 * @author aliang    
 * @version 1.0  
 * @created 2014年7月9日 上午9:42:55
 */
public class Page<T> {
	
	
	public   Long limit=20l;     //页面显示数目
	
	private Long total;				//总记录数
	
	private List<T> rows;			//当前页面内容集
	
	private Integer page;			//当前页面数
	
	private Long startPage;  			//开始记录数
	
	private Long endPage; 				 //结束记录数
	
	private T t; 					 //分页对象
	

	

	
	@SuppressWarnings("unchecked")
	public Map<String,Object> getParams() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{

		Map<String, Object> params = BeanUtils.describe(this.getT());
		params.put("startPage",this.getStartPage());
		params.put("endPage",this.getEndPage());
		
		return params;
	}


	public Long getLimit() {
		return limit;
	}



	public void setLimit(Long limit) {
		this.limit = limit;
	}



	public Long getTotal() {
		return total;
	}



	public void setTotal(Long total) {
		this.total = total;
	}



	public List<T> getRows() {
		return rows;
	}



	public void setRows(List<T> rows) {
		this.rows = rows;
	}


	



	public Integer getPage() {
		return page;
	}


	public void setPage(Integer page) {
		this.page = page;
	}


	public Long getStartPage() {
		
		this.startPage=((page-1)*limit);
		
		return startPage;
	}

	public Long getEndPage() {
		
		this.endPage=(page)*limit;
		
		return endPage;
	}



	public T getT() {
		return t;
	}



	public void setT(T t) {
		this.t = t;
	}

	
	
	

	
	
	
	


}
