package rs.ac.ni.pmf.oop3.vezbe.vezba04;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.*;

public class PredicatesDemo
{
	public static void main(String[] args)
	{
		//		check(10, evenChecker());

		//		IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
		//			.boxed()
		//			.filter(evenChecker())
		//			.forEach(System.out::println);

		//		IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
		//			.filter(v -> v % 2 == 0)
		//			.forEach(System.out::println);
		//		IntStream.rangeClosed(1, 10)
		//			.forEach(System.out::println);

		//		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
		//			.filter(evenChecker())
		//			.forEach(System.out::println);

		//		IntStream.rangeClosed(1, 1000)
		////			.filter(primeChecker())
		////			.filter(PredicatesDemo::isPrime)
		//			.filter(v -> BigInteger.valueOf(v).isProbablePrime(1))
		//			.forEach(System.out::println);

		//		check(12121, palindromeChecker());
		//		check(12121, PredicatesDemo::isPalindrome);
//		check(12323, PredicatesDemo::isPalindrome2);

		System.out.println(sumOfDigits(1232312));
	}

	private static Predicate<Integer> evenChecker()
	{
		return v -> v % 2 == 0;
	}

	private static IntPredicate primeChecker()
	{
		return PredicatesDemo::isPrime;
	}

	private static boolean isPalindrome2(int v)
	{
		String s = Integer.toString(v);
		return s.equals(new StringBuilder(s).reverse().toString());
	}

	private static boolean isPalindrome(int v)
	{
		List<Integer> digits = new ArrayList<>();
		int x = v;

		while (x > 0)
		{
			int c = x % 10;
			digits.add(c);
			x = x / 10;
		}

		int invV = 0;
		for (int d : digits)
		{
			invV = 10 * invV + d;
		}
		return v == invV;
	}

	private static IntPredicate palindromeChecker()
	{
		return v -> {
			List<Integer> digits = new ArrayList<>();

			int x = v;
			while (x > 0)
			{
				int c = x % 10;
				digits.add(c);
				x = x / 10;
			}

			boolean palindrome = true;
			int len = digits.size() - 1;
			for (int i = 0; palindrome && i <= len / 2; i++)
			{
				if (digits.get(i) != digits.get(len - i))
				{
					palindrome = false;
				}
			}

			return palindrome;
		};
	}

	private static boolean isPrime(int v)
	{
		boolean prime = v == 2 || (v > 2 && v % 2 != 0);

		int candidate = 3;

		while (prime && candidate <= Math.sqrt(v))
		{
			if (v % candidate == 0)
			{
				prime = false;
			}
			else
			{
				candidate += 2;
			}
		}

		return prime;
	}

	private static void check(int x, IntPredicate checker)
	{
		System.out.println(checker.test(x));
	}

	public static int sumOfDigits(int v)
	{
		/*
			12345 = 1 * 10^4 + 2 * 10^3 + 3 * 10^2 + 4 * 10 + 5
		 */
//		int numOfDigits = ?;

		return IntStream.iterate(v, el -> el > 0, el -> el / 10)
//		return IntStream.iterate(v, x -> x / 10)
//			.limit(numOfDigits)
			.map(el -> el % 10)
			.filter(el -> el % 2 == 1)
			.sum();
	}
}
