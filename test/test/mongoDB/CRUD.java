package test.mongoDB;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

/**
 * 
 * mongoDB增删改查
 * 
 * @author aliang
 * @version 1.0
 * @created 2014-6-7 下午3:57:18
 */
public class CRUD {

	private Mongo mg = null;
	private DB db;
	private DBCollection users;
	
	public CRUD(){
		try {
            mg = new Mongo("localhost", 27017);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //获取temp DB；如果默认没有创建，mongodb会自动创建
        db = mg.getDB("test");
        //获取users DBCollection；如果默认没有创建，mongodb会自动创建
        users = db.getCollection("foo");
	}
	
	
	

	
	public void  queryAll(){
		System.out.println("查询users的所有数据：");
	    //db游标
	    DBCursor cur = users.find();
	    
	    while (cur.hasNext()) {
	        System.out.println(cur.next());
	    }
	    
	}
	
	
	/**
	 * add
	 * 描述
	 */
	public void add(){
		System.err.println("添加前count:：：：：："+users.getCount());
		
		DBObject user = new BasicDBObject();
	    user.put("name", "hoojo");
	    user.put("age", 24);
	    //users.save(user)保存，getN()获取影响行数
	    //print(users.save(user).getN());
	    
	    //扩展字段，随意添加字段，不影响现有数据
	    user.put("sex", "男");
	    
	    System.out.println(users.save(user).getN());
	    
	    //添加多条数据，传递Array对象
	    System.out.println(users.insert(user, new BasicDBObject("name", "tom")).getN());
	    
	    //添加List集合
	    List<DBObject> list = new ArrayList<DBObject>();
	    list.add(user);
	    DBObject user2 = new BasicDBObject("name", "lucy");
	    user.put("age", 22);
	    list.add(user2);
	    //添加List集合
	    System.out.println(users.insert(list).getN());

		
		System.err.println("添加后count:：：：：："+users.getCount());
	}
	
	
	
	public void remove(){
		
		System.out.println("删除id = 4de73f7acd812d61b4626a77："+users.remove(new BasicDBObject("_id", new ObjectId("4de73f7acd812d61b4626a77"))).getN());
		
		System.out.println("remove age >= 24:"+(users.remove(new BasicDBObject("age", new BasicDBObject("$gte", 24))).getN()));
		
		
	}
	
}
