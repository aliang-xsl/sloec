package test.thread;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import jdk.nashorn.internal.objects.annotations.Where;

/**
 * 
 *   由生产者自己生产，带入仓库中间池，在消费者等待消费
 *  
 * @author aliang    
 * @version 1.0  
 * @created 2016年5月25日 下午8:45:35
 */
public class StorageTest1 {
	
	// 仓库对象
	private static Storage1 storage = new Storage1();
			
	public static void main(String[] args) throws InterruptedException
	{
		

		// 生产者对象
		new Producer1(storage).start();
		new Producer1(storage).start();
		

		// 消费者对象
		//new Consumer1(storage).start();
		
		//线程池启动消费者
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool(); 
	   cachedThreadPool.execute(new Runnable(){  
		    public void run() {  
		    	while(true){
		    		storage.consume(10);
		    	}
		    }  
	   });  
		
	
	   
		Thread.sleep(5000);
		new Producer1(storage).start();
		new Producer1(storage).start();
		Thread.sleep(5000);
		new Producer1(storage).start();
	
	
	   
		   
	}

}




/**
 * 仓库类Storage实现缓冲区
 * 
 * Email:530025983@qq.com
 * 
 * @author MONKEY.D.MENG 2011-03-15
 * 
 */
 class Storage1
{

	 
	// 仓库存储的载体
	private LinkedList<Object> list = new LinkedList<Object>();
	

	// 生产num个产品
	public void produce(LinkedList<Object> pList)
	{
		// 同步代码段
		synchronized (list)
		{
		
			this.list.addAll(pList);
			
			
			// 如果带过来的仓库数量不满足，直接挂起等待
			/*if (list.size()<1)
			{
				System.out.println("【带过来的生产的产品数量为】:" + list.size() + "\t暂时不能执行生产任务!");
				try
				{
					// 由于条件不满足，生产阻塞
					list.wait();
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}*/
			
			list.notifyAll();
		}
	}

	// 消费num个产品
	public void consume(int num)
	{
		// 同步代码段
		synchronized (list)
		{
			// 如果仓库存储量不足
			if (list.size() < num)
			{
				System.out.println("【要消费的产品数量】:" + num + "\t【库存量】:" + list.size() + "\t暂时不能执行生产任务!");
				try
				{
					// 由于条件不满足，消费阻塞
					list.wait();
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}

			// 消费条件满足情况下，消费num个产品
			for (int i = 1; i <= num; ++i)
			{
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				list.remove();
				System.out.println("消费======\t【现仓储量为】:" + list.size());
			}

			list.notifyAll();
		}
	}


}
 
 
 
 
 
 
 
 
/**
 * 生产者类Producer继承线程类Thread
 * 
 * Email:530025983@qq.com
 * 
 * @author MONKEY.D.MENG 2011-03-15
 * 
 */
 class Producer1 extends Thread
{
	 
	// 每次生产的产品数量
	private int num=10;
	
	private LinkedList<Object> producerList = new LinkedList<Object>(); 

	// 所在放置的仓库
	private Storage1 storage;


	public Producer1(Storage1 storage)
	{
		this.storage = storage;
	}

	// 线程run函数
	public void run()
	{
		
			// 自己生产，生产完后传入仓库
			for (int i = 1; i <= num; ++i)
			{
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				producerList.add(new Object());
				System.err.println("自己生产的======\t【现仓储量为】:" + producerList.size());
			}
			
			storage.produce(producerList);
			//producerList.removeAll(producerList);
	}



}
/**
 * 消费者类Consumer继承线程类Thread
 * 
 * Email:530025983@qq.com
 * 
 * @author MONKEY.D.MENG 2011-03-15
 * 
 */
 class Consumer1 extends Thread
{
	// 每次消费的产品数量
	private int num=10;

	// 所在放置的仓库
	private Storage1 storage;


	public Consumer1(Storage1 storage)
	{
		this.storage = storage;
	}

	
	public void run()
	{
		while (true) {
			storage.consume(num);
		}
		
	}

}

