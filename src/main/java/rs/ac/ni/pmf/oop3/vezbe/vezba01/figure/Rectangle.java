package rs.ac.ni.pmf.oop3.vezbe.vezba01.figure;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString
@SuperBuilder
public class Rectangle extends Figure
{
	private final double a;
	private final double b;

	@Override
	public double area()
	{
		return a * b;
	}

	@Override
	public double circumference()
	{
		return 2 * (a + b);
	}
}
