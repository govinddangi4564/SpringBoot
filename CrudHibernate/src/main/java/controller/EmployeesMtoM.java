package controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Employees;
import entity.Projects;

public class EmployeesMtoM {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();

//		Projects p1 = new Projects();
//		p1.setProjectName("Employee Management");
//
//		Projects p2 = new Projects();
//		p2.setProjectName("PathologyLab Management");
//
//		Employees e1 = new Employees();
//		e1.setName("Govind");
//		e1.setEmail("govind@gmail.com");
//		e1.setProjects(List.of(p1, p2));
//
//		Employees e2 = new Employees();
//		e2.setName("Sunil");
//		e2.setEmail("sunil@gmail.com");
//		e2.setProjects(List.of(p2));
//
//		s.persist(e1);
//		s.persist(e2);

//		Employees e1 = s.get(Employees.class, 2);
//		System.out.println(e1.getName() + "  -------  " + e1.getEmail());
//		e1.getProjects().stream().forEach(System.out::println);

//		Projects p = s.get(Projects.class, 2);
//		System.out.println(p.getProjectName());
//		p.getEmployees().stream().forEach(System.out::println);

		List<Employees> empList = s.createQuery("from Employees", Employees.class).list();
		for (Employees e : empList) {
			System.out.println("Employee name : " + e.getName() + "\t Email : " + e.getEmail());
			System.out.println(e.getProjects());
			System.out.println("----------------------------------------------------------------------");
		}

		s.getTransaction().commit();
		sf.close();
		s.close();

	}
}
