package edu.nyu.cs9053.homework9;

import java.util.concurrent.Semaphore;

/**
 * User: blangel
 */
public class Factory {

    private final static Semaphore SEMAPHORE;

    static {
        SEMAPHORE = new Semaphore(1);
    }

    public static Customer createCustomer() {
        return new CoffeeCustomer(SEMAPHORE);
    }

    public static Barista createBarista() {
        return new CoffeeProducer(SEMAPHORE);
    }
}
