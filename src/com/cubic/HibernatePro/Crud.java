package com.cubic.HibernatePro;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Crud {

	public static void insert() {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		/*Regular_Employee re=new Regular_Employee();
		re.setName("reddy");
		re.setBonus(1000);
		re.setSalary(12000);
		s.persist(re);
		tx.commit();
		System.out.println("Regular Employee Record Inserted");*/
		Contract_Employee ce=new Contract_Employee();
		ce.setName("reddy");
		ce.setPayperhour(400);
		ce.setContractperiod("3Months");
		s.persist(ce);
		tx.commit();
		System.out.println("Contract Employee Record Inserted");
		s.close();
		sf.close();
	}

	public static void fetch() {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		List<Contract_Employee> ls=s.createQuery("From Contract_Employee").list();
		Iterator<Contract_Employee> itr=ls.iterator();
		while(itr.hasNext()) {
			/*Employee ce=(Employee)itr.next();
			System.out.println("Employee Details");
			System.out.println("-------------------------");
			System.out.println(ce.getName());
			System.out.println(ce.getId());
*/			Contract_Employee ce=(Contract_Employee)itr.next();
			System.out.println("Contract Employee Details");
			System.out.println("-------------------------");
			System.out.println(ce.getName());
			System.out.println(ce.getId());
			System.out.println(ce.getPayperhour());
			System.out.println(ce.getContractperiod());
			/*Regular_Employee re=(Regular_Employee)itr.next();
			System.out.println("Regular Employee Details");
			System.out.println("-------------------------");
			System.out.println(re.getName());
			System.out.println(re.getSalary());
			System.out.println(re.getBonus());
			System.out.println(re.getId());*/
		}
		
	}

	public static void update() {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		Query<Contract_Employee> q=s.createQuery("from Contract_Employee where id=:id1");
		q.setInteger("id1", 1);
		Contract_Employee ce=(Contract_Employee)q.uniqueResult();
		ce.setContractperiod("6Months");
		s.update(ce);
		tx.commit();
		System.out.println("Record Updated");		
	}
	public static void delete() {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		Query<Contract_Employee> q=s.createQuery("from Contract_Employee where id=:id1");
		q.setInteger("id1", 1);
		Contract_Employee ce=(Contract_Employee)q.uniqueResult();
		s.delete(ce);
		tx.commit();
		System.out.println("Record Deleted");		
	}
}
