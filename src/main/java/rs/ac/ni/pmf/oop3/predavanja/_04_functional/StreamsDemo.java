package rs.ac.ni.pmf.oop3.predavanja._04_functional;

import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsDemo
{
	private static IntStream createPipeline(Stream<Integer> stream)
	{
		return stream
			.peek(e -> System.out.println("Currently processing element " + e))
			.filter(e -> e % 2 == 0)
			.peek(e -> System.out.println("Element " + e + " successfully filtered"))
			.map(e -> e / 2)
			.mapToInt(e -> e + 3);
	}

	private static Stream<Integer> filter(Stream<Integer> list)
	{
		return list.filter(e -> e % 2 == 0);
	}

	private static Stream<Integer> process(Stream<Integer> list)
	{
		return list.map(e -> e / 2);
	}

	public static void main(String[] args)
	{
		final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		final List<Integer> oddNumbers = List.of(1, 3, 5, 7, 9);
		final List<Integer> duplicates = List.of(1, 3, 1, 5, 1, 1, 7, 3, 5, 6, 7, 9);

		//		final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		//		System.out.println(createPipeline(numbers.stream()).sum());
		//		System.out.println(createPipeline(numbers.stream()).max().getAsInt());

		//		int x = numbers.stream()
		//			.filter(e -> e % 2 == 0)
		//			.findAny()
		//			.orElseGet(() -> {
		//				System.out.println("No even numbers found");
		//				return -1;
		//			});
		//
		//		System.out.println(x);

//		System.out.println(duplicates.stream()
//			.distinct()
//			.filter(e -> e % 2 == 0)
//			.count());

		int sum = numbers.stream()
			.sorted(Comparator.reverseOrder())
			.limit(4)
			.reduce(0, (accumulated, current) -> accumulated + current);

		System.out.println(sum);
	}
}
