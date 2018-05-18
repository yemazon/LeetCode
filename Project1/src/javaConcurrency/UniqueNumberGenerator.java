package javaConcurrency;

import java.util.concurrent.Semaphore;

public class UniqueNumberGenerator {

    private long sequence;

    private Semaphore binarySemaphore;

    public UniqueNumberGenerator(Semaphore binarySemaphore) {
        this.binarySemaphore = binarySemaphore;
        this.sequence = 0L;
    }

    public long next() {
//        long returnValue = sequence;
//        sequence += 1L;
//
//        return returnValue;


        // race condition

        //return sequence++;

        //

        try {
            binarySemaphore.acquire();
            return sequence++;
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(ie);
        } finally {
            binarySemaphore.release();
        }
    }
}
