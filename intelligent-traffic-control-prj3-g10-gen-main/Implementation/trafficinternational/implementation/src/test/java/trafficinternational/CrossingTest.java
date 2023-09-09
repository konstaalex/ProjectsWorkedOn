package trafficinternational;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import trafficinternational.api.TrafficLight;

public class CrossingTest {

    @Test
    void crossingTest(){

        LightFactory fac = new LightFactory();
        Crossing cross = new Crossing();

        var dutchPed1 = fac.getDutchPedestrianLight();
        var dutchPed2 = fac.getDutchPedestrianLight();

        cross.addObserver(dutchPed1);
        cross.addObserver(dutchPed2);


        SoftAssertions.assertSoftly(softly->{


            cross.nextSignal(DutchPedestrianLightSignal.PrepareToStop);

            softly.assertThat(dutchPed1.toString())
                    .isEqualTo("Pedestrian Light 1:  Red");

            softly.assertThat(dutchPed2.toString())
                    .isEqualTo("Pedestrian Light 2:  Red");


            cross.nextSignal(DutchPedestrianLightSignal.Stop);

            softly.assertThat(dutchPed1.toString())
                    .isEqualTo("Pedestrian Light 1:  Green");

            softly.assertThat(dutchPed2.toString())
                    .isEqualTo("Pedestrian Light 2:  Green");


            cross.nextSignal(DutchPedestrianLightSignal.Go);

            softly.assertThat(dutchPed1.toString())
                    .isEqualTo("Pedestrian Light 1:  Green Blinking");

            softly.assertThat(dutchPed2.toString())
                    .isEqualTo("Pedestrian Light 2:  Green Blinking");


            cross.nextSignal(DutchPedestrianLightSignal.PrepareToStop);

            softly.assertThat(dutchPed1.toString())
                    .isEqualTo("Pedestrian Light 1:  Red");

            softly.assertThat(dutchPed2.toString())
                    .isEqualTo("Pedestrian Light 2:  Red");

        });

    }
}