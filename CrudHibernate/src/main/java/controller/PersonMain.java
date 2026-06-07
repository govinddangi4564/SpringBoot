package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Passport;
import entity.Person;

public class PersonMain {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();

//		Passport ps = new Passport();
//		ps.setPassportNumber("qwert1234");
//
//		Person pr = new Person();
//		pr.setName("Govind");
//		pr.setAge(19);
//
//		pr.setPassport(ps);
//		ps.setPerson(pr);
//
//		s.persist(pr);
		
		Person pr = s.get(Person.class, 1);
//		System.out.println(pr);
		s.remove(pr);

		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
