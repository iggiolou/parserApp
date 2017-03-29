package by.vdoroshenko.parsers;

import by.vdoroshenko.Interfaces.IParseble;
import by.vdoroshenko.objects.Airplane;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by viktoriyadoroshenko on 3/29/17.
 */
public class ParsJaxb implements IParseble {

    List<Airplane> airplaneList = new ArrayList<>();

    public void parse(String filePath) {

        File file = new File(filePath);

        try {
            JAXBContext context = JAXBContext.newInstance(Airplane.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Airplane airplane = (Airplane) unmarshaller.unmarshal(file);
            airplaneList.add(airplane);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        airplaneList.forEach(airplane -> System.out.println(airplane.toString()));

    }
}
