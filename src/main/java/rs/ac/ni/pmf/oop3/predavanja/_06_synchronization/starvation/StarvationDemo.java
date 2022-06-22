package rs.ac.ni.pmf.oop3.predavanja._06_synchronization.starvation;

import java.util.ArrayList;
import java.util.List;

public class StarvationDemo
{
	public static void main(String[] args) throws InterruptedException
	{
		final SharedResource sharedResource = new SharedResource();

		final List<Thread> threads = new ArrayList<>();

		for (int i = 0; i < 10; i++)
		{
			threads.add(new HighPriorityThread(sharedResource));
			threads.add(new LowPriorityThread(sharedResource));
		}

		threads.forEach(Thread::start);

		for (Thread t : threads)
		{
			t.join();
		}
	}
}
