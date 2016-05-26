package aliang.entity.test;

import java.io.Serializable;

import javax.persistence.Entity;

import aliang.entity.BaseEntity;


@Entity(name="test_ServiceOrder")
public class ServiceOrder extends BaseEntity implements Serializable {

	/**  描述  */  
	private static final long serialVersionUID = 7901503505640312866L;
	
	
	private  String orderNo;
	private  String orderType;
	private  String orderDate;
	private  String orderProduct;
	private  String processInsId; //流程实例ID
	
	private  String ext1; 
	private  String ext2; 
	private  String ext3;
	
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderProduct() {
		return orderProduct;
	}
	public void setOrderProduct(String orderProduct) {
		this.orderProduct = orderProduct;
	}
	public String getProcessInsId() {
		return processInsId;
	}
	public void setProcessInsId(String processInsId) {
		this.processInsId = processInsId;
	}
	public String getExt1() {
		return ext1;
	}
	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}
	public String getExt2() {
		return ext2;
	}
	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}
	public String getExt3() {
		return ext3;
	}
	public void setExt3(String ext3) {
		this.ext3 = ext3;
	} 
	
	
	
	
	

}
