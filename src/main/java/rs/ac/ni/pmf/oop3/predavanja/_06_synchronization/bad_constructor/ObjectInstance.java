package rs.ac.ni.pmf.oop3.predavanja._06_synchronization.bad_constructor;

import java.util.List;
import lombok.Getter;

public class ObjectInstance
{
	private String label;
	private String otherLabel = "BAD_LABEL";

	public ObjectInstance(final String label, final List<ObjectInstance> currentInstances)
	{
		synchronized (this)
		{
			this.label = "Instance_" + label;

			// Initialization...
			currentInstances.add(this);

			// More long initialization...
			try
			{
				Thread.sleep(5000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}

			otherLabel = "OTHER: " + this.label;
		}
	}

	public synchronized String getLabel()
	{
		return label;
	}

	public synchronized String getOtherLabel()
	{
		return otherLabel;
	}
}
