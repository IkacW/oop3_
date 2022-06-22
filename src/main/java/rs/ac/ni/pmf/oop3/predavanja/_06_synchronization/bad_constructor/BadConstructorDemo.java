package rs.ac.ni.pmf.oop3.predavanja._06_synchronization.bad_constructor;

import java.util.ArrayList;
import java.util.List;

public class BadConstructorDemo
{
	public static void main(String[] args)
	{
		final List<ObjectInstance> instances = new ArrayList<>();

		new Thread(() -> {
			new ObjectInstance("1", instances);
		}).start();

		new Thread(() -> {
			sleepFor(1000);
			instances.forEach(instance -> {
				System.out.println(instance.getLabel());
				System.out.println(instance.getOtherLabel());
			});
		}).start();

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
