package rs.ac.ni.pmf.oop3.predavanja._06_synchronization.starvation;

public class LowPriorityThread extends Thread
{
	private final SharedResource shared;

	public LowPriorityThread(final SharedResource shared)
	{
		this.shared = shared;
		setPriority(MIN_PRIORITY);
	}

	@Override
	public void run()
	{
		shared.testMethod("LOW");
	}
}
