package rs.ac.ni.pmf.oop3.predavanja._06_synchronization.starvation;

public class HighPriorityThread extends Thread
{
	private final SharedResource shared;

	public HighPriorityThread(final SharedResource shared)
	{
		this.shared = shared;
		setPriority(Thread.MAX_PRIORITY);
	}

	@Override
	public void run()
	{
		shared.testMethod("HIGH");
	}
}
