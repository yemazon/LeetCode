package FunctionalProgramming;

import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;

public class Test {

    public static void main(String[] args) {

        //Function<?, ?> function = (String value) -> System.out.println(value);

        DoubleBinaryOperator biFunction = Math::min;

        System.out.println(biFunction.applyAsDouble(2,3));


    }

    private void foo() {
        Integer foo;

        Function<Integer, Integer> function = Integer::toString;

        foo.toString(); // Object class's toString()
        foo.toString(5); //Integer class's toString(Integer arg);

    }
}
