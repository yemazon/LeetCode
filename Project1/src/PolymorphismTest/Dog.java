package PolymorphismTest;

/**
 * Created by Sure on 2017/9/27.
 */
public class Dog extends Animal {

    @Override
    public String makeNoise() {
        return "Woof";
    }

    public String shit() {
        return "holy";
    }
}
