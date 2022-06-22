package rs.ac.ni.pmf.oop3.predavanja._01_exceptions;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExceptionsDemo
{
	public static void main(String[] args)
	{
		try
		{
			new ListOfNumbers().generateList("numbers.txt");
		}
		catch (final ListCreationException e)
		{
			final Throwable cause = e.getCause();
			cause.printStackTrace();
		}
	}

	public static void main2(String[] args)
	{
		final Scanner scanner = new Scanner(System.in);

		int x;
		int y;

		try
		{
			x = scanner.nextInt();
			y = scanner.nextInt();
		}
		catch (final InputMismatchException e)
		{
			log.error("Bad input. Aborting...", e);
			return;
		}

		try
		{
			System.out.format("%d / %d = %d%n", x, y, x / y);
			System.out.println("Computation finished.");
		}
		catch (final ArithmeticException e)
		{
			System.out.println("Error! " + e.getMessage());
			return;
		}
		finally
		{
			System.out.println("Executing finally block!");
		}

		try
		{
			FileOutputStream fileOutputStream = new FileOutputStream("test.dat");
		}
		catch (final FileNotFoundException e)
		{
			log.error("File could not be created", e);
		}
	}
}
