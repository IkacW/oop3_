package rs.ac.ni.pmf.oop3.vezbe.vezba04.orders;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class OrdersRepository
{
	private CustomersRepository _customersRepository;

	public List<Order> _orders = Arrays.asList(
		Order.builder().id(1).orderDate(LocalDate.parse("2021-02-28")).deliveryDate(LocalDate.parse("2021-03-08")).status("NEW").customer(findCustomer(5)).build());
//		Order.builder().id(2).orderDate("2021-02-28").deliveryDate("2021-03-05").status("NEW").3)
//	Order.builder().id(3).orderDate("2021-04-10").deliveryDate("2021-04-18").status("DELIVERED").5)
//	Order.builder().id(4).orderDate("2021-03-22").deliveryDate("2021-03-27").status("PENDING").3)
//	Order.builder().id(5).orderDate("2021-03-04").deliveryDate("2021-03-12").status("NEW").1)
//	Order.builder().id(6).orderDate("2021-03-30").deliveryDate("2021-04-07").status("DELIVERED").9)
//	Order.builder().id(7).orderDate("2021-03-05").deliveryDate("2021-03-09").status("PENDING").8)
//	Order.builder().id(8).orderDate("2021-03-27").deliveryDate("2021-04-05").status("NEW").4)
//	Order.builder().id(9).orderDate("2021-04-14").deliveryDate("2021-04-18").status("NEW").10)
//	Order.builder().id(10).orderDate("2021-03-10").deliveryDate("2021-03-19").status("NEW").8)
//	Order.builder().id(11).orderDate("2021-04-01").deliveryDate("2021-04-04").status("DELIVERED").1)
//	Order.builder().id(12).orderDate("2021-02-24").deliveryDate("2021-02-28").status("PENDING").5)
//	Order.builder().id(13).orderDate("2021-03-15").deliveryDate("2021-03-21").status("NEW").5)
//	Order.builder().id(14).orderDate("2021-03-30").deliveryDate("2021-04-07").status("PENDING").4)
//	Order.builder().id(15).orderDate("2021-03-13").deliveryDate("2021-03-14").status("DELIVERED").5)
//	Order.builder().id(16).orderDate("2021-03-13").deliveryDate("2021-03-21").status("NEW").1)
//	Order.builder().id(17).orderDate("2021-03-31").deliveryDate("2021-03-31").status("DELIVERED").6)
//	Order.builder().id(18).orderDate("2021-03-25").deliveryDate("2021-03-31").status("PENDING").9)
//	Order.builder().id(19).orderDate("2021-02-28").deliveryDate("2021-03-09").status("DELIVERED").9)
//	Order.builder().id(20).orderDate("2021-03-23").deliveryDate("2021-03-30").status("NEW").5)
//	Order.builder().id(21).orderDate("2021-03-19").deliveryDate("2021-03-24").status("DELIVERED").9)
//	Order.builder().id(22).orderDate("2021-02-27").deliveryDate("2021-03-01").status("NEW").5)
//	Order.builder().id(23).orderDate("2021-04-19").deliveryDate("2021-04-24").status("PENDING").4)
//	Order.builder().id(24).orderDate("2021-03-24").deliveryDate("2021-03-24").status("DELIVERED").1)
//	Order.builder().id(25).orderDate("2021-03-03").deliveryDate("2021-03-10").status("NEW").1)
//	Order.builder().id(26).orderDate("2021-03-17").deliveryDate("2021-03-26").status("NEW").10)
//	Order.builder().id(27).orderDate("2021-03-20").deliveryDate("2021-03-25").status("NEW").1)
//	Order.builder().id(28).orderDate("2021-04-09").deliveryDate("2021-04-16").status("DELIVERED").2)
//	Order.builder().id(29).orderDate("2021-04-06").deliveryDate("2021-04-08").status("PENDING").1)
//	Order.builder().id(30).orderDate("2021-04-19").deliveryDate("2021-04-20").status("DELIVERED").1)
//	Order.builder().id(31).orderDate("2021-03-03").deliveryDate("2021-03-04").status("NEW").3)
//	Order.builder().id(32).orderDate("2021-03-15").deliveryDate("2021-03-24").status("DELIVERED").2)
//	Order.builder().id(33).orderDate("2021-04-18").deliveryDate("2021-04-24").status("PENDING").1)
//	Order.builder().id(34).orderDate("2021-03-28").deliveryDate("2021-03-28").status("NEW").6)
//	Order.builder().id(35).orderDate("2021-03-15").deliveryDate("2021-03-17").status("NEW").1)
//	Order.builder().id(36).orderDate("2021-03-04").deliveryDate("2021-03-08").status("DELIVERED").2)
//	Order.builder().id(37).orderDate("2021-03-18").deliveryDate("2021-03-25").status("NEW").8)
//	Order.builder().id(38).orderDate("2021-04-11").deliveryDate("2021-04-20").status("NEW").8)
//	Order.builder().id(39).orderDate("2021-04-12").deliveryDate("2021-04-17").status("NEW").9)
//	Order.builder().id(40).orderDate("2021-03-12").deliveryDate("2021-03-12").status("PENDING").3)
//	Order.builder().id(41).orderDate("2021-02-24").deliveryDate("2021-02-26").status("NEW").5)
//	Order.builder().id(42).orderDate("2021-04-08").deliveryDate("2021-04-14").status("DELIVERED").9)
//	Order.builder().id(43).orderDate("2021-03-03").deliveryDate("2021-03-11").status("NEW").3)
//	Order.builder().id(44).orderDate("2021-03-12").deliveryDate("2021-03-14").status("DELIVERED").4)
//	Order.builder().id(45).orderDate("2021-04-01").deliveryDate("2021-04-06").status("DELIVERED").1)
//	Order.builder().id(46).orderDate("2021-03-16").deliveryDate("2021-03-22").status("NEW").10)
//	Order.builder().id(47).orderDate("2021-04-07").deliveryDate("2021-04-12").status("PENDING").2)
//	Order.builder().id(48).orderDate("2021-04-05").deliveryDate("2021-04-06").status("NEW").2)
//	Order.builder().id(49).orderDate("2021-04-10").deliveryDate("2021-04-13").status("NEW").7)
//	Order.builder().id(50).orderDate("2021-03-18").deliveryDate("2021-03-21").status("NEW").9)
//	);

	public List<Order> findAll()
	{
		return _orders;
	}

	private Customer findCustomer(int id)
	{
		return null;
	}
}
