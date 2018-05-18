package FunctionalProgramming;

@FunctionalInterface
public interface Craziness<A, B, C, D, R> {
    R apply(A one, B two, C three, D four);
}

(1,2,3d,4) -> 10f

//java 7
??? = new Craziness<>() {
            @Override public ........apply()
        }
