package by.vdoroshenko.utilities;

/**
 * Created by viktoriyadoroshenko on 3/23/17.
 */
public class Menu {
    public static int showMenu() {
        System.out.println("Select you parser");
        System.out.println("1 - SAX Parser");
        System.out.println("2 - DOM Parser");
        System.out.println("3 - STAX Parser");
        System.out.println("4 - JAXB");
        System.out.println("0 - For Exit");
        int menuItem = 0;

        switch (ConsoleReader.readNumber()) {
            case 1:
                menuItem = 1;
                break;
            case 2:
                menuItem = 2;
                break;
            case 3:
                menuItem = 3;
                break;
            case 4:
                menuItem = 4;
                break;
            default:
                System.out.println("Your choice does not match any menu item. Try again");
                return showMenu();

        }
        return menuItem;
    }

}
