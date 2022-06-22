package rs.ac.ni.pmf.oop3.vezbe.vezba05.zad04;

import java.util.Timer;
import java.util.TimerTask;

public class GreenhouseController extends Controller
{
	private boolean _light;
	private boolean _water;
	private String _thermostat = "Day";

	// Events
	public class LightOn extends Event
	{
		public LightOn(long delayTime)
		{
			super(delayTime);
		}

		@Override
		public void executeAction()
		{
			_light = true;
		}

		@Override
		public String toString()
		{
			return "Light is on";
		}
	}

	public class LightOff extends Event
	{
		public LightOff(long delayTime)
		{
			super(delayTime);
		}

		@Override
		public void executeAction()
		{
			_light = false;
		}

		@Override
		public String toString()
		{
			return "Light is off";
		}
	}

	public class WaterOn extends Event
	{
		public WaterOn(long delayTime)
		{
			super(delayTime);
		}

		@Override
		public void executeAction()
		{
			_water = true;
		}

		@Override
		public String toString()
		{
			return "Water is on";
		}
	}

	public class WaterOff extends Event
	{
		public WaterOff(long delayTime)
		{
			super(delayTime);
		}

		@Override
		public void executeAction()
		{
			_water = false;
		}

		@Override
		public String toString()
		{
			return "Water is off";
		}
	}

	public class ThermostatNight extends Event
	{
		public ThermostatNight(long delayTime)
		{
			super(delayTime);
		}

		@Override
		public void executeAction()
		{
			_thermostat = "Night";
		}

		@Override
		public String toString()
		{
			return "Thermostat on night settings";
		}
	}

	public class ThermostatDay extends Event
	{
		public ThermostatDay(long delayTime)
		{
			super(delayTime);
		}

		@Override
		public void executeAction()
		{
			_thermostat = "Day";
		}

		@Override
		public String toString()
		{
			return "Thermostat on day settings";
		}
	}

	public class Bell extends Event
	{
		public Bell(long delayTime)
		{
			super(delayTime);
		}

		@Override
		public void executeAction()
		{
			addEvent(new Bell(_delayTime));
		}

		@Override
		public String toString()
		{
			return "Bing!";
		}
	}

	public class Restart extends Event
	{
		private Event[] _events;

		public Restart(final long delayTime, final Event[] events)
		{
			super(delayTime);
			_events = events;
			for (int i = 0; i < _events.length; i++)
			{
				_events[i].start();
				addEvent(_events[i]);
			}
		}

		@Override
		public void executeAction()
		{
			for (int i = 0; i < _events.length; i++)
			{
				_events[i].start();
				addEvent(_events[i]);
			}
			start();
			addEvent(this);
		}

		@Override
		public String toString()
		{
			return "Restarting the system";
		}
	}

	public class Terminate extends Event
	{
		public Terminate(long delayTime)
		{
			super(delayTime);
		}

		@Override
		public void executeAction()
		{
			System.exit(0);
		}

		@Override
		public String toString()
		{
			return "Terminating";
		}
	}
}
