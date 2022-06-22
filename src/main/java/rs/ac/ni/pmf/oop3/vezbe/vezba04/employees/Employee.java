package rs.ac.ni.pmf.oop3.vezbe.vezba04.employees;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Employee
{
	long id;
	String name;
	Title title;
	int salary;

	public enum Title
	{
		CEO,
		CTO,
		DEVELOPER,
		QA
	}
}
