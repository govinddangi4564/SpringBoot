package controller;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dto.DoctorInfo;
import entity.Doctor;
import entity.Gender;

public class DoctorMain {
	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();

//		Doctor d = new Doctor("Kartik", 22, LocalDate.of(2004, 5, 28), 104, "Nothing", Gender.Male, "Kartik12@gmail.com",
//				"7897378455");
//		
//		s.persist(d);

//		Doctor d = s.get(Doctor.class, 3);
//		s.remove(d);

//		List<Doctor> list = s.createQuery("from Doctor", Doctor.class).list();
//		list.stream().forEach(a -> System.out.println(a));

//		List<Doctor> list = s.createQuery("from Doctor where name like '%Jay%'", Doctor.class).list();
//		list.stream().forEach(a -> System.out.println(a));
		
		List<DoctorInfo> list = s.createQuery("select name, phone, email from Doctor", DoctorInfo.class).list();
		list.stream().forEach(a -> System.out.println(a));

//		List<Doctor> list = s.createQuery("from Doctor order by name desc", Doctor.class).list();
//		list.stream().forEach(a -> System.out.println(a));

		s.getTransaction().commit();

		s.close();
		sf.close();
	}
}
