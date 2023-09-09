package trafficinternational.api;

/**
 * abstract crossing represents interface for a crossing that is responsible for notifying traffic lights to change to the next signal
 * it takes the role of the subject/ observable in implementing the observer pattern,
 * traffic lights being the observers that are added to the crossing
 */
public interface AbstractCrossing {
    /**
     * parameter is added to the crossing using a list.
     * @param trafficLight
     */
    public void addObserver(AbstractTrafficLight trafficLight);

    /**
     * parameter is removed from the list.
     * @param trafficLight
     */
    public void removeObserver(AbstractTrafficLight trafficLight);

    /**
     * notifies each traffic light from the list to change to the next signal.
     * @param signal
     */
    public void nextSignal(Signal signal);


}
