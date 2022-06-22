package rs.ac.ni.pmf.oop3.predavanja._04_functional;

import java.util.List;
import java.util.function.Consumer;

public class FunctionalDemo2
{
	public static void main(String[] args)
	{
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

//		int sum = 0;

		for (final Integer el : numbers)
		{
			if (el % 2 == 0)
			{
//				sum += 3 * el;
				System.out.println(3 * el);
			}
		}

		numbers.stream()
			.filter(el -> el % 2 == 0)
			.map(el -> 3 * el)
			.forEach(System.out::println);

		/*
			el1 -> el2 -> el3 -> ...
	filter		|
			el1 -> x   -> el3
		 */

//		System.out.println(sum);
	}
}
