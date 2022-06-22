package rs.ac.ni.pmf.oop3.predavanja._02_streams;

import java.io.*;

public class DataStreamsDemo
{
	static final double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
	static final int[] units = { 12, 8, 13, 29, 50 };
	static final String[] descs = {
		"Java T-shirt",
		"Java Mug",
		"Duke Juggling Dolls",
		"Java Pin",
		"Java Key Chain"
	};

	public static void main(String[] args) throws IOException
	{
		try (final DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.dat")))
		{
			for (int i = 0; i < prices.length; i++)
			{
				dos.writeDouble(prices[i]);
				dos.writeInt(units[i]);
				dos.writeUTF(descs[i]);
			}
		}

		try (final DataInputStream dis = new DataInputStream(new FileInputStream("data.dat")))
		{
			while (true)
			{
				final double price = dis.readDouble();
				final int unit = dis.readInt();
				final String description = dis.readUTF();

				System.out.println("price: " + price + ", unit: " + unit + ", desc: " + description);
			}
		}
		catch (final EOFException e)
		{
			System.out.println("Done");
		}
	}
}
