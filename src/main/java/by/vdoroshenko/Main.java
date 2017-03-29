package by.vdoroshenko;

import by.vdoroshenko.parsers.ParsDom;
import by.vdoroshenko.parsers.ParsJaxb;
import by.vdoroshenko.parsers.ParsSax;
import by.vdoroshenko.parsers.ParsStax;
import by.vdoroshenko.utilities.Menu;

/**
 * Created by viktoriyadoroshenko on 3/29/17.
 */
public class Main {

    private static final String FILE_PATH = "main/resources/AircraftList.xml";

    public static void main(String[] args) {

        while (true) {
            switch (Menu.showMenu()) {
                case 1:
                    ParsSax parsSax = new ParsSax();
                    parsSax.parse(FILE_PATH);
                    break;

                case 2:
                    ParsDom parsDom = new ParsDom();
                    parsDom.parse(FILE_PATH);
                    break;

                case 3:
                    ParsStax parsStax = new ParsStax();
                    parsStax.parse(FILE_PATH);
                    break;

                case 4:
                    ParsJaxb parsJaxb = new ParsJaxb();
                    parsJaxb.parse(FILE_PATH);
                    break;

                case 0:
                    System.out.println("See you later! Bye!");
                    System.exit(0);
                    break;

                default:
                    break;
            }
        }

    }

}
