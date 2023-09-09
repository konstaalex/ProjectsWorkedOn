package trafficinternational;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import trafficinternational.api.TrafficLight;

public class UserInterface {

    private final Scanner scanner;
    private final LightFactory factory;

    List<TrafficLight> trafficLights;
    List<TrafficLight> pedestrianLights;

    private String userInputFunction;
    private String userInputBehaviour;
    private String userInputControler;

    private String function;
    private String behavior;

    public UserInterface(Scanner scanner, LightFactory factory) {
        this.scanner = scanner;
        this.factory = factory;
    }

    public void run() {
        trafficLights = new ArrayList<>();
        pedestrianLights = new ArrayList<>();
        while (true) {
            System.out.println("Choose what kind of function to display:");
            System.out.println("a. traffic light\n"
                    + "b. pedestrian light\n"
                    + "c. pedestrian crossing\n"
                    + "x. stop program");
            userInputFunction = scanner.nextLine();
            if (userInputFunction.equals("a") || userInputFunction.equals("b") || userInputFunction.equals("c")) {
                while (true) {
                    System.out.println("Choose what kind of behaviour to display:");
                    System.out.println("a. Dutch\n"
                            + "b. German\n"
                            + "x. return to previous page");
                    userInputBehaviour = scanner.nextLine();
                    if (userInputBehaviour.equals("a") || userInputBehaviour.equals("b")) {
                        switch (userInputFunction) {
                            case "a" ->
                                function = "traffic light";
                            case "b" ->
                                function = "pedestrian light";
                            case "c" ->
                                function = "pedestrian crossing";
                        }
                        switch (userInputBehaviour) {
                            case "a" ->
                                behavior = "dutch";
                            case "b" ->
                                behavior = "german";
                        }
                        while (true) {
                            System.out.println("Choose an action:\n"
                                    + "For " + behavior + " " + function + "s");
                            printControllerOptions();
                            System.out.println("x. return to previous page");
                            userInputControler = scanner.nextLine();
                            if (userInputControler.equals("x")) {
                                break;
                            } else {
                                methodAccess();
                            }
                        }
                    } else if (userInputBehaviour.equals("x")) {
                        break;
                    }
                }
            } else if (userInputFunction.equals("x")) {
                break;
            }
        }
    }

    private void printControllerOptions() {
        switch (function) {
            case "traffic light" -> {
                System.out.println("a. create traffic light");
            }
            case "pedestrian light" -> {
                System.out.println("a. create pedestrian light");
            }
            case "pedestrian crossing" -> {
                System.out.println("a. create a pedestrian crossing\n"
                        + "b. set mode");
            }
        }
    }

    private void methodAccess() {
        if (behavior.equals("dutch")) {
            switch (function) {
                case "traffic light" -> {
                    TrafficLight newTrafficLight = factory.getDutchTrafficLight();
                    trafficLights.add(newTrafficLight);
                }
                case "pedestrian light" -> {
                    TrafficLight newPedestrianLight = factory.getDutchPedestrianLight();
                    pedestrianLights.add(newPedestrianLight);
                }
                case "pedestrian crossing" ->
                    System.out.println("Not supported yet");
            }
        } else if (behavior.equals("german")) {
            switch (function) {
                case "traffic light" -> {
                    TrafficLight newTrafficLight = factory.getGermanTrafficLight();
                    trafficLights.add(newTrafficLight);
                }
                case "pedestrian light" -> {
                    TrafficLight newPedestrianLight = factory.getGermanPedestrianLight();
                    pedestrianLights.add(newPedestrianLight);
                }
                case "pedestrian crossing" ->
                    System.out.println("Not supported yet");
            }
        }
    }
}
