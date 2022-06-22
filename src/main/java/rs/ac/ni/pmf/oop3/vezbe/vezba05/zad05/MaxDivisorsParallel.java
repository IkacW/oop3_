package rs.ac.ni.pmf.oop3.vezbe.vezba05.zad05;

import java.util.*;
import java.util.stream.IntStream;

public class MaxDivisorsParallel
{
	private static final int GROUP_SIZE = 10000;

	public static void main(String[] args) throws InterruptedException
	{
		final long start = System.currentTimeMillis();
		final List<DivisorsWorker> workers = new ArrayList<>();

		IntStream.range(0, 10)
			.forEach(i -> workers.add(new DivisorsWorker("Worker-" + i, GROUP_SIZE * i + 1, GROUP_SIZE * (i + 1))));

		workers.forEach(Thread::start);
		for (DivisorsWorker worker : workers)
		{
			worker.join();
		}

		final DivisorsWorker max = workers.stream()
			.max(Comparator.comparingInt(DivisorsWorker::getMaxDivisors)).get();

		final long end = System.currentTimeMillis();
		System.out.printf(
			"Number %d has the maximal number of divisors - %d%n",
			max.getValue(),
			max.getMaxDivisors());
		System.out.printf("Search duration: %d ms%n", end - start);
	}
}
