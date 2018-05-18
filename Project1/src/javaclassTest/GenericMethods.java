package javaclassTest;

public class GenericMethods<T> {
    public <S extends T> T transform(S value) {
        return value;
    }
}
