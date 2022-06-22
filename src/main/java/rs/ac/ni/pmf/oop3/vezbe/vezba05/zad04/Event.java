package rs.ac.ni.pmf.oop3.vezbe.vezba05.zad04;

public abstract class Event
{
	private long _eventTime;

	protected final long _delayTime;

	public Event(final long delayTime)
	{
		_delayTime = delayTime;
		start();
	}

	public void start()
	{
		_eventTime = System.currentTimeMillis() + _delayTime;
	}

	public boolean isReady()
	{
		return System.currentTimeMillis() >= _eventTime;
	}

	public abstract void executeAction();
}
