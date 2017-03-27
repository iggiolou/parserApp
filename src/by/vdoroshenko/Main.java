package by.vdoroshenko;

import by.vdoroshenko.parsers.ParserDom;
import by.vdoroshenko.parsers.ParserJaxb;
import by.vdoroshenko.parsers.ParserSax;
import by.vdoroshenko.parsers.ParserStax;
import by.vdoroshenko.utilities.Menu;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static final String FILE_PATH = "AircraftList.xml";

    public static void main(String[] args) {
        while (true) {
            switch (Menu.showMenu()) {
                case 1:
                    try {
                        ParserSax mySaxParser = new ParserSax();
                        SAXParserFactory factory = SAXParserFactory.newInstance();
                        SAXParser defSaxParser = factory.newSAXParser();
                        defSaxParser.parse(new File(FILE_PATH), mySaxParser);
                    } catch (SAXException | IOException | ParserConfigurationException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        ParserDom parserDom = new ParserDom();
                        parserDom.domParse(FILE_PATH);
                    } catch (ParserConfigurationException e) {
                        e.printStackTrace();
                    } catch (IOException | SAXException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        ParserStax parserStax = new ParserStax();
                        parserStax.parseStax(FILE_PATH);
                    } catch (FileNotFoundException | XMLStreamException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        ParserJaxb parserJaxb = new ParserJaxb();
                        parserJaxb.parseJaxb(FILE_PATH);
                    } catch (JAXBException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("See you later! Bye");
                    System.exit(0);

                default:
                    break;

            }

        }
    }
}
