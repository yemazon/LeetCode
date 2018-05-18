package edu.nyu.cs9053.homework10;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * User: blangel
 */
/*
public class MiddleAgesFortification implements Fortification<Thread>, ConcurrencyFactorProvider {

    private int concurrencyFactor;

    public MiddleAgesFortification(int concurrencyFactor) {
        this.concurrencyFactor = concurrencyFactor;
    }

    @Override public void handleAttack(AttackHandler attackHandler) {

        for (int i = 0; i < concurrencyFactor; i++) {
            Thread thread = new Thread();
            thread.start();
            attackHandler.soldiersReady();
        }
    }

    @Override public void surrender() {
        Thread.interrupted();
    }

    @Override public int getConcurrencyFactor() {
        return concurrencyFactor;
    }
}
*/

public class MiddleAgesFortification implements Fortification<Thread>, ConcurrencyFactorProvider {

    private final List<Thread> threads;

    private final BlockingQueue<Runnable> work;

    private int concurrencyFactor;

    private final AtomicBoolean started;

    @Override
    public int getConcurrencyFactor() {
        return concurrencyFactor;
    }

    public MiddleAgesFortification(int concurrencyFactor) {

        this.threads = new ArrayList<>(concurrencyFactor);
        createThreads();
        this.work = new LinkedBlockingQueue<Runnable>(concurrencyFactor);
        startThreads();
    }



    private void startThreads() {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    private void createThreads() {
        for (int i = 0; i < concurrencyFactor; i++) {
            threads.add(createThread());
        }
    }

    private Thread createThread() {
        return
    }


    private Runnable createThreadRunnable() {
        return new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    Runnable todo;
                    try {
                        todo = work.poll(100L, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException ie) {
                        //不能continue，因为当前thread已经interru了
                        Thread.currentThread().interrupt();
                        continue;
                    }

                    try {
                        if (todo != null) {
                            todo.run();
                        }
                    } catch (RuntimeException re) {
                        //Log
                        System.out.println(re.getMessage());
                        //continue;
                    }
                }
            }
        };
    }

    @Override
    public void handleAttack(final AttackHandler handler) { //Java8 后不需要final
        if (handler == null) {
            throw new IllegalArgumentException();
        }

        if (!started.getAndSet(true)) {
            startThreads();
        }

        try {
            work.put(new Runnable() {
                @Override
                public void run() {
                    handler.soldiersReady();
                }
            });
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(ie);
        }

    }

    @Override
    public void surrender() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }
}