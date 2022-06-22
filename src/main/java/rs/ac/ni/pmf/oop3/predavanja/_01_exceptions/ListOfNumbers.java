package rs.ac.ni.pmf.oop3.predavanja._01_exceptions;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ListOfNumbers
{
	private static final int SIZE = 100;
	private static final Random RANDOM = new Random();

	private void writeList(final String fileName) throws FileNotFoundException, BadValueException
	{
		try (final PrintWriter writer = new PrintWriter(fileName))
		{
			for (int i = 0; i < SIZE; i++)
			{
				final int randomValue = RANDOM.nextInt(1000);

				if (100 <= randomValue && randomValue < 500)
				{
					throw new BadValueException("Value " + randomValue + " is a bad value!");
				}

				if (500 <= randomValue && randomValue <= 900)
				{
					throw new ForbiddenValueException("Value " + randomValue + " is a forbidden value!");
				}

				writer.println(i + ": " + randomValue);
			}
		}
	}

	public void generateList(final String fileName) throws ListCreationException
	{
		try
		{
			writeList(fileName);
		}
		catch (final ForbiddenValueException | FileNotFoundException e)
		{
			log.debug("Error: " + e.getMessage());
			throw new ListCreationException("Error creating list", e);
		}
		catch (BadValueException e)
		{
			log.debug("A bad value occurred! Error: " + e.getMessage());
			throw new ListCreationException("Error creating list", e);
		}
	}
}
