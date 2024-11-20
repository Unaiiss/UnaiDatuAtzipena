package XML;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class SortuXML {
    public static void main(String[] args) {
        try {
            // Dokumentua sortu memoria-n (Document)
            DocumentBuilderFactory fabrika = DocumentBuilderFactory.newInstance();
            DocumentBuilder eraikitzailea = fabrika.newDocumentBuilder();
            Document doc = eraikitzailea.newDocument();
            
            // Sortu <animal> erro-nodoa "tipo" atributuarekin
            Element erroElementua = doc.createElement("animal");
            Attr motaAttr =  doc.createAttribute("tipo");
            motaAttr.setValue("mamifero");
            erroElementua.setAttributeNode(motaAttr);
            doc.appendChild(erroElementua);

            // Sortu <nombre> nodoa eta gehitu erro-nodoan
            Element izena = doc.createElement("nombre");
            izena.appendChild(doc.createTextNode("Elefante"));
            erroElementua.appendChild(izena);

            // Sortu <edad> nodoa eta gehitu erro-nodoan
            Element adina = doc.createElement("edad");
            adina.appendChild(doc.createTextNode("10"));
            erroElementua.appendChild(adina);

            // Sortu <habitat> nodoa eta gehitu erro-nodoan
            Element bizilekua = doc.createElement("habitat");
            bizilekua.appendChild(doc.createTextNode("Selva"));
            erroElementua.appendChild(bizilekua);

            // XML fitxategian idatzi
            TransformerFactory transFormatFactory = TransformerFactory.newInstance();
            Transformer transformadorea = transFormatFactory.newTransformer();
            StreamResult emaitza = new StreamResult(new File("src\\XML\\animal.xml"));
            DOMSource iturburu = new DOMSource(doc);
            transformadorea.transform(iturburu, emaitza);

            System.out.println("XML sortu da: 'animal.xml'");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
