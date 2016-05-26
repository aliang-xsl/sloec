package test.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import aliang.util.in.DateUtil;

/**
 * 
 * jdbc 测试  
 *  
 * @author aliang    
 * @version 1.0  
 * @created 2015年2月20日 下午8:21:58
 */
public class GoogleMailDao {
	
	public boolean insertBatch(List<String> list){

		Connection connection =null;
		Statement statement=null;
		try {
		
			 connection = DBhelp.GetInstance().getConnection();
			  statement = connection.createStatement();
			   for (int i = 0; i < list.size(); i++) {
				   statement.addBatch("INSERT INTO googlemail (mailName,addTime) VALUES ( '"+list.get(i)+"', '"+DateUtil.getNowDateTime()+"')");
			   }
				 statement.executeBatch();
				return true;
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		 finally {
				try {
					statement.close();
					connection.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		return false;
	}
	
	
	public static void main(String[] args) {
		
		int[] test=new int[2];
		test[0]=1;
		test[1]=1;
		System.out.println(test[test.length-1]);
		
	}

}
