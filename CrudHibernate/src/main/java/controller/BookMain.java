package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Books;
import entity.Topic;

public class BookMain {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();

		Books b = new Books("Wonder", 200.0, Topic.Success, 500, "Unknown");
		s.persist(b);

		s.getTransaction().commit();

		s.close();
		sf.close();
	}
}
