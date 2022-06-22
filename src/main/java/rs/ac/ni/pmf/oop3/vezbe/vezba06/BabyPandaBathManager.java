package rs.ac.ni.pmf.oop3.vezbe.vezba06;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class BabyPandaBathManager
{
	public static void await(CyclicBarrier cb)
	{
		try
		{
			cb.await();
		}
		catch (InterruptedException | BrokenBarrierException e)
		{
			// Handle exception
		}
	}

	public static void main(String[] args)
	{
		IntStream.iterate(1, i -> i + 1)
			.limit(12)
			.forEach(System.out::println);

		final CyclicBarrier cb = new CyclicBarrier(3, () -> System.out.println("Clean!"));// u1
		ExecutorService service = Executors.newScheduledThreadPool(2);
		IntStream.iterate(1, i -> 1) // u2
			.limit(12)
			.forEach(i -> service.submit( // u3
				() -> {
					System.out.println("Calling cb from thread " + Thread.currentThread().getName());
					await(cb);
				})); // u4
		service.shutdown();
	}
}
