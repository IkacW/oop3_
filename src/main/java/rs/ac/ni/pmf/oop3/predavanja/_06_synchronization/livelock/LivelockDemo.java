package rs.ac.ni.pmf.oop3.predavanja._06_synchronization.livelock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LivelockDemo
{
	private Lock lock1 = new ReentrantLock(true);
	private Lock lock2 = new ReentrantLock(true);

	private Random r = new Random();

	private Thread t1 = new Thread()
	{
		@Override
		public void run()
		{
			while (true)
			{
				lock1.lock();
				System.out.println("lock1 acquired, trying to acquire lock2...");
				sleepFor(r.nextInt(50));

				if (lock2.tryLock())
				{
					System.out.println("lock2 acquired, executing...");
				}
				else
				{
					System.out.println("lock2 is not available, releasing lock1");
					lock1.unlock();
					continue;
				}

				System.out.println("Executing commands from Thread1");
				break;
			}

			lock1.unlock();
			lock2.unlock();
		}
	};

	private Thread t2 = new Thread()
	{
		@Override
		public void run()
		{
			while (true)
			{
				lock2.lock();
				System.out.println("lock2 acquired, trying to acquire lock1...");
//				sleepFor(50);
				sleepFor(r.nextInt(50));

				if (lock1.tryLock())
				{
					System.out.println("lock1 acquired, executing...");
				}
				else
				{
					System.out.println("lock1 is not available, releasing lock2");
					lock2.unlock();
					continue;
				}

				System.out.println("Executing commands from Thread2");
				break;
			}

			lock1.unlock();
			lock2.unlock();
		}
	};

	public void doDemo() throws InterruptedException
	{
		long start = System.currentTimeMillis();
		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println("Finished in " + (System.currentTimeMillis() - start) + "ms");
	}

	public static void main(String[] args) throws InterruptedException
	{
		new LivelockDemo().doDemo();
	}

	private void sleepFor(long timeout)
	{
		try
		{
			Thread.sleep(timeout);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
