package trafficinternational.api;

/**
 * @author Cosmin Budurovici
 * @author Alex Constantinescu
 * @author Miro Miloloža
 * @author Max Jansen
 *
 * Interface for factories for each country
 */
public interface AbstractLightFactory {
    
    /**
     * Factory method to return a new German Pedestrian Light
     * @return new German Pedestrian Light Object
     */
    public TrafficLight getGermanPedestrianLight();

    /**
     * Factory method to return a new German Traffic Light
     * @return new German Traffic Light Object
     */
    public TrafficLight getGermanTrafficLight();

    /**
     * Factory method to return a new Dutch Pedestrian Light
     * @return new Dutch Pedestrian Light Object
     */
    public TrafficLight getDutchPedestrianLight();

    /**
     * Factory method to return a new Dutch Traffic Light
     * @return new Dutch Traffic Light Object
     */
    public TrafficLight getDutchTrafficLight();
}
