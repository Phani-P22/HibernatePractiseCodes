package com.digit.javaTraining.hibernatePractice;

public class Main {

	public static void main(String[] args) {
		HibernateManager curHM = new HibernateManager();

//		Student st1 = new Student(2, "SH");
//		curHM.saveObject(st1);

//		curHM.readAll();

//		curHM.readSpecific(1);

//		curHM.readSpecificWithCondition("Ph");

//		curHM.readWithMultipleConditions();

//		curHM.readWithOrderByDesc();

//		curHM.updateSpecific(2, "Temp");
		
		curHM.deleteSpecific(2);
	}
}
