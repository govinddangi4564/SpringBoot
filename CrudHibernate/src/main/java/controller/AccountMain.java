package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Accounts;

public class AccountMain {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();

//		Accounts ac = new Accounts("Jay", "IPOS003", 2000);
//		s.persist(ac);

		try {
			double amount = 5000;
			Accounts sender = s.get(Accounts.class, 1);
			Accounts reciever = s.get(Accounts.class, 3);

			sender.setBalance(sender.getBalance() - amount);
			reciever.setBalance(reciever.getBalance() + amount);

			tx.commit();

			System.out.println("Success");

		} catch (Exception e) {
			tx.rollback();
			System.out.println("Something went wrong..");
		}

		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
