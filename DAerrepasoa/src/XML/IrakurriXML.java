package XML;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class IrakurriXML {
    public static void main(String[] args) {
        try {
            // DocumentBuilderFactory eta DocumentBuilder sortu
            DocumentBuilderFactory fabrika = DocumentBuilderFactory.newInstance();
            DocumentBuilder eraikitzailea = fabrika.newDocumentBuilder();
            
            // XML fitxategia irakurri
            Document doc = eraikitzailea.parse(new File("src\\XML\\animal.xml"));

            // Dokumentua normalizatu
            doc.getDocumentElement().normalize();

            // "tipo" atributua irakurri eta erakutsi
            String tipo = doc.getDocumentElement().getAttribute("tipo");
            System.out.println("Tipo: " + tipo);

            // "nombre" balioa irakurri eta erakutsi
            NodeList nombreNodes = doc.getElementsByTagName("nombre");
            if (nombreNodes.getLength() > 0) {
                Node nombreNode = nombreNodes.item(0);
                System.out.println("Nombre: " + nombreNode.getTextContent());
            }

            // "edad" balioa irakurri eta erakutsi
            NodeList edadNodes = doc.getElementsByTagName("edad");
            if (edadNodes.getLength() > 0) {
                Node edadNode = edadNodes.item(0);
                System.out.println("Edad: " + edadNode.getTextContent());
            }

            // "habitat" balioa irakurri eta erakutsi
            NodeList habitatNodes = doc.getElementsByTagName("habitat");
            if (habitatNodes.getLength() > 0) {
                Node habitatNode = habitatNodes.item(0);
                System.out.println("Habitat: " + habitatNode.getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}

