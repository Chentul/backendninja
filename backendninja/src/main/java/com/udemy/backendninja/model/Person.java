package com.udemy.backendninja.model;

public class Person {

	private String name;
	private int age;
	
	/** se crea el contrusctor vacio para poder
	dar de alta a una persona **/
	public Person() {}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
