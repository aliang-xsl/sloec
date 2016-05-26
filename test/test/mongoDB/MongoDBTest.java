package test.mongoDB;



import java.net.UnknownHostException;

import org.ietf.jgss.Oid;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;

/**
 * 
 * MongoDB  测试  
 *  
 * @author aliang    
 * @version 1.0  
 * @created 2014-6-7 下午3:48:16
 */
public class MongoDBTest {
	
	public static void main(String[] args) {
		
		
		try {
			 
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * 简单查询列子
	 * 
	 * @throws MongoException 
	 * @throws UnknownHostException 
	 */
	public void queryDateTable() throws UnknownHostException, MongoException{
		Mongo mg = new Mongo();
        //查询所有的Database
        for (String name : mg.getDatabaseNames()) {
            System.out.println("dbName: " + name);
        }
        
        DB db = mg.getDB("test");
        //查询所有的聚集集合
        for (String name : db.getCollectionNames()) {
            System.out.println("collectionName: " + name);
        }
        
        DBCollection users = db.getCollection("foo");
        
        //查询所有的数据
        DBCursor cur = users.find();
        while (cur.hasNext()) {
            System.out.println("数据：：：：：：：："+cur.next());
        }
        
        System.out.println(cur.count());
        System.out.println(cur.getCursorId());
        System.out.println(JSON.serialize(cur));
	}
	
	/**
	 * 
	 * 简单的一个例子
	 * @throws UnknownHostException
	 * @throws MongoException
	 */
	public void queryDataBase() throws UnknownHostException, MongoException{
		
		Mongo mongo=new Mongo();//这样就创建了一个MongoDB的数据库连接对象，它默认连接到当前机器的localhost地址，端口是27017。
		
		
		DB db = mongo.getDB("test");//这样就获得了一个test的数据库，如果mongoDB中没有创建这个数据库也是可以正常运行的。
		
		
		DBCollection users = db.getCollection("users");//得到了db，下一步我们要获取一个“聚集集合DBCollection”，这样就获得了一个DBCollection，它相当于我们数据库的“表”。
		
		
		
		DBCursor cur = users.find();

		while (cur.hasNext()) {

		System.out.println(cur.next());

		}
	}

}
