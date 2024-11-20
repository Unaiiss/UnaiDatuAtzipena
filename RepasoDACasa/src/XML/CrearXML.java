package XML;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CrearXML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try {
            // Dokumentua sortu memoria-n (Document)
            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
            DocumentBuilder constructor = fabrica.newDocumentBuilder();
            Document doc = constructor.newDocument();
            
            //CREO EL ERRO NODO PERSONAS, EL XML TENDRA DOS PERSONAS
            Element erroElementua = doc.createElement("personas");
            doc.appendChild(erroElementua);
            
            Attr oficio;

            //=========== PERSONA 1 ===========
            Element personaElement1 = doc.createElement("persona");
            //EL ATRIBUTO ES OFICIO
            oficio = doc.createAttribute("oficio");
            oficio.setValue("programador");
            personaElement1.setAttributeNode(oficio);
            erroElementua.appendChild(personaElement1);
            
            //ELEMENTO NOMBRE
            Element nombre1 = doc.createElement("nombre");
            nombre1.appendChild(doc.createTextNode("Unai"));
            personaElement1.appendChild(nombre1);
            
            //ELEMENTO EDAD
            Element edad1 = doc.createElement("edad");
            edad1.appendChild(doc.createTextNode("22"));
            personaElement1.appendChild(edad1);
            
            //=========== PERSONA 2 ===========
            Element personaElement2 = doc.createElement("persona");
            //EL ATRIBUTO ES OFICIO
            oficio = doc.createAttribute("oficio");
            oficio.setValue("basurero");
            personaElement2.setAttributeNode(oficio);
            erroElementua.appendChild(personaElement2);
            
            //ELEMENTO NOMBRE
            Element nombre2 = doc.createElement("nombre");
            nombre2.appendChild(doc.createTextNode("Iker"));
            personaElement2.appendChild(nombre2);
            
            //ELEMENTO EDAD
            Element edad2 = doc.createElement("edad");
            edad2.appendChild(doc.createTextNode("21"));
            personaElement2.appendChild(edad2);

            // XML fitxategian idatzi
            TransformerFactory transFormatFactory = TransformerFactory.newInstance();
            Transformer transformadorea = transFormatFactory.newTransformer();
            StreamResult emaitza = new StreamResult(new File("src\\XML\\personas.xml"));
            DOMSource iturburu = new DOMSource(doc);
            transformadorea.transform(iturburu, emaitza);

            System.out.println("XML sortu da: 'personas.xml'");
            
            //SI SE QUISIERA AÑADIR OTRA PERSONA MAS APARTE DE LAS DOS QUE YA HAY
            //HABRIA QUE HACER UN erroElementua.appendChild(nuevaPersona);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
