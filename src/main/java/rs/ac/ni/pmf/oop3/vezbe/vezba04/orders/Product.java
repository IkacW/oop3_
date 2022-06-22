package rs.ac.ni.pmf.oop3.vezbe.vezba04.orders;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product
{
	private long id;
	private String name;
	private String category;
	private double price;

	public Product withDiscount(double discount) {
		return Product.builder()
			.id(id)
			.name(name)
			.category(category)
			.price(price * (1 - discount))
			.build();
	}
}
