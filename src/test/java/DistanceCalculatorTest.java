import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class DistanceCalculatorTest {

    private final CoordinateService coordinateService = new CoordinateService();
    private final DistanceCalculator distanceCalculator = new DistanceCalculator(coordinateService);

    @Test
    public void should_calculate_distance_between_two_points() {
//        Given
        var parisCoordinate = new Coordinates(48.884400, 2.313828);
        var lyonCoordinate = new Coordinates(45.751118, 4.851609);

        var distanceUnit = DistanceCalculator.DistanceUnit.KM;

        // When
        var distance = distanceCalculator.calculateDistance(parisCoordinate, lyonCoordinate, distanceUnit);

        // Then
        assertThat(distance).isEqualTo(new BigDecimal("397.4"));
    }

    @Test
    public void should_calculate_distance_between_two_cities() {
//        Given
        var distanceUnit = DistanceCalculator.DistanceUnit.KM;

        // When
        var distance = distanceCalculator.calculateDistance(DistanceCalculator.City.PARIS, DistanceCalculator.City.LYON, distanceUnit);

        // Then
        assertThat(distance).isEqualTo(new BigDecimal("397.4"));
    }
}
