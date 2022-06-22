package rs.ac.ni.pmf.oop3.vezbe;

public class WaitUtil
{
	public static void sleep(final long timeout)
	{
		try
		{
			Thread.sleep(timeout);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
