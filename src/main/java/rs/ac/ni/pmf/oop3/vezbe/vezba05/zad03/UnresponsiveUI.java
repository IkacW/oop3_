package rs.ac.ni.pmf.oop3.vezbe.vezba05.zad03;

import java.io.IOException;
import lombok.Getter;

@Getter
public class UnresponsiveUI
{
	private double d = 1;

	public UnresponsiveUI()
	{
		while (d > 0)
		{
			d = (d + (Math.PI + Math.E)) / d;
		}
	}
}
