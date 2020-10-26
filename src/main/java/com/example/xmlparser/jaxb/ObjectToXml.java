package com.example.xmlparser.jaxb;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class ObjectToXml {
	public void marshalling() throws JAXBException {
		JAXBContext contextObj= JAXBContext.newInstance(Office.class);
		Marshaller marshallerObj = contextObj.createMarshaller(); 
		marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
		
		Employee emp1=new Employee(101,"arun","jaipur",40000);  
	    Employee emp2=new Employee(101,"sharma","dehradun",50000);  
	    
	    ArrayList<Employee> list=new ArrayList<Employee>();  
	    list.add(emp1);  
	    list.add(emp2);

	    Office offc=new Office(1,list);  
	    try {
			marshallerObj.marshal(offc, new FileOutputStream("/Users/ruuh/git/XMLParserAPI/src/main/java/xml_file.xml"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

}