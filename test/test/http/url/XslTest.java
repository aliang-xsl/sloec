package test.http.url;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import sun.misc.BASE64Encoder;

public class XslTest {
	
	public static void main(String[] args) {
		
		try {
			
			long start = System.currentTimeMillis();
			
			 HttpClient client=new HttpClient();
		      String url="http://192.168.1.106:6080/dayu/admin/web/test/xsltest";
		      PostMethod postMethod=new PostMethod(url);
		      //增加变量
		        postMethod.addParameter("base64String",test());                                
		       
		       
		        client.executeMethod(postMethod);
		        String str="";
		        str=new String(postMethod.getResponseBodyAsString().getBytes("utf-8"));
		        System.out.println(str);
		        postMethod.releaseConnection();
		        long end = System.currentTimeMillis(); 
		        
		        System.out.println(end-start);
		     	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	     	
		
	}

	
	
	public static String test(){
		 File f = new File("E:\\photo\\20151027170557.png");  
		 BASE64Encoder encoder = new sun.misc.BASE64Encoder();
	        BufferedImage bi;      
	        try {      
	            bi = ImageIO.read(f);      
	            ByteArrayOutputStream baos = new ByteArrayOutputStream();      
	            ImageIO.write(bi, "jpg", baos);      
	            byte[] bytes = baos.toByteArray();   
	           String value = encoder.encodeBuffer(bytes).trim();
              //System.out.println(value);
              return  value;
	        } catch (Exception e) {      
	            e.printStackTrace();      
	        }      
	        return null;
	}
	
	
}
