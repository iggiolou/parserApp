package by.vdoroshenko.parsers;

import by.vdoroshenko.objects.Airplane;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by viktoriyadoroshenko on 3/22/17.
 */
public class ParserSax extends DefaultHandler {

    Airplane airplane = new Airplane();
    private String element;

    public ParserSax() throws FileNotFoundException, ParserConfigurationException, SAXException {
    }


    InputStream XMLData = new FileInputStream(new File("AircraftList.xml"));

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("Starting SAX Parser");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        element = qName;
        super.startElement(uri, localName, qName, attributes);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);

        String tagValue = new String(ch, start, length).trim();

        if (tagValue.length() > 0) {

            if (element.equals("id")) {
                airplane.setId(new Integer(new String(ch, start, length)));
            }
            if (element.equals("Name")) {
                airplane.setName(new String(ch, start, length));
            }
            if (element.equals("Type")) {
                airplane.setType(new String(ch, start, length));
            }
            if (element.equals("MaxSpeed")) {
                airplane.setSpeed(new Integer(new String(ch, start, length)));
            }
            if (element.equals("Capacity")) {
                airplane.setCapacity(new Double(new String(ch, start, length)));
            }
            if (element.equals("Length")) {
                airplane.setLength((new Integer(new String(ch, start, length))));
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        element = null;
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("Parsing via SAX Parser is completed");

        System.out.println(airplane.toString());

    }
}
