package by.vdoroshenko.parsers;

import by.vdoroshenko.Interfaces.IParseble;
import by.vdoroshenko.objects.Airplane;
import by.vdoroshenko.objects.Values;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by viktoriyadoroshenko on 3/29/17.
 */
public class ParsDom implements IParseble {

    Airplane airplane = new Airplane();
    List<Airplane> airplaneList = new ArrayList<>();

    public void parse(String filePath) {

        System.out.println("Starting DOM Parser");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        Document document = null;
        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse(new File(filePath));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        NodeList nodeList = document.getElementsByTagName(Values.OBJECT.toString());

        for (int i = 0; i < nodeList.getLength(); i++) {

            Node node = nodeList.item(i);

            Element element = (Element) node;
            airplane.setId(Integer.parseInt(element.getElementsByTagName(Values.ID.toString()).item(0)
                    .getChildNodes().item(0).getNodeValue()));
            airplane.setName(element.getElementsByTagName(Values.NAME.toString()).item(0)
                    .getChildNodes().item(0).getNodeValue());
            airplane.setType(element.getElementsByTagName(Values.TYPE.toString()).item(0)
                    .getChildNodes().item(0).getNodeValue());
            airplane.setSpeed(Integer.parseInt(element.getElementsByTagName(Values.SPEED.toString()).item(0)
                    .getChildNodes().item(0).getNodeValue()));
            airplane.setCapacity(Double.parseDouble(element.getElementsByTagName(Values.CAPACITY.toString()).item(0)
                    .getChildNodes().item(0).getNodeValue()));
            airplane.setLength(Integer.parseInt(element.getElementsByTagName(Values.LENGTH.toString()).item(0)
                    .getChildNodes().item(0).getNodeValue()));

            airplaneList.add(airplane);

        }
        System.out.println("Parsing via SAX Parser is completed");

        airplaneList.forEach(airplane -> System.out.println(airplane.toString()));

    }
}
