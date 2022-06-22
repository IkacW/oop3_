package rs.ac.ni.pmf.oop3.vezbe.vezba04.orders;

import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order
{
	private long id;
	private String status;
	private LocalDate orderDate;
	private LocalDate deliveryDate;

	private List<Product> products;
	private Customer customer;
}
