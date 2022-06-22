package rs.ac.ni.pmf.oop3.vezbe.vezba04.orders;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer
{
	private long id;
	private String name;
	private int tier;
}
