/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package task3.transformers;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author Hlib Babii <hlib.babii at hlibbabii.ua>
 */
public class XmlTransformer {

    public static void transform(String xslFile, String xmlFile, String htmlFile) {
        try {
            TransformerFactory tFact =
                    TransformerFactory.newInstance();
            Transformer transformer = tFact.newTransformer(
                    new StreamSource(xslFile));
            transformer.transform(
                    new StreamSource(xmlFile),
                    new StreamResult(htmlFile));
        } catch (TransformerException ex) {
            Logger.getLogger(XmlTransformer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
