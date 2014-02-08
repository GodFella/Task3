/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package task3.parsers;

import java.util.LinkedList;
import java.util.List;
import task3.model.Flower;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Gleb
 */
public class MySAXHandler extends DefaultHandler {
    
    /** Instance of  being processed at the moment*/
    private Flower currentFlower = null;
    
    /** collection of processed objects Flower */
    private LinkedList<Flower> flowers = new LinkedList<>();
    
    /** Temporary variable for storing contents of the element*/
    private String tempVal = "";
    
    /** Temporary variable for storing attribute values of the element*/
    private String value = "";

    /** Handles starting element found  */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("Flower")) {
            //add it to the list
            currentFlower = new Flower();
            String id = attributes.getValue(Flower.ID);
            currentFlower.setId(Integer.parseInt(id.substring(1)));
        } else if (qName.equalsIgnoreCase(Flower.TEMPERATURE)) {
            value = attributes.getValue("grade");
        } else if (qName.equalsIgnoreCase(Flower.AVERAGE_SIZE)) {
            value = attributes.getValue("unit");
        } else if (qName.equalsIgnoreCase(Flower.WATERING)) {
            value = attributes.getValue("unit");
        }
    }
    
    /** Handles data between elements found */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        tempVal = new String(ch, start, length);
    }

    /** Handles end element found  */
    @Override
    public void endElement(String uri, String localName,
            String qName) throws SAXException {

        if (qName.equalsIgnoreCase("Flower")) {
            //add it to the list
            flowers.add(currentFlower);
        } else if (qName.equalsIgnoreCase(Flower.NAME)) {
            currentFlower.setName(tempVal);
        } else if (qName.equalsIgnoreCase(Flower.SOIL)) {
            currentFlower.setSoil(tempVal);
        } else if (qName.equalsIgnoreCase(Flower.ORIGIN)) {
            currentFlower.setOrigin(tempVal);
        } else if (qName.equalsIgnoreCase(Flower.MULTIPLYING)) {
            currentFlower.setMyltiplying(tempVal);
        } else if (qName.equalsIgnoreCase(Flower.STEM_COLOUR)) {
            currentFlower.setStemColour(tempVal);
        } else if (qName.equalsIgnoreCase(Flower.LEAVES_COLOUR)) {
            currentFlower.setLeavesColour(tempVal);
        } else if (qName.equalsIgnoreCase(Flower.AVERAGE_SIZE)) {
            currentFlower.setAverageSize(tempVal, value);
        } else if (qName.equalsIgnoreCase(Flower.TEMPERATURE)) {
            currentFlower.setTemperature(tempVal, value);
        } else if (qName.equalsIgnoreCase(Flower.LIGHT)) {
            currentFlower.setLight(Integer.parseInt(tempVal));
        } else if (qName.equalsIgnoreCase(Flower.WATERING)) {
            currentFlower.setWatering(tempVal, value);
        }

    }

    /**
     * returns the collection that has been parsed
     * 
     * @return the collection that has been parsed
     */
    public LinkedList<Flower> getParsedCollection() {
        return flowers;
    }
}
