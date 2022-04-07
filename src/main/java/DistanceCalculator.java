import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.Math.*;

public class DistanceCalculator {

    private static final double EARTH_RADIUS = 6371000;

    private final CoordinateService coordinateService;

    public DistanceCalculator(CoordinateService coordinateService) {
        this.coordinateService = coordinateService;
    }

    public enum DistanceUnit {
        KM,
        M
    }

    public enum City {
        PARIS,
        LYON
    }

    public BigDecimal calculateDistance(Coordinates coordinates1, Coordinates coordinates2, DistanceUnit distanceUnit) {
        var distanceToMeter = haversineDistanceToMeter(coordinates1, coordinates2);

        switch(distanceUnit){
            case KM:
                return BigDecimal.valueOf(distanceToMeter / 1000).setScale(1, RoundingMode.HALF_UP);
            case M:
                return BigDecimal.valueOf(distanceToMeter).setScale(1, RoundingMode.HALF_UP);
            default:
                throw new IllegalStateException("invalid unit");
        }
    }

    public BigDecimal calculateDistance(City paris, City lyon, DistanceUnit distanceUnit) {
        var coordinates1 = coordinateService.coordinateByCity(paris);
        var coordinates2 = coordinateService.coordinateByCity(lyon);

        return calculateDistance(coordinates1, coordinates2, distanceUnit);
    }

    private double haversineDistanceToMeter(Coordinates coordinates1, Coordinates coordinates2) {
        double dLat = toRadians(coordinates2.lat - coordinates1.lat);
        double dLon = toRadians(coordinates2.lon - coordinates1.lon);

        double a = pow(Math.sin(dLat / 2), 2) + pow(Math.sin(dLon / 2), 2) * cos(toRadians(coordinates1.lat)) * cos(toRadians(coordinates2.lat));

        return EARTH_RADIUS * 2 * asin(sqrt(a));
    }

}
