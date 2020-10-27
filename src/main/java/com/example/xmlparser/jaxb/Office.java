package com.example.xmlparser.jaxb;

import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Office {
	private int id;
	private List<Employee> employee;
	public Office() {
		super();
	}
	public Office(int id, List<Employee> employee) {
		super();
		this.id = id;
		this.employee = employee;
	}
	
	@XmlAttribute
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@XmlElement
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

}
