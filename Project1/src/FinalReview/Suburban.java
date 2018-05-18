package FinalReview;

public class Suburban implements Suv, Car {

    public static void main(String[] args) {
        Suburban suburban = new Suburban();
        System.out.println(suburban.getNumberOfDoors());
    }

    @Override
    public Integer getNumberOfDoors() {
        return 9;
    }
}
