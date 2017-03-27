package by.vdoroshenko.parsers;

import by.vdoroshenko.objects.Airplane;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by viktoriyadoroshenko on 3/22/17.
 */
public class ParserStax implements XMLStreamConstants {

    Airplane airplane = new Airplane();

    public void parseStax(String filePath) throws FileNotFoundException, XMLStreamException {

        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader xmlStreamReader = factory.createXMLStreamReader(new FileInputStream(new File(filePath)));
        String tagContent = null;
        String tagName = null;

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

                    switch (tagName) {
                        case "id":
                            airplane.setId(Integer.parseInt(tagContent));
                            break;
                        case "Name":
                            airplane.setName(tagContent);
                            break;
                        case "Type":
                            airplane.setType(tagContent);
                            break;
                        case "MaxSpeed":
                            airplane.setSpeed(Integer.parseInt(tagContent));
                            break;
                        case "Capacity":
                            airplane.setCapacity(Double.parseDouble(tagContent));
                            break;
                        case "Length":
                            airplane.setLength(Integer.parseInt(tagContent));
                            break;
                        default:
                            break;
                    }
                    break;

                case XMLStreamConstants.END_DOCUMENT:
                    System.out.println("Parsing via STAX Parser is completed\n");
                    System.out.println(airplane.toString());
                    break;

                default:
                    break;

            }

        }

    }

}


