/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package task3.main;

import task3.validators.MyValidator;
import task3.model.FlowerComparator;
import task3.model.Flower;
import java.util.Collections;
import java.util.LinkedList;
import org.xml.sax.SAXException;
import task3.parsers.DOMParser;
import task3.parsers.MySAXParser;
import task3.parsers.StAXParser;
import task3.parsers.XMLParser;
import task3.transformers.XmlTransformer;

/**
 * Main class,; launches file parsing and shows the output
 * 
 * @version 1.0
 * @author Gleb
 */
public class Task3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SAXException {

        MyValidator val = new MyValidator("flower.xsd", "flower.xml");
        if (val.validate()) {

            XMLParser p = new MySAXParser();
            LinkedList<Flower> flowerList = (LinkedList) p.parse("flower.xml");
            
            /* Sort out the collection*/
            Collections.sort(flowerList, new FlowerComparator());

            /* show the collection*/
            System.out.println();
            for (Flower f : flowerList) {
                System.out.println("Id = " + f.getId());
                System.out.println("Name = " + f.getName());
                System.out.println(" type of soil = " + f.getSoil());
                System.out.println(" Origin = " + f.getOrigin());
                System.out.println(" Stem colour = " + f.getStemColour());
                System.out.println(" Leaves colour = " + f.getLeavesColour());
                System.out.println(" Average size in inches = " + f.getAverageSize());
                System.out.println(" temperature in centigrade = " + f.getTemperature());
                System.out.println(" preferable light (0 - shade, +" + "10 - bright light) = " + f.getLight());
                System.out.println(" Watering = " + f.getWatering());
                System.out.println(" type of multiplying = " + f.getMyltiplying());
                System.out.println();
            }
            
            XmlTransformer.transform("flower.xsl", "flower.xml", "flower.html");
        }
    }
}
