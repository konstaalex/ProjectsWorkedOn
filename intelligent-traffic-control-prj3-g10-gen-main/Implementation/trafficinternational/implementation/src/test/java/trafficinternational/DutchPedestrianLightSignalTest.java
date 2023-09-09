package trafficinternational;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import trafficinternational.api.TrafficLight;

public class DutchPedestrianLightSignalTest {

    LightFactory fac = new LightFactory();

    @Test
    void dutchPedestrianLightTest(){
        TrafficLight dutchPedestrianLight=fac.getDutchPedestrianLight();
        SoftAssertions.assertSoftly(softly->{

            System.out.println(dutchPedestrianLight.toString());

            softly.assertThat(dutchPedestrianLight.toString())
                    .isEqualTo("Pedestrian Light 1:  Red");

            dutchPedestrianLight.update();

            softly.assertThat(dutchPedestrianLight.toString())
                    .isEqualTo("Pedestrian Light 1:  Green");

            dutchPedestrianLight.update();

            softly.assertThat(dutchPedestrianLight.toString())
                    .isEqualTo("Pedestrian Light 1:  Green Blinking");

            dutchPedestrianLight.update();

            softly.assertThat(dutchPedestrianLight.toString())
                    .isEqualTo("Pedestrian Light 1:  Red");
        });

    }
}
