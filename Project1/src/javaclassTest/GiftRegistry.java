package javaclassTest;

import edu.nyu.cs9053.homework7.ArrayCreator;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class GiftRegistry<T> {

    private final AtomicReference<T[]> values;

    //private final AtomicInteger index;

    private final ArrayCreator<T> arrayCreator;

    public GiftRegistry(ArrayCreator<T> arrayCreator) {
        //this.values = values;
        this.arrayCreator = arrayCreator;
        this.values = new AtomicReference<>(arrayCreator.create(12)); //Default

    }

    public boolean add(T value) {
        //

        //T[] expanded = new T[this.values.get().length * 2];
        return false;
    }

}
