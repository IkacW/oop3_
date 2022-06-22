package rs.ac.ni.pmf.oop3.vezbe.vezba05.zad04;

import java.util.ArrayList;
import java.util.List;

public class Controller
{
	private final List<Event> _events = new ArrayList<>();

	public void addEvent(final Event event)
	{
		_events.add(event);
	}

	public void run()
	{
		// Loše
		while (_events.size() > 0)
		{
			// Loše
			for (int i = 0; i < _events.size(); i++)
			{
				final Event event = _events.get(i);

				if (event.isReady())
				{
					System.out.println(event);
					event.executeAction();
					_events.remove(i);
					System.out.println("Number of events remaining: " + _events.size());
				}
			}
		}
	}
}
