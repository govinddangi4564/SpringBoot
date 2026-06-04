package controller;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import entity.Customers;

public class CustomersMain {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session s = sf.openSession();

		int i = 0;

		while (true) {

			System.out.println("Press y for next 10 records / n for exit");
			String ch = sc.next();

			switch (ch) {

			case "y":

				Query<Customers> q = s.createQuery("from Customers", Customers.class);

				q.setFirstResult(i);
				q.setMaxResults(10);

				List<Customers> list = q.list();

				if (list.isEmpty()) {
					System.out.println("No more records");
					break;
				}

				list.forEach(System.out::println);

				i += 10;
				break;

			case "n":

				s.close();
				sf.close();
				sc.close();
				return;

			default:
				System.out.println("Invalid choice");
			}
		}
	}
}