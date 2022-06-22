package rs.ac.ni.pmf.oop3.vezbe.vezba06;

public class STC implements AutoCloseable
{

	@Override
	public void close() throws Exception
	{
		throw new Exception("Not closed");
	}

	public static void main(String[] args) throws Exception
	{
		try(STC t = new STC())
		{
			System.out.println("x");
		}
	}
}
