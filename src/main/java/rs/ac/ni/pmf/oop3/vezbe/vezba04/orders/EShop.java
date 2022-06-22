package rs.ac.ni.pmf.oop3.vezbe.vezba04.orders;

import java.util.List;
import java.util.stream.Collectors;

public class EShop
{
	private final ProductsRepository _productsRepository = new ProductsRepository();
	private final OrdersRepository _ordersRepository = new OrdersRepository();

	public List<Product> getProductsByCategoryAndPrice(final String category, final double minPrice)
	{
		return _productsRepository.findAll().stream()
			.filter(product -> product.getCategory().equalsIgnoreCase(category))
			.filter(product -> product.getPrice() > minPrice)
			.collect(Collectors.toList());
	}

	public List<Order> getOrdersWithProductCategory(final String category)
	{
		return _ordersRepository.findAll().stream()
			.filter(order -> orderContainsProductOfCategory(order, category))
			.collect(Collectors.toList());
	}

	private boolean orderContainsProductOfCategory(final Order order, final String category)
	{
		return order.getProducts().stream()
			.anyMatch(product -> product.getCategory().equals(category));
	}

	public List<Product> getProductsByCategoryAndApplyDiscount(final String category, final double discount)
	{
		return _productsRepository.findAll().stream()
			.filter(product -> product.getCategory().equals(category))
			.map(product -> product.withDiscount(0.1))
			.collect(Collectors.toList());
	}
}
