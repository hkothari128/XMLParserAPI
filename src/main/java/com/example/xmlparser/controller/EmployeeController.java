package com.example.xmlparser.controller;


import java.io.ByteArrayOutputStream;

import java.util.ArrayList;
import java.util.List;


import javax.ws.rs.GET;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.bind.JAXBException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

import com.example.xmlparser.apachepoi.ObjectToExcel;
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
	ObjectToExcel o2xl;

	@Autowired
	ObjectToXml o2x;
	
	@GetMapping("/")
	public String index(Model model) {
		System.out.println("hit");
		Office offc = x2o.unmarshalling();
		model.addAttribute("listEmployees", offc.getEmployee());
		return "index";
	}
	
	@GetMapping("/new")
	public String newForm() {
		return "new";
	}

	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable String id) {
		Office offc = x2o.unmarshalling();
		Employee emp = null;
		for(Employee e:offc.getEmployee()) {
			if(e.getId().equalsIgnoreCase(id))
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
	public Employee getEmployee(@PathVariable("id") String id) {
		Office offc = x2o.unmarshalling();
		for(Employee e:offc.getEmployee()) {
			if(e.getId().equalsIgnoreCase(id))
				return e;
		}

		return null;
	}


	@GetMapping(path="/report")
	@ResponseBody
	public ResponseEntity<ByteArrayResource> downloadTemplate() throws Exception {
        try {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            HSSFWorkbook workbook = o2xl.convert(x2o.unmarshalling()); // creates the workbook
            HttpHeaders header = new HttpHeaders();
            header.setContentType(new MediaType("application", "force-download"));
            header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Employees.xlsx");
            workbook.write(stream);
            workbook.close();
            return new ResponseEntity<>(new ByteArrayResource(stream.toByteArray()),
                    header, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


	@PostMapping("/new")
	public String addEmployee(Model model, @ModelAttribute("emp") Employee emp) {
//		System.out.println(emp.toString());
		Office offc = x2o.unmarshalling();
		List <Employee> list= offc.getEmployee();
		for(Employee e: list){
			if(e.getId().equalsIgnoreCase((emp.getId()))) {
				model.addAttribute("Alert",
						"Employee with id=" + emp.getId() + " already exists, Please put another id");
				model.addAttribute("emp", emp);
				return "new";
			}
		}

	    list.add(emp);

		try {
			//System.out.println("inside try in controller");
			o2x.marshalling(list);
			//model.addAttribute("listEmployees", offc.getEmployee());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/";

	}

	@PostMapping("/edit")
	public String editEmployee(Employee emp) {
		System.out.println( " EDIT " + emp.toString());
		Office offc = x2o.unmarshalling();
		List<Employee> list = offc.getEmployee();
		for(Employee e : list){
			//System.out.println(e.toString());
			if(e.getId().equalsIgnoreCase(emp.getId())) {
				int i = list.indexOf(e);
				list.set(i,emp);
			}
		}
		try {
			o2x.marshalling(list);
		} catch (JAXBException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable String id ) {

		Office offc = x2o.unmarshalling();
		List<Employee> list = new ArrayList<Employee>();
		for(Employee e : offc.getEmployee()) {
			if(!e.getId().equalsIgnoreCase(id)) {
				list.add(e);
			}
		}
		try {
			//System.out.println("inside try in controller");
			o2x.marshalling(list);

		} catch (JAXBException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return "redirect:/";
	}

}
