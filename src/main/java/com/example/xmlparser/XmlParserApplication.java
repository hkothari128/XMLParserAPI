package com.example.xmlparser;

import javax.xml.bind.JAXBException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.xmlparser.jaxb.XmlToObject;
import com.example.xmlparser.jaxb.ObjectToXml;

@SpringBootApplication
public class XmlParserApplication {

	public static void main(String[] args) {
		SpringApplication.run(XmlParserApplication.class, args);
//		XmlToObject obj1 = new XmlToObject();
//		obj1.unmarshalling();
//		ObjectToXml obj2 = new ObjectToXml();
//		try {
//			obj2.marshalling();
//			System.out.println("SAVED");
//		} catch (JAXBException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
