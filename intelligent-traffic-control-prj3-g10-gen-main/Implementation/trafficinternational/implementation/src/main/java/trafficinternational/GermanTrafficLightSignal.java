package trafficinternational;

import trafficinternational.api.Signal;

/**
 *  The signals of the GermanTrafficLight cycle in the following way:
 *  -normal mode: Stop->PrepareToGo->Go->PrepareToStop->Stop
 */

public enum GermanTrafficLightSignal implements Signal {
    Stop{
        @Override
        public Signal next() {
            return GermanTrafficLightSignal.PrepareToGo;
        }
        public String toString(){return "Red";}
    },
    PrepareToGo{
        @Override
        public Signal next() {
            return GermanTrafficLightSignal.Go;
        }
        public String toString(){return "Red-yellow";}
    },
    Go{
        @Override
        public Signal next() {
            return GermanTrafficLightSignal.PrepareToStop;
        }
        public String toString(){return "Green";}
    },
    PrepareToStop{
        @Override
        public Signal next() {
            return GermanTrafficLightSignal.Stop;
        }
        public String toString(){return "Yellow";}
    }
    ;

    @Override
    public Signal decorateWith(String addition){
        switch (addition){
            case "sideArrow":
                return new TrafficLightWithArrow(this);
            default :
                return this;
        }
    }

}
