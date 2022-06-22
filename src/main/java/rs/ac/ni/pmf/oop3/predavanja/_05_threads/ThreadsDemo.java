package rs.ac.ni.pmf.oop3.predavanja._05_threads;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadsDemo
{
	public static void main(String[] args) throws InterruptedException
	{
//		final Thread t = new WorkerThread(5);
//		t.start();
//
//		new WorkerThread(6).start();
//
//		for (int i = 0; i < 5; i++)
//		{
//			System.out.println(Thread.currentThread().getName() + ": " + i);
//		}
//
//		final Thread t2 = new Thread(new WorkerRunnable(5));
//		t2.start();

//		final Thread t3 = new Thread(() -> print(50));

//		final Thread t3 = new Thread(ThreadsDemo::longTask);
//		t3.start();
//
//		Thread.sleep(2000);
//
//		t3.interrupt(); // Za thread t3 postavlja interrupt indikator

		final Thread t4 = new Thread(ThreadsDemo::anotherTask);
		t4.setName("Worker-Thread");
		t4.setDaemon(true);

		System.out.println("Starting anotherTask()");
		t4.start();

		System.out.println("Working...");
		Thread.sleep(1000);
		System.out.println("Enough waiting! Interrupting the work");
		t4.interrupt();

//		while (t4.isAlive())
//		{
//			System.out.println("Still waiting for thread to finish");
//			t4.join(1000);
//		}

		System.out.println("Work finished!");
	}

	public static void longTask()
	{
		long start = System.currentTimeMillis();
		double sum = 0.0;

		for (long i = 0; i < 5000000000L; i++)
		{
			sum += Math.sqrt(i);

			// Proveravam da li se desio interrupt
			if (Thread.currentThread().isInterrupted())
			{
				log.info("Computation interrupted at i = {}. Sum so far: {}", i, sum);
				break;
			}
		}

		long elapsed = System.currentTimeMillis() - start;
		System.out.println("Time: " + elapsed + "ms");
	}

	public static void print(int n)
	{
		for (int i = 0; i < n; i++)
		{
			System.out.println(Thread.currentThread().getName() + ": " + i);

			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				log.info("Print interrupted!");
				Thread.currentThread().interrupt();
				try
				{
					Thread.sleep(1000);
				}
				catch (InterruptedException ex)
				{
					log.info("Interrupted again. Stopping...");
					return;
				}
			}
		}
	}

	public static void b()
	{
		for(int i = 0; i < 100; i++)
		{
			try
			{
				Thread.sleep(100);
			}
			catch (final InterruptedException e)
			{
				System.out.println("Method b() interrupted, stopping.");
				Thread.currentThread().interrupt();
				return;
			}
		}
	}

	public static void a()
	{
		for(int i = 0; i < 100; i++)
		{
			try
			{
				b();
				Thread.sleep(100);
			}
			catch (final InterruptedException e)
			{
				System.out.println("Method a() interrupted, stopping.");
				Thread.currentThread().interrupt();
				return;
			}
		}
	}

	public static void anotherTask()
	{
		for (int i = 0; i < 100; i++)
		{
			try
			{
				System.out.println(i);
				Thread.sleep(4000);
			}
			catch (InterruptedException e)
			{
				log.info("Thread interrupted. Stopping...");

				try
				{
					Thread.sleep(10000);
				}
				catch (InterruptedException ex)
				{
					ex.printStackTrace();
				}

				log.info("Ready to stop");

				Thread.currentThread().interrupt();
				return;
			}
		}
	}
}
