package controller;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Customer;
import entity.Food;

public class CustomerMain {
	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();

		Customer c = new Customer("Govind", 19, Food.Pasta, 200.0, LocalDateTime.now(), "7067624564");
		s.persist(c);

		s.getTransaction().commit();

		s.close();
		sf.close();
	}
}
