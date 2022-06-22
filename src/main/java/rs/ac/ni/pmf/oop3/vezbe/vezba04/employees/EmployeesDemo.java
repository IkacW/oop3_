package rs.ac.ni.pmf.oop3.vezbe.vezba04.employees;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeesDemo
{
	private EmployeesRepository _repository = EmployeesRepository.INSTANCE;

	public double averageSalary()
	{
		return _repository.findAll().stream()
			.mapToInt(Employee::getSalary)
			.average()
			.orElse(0);

//		final List<Employee> employees = _repository.findAll();
//
//		int count = employees.size();
//		if (count == 0)
//		{
//			return 0;
//		}
//
//		int totalSalary = 0;
//		for (Employee employee : employees)
//		{
//			totalSalary += employee.getSalary();
//		}
//
//		return ((double)totalSalary) / count;
	}

	public Map<Employee.Title, List<Employee>> groupByTitle()
	{
		final Map<Employee.Title, List<Employee>> map = new HashMap<>();

		for (final Employee employee : _repository.findAll())
		{
			final Employee.Title title = employee.getTitle();

			List<Employee> list = map.get(title);

			if (list == null) {
				list = new ArrayList<>();
				map.put(title, list);
			}

			list.add(employee);
		}

		return map;
	}

	public Map<Employee.Title, List<Employee>> groupByTitle2()
	{
		final Map<Employee.Title, List<Employee>> map = new HashMap<>();

		for (final Employee employee : _repository.findAll())
		{
			List<Employee> list = map.computeIfAbsent(employee.getTitle(), k -> new ArrayList<>());
			list.add(employee);
		}

		return map;
	}

	public Map<Employee.Title, List<Employee>> groupByTitle3()
	{
		return _repository.findAll().stream()
			.collect(Collectors.groupingBy(Employee::getTitle));
	}

	public static void main(String[] args)
	{
		final EmployeesDemo employeesDemo = new EmployeesDemo();

//		double averageSalary = employeesDemo.averageSalary();
//		System.out.println(averageSalary);

		final Map<Employee.Title, List<Employee>> employeesByTitle = employeesDemo.groupByTitle3();

		employeesByTitle.forEach((key, value) -> {
			System.out.println(key);
			System.out.println(value.stream().mapToInt(Employee::getSalary).average().orElse(0));

//			String output = value.stream()
//				.map(Employee::getName)
//				.collect(Collectors.joining(", "));
//			System.out.println(output);
		});
	}
}
