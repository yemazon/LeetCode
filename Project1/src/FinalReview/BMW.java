package FinalReview;

public class BMW extends AbstractCar implements Vehicle, Car {

    public static void main(String[] args) {
        BMW bmw = new BMW("testCar");

        System.out.println(bmw.getNumberOfWheels());
    }

    private final String name;

    public BMW(String name) {
        this.name = name;
    }
}
