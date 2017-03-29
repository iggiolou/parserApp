package by.vdoroshenko.utilities;

import java.util.Scanner;

/**
 * Created by viktoriyadoroshenko on 3/23/17.
 */
public class ConsoleReader {

    public static int readNumber() {
        int key = 0;
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            return key = Integer.parseInt(sc.next());
        } else {
            System.out.println("The value you entered is not a number. Try again");
            Menu.showMenu();
        }
        return key;
    }

}
