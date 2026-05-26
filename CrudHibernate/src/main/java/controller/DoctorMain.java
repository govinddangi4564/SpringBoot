package controller;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.id.factory.spi.GeneratorDefinitionResolver;

import entity.Doctor;
import entity.Gender;

public class DoctorMain {
	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();

		Doctor d = new Doctor("Mohit", 20, LocalDate.of(2003, 07, 21), 101, "Nothing", Gender.Male, "mohit@gmail.com",
				"963258965");
		
		s.persist(d);
		
//		Doctor d = s.get(Doctor.class, 3);
//		s.remove(d);
		
		

		s.getTransaction().commit();

		s.close();
		sf.close();
	}
}
