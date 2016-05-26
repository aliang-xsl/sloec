package aliang.util.memcache.client;

import java.util.Date;

public class TestMemcache {
	
	public static void main(String[] args) {
		
		
		MemCached.getInstance().add("1", "2121212121212121", new Date());
		//MemCached.getInstance().replace("1","xsl");
		System.out.println(MemCached.getInstance().get("1"));
		
		
	}

}
