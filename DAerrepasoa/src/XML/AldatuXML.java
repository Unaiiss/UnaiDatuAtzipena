package XML;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class AldatuXML {
    public static void main(String[] args) {
        try {
            // DocumentBuilderFactory eta DocumentBuilder sortu
            DocumentBuilderFactory fabrika = DocumentBuilderFactory.newInstance();
            DocumentBuilder eraikitzailea = fabrika.newDocumentBuilder();
            
            // XML fitxategia irakurri
            Document doc = eraikitzailea.parse(new File("src\\XML\\animal.xml"));

            // Dokumentua normalizatu
            doc.getDocumentElement().normalize();

            // "edad" balioa aldatu
            NodeList edadNodes = doc.getElementsByTagName("edad");
            if (edadNodes.getLength() > 0) {
                Node edadNode = edadNodes.item(0);
                edadNode.setTextContent("12"); // Adina aldatu 12-ra
            }

            // "tipo" atributua aldatu
            NodeList animalNodes = doc.getElementsByTagName("animal");
            if (animalNodes.getLength() > 0) {
            	Node animalNode = animalNodes.item(0);
            	NamedNodeMap motaAttr = animalNode.getAttributes();
            	Node nodeAttr = motaAttr.getNamedItem("tipo");
            	nodeAttr.setTextContent("reptil"); // Mota aldatu "reptil"-era
            }
            
            // XML fitxategian aldaketa gorde
            TransformerFactory transFormatFactory = TransformerFactory.newInstance();
            Transformer transformadorea = transFormatFactory.newTransformer();
            StreamResult emaitza = new StreamResult(new File("src\\XML\\animal_aldatua.xml"));
            DOMSource iturburu = new DOMSource(doc);
            transformadorea.transform(iturburu, emaitza);

            System.out.println("XML-a aldatu da eta 'animal_aldatua.xml' izenarekin gorde da.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
