package rs.ac.ni.pmf.oop3.predavanja._04_functional;

import java.util.function.*;

public class FunctionalDemo
{
	public static void main(String[] args)
	{
		// Supplier<T>
		// 		T get()

		// Predicate<T>
		// 		boolean test(T t)

		// Function<T, R>
		// 		R apply(T t)

		// Consumer<T>
		// 		void accept(T t)

		final int value1 = doOperation(5, x -> 2 * x);
		final int value2 = doOperation(5, x -> 3 * x);

		System.out.println(value1);
		System.out.println(value2);

		printOperationValue(10, 5, Integer::sum);

		printOperationValue(10, 5, FunctionalDemo::complexComputation);
	}

	private static int complexComputation(int x, int y)
	{
		int pom = x - y;
		pom = x * pom + y;
		pom = pom * 3;
		return pom;
	}

	private static int doOperation(int x, Function<Integer, Integer> operation)
	{
		return operation.apply(x);
	}

	private static void printOperationValue(int a, int b, Operation op)
	{
		System.out.println(op.compute(a, b));
	}
}
