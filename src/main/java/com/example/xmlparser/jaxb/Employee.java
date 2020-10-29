package com.example.xmlparser.jaxb;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
	private int id;
	private String name;
	private String address;
	private int salary;
	public Employee() {
		super();
	}
	public Employee(int id, String name, String address, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}
	@XmlElement
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@XmlElement
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public List<Object> getAttributes() {
		List<Object> attr = new ArrayList<Object>();
		attr.add(this.id);
		attr.add(this.name);
		attr.add(this.address);
		attr.add(this.salary);
		return attr;
	}
	
	public static List<String> getAttributeNames() {
		List<String> attrNames = new ArrayList<String>();
		attrNames.add("id");
		attrNames.add("name");
		attrNames.add("address");
		attrNames.add("salary");
		return attrNames;
	}
	
}
