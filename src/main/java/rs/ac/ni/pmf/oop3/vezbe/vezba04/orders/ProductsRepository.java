package rs.ac.ni.pmf.oop3.vezbe.vezba04.orders;

import java.util.Arrays;
import java.util.List;

public class ProductsRepository
{
	private final List<Product> _products = Arrays.asList(
		Product.builder().id(1).name("omnis quod consequatur").category("Games").price(184.83).build(),
		Product.builder().id(2).name("vel libero suscipit").category("Toys").price(12.66).build(),
		Product.builder().id(3).name("non nemo iure").category("Grocery").price(498.02).build(),
		Product.builder().id(4).name("voluptatem voluptas aspernatur").category("Toys").price(536.80).build(),
		Product.builder().id(5).name("animi cum rem").category("Games").price(458.20).build(),
		Product.builder().id(6).name("dolorem porro debitis").category("Toys").price(146.52).build(),
		Product.builder().id(7).name("aspernatur rerum qui").category("Books").price(656.42).build(),
		Product.builder().id(8).name("deleniti earum et").category("Baby").price(41.46).build(),
		Product.builder().id(9).name("voluptas ut quidem").category("Books").price(697.57).build(),
		Product.builder().id(10).name("eos sed debitis").category("Baby").price(366.90).build(),
		Product.builder().id(11).name("laudantium sit nihil").category("Toys").price(95.50).build(),
		Product.builder().id(12).name("ut perferendis corporis").category("Grocery").price(302.19).build(),
		Product.builder().id(13).name("sint voluptatem ut").category("Toys").price(295.37).build(),
		Product.builder().id(14).name("quos sunt ipsam").category("Grocery").price(534.64).build(),
		Product.builder().id(15).name("qui illo error").category("Baby").price(623.58).build(),
		Product.builder().id(16).name("aut ex ducimus").category("Books").price(551.39).build(),
		Product.builder().id(17).name("accusamus repellendus minus").category("Books").price(240.58).build(),
		Product.builder().id(18).name("aut accusamus quia").category("Baby").price(881.38).build(),
		Product.builder().id(19).name("doloremque incidunt sed").category("Games").price(988.49).build(),
		Product.builder().id(20).name("libero omnis velit").category("Baby").price(177.61).build(),
		Product.builder().id(21).name("consectetur cupiditate sunt").category("Toys").price(95.46).build(),
		Product.builder().id(22).name("itaque ea qui").category("Baby").price(677.78).build(),
		Product.builder().id(23).name("non et nulla").category("Grocery").price(70.49).build(),
		Product.builder().id(24).name("veniam consequatur et").category("Books").price(893.44).build(),
		Product.builder().id(25).name("magnam adipisci voluptate").category("Grocery").price(366.13).build(),
		Product.builder().id(26).name("reiciendis consequuntur placeat").category("Toys").price(359.27).build(),
		Product.builder().id(27).name("dolores ipsum sit").category("Toys").price(786.99).build(),
		Product.builder().id(28).name("ut hic tempore").category("Toys").price(316.09).build(),
		Product.builder().id(29).name("quas quis deserunt").category("Toys").price(772.78).build(),
		Product.builder().id(30).name("excepturi nesciunt accusantium").category("Toys").price(911.46).build()
	);
	
	public List<Product> findAll()
	{
		return _products;
	}
}
