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

		Users u = new Users();
		u.setName("Govind");
		u.setEmail("govind@gmail.com");

		List<Orders> orders = List.of(
				new Orders("Mouse", 500.0, 5, u),
				new Orders("Keyboard", 1500.0, 7, u),
				new Orders("Pen Drive", 700.0, 50, u),
				new Orders("MacBook", 150000.0, 2, u)
				);
		
		u.setOrders(orders);
		
		s.persist(u);

		s.getTransaction().commit();
		sf.close();
		s.close();
	}
}
