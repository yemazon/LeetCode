package JavaExceptionClass;

public enum GasType {
    Regular, Diesel, E85;

    public void print(GasType type) {
        switch (type) {
            case Regular:
                //to do
                break;
            case Diesel:

                break;
            default:
                throw new AssertionError();
        }
    }
}
