package edu.nyu.cs9053.homework9;

import java.util.concurrent.Semaphore;

public class CoffeeProducer implements Barista {

    private final Semaphore semaphore;

    public CoffeeProducer(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override public OrderNumber handle(Queue from) {

        if(from == null){
            throw new NullPointerException("the queue should not be null");
        }

        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            if (from.isEmpty()) {
                return null;
            } else {
                return from.getOrderNumber();
            }
        } finally {
            semaphore.release();
        }
    }
}
