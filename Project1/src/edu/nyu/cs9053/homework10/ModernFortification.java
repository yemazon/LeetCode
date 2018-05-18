package edu.nyu.cs9053.homework10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: blangel
 */
public class ModernFortification implements Fortification<ExecutorService>, ConcurrencyFactorProvider {

    private final int concurrencyFactor;

    private final ExecutorService executorService;

    public ModernFortification(int concurrencyFactor) {
        this.concurrencyFactor = concurrencyFactor;
        executorService = Executors.newFixedThreadPool(concurrencyFactor);
    }

    @Override
    public void handleAttack(AttackHandler attackHandler) {

        for (int i = 0; i < concurrencyFactor; i++) {
            executorService.submit(() -> attackHandler.soldiersReady());
        }
    }

    @Override
    public void surrender() {
        executorService.shutdownNow();
    }

    @Override
    public int getConcurrencyFactor() {
        return concurrencyFactor;
    }
}
