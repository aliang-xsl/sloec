package test.jdbc.queue;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import test.jdbc.GoogleMailDao;

public class Test {
	
	public static void main(String[] args){
		
		
		
		
	}
	
	
	
	

	
	
	public static void test(){
		
		try {

			File file = new File(
					"E:\\数据\\google_5000000/google_5000000.txt");
		
			InputStream is = new FileInputStream(file);
			
			DataInputStream ds = new DataInputStream(is);

			String s="";
			List<String> googleMails=new ArrayList<String>();
			GoogleMailDao googleMailDao=new GoogleMailDao();
			Long num=0l;
			
			
			while (s!=null) {
				
				
				s=ds.readLine();
				googleMails.add(s);
				if(googleMails.size()==100){
					num+=100;
					if(googleMailDao.insertBatch(googleMails)){
						
						System.out.println(num);
					}
					
					/*if(num>500000)
						break;*/
						
					googleMails.removeAll(googleMails);
				}
			}
			
			

			ds.close();
			is.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
}
