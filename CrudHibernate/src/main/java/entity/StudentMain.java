package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentMain {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();

		Address ad = new Address();
		ad.setCity("Indore");
		ad.setState("MP");
		ad.setZipCode(452001);

		Marks mk = new Marks();
		mk.setHindi(80);
		mk.setEnglish(90);
		mk.setMaths(95);

		Student st = new Student();
		st.setName("Govind");
		st.setAge(19);
		st.setRollno(63);

		st.setAddress(ad);
		st.setMarks(mk);
		ad.setStudent(st);
		mk.setStudent(st);

		s.persist(st);

		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
