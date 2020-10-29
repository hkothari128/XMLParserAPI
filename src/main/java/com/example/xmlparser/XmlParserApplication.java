package com.example.xmlparser;

import javax.xml.bind.JAXBException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.xmlparser.jaxb.XmlToObject;
import com.example.xmlparser.apachepoi.ObjectToExcel;
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
	}

}
