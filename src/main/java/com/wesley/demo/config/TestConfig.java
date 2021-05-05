package com.wesley.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.wesley.demo.entities.Category;
import com.wesley.demo.entities.Order;
import com.wesley.demo.entities.OrderItem;
import com.wesley.demo.entities.Payment;
import com.wesley.demo.entities.Product;
import com.wesley.demo.entities.User;
import com.wesley.demo.entities.enums.OrderStatus;
import com.wesley.demo.repositories.CategoryRepository;
import com.wesley.demo.repositories.OrderItemRepository;
import com.wesley.demo.repositories.OrderRepository;
import com.wesley.demo.repositories.ProductRepository;
import com.wesley.demo.repositories.UserReposositoy;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserReposositoy userRepository;
 
	@Autowired
    private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productrepository;
	
	@Autowired
	private OrderItemRepository orderitem;
	
	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "joão", " joão@gmail.com", "89879879889", "123456");
		User u2 = new User(null, "joão2", " joão@gmail2.com", "89879879889", "123456");

		userRepository.saveAll(Arrays.asList(u1, u2));

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.CANCELED, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WATING_PAYMENT, u1);

		orderRepository.saveAll(Arrays.asList(o1, o2, o3));

		Category c1 = new Category(null, " Eletronicos");
		Category c2 = new Category(null, " books");
		Category c3 = new Category(null, "computers");

		categoryRepository.saveAll(Arrays.asList(c1, c2, c3));

		Product p1 = new Product(null, "video game", "ps5", 100.0, "");
		Product p2 = new Product(null, "macbook", "apple", 200.0, "");
		
		productrepository.saveAll(Arrays.asList(p1,p2));
	
	    p1.getCategories().add(c1);
	    p2.getCategories().add(c3);
	    
	    productrepository.saveAll(Arrays.asList(p1,p2));
	
		OrderItem oi1 = new OrderItem(o3, p2, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o2, p1, 3, p2.getPrice());
		OrderItem oi3 = new OrderItem(o1, p2, 4, p1.getPrice());

		orderitem.saveAll(Arrays.asList(oi1, oi2, oi3));

		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T19:53:07Z"), o1);
		o1.setPayment(pay1);

		orderRepository.save(o1);

	}

}
