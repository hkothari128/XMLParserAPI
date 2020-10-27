package com.example.xmlparser.jaxb;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class XmlToObject {
	public void unmarshalling() {
		try {
			File file = new File("/Users/ruuh/git/XMLParserAPI/src/main/java/xml_file.xml");  
	        JAXBContext jaxbContext = JAXBContext.newInstance(Office.class);  
	   
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
	        Office offc= (Office) jaxbUnmarshaller.unmarshal(file);  
	        System.out.println(offc.getId());  
	        System.out.println("Employee:");  
	        List<Employee> list=offc.getEmployee();  
	        for(Employee emp:list)  
	          System.out.println(emp.getId()+" "+emp.getName()+"  "+emp.getAddress());  
	   
	      } catch (JAXBException e) {  
	        e.printStackTrace();  
	      }  
	}

}
