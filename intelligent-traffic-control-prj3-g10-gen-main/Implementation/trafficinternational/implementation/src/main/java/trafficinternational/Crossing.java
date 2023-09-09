package trafficinternational;

import trafficinternational.api.AbstractCrossing;
import trafficinternational.api.AbstractTrafficLight;
import trafficinternational.api.Signal;

import java.util.ArrayList;
import java.util.List;

public class Crossing implements AbstractCrossing {
    private Signal signal;
    private List<AbstractTrafficLight> trafficLights = new ArrayList<>();
    
    @Override
    public void addObserver(AbstractTrafficLight trafficLight) {
        trafficLights.add(trafficLight);
    }

    @Override
    public void removeObserver(AbstractTrafficLight trafficLight) {
        trafficLights.remove(trafficLight);
    }

    @Override
    public void nextSignal(Signal signal) {
        this.signal = signal;
        for (AbstractTrafficLight tl: this.trafficLights) {
            tl.isNotified(this.signal);
        }
    }
}
