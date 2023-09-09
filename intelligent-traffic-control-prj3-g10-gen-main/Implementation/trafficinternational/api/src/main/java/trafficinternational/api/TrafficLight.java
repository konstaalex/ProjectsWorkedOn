package trafficinternational.api;

public class TrafficLight implements AbstractTrafficLight {
    private Signal signal;
    private String name;

    public TrafficLight(String name, Signal signal){
        this.name=name;
        this.signal=signal;
    }

    /**
     * This function changes the traffic light to the next signal in the cycle
     * @return The new signal of the traffic light
     */
    public Signal update(){
        signal=signal.next();
        System.out.println(this.toString());
        return signal;
    }

    /**
     *  toString method used to display any changes in the
     *  trafic light behaviour to the console
     * @return
     */
    public String toString(){
        return name + " " + signal.toString();
    }

    @Override
    public void isNotified(Signal signal) {
        this.signal = signal;
        this.update();
    }

    public void decorateTrafficLight(String addition){
        this.signal=this.signal.decorateWith(addition);
    }
}

