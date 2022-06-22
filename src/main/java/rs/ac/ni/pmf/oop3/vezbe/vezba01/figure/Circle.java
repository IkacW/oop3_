package rs.ac.ni.pmf.oop3.vezbe.vezba01.figure;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString
@SuperBuilder
public class Circle extends Figure
{
	private final double r;

	@Override
	public double area()
	{
		return r * r * Math.PI;
	}

	@Override
	public double circumference()
	{
		return 2 * r * Math.PI;
	}
}
