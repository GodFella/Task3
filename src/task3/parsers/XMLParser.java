/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package task3.parsers;

import java.util.List;
import task3.model.Flower;

/**
 *abstract class for xml files parsers
 * 
 * @author Gleb
 */
public abstract class XMLParser {
    abstract public List<Flower> parse(String fileName);
}
    