package by.vdoroshenko.parsers;

import by.vdoroshenko.objects.Airplane;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by viktoriyadoroshenko on 3/22/17.
 */
public class ParserDom {

    Airplane airplane = new Airplane();

    public void domParse(String filePath) throws ParserConfigurationException, IOException, SAXException {

        System.out.println("Starting DOM Parser");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(filePath));

        NodeList nodeList = document.getElementsByTagName("Airplane");

        for (int i = 0; i < nodeList.getLength(); i++) {

            Node node = nodeList.item(i);

            Element element = (Element) node;
            airplane.setId(Integer.parseInt(element.getElementsByTagName("id").item(0)
                    .getChildNodes().item(0).getNodeValue()));
            airplane.setName(element.getElementsByTagName("Name").item(0)
                    .getChildNodes().item(0).getNodeValue());
            airplane.setType(element.getElementsByTagName("Type").item(0)
                    .getChildNodes().item(0).getNodeValue());
            airplane.setSpeed(Integer.parseInt(element.getElementsByTagName("MaxSpeed").item(0)
                    .getChildNodes().item(0).getNodeValue()));
            airplane.setCapacity(Double.parseDouble(element.getElementsByTagName("Capacity").item(0)
                    .getChildNodes().item(0).getNodeValue()));
            airplane.setLength(Integer.parseInt(element.getElementsByTagName("Length").item(0)
                    .getChildNodes().item(0).getNodeValue()));

        }
        System.out.println("Parsing via SAX Parser is completed");
        System.out.println(airplane.toString());
    }
}

