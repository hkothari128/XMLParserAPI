package com.example.xmlparser.jaxb;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

@Service
public class XmlToObject {
	public Office unmarshalling() {
		Office offc = null;
		//Office offc;
		try {

			File file = new File("/Users/ruuh/git/XMLParserAPI/src/main/java/xml_file.xml");

	        JAXBContext jaxbContext = JAXBContext.newInstance(Office.class);  
	   
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
	        offc= (Office) jaxbUnmarshaller.unmarshal(file);
	        if(offc.getEmployee()==null)
	        	offc.setEmployee(new ArrayList<Employee>());
	        return offc;
//	        System.out.println(offc.getId());  
//	        System.out.println("Employee:");  
//	        List<Employee> list=offc.getEmployee();  
//	        for(Employee emp:list)  
//	          System.out.println(emp.getId()+" "+emp.getName()+"  "+emp.getAddress());  
	   
	      } catch (JAXBException e) {  
	        e.printStackTrace();  
	      }
		return offc;
		//return null;
		
	}

}
