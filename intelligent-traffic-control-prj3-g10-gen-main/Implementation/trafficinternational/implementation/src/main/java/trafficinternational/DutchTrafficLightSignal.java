package trafficinternational;

import trafficinternational.api.Signal;

/**
 *  The signals of the DutchTrafficLightSignal cycle in the following way:
 *  -normal mode: Stop->Go->PrepareToStop->Stop
 */

public enum DutchTrafficLightSignal implements Signal {

    Go{
        @Override
        public Signal next() {

            return DutchTrafficLightSignal.PrepareToStop;
        }

        @Override
        public String toString() {

            return "Green";
        }
    },

    PrepareToStop{

        @Override
        public Signal next() {

            return DutchTrafficLightSignal.Stop;
        }

        @Override
        public String toString() {

            return "Yellow";
        }

    },

    Stop{

        @Override
        public Signal next() {

            return DutchTrafficLightSignal.Go;
        }

        @Override
        public String toString() {

            return "Red";
        }
    }
}
