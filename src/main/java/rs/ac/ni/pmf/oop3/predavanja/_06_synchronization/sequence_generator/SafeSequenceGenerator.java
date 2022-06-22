package rs.ac.ni.pmf.oop3.predavanja._06_synchronization.sequence_generator;

public class SafeSequenceGenerator implements SequenceGenerator
{
	private int value;

	@Override
	public synchronized int getAndIncrease()
	{
		return value++;
	}
}
