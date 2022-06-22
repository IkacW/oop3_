package rs.ac.ni.pmf.oop3.predavanja._02_streams;

import java.io.*;

public class ObjectStreamsDemo
{
	public static void main(String[] args) throws IOException
	{
//				final Person person = Person.builder().id(1).firstName("Pera").lastName("Petrovic").email("pera@mail.com").build();
//
//				try (final ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("persons.dat")))
//				{
//					objectOutputStream.writeObject(person);
//				}

		try (final ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("persons.dat")))
		{
			final Person person = (Person)objectInputStream.readObject();
			System.out.println(person.toString());
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
