/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package task3.validators;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

/**
 * Validates xml-file by using xsd
 * 
 * @author Gleb
 */
public class MyValidator {

    File schemaFile;
    Source xml;

    public MyValidator(String schema, String xml) {
        schemaFile = new File(schema);
        this.xml = new StreamSource(new File(xml));
    }

    /**
     * validates xml file
     * 
     * @return true - if file is valid, otherwise - false
     */
    public boolean validate() {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            validator.validate(xml);
            System.out.println("xml file is valid");
        } catch (SAXException ex) {
            System.out.println(xml.getSystemId() + " is NOT valid");
            System.out.println("Reason: " + ex.getLocalizedMessage());
            return false;
        } catch (IOException ex) {
            System.out.println("Input / Output exception");
            return false;
        }
        return true;
    }
}
