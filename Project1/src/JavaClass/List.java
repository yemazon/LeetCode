package JavaClass;

public interface List<T> extends java.util.List<T> {

    static <T> void swap(List<T> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

    default void shuffle() {
        throw new UnsupportedOperationException();
    }
}
