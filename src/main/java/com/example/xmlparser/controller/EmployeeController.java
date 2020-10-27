package com.example.xmlparser.controller;

import javax.ws.rs.GET;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.xmlparser.jaxb.Employee;
import com.example.xmlparser.jaxb.Office;
import com.example.xmlparser.jaxb.XmlToObject;

@Controller
@CrossOrigin
public class EmployeeController {
	@Autowired
	XmlToObject x2o;
	

	@GetMapping("/")
	public String index(Model model) {
		Office offc = x2o.unmarshalling();
		
		model.addAttribute("listEmployees", offc.getEmployee());
		return "index";
	}
	
	@GetMapping("/new")
	public String newForm() {
		return "new";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable int id) {
		Office offc = x2o.unmarshalling();
		Employee emp = null;
		for(Employee e:offc.getEmployee()) {
			if(e.getId() == id)
				emp = e;
		}
		
		model.addAttribute("employee", emp);
		return "edit";
	}
	
	@GetMapping("/employees")
	@ResponseBody
	public Office getEmployees(Model model) {
		return x2o.unmarshalling();		
	}
	
	@GetMapping(path = "/employee/{id}")
	@ResponseBody
	public Employee getEmployee(@PathVariable("id") int id) {
		Office offc = x2o.unmarshalling();
		for(Employee e:offc.getEmployee()) {
			if(e.getId() == id)
				return e;
		}
		
		return null;
	}
	
}
