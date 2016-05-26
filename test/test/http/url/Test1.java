package test.http.url;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test1 {
	
	 private URL url;
	    private HttpURLConnection httpURLConn;
	    
	    public void myDoGet()
	    {
	        try
	        {
	            String temp = new String();
	            url = new  URL("http://10.10.0.135");
	            httpURLConn= (HttpURLConnection)url.openConnection();
	            httpURLConn.setDoOutput(true);
	            httpURLConn.setRequestMethod("GET");
	            httpURLConn.setIfModifiedSince(999999999);
	            httpURLConn.setRequestProperty("Referer", "http://localhost:80");
	            httpURLConn.setRequestProperty("User-Agent", "test");
	            httpURLConn.connect();
	            InputStream in =httpURLConn.getInputStream();
	            BufferedReader bd = new BufferedReader(new InputStreamReader(in));
	            while((temp=bd.readLine())!=null)
	            {
	                System.out.println(temp);
	            }            
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        } 
	        finally
	        {
	            if(httpURLConn!=null)
	            {
	                httpURLConn.disconnect();
	            }
	        }
	    }
	    public static void main(String[] args)
	    {
	    	Test1 hg = new Test1();
	        hg.myDoGet();
	    }
}
