package trafficinternational.api;

/**
 * interface for traffic light taking role as an observer
 */
public interface AbstractTrafficLight {
    /**
     * method to notify the change to a signal that has to happen within a traffic light
     *
     * @param signal
     */
    public void isNotified(Signal signal);

}
