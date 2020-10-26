package com.example.xmlparser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.xmlparser.jaxb.XmlToObject;

@SpringBootApplication
public class XmlParserApplication {

	public static void main(String[] args) {
		SpringApplication.run(XmlParserApplication.class, args);
		XmlToObject obj = new XmlToObject();
		obj.unmarshalling();
	}

}
