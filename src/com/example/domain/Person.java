package com.example.domain;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@XmlRootElement
@XmlType(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

	@XmlElement(name="name")
	private String name;
	
	@XmlElement(name="email")
	private String email;
	
	@XmlElement(name="age")
	private Integer age;

	public String getNome() {
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
	
	public Integer getIdade() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
}
