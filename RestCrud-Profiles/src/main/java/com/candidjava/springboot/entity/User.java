package com.candidjava.springboot.entity;

public class User {
	
	public User(Long id, String name, String password, int age, String email, String city) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
		this.email = email;
		this.city = city;
	}
	private Long id;
	private String name;
	private String password;
	private int age;
	private String email;
	private String city;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	

}
