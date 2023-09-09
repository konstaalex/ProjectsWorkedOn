package trafficinternational;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import trafficinternational.api.TrafficLight;

public class DutchTrafficLightSignalTest {

    LightFactory fac = new LightFactory();

    @Test
    void dutchTrafficLightTest(){
        TrafficLight dutchTrafficLight=fac.getDutchTrafficLight();

        SoftAssertions.assertSoftly(softly->{

           System.out.println(  dutchTrafficLight.toString());

            softly.assertThat(dutchTrafficLight.toString())
                    .isEqualTo("Traffic Light 1:  Red");
            dutchTrafficLight.update();
            softly.assertThat(dutchTrafficLight.toString())
                    .isEqualTo("Traffic Light 1:  Green");
            dutchTrafficLight.update();
            softly.assertThat(dutchTrafficLight.toString())
                    .isEqualTo("Traffic Light 1:  Yellow");
            dutchTrafficLight.update();
            softly.assertThat(dutchTrafficLight.toString())
                    .isEqualTo("Traffic Light 1:  Red");
        });

    }
}
