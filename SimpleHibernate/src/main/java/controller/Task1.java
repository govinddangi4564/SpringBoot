package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class Task1 {
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		Student st = new Student("Govind", 19, "0863CS231062");
		s.persist(st);
		
		s.getTransaction().commit();
		
		s.close();
		sf.close();
		
	}
}
