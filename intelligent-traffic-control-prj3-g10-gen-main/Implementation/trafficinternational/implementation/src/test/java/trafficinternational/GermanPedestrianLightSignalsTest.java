package trafficinternational;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import trafficinternational.api.TrafficLight;

class GermanPedestrianLightSignalsTest {

    LightFactory factory=new LightFactory();

    /**
     * Tests the correct cycle of a german pedestrian light
     */
    @Test
    void germanPedestrianLightTest(){
        SoftAssertions.assertSoftly(softly->{
            TrafficLight germanPedestrianLight=factory.getGermanPedestrianLight();
            System.out.println(   germanPedestrianLight.toString() );
            softly.assertThat(germanPedestrianLight.toString()).isEqualTo("Pedestrian Light 1:  Red");
            germanPedestrianLight.update();
            softly.assertThat(germanPedestrianLight.toString()).isEqualTo("Pedestrian Light 1:  Green");
            germanPedestrianLight.update();
            softly.assertThat(germanPedestrianLight.toString()).isEqualTo("Pedestrian Light 1:  Red");
        });
    }
}