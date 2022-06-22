package rs.ac.ni.pmf.oop3.vezbe.vezba05.zad01;

public class MyThread extends Thread
{
	public MyThread(final String name)
	{
		super(name);
	}

	@Override
	public void run()
	{
		System.out.println("Thread: " + Thread.currentThread().getName() + " - run()");
	}

	@Override
	public synchronized void start()
	{
		System.out.println("Sorry not running today...");
		super.start();
	}
}
