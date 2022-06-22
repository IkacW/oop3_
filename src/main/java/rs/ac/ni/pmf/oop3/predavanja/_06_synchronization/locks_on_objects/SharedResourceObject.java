package rs.ac.ni.pmf.oop3.predavanja._06_synchronization.locks_on_objects;

import java.util.concurrent.locks.Lock;

public class SharedResourceObject
{
	private final Object lockA = new Object();
	private final Object lockB = new Object();

	private int valueA;
	private int valueB;
	private int valueC;

	public int methodA()
	{
		int currentValue;

		synchronized (lockA)
		{
			System.out.println("Executing method A");
			sleepFor(2000);
			currentValue = valueA;
			valueA++;
			System.out.println("Finished method A");
		}

		return currentValue;
	}

	public int methodB()
	{
		int currentValue;

		synchronized (lockB)
		{
			System.out.println("Executing method B");
			sleepFor(2000);
			currentValue = valueB;
			valueB++;
			System.out.println("Finished method B");
		}

		return currentValue;
	}

	public int methodC()
	{
		System.out.println("Executing method C");
		sleepFor(2000);
		System.out.println("Finished method C");
		return valueC++;
	}

	private static void sleepFor(long timeout)
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