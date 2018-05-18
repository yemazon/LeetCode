package edu.nyu.cs9053.homework7;

import java.util.concurrent.atomic.AtomicReference;

public class Wallet<T> implements ArrayCreator {

    private final AtomicReference<T[]> atomicReference;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public Wallet() {
        atomicReference = new AtomicReference<>((T[]) new Object[DEFAULT_INITIAL_CAPACITY]);
    }

    public Wallet(T[] array) {
        atomicReference = new AtomicReference<>(array);
    }

    @SuppressWarnings("unchecked")
    @Override public T[] create(int size) {
        return (T[]) new Object[size];
    }

    @SuppressWarnings("unchecked")
    public boolean add(T value) {
        if (contains(value)) {
            return false;
        }
        if (length() == size()) {
            T[] newArray = (T[]) new Object[size() * 2];
            System.arraycopy(atomicReference.get(), 0, newArray, 0, size());
            newArray[size()] = value;
            atomicReference.set(newArray);
        } else {
            for (int i = 0; i < length(); i++) {
                if (atomicReference.get()[i] == null) {
                    T[] array = atomicReference.get();
                    array[i] = value;
                    atomicReference.set(array);
                }
            }
        }
        return true;
    }

    public boolean contains(T value) {
        for (T element : atomicReference.get()) {
            if (element == null) {
                continue;
            }
            if (element.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public boolean remove(T value) {
        for (int i = 0; i < length(); i++) {
            if (atomicReference.get()[i].equals(value)) {
                T[] array = atomicReference.get();
                array[i] = null;
                atomicReference.set(array);
                return true;
            }
        }
        return false;
    }

    public T get(int index) {
        if (atomicReference.get()[index] == null) {
            return null;
        } else {
            return atomicReference.get()[index];
        }
    }

    public int size() {
        int count = 0;
        for (T element : atomicReference.get()) {
            if (element != null) {
                count ++;
            }
        }
        return count;
    }

    public int length() {
        return atomicReference.get().length;
    }
}
