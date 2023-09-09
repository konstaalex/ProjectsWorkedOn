 package trafficinternational;

import trafficinternational.api.AbstractLightFactory;
import trafficinternational.api.TrafficLight;

 /**
 * @author Cosmin Budurovici
 * @author Alex Constantinescu
 * @author Miro Miloloža
 * @author Max Jansen
 */
public class LightFactory implements AbstractLightFactory {

    private static int pLNumber=1;
    private static int tLNumber = 1;

    private static int aSNumber = 1;
    @Override
    public TrafficLight getGermanPedestrianLight() {
        String name="Pedestrian Light "+pLNumber+": ";
        pLNumber=pLNumber+1;
        return new TrafficLight(name,GermanPedestrianLightSignals.Stop);
    }

    @Override
    public TrafficLight getGermanTrafficLight() {
        String name = "Traffic light " + tLNumber + ":";
        tLNumber ++;
        return new TrafficLight(name,GermanTrafficLightSignal.Stop);
    }

    @Override
    public TrafficLight getDutchPedestrianLight() {
        String name = "Pedestrian Light " + pLNumber + ": ";
        pLNumber ++;

        return new TrafficLight(name, DutchPedestrianLightSignal.Stop);
    }

    @Override
    public TrafficLight getDutchTrafficLight() {
        String name = "Traffic Light " + tLNumber + ": ";
        tLNumber ++;

        return new TrafficLight(name, DutchTrafficLightSignal.Stop);
    }
}
