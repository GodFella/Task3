/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package task3.parsers;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import task3.model.Flower;
import org.xml.sax.SAXException;

/**
 * XML parser that uses SAX library
 * 
 * @author Gleb
 */
public class MySAXParser extends XMLParser {

    /** SAX handler */
    private MySAXHandler saxHandler =null;
    
    /** Default constructor */
    public MySAXParser()
    {
    }
    
    /**
     * Parses xml file
     * 
     * @param fileName location of the file on a disk
     * @return collectiion of objects Flower
     */
    @Override
    public List<Flower> parse(String fileName) {
        
        SAXParserFactory spf = SAXParserFactory.newInstance();
        saxHandler = new MySAXHandler();
        try {
            SAXParser parser = spf.newSAXParser();
            parser.parse(fileName, saxHandler);
            System.out.println("Parsed successfully");
        } catch (SAXException ex) {
            System.out.println("SAXException");
            System.exit(1);
        } catch (IOException ex) {
            System.out.println("File not found");
            System.exit(1);
        } catch (ParserConfigurationException ex) {
            System.out.println("Parser configuration exception");
            System.exit(1);
        }
        return saxHandler.getParsedCollection();
    }
}
