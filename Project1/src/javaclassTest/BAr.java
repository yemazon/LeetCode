package javaclassTest;

public class BAr<T> extends Gift<T> {

    private T barCost;

    public BAr(T value, Double cost, T barCost) {
        super(value, cost);
        this.barCost = barCost;
    }

}
