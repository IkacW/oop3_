package rs.ac.ni.pmf.oop3.vezbe.vezba04.orders;

public class EShopTest
{
	public static void main(String[] args)
	{
		final EShop eShop = new EShop();

		eShop.getProductsByCategoryAndPrice("Toys", 900).forEach(System.out::println);
		eShop.getProductsByCategoryAndApplyDiscount("Toys", 0.1).forEach(System.out::println);
	}
}
