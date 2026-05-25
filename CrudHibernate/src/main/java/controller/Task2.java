package controller;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Employee;

public class Task2 {
	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();

		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("Enter 1 for insert: ");
			System.out.println("Enter 2 for Delete: ");
			System.out.println("Enter 3 for Update: ");
			System.out.println("Enter 4 for Exit: ");

			int n = sc.nextInt();

			switch (n) {
			case 1: {
				s.beginTransaction();

				sc.nextLine();
				System.out.println("Enter name: ");
				String name = sc.nextLine();

				System.out.println("Enter age: ");
				int age = sc.nextInt();

				System.out.println("Enter salary: ");
				double salary = sc.nextDouble();

				sc.nextLine();
				System.out.println("Enter email: ");
				String email = sc.nextLine();

				Employee em = new Employee(name, age, salary, email);
				s.persist(em);

				s.getTransaction().commit();

				System.out.println("Inserted Successfully");
			}
				break;

			case 2: {
				s.beginTransaction();

				System.out.println("Enter id: ");
				int id = sc.nextInt();

				Employee em = s.get(Employee.class, id);
				s.remove(em);

				s.getTransaction().commit();

				System.out.println("Deleted Successfully");
			}
				break;

			case 3: {
				s.beginTransaction();

				System.out.println("Enter Id: ");
				int id = sc.nextInt();
				Employee em = s.get(Employee.class, id);

				System.out.println("1. Update Name");
				System.out.println("2. Update Age");
				System.out.println("3. Update Salary");
				System.out.println("4. Update Email");

				int choice = sc.nextInt();

				sc.nextLine();

				switch (choice) {
				case 1: {
					System.out.println("Enter name: ");
					String name = sc.nextLine();
					em.setName(name);
				}
					break;

				case 2: {
					System.out.println("Update age: ");
					int age = sc.nextInt();
					em.setAge(age);
				}
					break;

				case 3: {
					System.out.println("Enter salary: ");
					double salary = sc.nextDouble();
					em.setSalary(salary);
				}
					break;

				case 4: {
					System.out.println("Enter email: ");
					String email = sc.nextLine();
					em.setEmail(email);
				}
					break;

				default:
					System.out.println("Invalid choice");
				}

				s.getTransaction().commit();

				System.out.println("Updated Successfully");
			}
				break;

			case 4: {
				s.close();
				sf.close();
				sc.close();
			}
				return;

			default:
				System.out.println("Invalid choice");
				break;
			}
		}
	}
}
