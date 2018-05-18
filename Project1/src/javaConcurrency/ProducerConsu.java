/*
package javaConcurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;


//一种是synchro的，一种是lock的
public class ProducerConsu {

    private final Lock lock;

    private final Condition oneCondition;

    private final Object instinsicLock = new Object();

    private final Object[] buffer;

    public synchronized void add(Object data) {
        //instinsicLock.lock();

        if (lock.tryLock()) {

        }

        if (lock.tryLock(TimeUnit.SECONDS, 1L)) {

        }


        lock.lock();

        try {
            while (one condition) {
                oneCondition.await();
            }
            //TODO - add
            //notifyAll();
            oneCondition.signalAll();

        } finally {
            instinsicLock.unlock();
        }
    }

    public synchronized Object remove() {
        notifyAll();
    }

}
*/