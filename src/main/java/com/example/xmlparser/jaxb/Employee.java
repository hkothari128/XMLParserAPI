package com.example.xmlparser.jaxb;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {


	@XmlElement
	@XmlID
	private String id;
	@XmlElement
	private String name;
	@XmlElement
	private String address;
	@XmlElement
	private int salary;
	public Employee() {
		super();
	}
	public Employee(String id, String name, String address, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", salary=" + salary + "]";
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

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
