package Controlador;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import Funciones.Utilidades;
import Modelo.CD;

public class Main {
    static Document doc = null;

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, TransformerException {
        Scanner sc = new Scanner(System.in);

        File inputFile = new File("C:\\Users\\in2dm3-d\\Desktop\\ariketa.xml");
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        doc = docBuilder.parse(inputFile);

        // Mostrar CDs existentes
        mostrarCDs();

        System.out.println("Quieres añadir uno? S-N");
        String aukera = sc.nextLine();
        if (aukera.equalsIgnoreCase("S")) {
            CD nuevoCD = Utilidades.pedirCD(sc);
            agregarNuevoCD(nuevoCD);
            guardarXML(inputFile);
        } else {
            System.exit(0);
        }
    }

    public static void mostrarCDs() {
        for (int i = 0; i < doc.getElementsByTagName("cd").getLength(); i++) {
            Node cdNode = doc.getElementsByTagName("cd").item(i);
            NamedNodeMap atributos = cdNode.getAttributes();

            int id = Integer.parseInt(atributos.getNamedItem("id").getNodeValue());
            String titulo = doc.getElementsByTagName("titulo").item(i).getTextContent();
            String artista = doc.getElementsByTagName("artista").item(i).getTextContent();
            String pais = doc.getElementsByTagName("pais").item(i).getTextContent();
            String sello = doc.getElementsByTagName("sello").item(i).getTextContent();
            double precio = Double.parseDouble(doc.getElementsByTagName("precio").item(i).getTextContent());
            int año = Integer.parseInt(doc.getElementsByTagName("ano").item(i).getTextContent());

            CD cd = new CD(id, titulo, artista, pais, sello, precio, año);
            System.out.println(cd.toString());
        }
    }

    public static void agregarNuevoCD(CD nuevoCD) {
        // Obtener el número actual de CDs y asignar el nuevo ID
        int nuevoId = doc.getElementsByTagName("cd").getLength() + 1;
        nuevoCD.setId(nuevoId);

        // Crear nuevo elemento <cd>
        Element cdElement = doc.createElement("cd");
        cdElement.setAttribute("id", Integer.toString(nuevoId));

        // Crear subelementos y añadirlos al <cd>
        Element tituloElement = doc.createElement("titulo");
        tituloElement.appendChild(doc.createTextNode(nuevoCD.getTitulo()));
        cdElement.appendChild(tituloElement);

        Element artistaElement = doc.createElement("artista");
        artistaElement.appendChild(doc.createTextNode(nuevoCD.getArtista()));
        cdElement.appendChild(artistaElement);

        Element paisElement = doc.createElement("pais");
        paisElement.appendChild(doc.createTextNode(nuevoCD.getPais()));
        cdElement.appendChild(paisElement);

        Element selloElement = doc.createElement("sello");
        selloElement.appendChild(doc.createTextNode(nuevoCD.getSello()));
        cdElement.appendChild(selloElement);

        Element precioElement = doc.createElement("precio");
        precioElement.appendChild(doc.createTextNode(Double.toString(nuevoCD.getPrecio())));
        cdElement.appendChild(precioElement);

        Element anoElement = doc.createElement("ano");
        anoElement.appendChild(doc.createTextNode(Integer.toString(nuevoCD.getAño())));
        cdElement.appendChild(anoElement);

        // Añadir el nuevo <cd> al documento XML
        doc.getDocumentElement().appendChild(cdElement);
    }

    public static void guardarXML(File file) throws TransformerException {
        // Guardar el documento XML modificado
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(file);
        transformer.transform(source, result);
        System.out.println("Archivo XML actualizado correctamente.");
    }
}
