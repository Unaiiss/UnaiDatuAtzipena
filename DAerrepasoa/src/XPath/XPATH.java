package XPath;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.*;
import javax.xml.xpath.*;

public class XPATH {
    public static void main(String[] args) {
        try {
            // XML dokumentua kargatzea
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("src\\XPath\\company.xml");

            // XPath instantzia bat sortzea
            XPath xpath = XPathFactory.newInstance().newXPath();

            // 1. Langile guztiak
            String expresion1 = "//employee";
            NodeList empleados1 = (NodeList) xpath.evaluate(expresion1, document, XPathConstants.NODESET);
            System.out.println("Langile guztiak:");
            for (int i = 0; i < empleados1.getLength(); i++) {
                System.out.println(empleados1.item(i).getTextContent());
            }

            // 2. Soldata 45000 baino handiagoa duten langileak
            String expresion2 = "//employee[salary > 45000]";
            NodeList empleados2 = (NodeList) xpath.evaluate(expresion2, document, XPathConstants.NODESET);
            System.out.println("\nSoldata 45000 baino handiagoa duten langileak:");
            for (int i = 0; i < empleados2.getLength(); i++) {
                System.out.println(empleados2.item(i).getTextContent());
            }

            // 3. Langile guztien izenak
            String expresion3 = "//employee/name/text()";
            NodeList nombres3 = (NodeList) xpath.evaluate(expresion3, document, XPathConstants.NODESET);
            System.out.println("\nLangile guztien izenak:");
            for (int i = 0; i < nombres3.getLength(); i++) {
                System.out.println(nombres3.item(i).getNodeValue());
            }

            // 4. Soldata 50000 edo txikiagoa duten langileen izenak
            String expresion4 = "//employee[salary <= 50000]/name/text()";
            NodeList nombres4 = (NodeList) xpath.evaluate(expresion4, document, XPathConstants.NODESET);
            System.out.println("\nSoldata 50000 edo txikiagoa duten langileen izenak:");
            for (int i = 0; i < nombres4.getLength(); i++) {
                System.out.println(nombres4.item(i).getNodeValue());
            }

            // 5. id="3" duen langilearen soldata
            String expresion5 = "//employee[@id='3']/salary/text()";
            NodeList salario5 = (NodeList) xpath.evaluate(expresion5, document, XPathConstants.NODESET);
            System.out.println("\n'id' atributuan '3' balioa duen langilearen soldata:");
            System.out.println(salario5.item(0).getNodeValue());

            // 6. Soldata 45000 eta 60000 bitartekoa duten langileak
            String expresion6 = "//employee[salary >= 45000 and salary <= 60000]";
            NodeList empleados6 = (NodeList) xpath.evaluate(expresion6, document, XPathConstants.NODESET);
            System.out.println("\nSoldata 45000 eta 60000 bitartekoa duten langileak:");
            for (int i = 0; i < empleados6.getLength(); i++) {
                System.out.println(empleados6.item(i).getTextContent());
            }

            // 7. "Desarrollador" bezala lan egiten duten langileen kopurua
            String expresion7 = "count(//employee[position='Desarrollador'])";
            Double result7 = (Double) xpath.evaluate(expresion7, document, XPathConstants.NUMBER);
            System.out.println("\n'Desarrollador' bezala lan egiten duten langileen kopurua: " + result7.intValue());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
