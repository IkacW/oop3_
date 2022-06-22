package rs.ac.ni.pmf.oop3.vezbe.vezba05.zad05;

import java.util.stream.IntStream;

public class MaxDivisorsMain
{
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

	public static void main(String[] args)
	{
		final long start = System.currentTimeMillis();

		int maxDivisors = IntStream.range(1, 100000)
			.parallel()
			.map(MaxDivisorsMain::divisorsCount)
			.max().getAsInt();

		final long end = System.currentTimeMillis();
		System.out.printf("Maximal number of divisors - %d%n", maxDivisors);
		System.out.printf("Search duration: %d ms%n", end - start);
	}
}
