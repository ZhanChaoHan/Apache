package com.jachs.cookiesession.entity;

/***
 * 
 * @author zhanchaohan
 *
 */
public class Boy {
	private String name;
	private int age;
	
	public Boy() {
		super();
	}
	public Boy(String name, int age) {
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
