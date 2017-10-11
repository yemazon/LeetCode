package PolymorphismTest;

public class TypeCheck {
    public boolean isString(Object value) {
        return (value instanceof String);
    }

    public String corce(Object value) throws ClassCastException{
        return (String) value;
    }
}
