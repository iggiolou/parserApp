package by.vdoroshenko.parsers;

import by.vdoroshenko.Interfaces.IParseble;
import by.vdoroshenko.objects.Airplane;
import by.vdoroshenko.objects.Values;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by viktoriyadoroshenko on 3/29/17.
 */
public class ParsStax implements IParseble, XMLStreamConstants {

    Airplane airplane = new Airplane();
    List<Airplane> airplaneList = new ArrayList<>();

    public void parse(String filePath) {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader xmlStreamReader = null;
        try {
            xmlStreamReader = factory.createXMLStreamReader(new FileInputStream(new File(filePath)));
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String tagContent = null;
        String tagName = null;

        try {
            while (xmlStreamReader.hasNext()) {
                int event = xmlStreamReader.next();

                switch (event) {
                    case XMLStreamConstants.START_DOCUMENT:
                        System.out.println("Starting STAX Parser");
                        break;

                    case XMLStreamConstants.START_ELEMENT:
                        tagName = xmlStreamReader.getName().getLocalPart();
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        if (!xmlStreamReader.hasText()) {
                            break;
                        }
                        tagContent = xmlStreamReader.getText().trim();
                        if (tagContent == null || tagContent.length() == 0) {
                            break;
                        }
                        if (tagName.equals(Values.ID.toString())) {
                            airplane.setId(Integer.parseInt(tagContent));
                        }
                        if (tagName.equals(Values.NAME.toString())) {
                            airplane.setName(tagContent);
                        }
                        if (tagName.equals(Values.TYPE.toString())) {
                            airplane.setType(tagContent);
                        }
                        if (tagName.equals(Values.SPEED.toString())) {
                            airplane.setSpeed(Integer.parseInt(tagContent));
                        }
                        if (tagName.equals(Values.CAPACITY.toString())) {
                            airplane.setCapacity(Double.parseDouble(tagContent));
                        }
                        if (tagName.equals(Values.LENGTH.toString())) {
                            airplane.setLength(Integer.parseInt(tagContent));
                        } else {
                            break;
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        if (tagName.equals("Airplane")) {
                            airplaneList.add(airplane);
                        }
                        break;

                    case XMLStreamConstants.END_DOCUMENT:
                        System.out.println("Parsing via STAX Parser is completed\n");
                        airplaneList.forEach(airplane -> System.out.println(airplane.toString()));
                        break;

                    default:
                        break;
                }

            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

    }
}
