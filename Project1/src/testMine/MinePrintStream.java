//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package testMine;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.Locale;
import java.util.regex.Pattern;

public class MinePrintStream extends PrintStream {
    private static final Pattern REG_EX = Pattern.compile(".*\\d\\d\\d\\d\\d\\d.*");
    private final PrintStream delegate;

    private static OutputStream getOut(PrintStream delegate) {
        try {
            Field outField = FilterOutputStream.class.getDeclaredField("out");
            outField.setAccessible(true);
            return (OutputStream)outField.get(delegate);
        } catch (Exception var2) {
            throw new AssertionError(var2);
        }
    }

    public MinePrintStream(PrintStream delegate) {
        super(getOut(delegate));
        this.delegate = delegate;
    }

    public void flush() {
        this.delegate.flush();
    }

    public void close() {
        this.delegate.close();
    }

    public boolean checkError() {
        return this.delegate.checkError();
    }

    public void setError() {
    }

    public void clearError() {
    }

    public void write(int b) {
        throw new UnsupportedOperationException();
    }

    public void write(byte[] buf, int off, int len) {
        throw new UnsupportedOperationException();
    }

    public void print(boolean b) {
        throw new UnsupportedOperationException();
    }

    public void print(char c) {
        throw new UnsupportedOperationException();
    }

    public void print(int i) {
        throw new UnsupportedOperationException();
    }

    public void print(long l) {
        throw new UnsupportedOperationException();
    }

    public void print(float f) {
        throw new UnsupportedOperationException();
    }

    public void print(double d) {
        throw new UnsupportedOperationException();
    }

    public void print(char[] s) {
        throw new UnsupportedOperationException();
    }

    public void print(String s) {
        throw new UnsupportedOperationException();
    }

    public void print(Object obj) {
        throw new UnsupportedOperationException();
    }

    public void println() {
        throw new UnsupportedOperationException();
    }

    public void println(boolean x) {
        throw new UnsupportedOperationException();
    }

    public void println(char x) {
        throw new UnsupportedOperationException();
    }

    public void println(int x) {
        throw new UnsupportedOperationException();
    }

    public void println(long x) {
        throw new UnsupportedOperationException();
    }

    public void println(float x) {
        this.delegate.println(x);
    }

    public void println(double x) {
        this.delegate.println(x);
    }

    public void println(char[] x) {
        this.delegate.println(x);
    }

    public void println(String x) {
        this.delegate.println(x);
    }

    public void println(Object x) {
        this.delegate.println(x);
    }

    public PrintStream printf(String format, Object... args) {
        if(!REG_EX.matcher(format).find() && !this.isLong(args)) {
            return this.delegate.printf(format, args);
        } else {
            throw new UnsupportedOperationException("Naughty, naughty...");
        }
    }

    public PrintStream printf(Locale l, String format, Object... args) {
        if(!REG_EX.matcher(format).find() && !this.isLong(args)) {
            return this.delegate.printf(l, format, args);
        } else {
            throw new UnsupportedOperationException("Naughty, naughty...");
        }
    }

    public PrintStream format(String format, Object... args) {
        throw new UnsupportedOperationException();
    }

    public PrintStream format(Locale l, String format, Object... args) {
        throw new UnsupportedOperationException();
    }

    public PrintStream append(CharSequence csq) {
        if(REG_EX.matcher(csq.toString()).find()) {
            throw new UnsupportedOperationException();
        } else {
            return this.delegate.append(csq);
        }
    }

    public PrintStream append(CharSequence csq, int start, int end) {
        if(REG_EX.matcher(csq.toString()).find()) {
            throw new UnsupportedOperationException();
        } else {
            return this.delegate.append(csq, start, end);
        }
    }

    public PrintStream append(char c) {
        throw new UnsupportedOperationException();
    }

    public void write(byte[] b) throws IOException {
        throw new UnsupportedOperationException();
    }

    private boolean isLong(Object... args) {
        if(args != null && args.length >= 1) {
            Object[] var2 = args;
            int var3 = args.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                Object arg = var2[var4];
                if(arg instanceof Long) {
                    return true;
                }
            }

            return false;
        } else {
            return false;
        }
    }
}
