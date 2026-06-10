package controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Orders;
import entity.Users;

public class UsersMain {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();

//		Users u = new Users();
//		u.setName("Sunil");
//		u.setEmail("sunil@gmail.com");
//
//		List<Orders> orders = List.of(
//				new Orders("Pen Drive", 700.0, 50, u),
//				new Orders("Mouse", 500.0, 5, u),
//				new Orders("MacBook", 150000.0, 2, u),
//				new Orders("Keyboard", 1500.0, 7, u)
//				);
//		
//		u.setOrders(orders);
//		
//		s.persist(u);

		Users us = s.get(Users.class, 1);
		System.out.println(us.getName() + "  " + us.getEmail());
		us.getOrders().stream().forEach(System.out::println);
		
//		Orders o = s.get(Orders.class, 1);
//		int q = o.getQuantity();
//		double p = o.getPrice();
//		
//		double t = q*p;
//		System.out.println("Total: " + t);

		s.getTransaction().commit();
		sf.close();
		s.close();
	}
}
