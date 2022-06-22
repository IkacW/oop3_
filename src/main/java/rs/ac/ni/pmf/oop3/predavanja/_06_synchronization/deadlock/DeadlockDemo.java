package rs.ac.ni.pmf.oop3.predavanja._06_synchronization.deadlock;

public class DeadlockDemo
{
	public static void main(String[] args) throws InterruptedException
	{

		final String resource1 = "Resource 1";
		final String resource2 = "Resource 2";

		final Thread t1 = new Thread()
		{
			@Override
			public void run()
			{
				System.out.println("Starting t1");
				System.out.println("T1: Locking " + resource1);

				synchronized (resource1)
				{
					try
					{
						Thread.sleep(100);
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}

					System.out.println("T1: Locking " + resource2);
					synchronized (resource2)
					{
						System.out.println("T1: Both resources locked. Processing...");
						System.out.println(resource1 + ":" + resource2);
					}
				}
			}
		};

		final Thread t2 = new Thread()
		{
			@Override
			public void run()
			{
				System.out.println("Starting t2");

//				System.out.println("Locking " + resource2);
				// 				synchronized (resource2)

				System.out.println("T2: Locking " + resource1);
				synchronized (resource1)
				{
					try
					{
						Thread.sleep(100);
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}

//					System.out.println("Locking " + resource1);
//					synchronized (resource1)
					System.out.println("T2: Locking " + resource2);
					synchronized (resource2)
					{
						System.out.println("T2: Both resources locked. Processing...");
						System.out.println(resource1 + "-" + resource2);
					}
				}
			}
		};

		t1.start();
		t2.start();

		t1.join();
		t2.join();
	}
}
