package trafficinternational;

import trafficinternational.api.Signal;

/**
 *  The signals of the GermanPedestrianLight cycle in the following way:
 *  -normal mode: Stop->Go->Stop
 *  Each Enum can return its light color as a String 
 */

public enum GermanPedestrianLightSignals implements Signal {
    Stop{
        @Override
        public Signal next() {
            return GermanPedestrianLightSignals.Go;
        }
        @Override
        public String toString(){return "Red";}
    },
    Go{
        @Override
        public Signal next() {
            return GermanPedestrianLightSignals.Stop;
        }
        @Override
        public String toString(){return "Green";}
    };
}
