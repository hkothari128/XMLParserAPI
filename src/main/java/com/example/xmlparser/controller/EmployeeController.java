package com.example.xmlparser.controller;

import javax.ws.rs.GET;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.xmlparser.jaxb.Employee;
import com.example.xmlparser.jaxb.Office;
import com.example.xmlparser.jaxb.XmlToObject;

@RestController
@CrossOrigin
public class EmployeeController {
	@Autowired
	XmlToObject x2o;
	

	@GetMapping(path = "/employees")
	public Office getEmployees() {
		Office offc = x2o.unmarshalling();
		System.out.println(offc.getId());
		return offc;
	}
	
	@GetMapping(path = "/employee/{id}")
	public Employee getEmployee(@PathVariable("id") int id) {
		Office offc = x2o.unmarshalling();
		for(Employee e:offc.getEmployee()) {
			if(e.getId() == id)
				return e;
		}
		
		return null;
	}
	
}
