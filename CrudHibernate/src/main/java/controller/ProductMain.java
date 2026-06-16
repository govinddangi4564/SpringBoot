package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Product;

public class ProductMain {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();

		Product pr = new Product("Jeather Jacket", "Luivitton", "Clothes", 25000.0);
		s.persist(pr);

		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
