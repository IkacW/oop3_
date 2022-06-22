package rs.ac.ni.pmf.oop3.predavanja._02_streams;

import java.io.*;
import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamsDemo
{
	private static final int MAX_BYTES = 1000;

	public static void main1(String[] args)
	{
		final InputStream inputStream = StreamsDemo.class.getClassLoader()
			.getResourceAsStream("brojevi.txt");

		if (inputStream == null)
		{
			System.out.println("Fajl 'brojevi.txt' nije pronadjen");
			return;
		}

		Scanner scanner = new Scanner(inputStream);

		int x = scanner.nextInt();

		System.out.println("Ucitan broj: " + x);

		try
		{
			inputStream.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException
	{
//		try(final FileOutputStream fos = new FileOutputStream("numbers.dat"))
//		{
//			final long start = System.currentTimeMillis();
//
//			for (int i = 0; i < 10000000; i++)
//			{
//				fos.write(i);
//			}
//
//			final long ellapsed = System.currentTimeMillis() - start;
//
//			System.out.println("Writing took: " + ellapsed + "ms");
//
////			copyBytes("letters.txt", "letters-bytes-copy.txt");
////			copyChars("letters.txt", "letters-chars-copy.txt");
//		}
//		catch (IOException e)
//		{
//			System.out.println(e.getMessage());
//		}

		try(final BufferedOutputStream baos = new BufferedOutputStream(new FileOutputStream("numbers.dat")))
		{
			final long start = System.currentTimeMillis();

			for (int i = 0; i < 10000000; i++)
			{
				baos.write(i);
			}

			baos.flush();

			final long ellapsed = System.currentTimeMillis() - start;

			System.out.println("Writing took: " + ellapsed + "ms");

//			copyBytes("letters.txt", "letters-bytes-copy.txt");
//			copyChars("letters.txt", "letters-chars-copy.txt");
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}

	private static void copyChars(final String inFileName, final String outFileName) throws IOException
	{
		try (final FileReader in = new FileReader(inFileName); final FileWriter out = new FileWriter(outFileName))
		{
			int c;
			int counter = 0;

			while ((c = in.read()) != -1)
			{
				out.write(c);
				++counter;
			}

			System.out.println("copyChars - total reads: " + counter);
		}
	}

	private static void copyBytes(final String inFileName, final String outFileName) throws IOException
	{
		try (final FileInputStream in = new FileInputStream(inFileName);
			final FileOutputStream out = new FileOutputStream(outFileName))
		{
			// Copy the file
			System.out.println("copyBytes - total reads: " + copyBytePerByte(in, out));
			//			System.out.println("Total reads: " + copyUsingBuffer(in, out));
		}
	}

	private static int copyUsingBuffer(final FileInputStream in, final FileOutputStream out) throws IOException
	{
		byte[] buffer = new byte[MAX_BYTES];
		int counter = 0;
		int bytesRead;

		while ((bytesRead = in.read(buffer)) != -1)
		{
			out.write(buffer, 0, bytesRead);
			counter++;
		}

		return counter;
	}

	private static int copyBytePerByte(final FileInputStream in, final FileOutputStream out) throws IOException
	{
		int c;
		int counter = 0;

		while ((c = in.read()) != -1)
		{
			out.write(c);
			++counter;
		}

		return counter;
	}
}
