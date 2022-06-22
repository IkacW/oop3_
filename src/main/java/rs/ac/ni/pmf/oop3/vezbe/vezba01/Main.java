package rs.ac.ni.pmf.oop3.vezbe.vezba01;

import java.util.*;
import rs.ac.ni.pmf.oop3.vezbe.vezba01.figure.*;

public class Main
{
	private static final int SCALE = 10;

	public static void main(String[] args)
	{
		final List<Figure> figures;
		final int argCount = args.length;


		if (argCount >= 2)
		{
			final int m = Integer.parseInt(args[0]);
			final int n = Integer.parseInt(args[1]);

			figures = generateFigures(m, n);
		}
		else if (argCount == 1)
		{
			final int n = Integer.parseInt(args[0]);
			figures = generateFigures(n, n);
		}
		else
		{
			// Pitamo korisnika koliko krugova, koliko pravougaonika
			final Scanner in = new Scanner(System.in);
			int m = in.nextInt();
			int n = in.nextInt();
			in.close();

			figures = generateFigures(m, n);
		}

//		Collections.sort(figures);
		figures.sort((o1, o2) -> Double.compare(o2.circumference(), o1.circumference()));

		printDetails(figures);


		Collections.shuffle(figures);

		System.out.println("*******************************************");
		System.out.println("*******************************************");
		System.out.println("*******************************************");

		printDetails(figures);
	}

	private static void printDetails(List<Figure> figures)
	{
		for (final Figure figure : figures)
		{
			System.out.println(figure.getLabel());
			System.out.println(figure);
			System.out.println("Circumference: " + figure.circumference());
			System.out.println("---------------------------------");
		}
	}

	private static List<Figure> generateFigures(int numberOfCircles, int numberOfRectangles)
	{
		final Random random = new Random();
		final List<Figure> figures = new ArrayList<>();

		for (int i = 0; i < numberOfCircles; i++)
		{
			final String label = "Circle_" + i;
			final double radius = random.nextDouble() * SCALE;

			figures.add(Circle.builder().label(label).r(radius).build());
		}

		for (int i = 0; i < numberOfRectangles; i++)
		{
			final String label = "Rectangle_" + i;
			final double a = random.nextDouble() * SCALE;
			final double b = random.nextDouble() * SCALE;

			figures.add(Rectangle.builder().label(label).a(a).b(b).build());
		}

		return  figures;
	}
}
