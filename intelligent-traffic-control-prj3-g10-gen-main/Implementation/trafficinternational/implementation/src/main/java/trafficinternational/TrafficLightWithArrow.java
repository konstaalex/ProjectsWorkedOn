package trafficinternational;

import trafficinternational.api.Signal;

public class TrafficLightWithArrow implements Signal {

    Signal originalTrafficLightSignal;
    String signal;

    /**
     * basic constructor with traffic light signal
     * @param signal
     */
    TrafficLightWithArrow(Signal signal){
        this.originalTrafficLightSignal =signal;
        if(signal==GermanTrafficLightSignal.Stop || signal==GermanTrafficLightSignal.PrepareToGo){
            this.signal="ON";
        }else {
            this.signal="OFF";
        }
    }

    /**
     * Next function made to update the traffic light
     * The sideArrow is On while the main traffic light is in Stop or PrepareToGo and Off in other signals
     * @return
     */
    @Override
    public Signal next() {
        this.originalTrafficLightSignal = originalTrafficLightSignal.next();
        if(originalTrafficLightSignal ==GermanTrafficLightSignal.Stop
                || originalTrafficLightSignal ==GermanTrafficLightSignal.PrepareToGo){
            this.signal="ON";
        }else {
            this.signal="OFF";
        }
        return this;
    }

    /**
     * Displays the traffic light with the additional signal
     * @return
     */
    @Override
    public String toString(){
        return originalTrafficLightSignal.toString()+" Sidearrow is "+signal;
    }
}
