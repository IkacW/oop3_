package rs.ac.ni.pmf.oop3.predavanja._06_synchronization;

import lombok.Value;

@Value
public class ImmutableRGB
{
	int red;
	int green;
	int blue;
	String name;

	public int getRGB()
	{
		return ((red << 16) | (green << 8) | blue);
	}

	public ImmutableRGB invert()
	{
		return new ImmutableRGB(
			255 - red, 255 - green, 255 - blue,
			"Inverse of " + name);
	}
}
