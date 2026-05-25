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
		
//		Employee em = new Employee("Sunil",20, 900000.0, "sunil@gmail.com");
//		s.persist(em);
		
		Employee em = s.get(Employee.class, 2);
//		s.remove(em);
		
//		em.setSalary(550000);
		
		System.out.println(em);
		
		
		s.getTransaction().commit();
		
		s.close();
		sf.close();
	}
}
