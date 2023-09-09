package trafficinternational.api;

/**
 * In this context a signal is a property of a traffic
 * light that dictates what is shown to the drivers and pedestrians
 *
 * Each signal knows what signal should come after it,
 * based on the current mode of its respective traffic light
 */

public interface Signal {

    /**
     * Method to change the current active Signal to its fixed successor State
     * @return Fixed following Signal
     */
    public Signal next();

    default public Signal decorateWith(String addition){
        return this;
    }
}
