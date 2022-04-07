public class CoordinateService {

    public Coordinates coordinateByCity(DistanceCalculator.City city) {
        switch (city) {
            case PARIS:
                return new Coordinates(48.884400, 2.313828);
            case LYON:
                return new Coordinates(45.751118, 4.851609);
            default:
                throw new IllegalStateException("invalid city");
        }
    }

}
