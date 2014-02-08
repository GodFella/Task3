/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package task3.parsers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import task3.model.Flower;

/**
 * XML parser that uses StAX library
 *
 * @author Gleb
 */
public class StAXParser extends XMLParser {

    /**
     * Parses xml file
     * 
     * @param fileName location of the file on a disk
     * @return collectiion of objects Flower
     */
    public List<Flower> parse(String fileName) {
        List<Flower> flowers = new LinkedList<Flower>();
        try {
            /* First create a new XMLInputFactory */
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            // Setup a new eventReader
            InputStream in = new FileInputStream(fileName);
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
            /* Read the XML document */
            Flower flower = null;

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    // If we have a item element we create a new item
                    if (startElement.getName().getLocalPart().equals("flower")) {
                        flower = new Flower();
                        // We read the attributes from this tag and add the date
                        // attribute to our object
                        Iterator<Attribute> attributes = startElement.getAttributes();
                        while (attributes.hasNext()) {
                            Attribute attribute = attributes.next();
                            if (attribute.getName().toString().equals(Flower.ID)) {
                                flower.setId(Integer.parseInt(attribute.getValue().substring(1)));
                            }

                        }
                    }

                    if (event.isStartElement()) {
                        if (event.asStartElement().getName().getLocalPart().equals(Flower.NAME)) {
                            event = eventReader.nextEvent();
                            flower.setName(event.asCharacters().getData());
                        } else if (event.asStartElement().getName().getLocalPart().equals(Flower.SOIL)) {
                            event = eventReader.nextEvent();
                            flower.setSoil(event.asCharacters().getData());
                        } else if (event.asStartElement().getName().getLocalPart().equals(Flower.ORIGIN)) {
                            event = eventReader.nextEvent();
                            flower.setOrigin(event.asCharacters().getData());
                        } else if (event.asStartElement().getName().getLocalPart().equals(Flower.STEM_COLOUR)) {
                            event = eventReader.nextEvent();
                            flower.setStemColour(event.asCharacters().getData());
                        } else if (event.asStartElement().getName().getLocalPart().equals(Flower.LEAVES_COLOUR)) {
                            event = eventReader.nextEvent();
                            flower.setLeavesColour(event.asCharacters().getData());
                        } else if (event.asStartElement().getName().getLocalPart().equals(Flower.TEMPERATURE)) {
                            event = eventReader.nextEvent();
                            String temp = event.asCharacters().getData();

                            Iterator<Attribute> attributes = startElement.getAttributes();
                            while (attributes.hasNext()) {
                                Attribute attribute = attributes.next();
                                if (attribute.getName().toString().equals("grade")) {
                                    flower.setTemperature(temp, attribute.getValue());
                                }

                            }

                        } else if (event.asStartElement().getName().getLocalPart().equals(Flower.LIGHT)) {
                            event = eventReader.nextEvent();
                            flower.setLight(Integer.parseInt(event.asCharacters().getData()));
                        } else if (event.asStartElement().getName().getLocalPart().equals(Flower.WATERING)) {
                            event = eventReader.nextEvent();
                            String vol = event.asCharacters().getData();
                            Iterator<Attribute> attributes = startElement.getAttributes();
                            while (attributes.hasNext()) {
                                Attribute attribute = attributes.next();
                                if (attribute.getName().toString().equals("unit")) {
                                    flower.setWatering(vol, attribute.getValue());
                                }
                            }
                        } else if (event.asStartElement().getName().getLocalPart().equals(Flower.MULTIPLYING)) {
                            event = eventReader.nextEvent();
                            flower.setMyltiplying(event.asCharacters().getData());
                        } else if (event.asStartElement().getName().getLocalPart().equals(Flower.AVERAGE_SIZE)) {
                            event = eventReader.nextEvent();
                            String size = event.asCharacters().getData();
                            Iterator<Attribute> attributes = startElement.getAttributes();
                            while (attributes.hasNext()) {
                                Attribute attribute = attributes.next();
                                if (attribute.getName().toString().equals("unit")) {
                                    flower.setAverageSize(size, attribute.getValue());
                                }
                            }
                        }
                    }
                }
                // If we reach the end of an item element we add it to the list
                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart().equals("flower")) {
                        flowers.add(flower);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return flowers;
    }
}
