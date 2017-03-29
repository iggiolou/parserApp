package by.vdoroshenko.parsers;

import by.vdoroshenko.Interfaces.IParseble;
import by.vdoroshenko.objects.Airplane;
import by.vdoroshenko.objects.Values;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by viktoriyadoroshenko on 3/29/17.
 */
public class ParsSax extends DefaultHandler implements IParseble {

    Airplane airplane = new Airplane();
    List<Airplane> airplaneList = new ArrayList<>();
    private String element;

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();

        System.out.println("Starting SAX Parser");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        element = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);

        String tagValue = new String(ch, start, length).trim();

        if (tagValue.length() > 0) {

            if (element.equals(Values.ID.toString())) {
                airplane.setId(new Integer(new String(ch, start, length)));
            }
            if (element.equals(Values.NAME.toString())) {
                airplane.setName(new String(ch, start, length));
            }
            if (element.equals(Values.TYPE.toString())) {
                airplane.setType(new String(ch, start, length));
            }
            if (element.equals(Values.SPEED.toString())) {
                airplane.setSpeed(new Integer(new String(ch, start, length)));
            }
            if (element.equals(Values.CAPACITY.toString())) {
                airplane.setCapacity(new Double(new String(ch, start, length)));
            }
            if (element.equals(Values.LENGTH.toString())) {
                airplane.setLength((new Integer(new String(ch, start, length))));
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (element.equals(Values.OBJECT.toString())) {
            airplaneList.add(airplane);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("Parsing via SAX Parser is completed");

        airplaneList.forEach(airplane -> System.out.println(airplane.toString()));

    }

    public void parse(String filePath) {

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(filePath, (new ParsSax()));

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }
}

