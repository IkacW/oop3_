package rs.ac.ni.pmf.oop3.predavanja._06_synchronization.wait;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class WaitNotifyDemo
{
	public static void main(String[] args) throws InterruptedException
	{
		final SharedStorage sharedStorage = new SharedStorage();

		final List<Producer> producers = new ArrayList<>();
		final List<Consumer> consumers = new ArrayList<>();

		IntStream.range(0, 3).forEach(i -> producers.add(new Producer(i, sharedStorage)));
		IntStream.range(0, 3).forEach(i -> consumers.add(new Consumer(sharedStorage)));

		consumers.forEach(Thread::start);
		producers.forEach(Thread::start);

		for (Thread p : producers) {
			p.join();
		}

		for (Thread c : consumers) {
			c.join();
		}
	}
}
