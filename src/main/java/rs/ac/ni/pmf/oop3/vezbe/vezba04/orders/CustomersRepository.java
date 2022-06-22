package rs.ac.ni.pmf.oop3.vezbe.vezba04.orders;

import java.util.Arrays;
import java.util.List;

public class CustomersRepository
{
	private final List<Customer> _customers = Arrays.asList(
		Customer.builder().id(1).name("Stefan Walker").tier(1).build(),
		Customer.builder().id(2).name("Daija Von").tier(1).build(),
		Customer.builder().id(3).name("Ariane Rodriguez").tier(1).build(),
		Customer.builder().id(4).name("Marques Nikolaus").tier(2).build(),
		Customer.builder().id(5).name("Rachelle Greenfelder").tier(0).build(),
		Customer.builder().id(6).name("Larissa White").tier(2).build(),
		Customer.builder().id(7).name("Fae Heidenreich").tier(1).build(),
		Customer.builder().id(8).name("Dino Will").tier(2).build(),
		Customer.builder().id(9).name("Eloy Stroman").tier(1).build(),
		Customer.builder().id(10).name("Brisa O'Connell").tier(1).build()
	);

	public List<Customer> findAll()
	{
		return _customers;
	}
}
