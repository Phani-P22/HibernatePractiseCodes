package com.digit.javaTraining.aadharEnrollmentCenter.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class AadharData {
	private Long aadharNumber;
	private String name;
	private String email;
	private Long phoneNumber;
	private String addressLine;
	private String city;
	private String state;
	private int pinCode;

	private static Session session;

	public AadharData() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistryBuilder builder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.buildServiceRegistry());
		session = sessionFactory.openSession();
		System.out.println("Connected to Pf...");
	}

	public Long getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(Long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public Long generateRandomAadharNumber() {
		Long curGenNum = 0L;
		while (true) {
			curGenNum = (long) (Math.random() * (999999999999L - 100000000000L) + 100000000000L);
			AadharData curData = (AadharData) session.get(AadharData.class, curGenNum);
			if (curData == null) {
				break;
			}
		}
		return curGenNum;
	}

	public void registerUser(AadharData curAadharData) {
		Transaction trn = session.beginTransaction();
		session.save(curAadharData);
		trn.commit();
		System.out.println("Object Saved!");
	}

	public void updateName(long aadhar, String newName) {
		Transaction trn = session.beginTransaction();

		AadharData ad = (AadharData) session.get(AadharData.class, aadhar);
		ad.setName(newName);

		session.update(ad);
		trn.commit();
	}
	
	public void updatePhoneNumber(long aadhar, Long newNumber) {
		Transaction trn = session.beginTransaction();

		AadharData ad = (AadharData) session.get(AadharData.class, aadhar);
		ad.setPhoneNumber(newNumber);

		session.update(ad);
		trn.commit();
	}

	public void deleteUser(AadharData curAadharData) {
		Transaction trn = session.beginTransaction();
		session.delete(curAadharData);
		trn.commit();
	}

	public boolean getUser(Long aadharNumber) {
		session.beginTransaction();
		AadharData curAadharData = (AadharData) session.get(AadharData.class, aadharNumber);
		if (curAadharData != null) {
			this.aadharNumber = aadharNumber;
			this.name = curAadharData.getName();
			this.email = curAadharData.getEmail();
			this.phoneNumber = curAadharData.getPhoneNumber();
			this.addressLine = curAadharData.getAddressLine();
			this.city = curAadharData.getCity();
			this.state = curAadharData.getState();
			this.pinCode = curAadharData.getPinCode();

			return true;
		}
		return false;
	}
}
