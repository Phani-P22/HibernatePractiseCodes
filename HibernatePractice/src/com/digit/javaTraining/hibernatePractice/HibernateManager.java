package com.digit.javaTraining.hibernatePractice;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateManager {

	public Session session;

	public HibernateManager() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistryBuilder builder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.buildServiceRegistry());
		session = sessionFactory.openSession();
		System.out.println("Connected to Pf...");
	}

	public void saveObject(Student s) {
		Transaction trn = session.beginTransaction();
		session.save(s);
		trn.commit();
		System.out.println("Object Saved!");
	}

	public void readAll() {
		Transaction trn = session.beginTransaction();
		Query createQuery = session.createQuery("FROM Student");
		List list = createQuery.list();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Student curSt = (Student) it.next();
			System.out.println("Student Name: " + curSt.getName() + ". Student ID: " + curSt.getId());
		}
		trn.commit();
	}

	public void readSpecific(int id) {
		Transaction trn = session.beginTransaction();

		Student curSt = (Student) session.get(Student.class, id);
		System.out.println("Student Name: " + curSt.getName() + ". Student ID: " + curSt.getId());

		trn.commit();
	}

	public void readSpecificWithCondition(String name) {
		Transaction trn = session.beginTransaction();

		Query query = session.createQuery("FROM Student WHERE name=:name");
		query.setParameter("name", name);
		List list = query.list();

		Iterator itr = list.iterator();

		while (itr.hasNext()) {
			Student curSt = (Student) itr.next();
			System.out.println("Student Name: " + curSt.getName() + ". Student ID: " + curSt.getId());
		}
		trn.commit();
	}
	
	public void readWithMultipleConditions() {
		Transaction trn = session.beginTransaction();
		
		Query query = session.createQuery("FROM Student WHERE name=:name or id=:id");
		query.setParameter("name", "Ph");
		query.setParameter("id", 2);
		
		List list = query.list();
		
		Iterator itr = list.iterator();
 		while (itr.hasNext()) {
 			Student curSt = (Student) itr.next();
			System.out.println("Student Name: " + curSt.getName() + ". Student ID: " + curSt.getId());
 		}
		
		trn.commit();
	}
	
	
	public void readWithOrderByDesc() {
		session.getTransaction();
		
		Query query = session.createQuery("from Student order by id desc");
		List list = query.list();
		
		Iterator itr = list.iterator();
		while(itr.hasNext()) {
			Student curSt = (Student) itr.next();
			System.out.println("Student Name: " + curSt.getName() + ". Student ID: " + curSt.getId());
		}		
	}
	
	public void updateSpecific(int id, String name) {
		Transaction trn = session.beginTransaction();
		
		Student curSt = (Student) session.get(Student.class, id);
		curSt.setName(name);
		
		session.update(curSt);
		
		trn.commit();
		
		System.out.println("Row Updated");
	}
	
	public void deleteSpecific(int id) {
		Transaction trn = session.beginTransaction();
		
		Student st = (Student) session.get(Student.class, id);
		
		session.delete(st);
		
		trn.commit();
		
		System.out.println("Deleted!");
	}
}
