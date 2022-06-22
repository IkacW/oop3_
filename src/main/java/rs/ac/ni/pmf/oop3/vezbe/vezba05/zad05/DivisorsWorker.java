package rs.ac.ni.pmf.oop3.vezbe.vezba05.zad05;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class DivisorsWorker extends Thread
{
	private final String workerName;
	private final int from;
	private final int to;

	private int maxDivisors;
	private int value;

	public static int divisorsCount(int n)
	{
		int count = 0;

		for (int i = 1; i <= n; i++)
		{
			if (n % i == 0)
			{
				count++;
			}
		}

		return count;
	}

	@Override
	public void run()
	{
		maxDivisors = 0;
		value = 0;
		final long start = System.currentTimeMillis();
		for (int i = from; i < to; i++)
		{
			int currentDivisors = divisorsCount(i);
			if (currentDivisors > maxDivisors)
			{
				maxDivisors = currentDivisors;
				value = i;
			}
		}
		final long end = System.currentTimeMillis();
		System.out.printf("Worker %s finished in %d ms%n", workerName, end - start);
	}
}
