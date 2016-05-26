package test.thread;
import java.util.LinkedList;

/**
 * 
 * 由生产者启动线程争锁后去生产，同一时间只能有一个生产者生产和消费。  
 *  
 * @author aliang    
 * @version 1.0  
 * @created 2016年5月25日 下午8:46:28
 */
public class StorageTest {
	
	public static void main(String[] args)
	{
		// 仓库对象
		Storage storage = new Storage();

		// 生产者对象
		 new Producer(storage).start();
		 new Producer(storage).start();

		// 消费者对象
		new Consumer(storage).start();
		
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
 class Storage
{


	// 仓库存储的载体
	private LinkedList<Object> list = new LinkedList<Object>();

	// 生产num个产品
	public void produce(int num)
	{
		// 同步代码段
		synchronized (list)
		{
			// 如果仓库剩余容量不足
			if (list.size() + num > 10)
			{
				System.out.println("【要生产的产品数量】:" + num + "\t【库存量】:" + list.size() + "\t暂时不能执行生产任务!");
				try
				{
					// 由于条件不满足，生产阻塞
					list.wait();
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}

			// 生产条件满足情况下，生产num个产品
			for (int i = 1; i <= num; ++i)
			{
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				list.add(new Object());
				System.out.println("生产======\t【现仓储量为】:" + list.size());
			}

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
 class Producer extends Thread
{
	// 每次生产的产品数量
	private int num=10;

	// 所在放置的仓库
	private Storage storage;


	public Producer(Storage storage)
	{
		this.storage = storage;
	}

	// 线程run函数
	public void run()
	{
		while (true) {
			storage.produce(num);
		}
		
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
 class Consumer extends Thread
{
	// 每次消费的产品数量
	private int num=10;

	// 所在放置的仓库
	private Storage storage;


	public Consumer(Storage storage)
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

