/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package task3.parsers;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import task3.model.Flower;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * XML parser that uses DOM library
 * 
 * @author Gleb
 */
public class DOMParser extends XMLParser {

    private String getTagValue(String sTag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();

        Node nValue = (Node) nlList.item(0);

        return nValue.getNodeValue();
    }

    /**
     * Parses xml file
     * 
     * @param fileName location of the file on a disk
     * @return collectiion of objects Flower
     */
    @Override
    public List<Flower> parse(String fileName) {

        LinkedList<Flower> flowerList = new LinkedList<>();
        Flower flower;

        try {
            File fXmlFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("flower");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                flower = new Flower();
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;
                    String id = eElement.getAttribute(Flower.ID);
                    flower.setId(Integer.parseInt(id.substring(1)));

                    flower.setName(getTagValue(Flower.NAME, eElement));
                    flower.setSoil(getTagValue(Flower.SOIL, eElement));
                    flower.setOrigin(getTagValue(Flower.ORIGIN, eElement));
                    flower.setStemColour(getTagValue(Flower.STEM_COLOUR, eElement));
                    flower.setLeavesColour(getTagValue(Flower.LEAVES_COLOUR, eElement));
                    
                    // set average size
                    NodeList nList2 = ((Element)nNode).getElementsByTagName(Flower.AVERAGE_SIZE);
                    String unit = ((Element)nList2.item(0)).getAttribute("unit");
                    flower.setAverageSize(getTagValue(Flower.AVERAGE_SIZE, eElement), unit);
                    
                    // set temperature
                    nList2 = ((Element)nNode).getElementsByTagName(Flower.TEMPERATURE);
                    String grade = ((Element)nList2.item(0)).getAttribute("grade");
                    flower.setTemperature(getTagValue(
                                    Flower.TEMPERATURE, eElement), grade);
                    
                    // set light
                    flower.setLight(Integer.parseInt(getTagValue(Flower.LIGHT, eElement)));
                    
                    nList2 = ((Element)nNode).getElementsByTagName("watering");
                    unit = ((Element)nList2.item(0)).getAttribute("unit");
                    flower.setWatering(getTagValue(Flower.WATERING, eElement), unit);
                    
                    flower.setMyltiplying(getTagValue(Flower.MULTIPLYING, eElement));
                    
                }
                flowerList.add(flower);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flowerList;
    }
}
