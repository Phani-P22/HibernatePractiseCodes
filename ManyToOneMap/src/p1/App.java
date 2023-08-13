package p1;

public class App {
	public static void main(String[] args) {

		Publisher p = new Publisher();
		p.setPname("penguin");

		Book b1 = new Book();
		b1.setBname("book a");
		b1.setPub(p);

		Book b2 = new Book();
		b2.setBname("book b");
		b2.setPub(p);

		HibernateMapping hbm = new HibernateMapping();
		hbm.insert(b1);
		hbm.insert(b2);
	}
}
