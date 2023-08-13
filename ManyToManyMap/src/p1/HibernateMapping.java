package p1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateMapping {

	private Session session;

	public HibernateMapping() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistryBuilder builder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.buildServiceRegistry());
		session = sessionFactory.openSession();
		System.out.println("Connected to Pf...");
	}

	public void insert(Student s) {
		Transaction tr = session.beginTransaction();
		session.save(s);
		tr.commit();
		System.out.println("Done");
	}

}
