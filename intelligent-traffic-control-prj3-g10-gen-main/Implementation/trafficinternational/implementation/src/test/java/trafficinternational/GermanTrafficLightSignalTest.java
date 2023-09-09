package trafficinternational;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import trafficinternational.api.TrafficLight;

public class GermanTrafficLightSignalTest {
    LightFactory germanTrafficLightFactory = new LightFactory();
    TrafficLight germanTrafficLight = germanTrafficLightFactory.getGermanTrafficLight();


    @Test
    void germanTrafficLightTest() {
        SoftAssertions.assertSoftly(softly -> {
            System.out.println(germanTrafficLight.toString());
            softly.assertThat(germanTrafficLight.toString()).isEqualTo("Traffic light 1: Red");
            germanTrafficLight.update();
            softly.assertThat(germanTrafficLight.toString()).isEqualTo("Traffic light 1: Red-yellow");
            germanTrafficLight.update();
            softly.assertThat(germanTrafficLight.toString()).isEqualTo("Traffic light 1: Green");
            germanTrafficLight.update();
            softly.assertThat(germanTrafficLight.toString()).isEqualTo("Traffic light 1: Yellow");
            germanTrafficLight.update();
            softly.assertThat(germanTrafficLight.toString()).isEqualTo("Traffic light 1: Red");
        });
    }

}