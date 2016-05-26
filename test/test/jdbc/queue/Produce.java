package test.jdbc.queue;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * 生产者 负责生产数据  
 *  
 * @author aliang    
 * @version 1.0  
 * @created 2015年2月20日 下午9:51:46
 */
public class Produce {

	
	@SuppressWarnings("deprecation")
	void produceStart(){
		
		
		try {

			File file = new File(
					"E:\\数据\\google_5000000/google_5000000.txt");
		
			InputStream is = new FileInputStream(file);
			
			DataInputStream ds = new DataInputStream(is);
			String s="";
			
			
			
			while (s!=null) {
				
				//googleMails.add(ds.readLine());
				
				
				
			}
			ds.close();
			is.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
