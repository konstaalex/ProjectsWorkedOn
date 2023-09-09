package trafficinternational;

import java.util.Scanner;

/**
 *
 * @author maxim
 */
public class TrafficInternational {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserInterface ui = new UserInterface(new Scanner(System.in),new LightFactory());
        ui.run();
    }
}
