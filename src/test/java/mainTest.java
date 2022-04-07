import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class mainTest {

    private final Main main = new Main();

    @Test
    public void should_calculate_distance_between_two_points() {
//        Given
//        Paris
        double lat1 = 48.884400;
        double lon1 = 2.313828;

//        Lyon
        double lat2 = 45.751118;
        double lon2 = 4.851609;

        var distanceUnit = Main.DistanceUnit.KM;

        // When
        var distance = main.calculateDistance(lat1, lon1, lat2, lon2, distanceUnit);

        // Then
        assertThat(distance).isEqualTo(new BigDecimal("397.4"));
    }

    @Test
    public void should_calculate_distance_between_two_cities() {
//        Given
        var distanceUnit = Main.DistanceUnit.KM;

        // When
        var distance = main.calculateDistance(Main.City.PARIS, Main.City.LYON, distanceUnit);

        // Then
        assertThat(distance).isEqualTo(new BigDecimal("397.4"));
    }


}
