import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.Math.*;

public class Main {

    public static void main(String[] args) {

    }

    public BigDecimal calculateDistance(double lat1, double lon1, double lat2, double lon2, DistanceUnit distanceUnit) {
        // distance between latitudes
        // and longitudes
        double dLat = (lat2 - lat1) * Math.PI / 180.0;
        double dLon = (lon2 - lon1) * Math.PI / 180.0;

        // convert to radians
        lat1 = (lat1) * Math.PI / 180.0;
        lat2 = (lat2) * Math.PI / 180.0;

        // apply formulae
        double a = pow(Math.sin(dLat / 2), 2) + pow(Math.sin(dLon / 2), 2) * cos(lat1) * cos(lat2);

        double rad = 6371000;

        double c = 2 * asin(sqrt(a));

        switch(distanceUnit){
            case KM:
                return BigDecimal.valueOf(rad * c / 1000).setScale(1, RoundingMode.HALF_UP);
            case M:
                return BigDecimal.valueOf(rad * c).setScale(1, RoundingMode.HALF_UP);
            default:
                throw new IllegalStateException("invalid unit");
        }
    }

    public BigDecimal calculateDistance(City paris, City lyon, DistanceUnit distanceUnit) {
        return null;
    }

    public enum DistanceUnit {
        KM,
        M
    }

    public enum City {
        PARIS,
        LYON
    }

    public class CoordinateService {

        public Double coordinateByCity(City city) {

        }
    }
}
