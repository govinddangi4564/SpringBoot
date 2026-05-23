package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Employee;

public class Task1 {
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		Employee em = new Employee("Honey", 20, 9999999.0, "honey@gmail.com");
		s.persist(em);
		
		s.getTransaction().commit();
		
		s.close();
		sf.close();
	}
}
