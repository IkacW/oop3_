package rs.ac.ni.pmf.oop3.predavanja._06_synchronization.wait;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SharedStorage
{
	String _message;
	boolean _empty = true;

	public synchronized String get()
	{
		log.info("Waiting to get a message");
		while (_empty)
		{
			try
			{
				wait();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}

		log.info("Got the message");
		_empty = true;
		notifyAll();
		return _message;
	}

	public synchronized void set(final String message)
	{
		log.info("Waiting to set the message");
		while (!_empty)
		{
			try
			{
				wait();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}

		log.info("Setting the message");
		_empty = false;
		_message = message;
		notifyAll();
	}
}
