package FinalReview;

public interface Suv {

    Integer DEFAULT_NUMBER_OF_DOORS = 4;

    default Integer getNumberOfDoors() {
        return DEFAULT_NUMBER_OF_DOORS;
    }

}
