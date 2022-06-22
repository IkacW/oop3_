package rs.ac.ni.pmf.oop3.predavanja._06_synchronization.sequence_generator;

public class UnsafeSequenceGenerator implements SequenceGenerator
{
	private int value;

	@Override
	public int getAndIncrease()
	{
		int currentValue = value;
		value = value + 1;
		return currentValue;
	}
}
