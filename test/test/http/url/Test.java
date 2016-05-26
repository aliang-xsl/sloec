package test.http.url;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;



public class Test {

	
	 public static void main(String[] args) {     
	        try {     
	        
	        	
	        	
	        	for (int i = 0; i <10000; i++) {
	        		test();
				}
	        	
	        	
	        	
	        } catch (Exception e) {     
	            e.printStackTrace();     
	        }     
	    }  
	    
	
	 public static void test() throws Exception{
		 
			
     	//建立与服务器的URL对象
     	java.net.URL url=new java.net.URL("http://10.10.1.135/");//http://hq.sinajs.cn/list=sz002590
     	
     	//打开连接
     	HttpURLConnection  conn = (HttpURLConnection) url.openConnection();
     	
     	conn.setRequestProperty("contentType", "GBK");  
     	
     	System.out.println(conn.getResponseCode());
     	
     	InputStream in=conn.getInputStream(); //获取服务器输入流
     	
     	
     	BufferedReader br=new BufferedReader(new InputStreamReader(in,"GBK"));
     	
     	String string="";
     	
     	while ((string=br.readLine())!=null) {
     		//System.out.println(string);
			}
     	
     	conn.disconnect();
     	
		 
        /*	
     	conn.getResponseCode();//获取响应码
     	
     	conn.getResponseMessage();//获取响应码描述
     	
     	conn.getHeaderField("Server"); //获取响应头
*/   
	 }
	 
	 
	 public  static void doGet() throws Exception{
		 URL  url=new URL("http://hq.sinajs.cn/list=sz002590");
		//打开连接
     	HttpURLConnection  conn = (HttpURLConnection) url.openConnection();
     	
     	conn.setDoInput(true);//打开可以向服务器发消息
     	conn.setRequestProperty("contentType", "GBK");  //发送请求头
     	OutputStream out = conn.getOutputStream();
     	out.write("name=test".getBytes());//发送正文数据
     	
     	
     	//获取状态码，以表示完成请求
     	int code=conn.getResponseCode();
     	System.out.println(code);
     	
     	
		 
	 }
	 
	 
	 
	 public  static void doPost() throws Exception{
		 URL  url=new URL("http://hq.sinajs.cn/list=sz002590");
		//打开连接
     	HttpURLConnection  conn = (HttpURLConnection) url.openConnection();
     	
     	conn.setRequestMethod("POST");
     	
     	conn.setDoInput(true);//打开可以向服务器发消息
     	conn.setRequestProperty("", "");//发送请求头
     	OutputStream out = conn.getOutputStream();
     	out.write("name=test".getBytes());//发送正文数据
     	
     	
     	//获取状态码，以表示完成请求
     	int code=conn.getResponseCode();
     	System.out.println(code);
     	
     	
		 
	 }
	
}
