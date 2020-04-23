package by.training.epam.service;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class MyValidator {
	
	 public boolean validate(String schemaFile, String xmlFile) {
		 SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		 try {
	            Schema schema = schemaFactory.newSchema(new File(schemaFile));
	            Validator validator = schema.newValidator();
	            validator.validate(new StreamSource(new File(xmlFile)));
	            return true;
	        } catch (SAXException | IOException e) {
	            return false;
	        }
	 }
	 
}
