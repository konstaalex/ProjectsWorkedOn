package trafficinternational;

import org.junit.jupiter.api.Test;
import trafficinternational.api.TrafficLight;
import org.assertj.core.api.SoftAssertions;


public class TrafficLightWithArrowTest {

    LightFactory factory=new LightFactory();

    @Test
    public void test(){
        TrafficLight germanTrafficLight=factory.getGermanTrafficLight();
        germanTrafficLight.decorateTrafficLight("sideArrow");
        SoftAssertions.assertSoftly(softly -> {
            System.out.println(germanTrafficLight.toString());
            softly.assertThat(germanTrafficLight.toString()).isEqualTo("Traffic light 1: Red Sidearrow is ON");
            germanTrafficLight.update();
            softly.assertThat(germanTrafficLight.toString()).isEqualTo("Traffic light 1: Red-yellow Sidearrow is ON");
            germanTrafficLight.update();
            softly.assertThat(germanTrafficLight.toString()).isEqualTo("Traffic light 1: Green Sidearrow is OFF");
            germanTrafficLight.update();
            softly.assertThat(germanTrafficLight.toString()).isEqualTo("Traffic light 1: Yellow Sidearrow is OFF");
            germanTrafficLight.update();
            softly.assertThat(germanTrafficLight.toString()).isEqualTo("Traffic light 1: Red Sidearrow is ON");
        });
    }
}
