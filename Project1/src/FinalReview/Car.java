package FinalReview;

public interface Car {

    Integer DEFAULT_NUMBER_OF_WHEELS = 4;

    Integer DEFAULT_NUMBER_OF_DOORS = 4;

    default Integer getNumberOfWheels() {
        return DEFAULT_NUMBER_OF_WHEELS;
    }

    default Integer getNumberOfDoors() {
        return DEFAULT_NUMBER_OF_DOORS;
    }

    static String getString() {
        return "test";
    }
}
