package controller;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Doctor;
import entity.Gender;

public class DoctorMain {
	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();

		Doctor d = new Doctor("Jay", 21, LocalDate.of(2003, 5, 22), 101, "Heart", Gender.Male, "jay12@gmail.com",
				"7896321455");
		
		s.persist(d);
		
//		Doctor d = s.get(Doctor.class, 3);
//		s.remove(d);
		
		

		s.getTransaction().commit();

		s.close();
		sf.close();
	}
}
