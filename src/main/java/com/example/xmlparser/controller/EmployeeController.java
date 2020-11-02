package com.example.xmlparser.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.xmlparser.jaxb.Employee;
import com.example.xmlparser.jaxb.ObjectToXml;
import com.example.xmlparser.jaxb.Office;
import com.example.xmlparser.jaxb.XmlToObject;

@Controller
@CrossOrigin
public class EmployeeController {
	@Autowired
	XmlToObject x2o;
	
	@Autowired
	ObjectToXml o2x;
	
	@Autowired
	Office offc;
	
	ArrayList<Employee> list=new ArrayList<Employee>();
	

	@GetMapping("/")
	public String index(Model model) {
		//Office 
		//System.out.println("hellllloooooooo");
		offc = x2o.unmarshalling();
		
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
	
	@PostMapping("/new")
	public String addEmployee(Model model ,@ModelAttribute("emp") Employee emp) {
		//System.out.println("hellllloooooooo");
		//Employee emp=new Employee(101,"arunachal","jaipur",40000);  
	    //Employee emp2=new Employee(102,"sharma","dehradun",50000);  
	    
	    //List <Employee> list=new ArrayList<Employee>();  
	    list.add(emp);  
	    //list.add(emp2);
		offc.setEmployee(list);
		//System.out.println(emp.toString()+""+list);
		try {
			//System.out.println("inside try in controller");
			o2x.marshalling(offc.getEmployee());
			//model.addAttribute("listEmployees", offc.getEmployee());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return index(model);
		//return "redirect:/";
		
	}
	
	@PostMapping("/edit")
	public String editEmployee(Model model, Employee emp) {
		for(Employee e : offc.getEmployee()){
			//System.out.println(e.toString());
			if(e.getId() == emp.getId()) {
				int i = list.indexOf(e);
				offc.getEmployee().set(i,emp);       
			}
		}
		return index(model);
		//return "redirect;/";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(Model model, Employee emp ) {
		for(Employee e : offc.getEmployee()) {
			if(e.getId()==emp.getId()) {
				int i = list.indexOf(e);
				offc.getEmployee().remove(i);
			}
		}
		return index(model);
	}
}
