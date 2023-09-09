package trafficinternational;

import trafficinternational.api.Signal;

/**
 *  The signals of the DutchPedestrianLight cycle in the following way:
 *  -normal mode: Stop->Go->PrepareToStop->Stop
 */

public enum DutchPedestrianLightSignal implements Signal {

    Go{
        @Override
        public Signal next() {

            return DutchPedestrianLightSignal.PrepareToStop;
        }

        @Override
        public String toString() {

            return "Green";
        }
    },

    PrepareToStop{

        @Override
        public Signal next() {

            return DutchPedestrianLightSignal.Stop;
        }

        @Override
        public String toString() {

            return "Green Blinking";
        }

    },

    Stop{

        @Override
        public Signal next() {

            return DutchPedestrianLightSignal.Go;
        }

        @Override
        public String toString() {

            return "Red";
        }
    }


}
