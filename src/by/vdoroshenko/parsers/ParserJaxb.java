package by.vdoroshenko.parsers;

import by.vdoroshenko.objects.Airplane;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by viktoriyadoroshenko on 3/24/17.
 */
public class ParserJaxb {

    public void parseJaxb(String filePath) throws JAXBException {

        File file = new File(filePath);
        JAXBContext context = JAXBContext.newInstance(Airplane.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();
        Airplane airplane = (Airplane) unmarshaller.unmarshal(file);

        System.out.println(airplane.toString());

    }

}
