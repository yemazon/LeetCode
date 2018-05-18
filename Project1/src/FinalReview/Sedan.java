package FinalReview;

public interface Sedan extends Car {

    Integer DEFAULT_NUMBER_OF_DOORS = 2;

    @Override
    default Integer getNumberOfDoors() {
        return DEFAULT_NUMBER_OF_DOORS;
    }
}
