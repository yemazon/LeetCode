//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package testMine;

import java.io.PrintStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.reflect.Method;

public class SafetyDepositBox {
    private final long toolsCombination;
    private final long cashCombination;

    public SafetyDepositBox(long password) {
        this.toolsCombination = CRC32s.crc32(String.valueOf(password));
        this.cashCombination = CRC32s.crc32(String.valueOf(password + (long)Long.valueOf(password).hashCode()));
    }

    public boolean canGetTools(Mine mine) {
        return this.unlock(mine, "getTools", this.toolsCombination, new Class[0]);
    }

    public boolean canCashIn(Mine mine, int gems) {
        if(gems < 1) {
            throw new IllegalArgumentException();
        } else {
            return this.unlock(mine, "cashIn", this.cashCombination, new Class[]{Integer.TYPE});
        }
    }

    private boolean unlock(Mine mine, String methodName, long combination, Class... parameterTypes) {
        try {
            Method method = mine.getClass().getDeclaredMethod(methodName, parameterTypes);
            if(!method.isAnnotationPresent(Safe.class)) {
                return false;
            } else {
                Safe safe = (Safe)method.getAnnotation(Safe.class);
                long password = safe.password();
                return password == 0L?false:password == combination;
            }
        } catch (Exception var10) {
            throw new AssertionError(var10);
        }
    }

    static {
        final PrintStream existingOut = System.out;
        final PrintStream existingErr = System.err;
        System.setOut(new MinePrintStream(existingOut));
        System.setErr(new MinePrintStream(existingErr));
        Thread.currentThread().setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            public void uncaughtException(Thread t, Throwable e) {
                System.setOut(existingOut);
                System.setErr(existingErr);
                e.printStackTrace();
            }
        });
    }
}
