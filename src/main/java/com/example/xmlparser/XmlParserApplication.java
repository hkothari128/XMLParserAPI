package com.example.xmlparser;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.xmlparser.jaxb.XmlToObject;

import com.example.xmlparser.apachepoi.ObjectToExcel;

import com.example.xmlparser.jaxb.Employee;

import com.example.xmlparser.jaxb.ObjectToXml;
import com.example.xmlparser.jaxb.Office;

@SpringBootApplication
public class XmlParserApplication {

	public static void main(String[] args) {
		SpringApplication.run(XmlParserApplication.class, args);
//		XmlToObject obj1 = new XmlToObject();
//		ObjectToExcel xl = new ObjectToExcel();
////		ObjectToXml obj2 = new ObjectToXml();
//		try {
//			Office offc = obj1.unmarshalling();
//			xl.convert(offc);
////			obj2.marshalling();
//			System.out.println("SAVED");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("hellllloooooooo");
//		ObjectToXml o2x = new ObjectToXml();
//		Office offc = new Office();
//		Employee emp1=new Employee(101,"arunachal","jaipur",40000);  
//	    Employee emp2=new Employee(102,"sharma","dehradun",50000);  
//	    
//	    List<Employee> list=new ArrayList<Employee>();  
//	    list.add(emp1);  
//	    list.add(emp2);
//		
//		offc.setEmployee(list);
//		try {
//			o2x.marshalling(offc.getEmployee());
//			//model.addAttribute("listEmployees", offc.getEmployee());
//		} catch (JAXBException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
