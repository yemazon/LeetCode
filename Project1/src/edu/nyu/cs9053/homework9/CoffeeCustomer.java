package edu.nyu.cs9053.homework9;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class CoffeeCustomer implements Customer {

    private final static Random RANDOM = new Random();
    private final Semaphore semaphore;

    public CoffeeCustomer(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public OrderNumber order(Queue queue) {

        if (queue == null) {
            throw new IllegalArgumentException("the queue should not be null");
        }

        try {
            semaphore.acquire();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        try {
            if (queue.full()) {
                return null;
            }
            return queue.addOrder(getFavoriteDrink());
        } finally {
            semaphore.release();
        }
    }

    private CoffeeDrink getFavoriteDrink() {
        int randomNum = RANDOM.nextInt(3);
        if (randomNum == 0) {
            return new MermaidFrappuccino();
        } else if (randomNum == 1) {
            return new IcedTea();
        } else {
            return new ColdBrew();
        }
    }
}
