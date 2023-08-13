package p1;

public class App {
	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setName("Ph");
		
		Address addr = new Address();
		addr.setAddline("9th Cross");
		addr.setCity("Bangalore");
		addr.setState("KN");
		addr.setCountry("India");
		
		emp.setAddr(addr);
		
		HibernateM h = new HibernateM();
		h.insert(emp);
	}
}
