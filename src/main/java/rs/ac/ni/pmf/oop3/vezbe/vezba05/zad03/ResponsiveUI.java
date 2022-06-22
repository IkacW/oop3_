package rs.ac.ni.pmf.oop3.vezbe.vezba05.zad03;

import lombok.Getter;

@Getter
public class ResponsiveUI extends Thread
{
	private volatile double d = 1;

	@Override
	public void run()
	{
		while (true)
		{
			d = d + (Math.PI + Math.E) / d;

			if (Thread.interrupted())
			{
				return;
			}
		}
	}
}
