package com.udemy.backendninja.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

public class Person {
	
	/**
	 * @NotNull -> validate attributes
	 * @Size -> validate values from min to max
	 * @Min -> validate value that gas to be grather than 18
	 */
	@NotNull
//	@Size(min=2, max=6)
	@Min(2)
	@Max(7)
	private String name;
	
	@NotNull
	@Min(18)
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

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	

}
