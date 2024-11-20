package XML;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LeerXML {

	public static void main(String[] args) {
		try {
			// Crear el DocumentBuilderFactory y el DocumentBuilder
			DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
			DocumentBuilder constructor = fabrica.newDocumentBuilder();

			// Leer el archivo XML
			Document doc = constructor.parse(new File("src\\XML\\personas.xml"));

			// Normalizar el documento
			doc.getDocumentElement().normalize();

			// Obtener la lista de nodos <persona>
			NodeList personaNodes = doc.getElementsByTagName("persona");

			// Recorrer los nodos <persona>
			for (int i = 0; i < personaNodes.getLength(); i++) {
				Node personaNode = personaNodes.item(i);

				Element personaElement = (Element) personaNode;

				// CONSIGO EL ATRIBUTO, OFICIO EN ESTE CASO
				String oficio = personaElement.getAttribute("oficio");
				System.out.println("Oficio: " + oficio);

				// CONSIGO EL NOMBRE
				NodeList nombreNodes = personaElement.getElementsByTagName("nombre");
				String nombre = nombreNodes.item(0).getTextContent();
				System.out.println("Nombre: " + nombre);

				// CONSIGO LA EDAD
				NodeList edadNodes = personaElement.getElementsByTagName("edad");
				String edad = edadNodes.item(0).getTextContent();
				System.out.println("Edad: " + edad);
				System.out.println("-------------------------");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
