package JavaExceptionClass;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionExample {
    public static void main(String[] args) {
        try {
            ExceptionExample exceptionExample = new ExceptionExample(null);
            exceptionExample.print(null);
            System.out.printf("Howdy!%n");
        } catch (IllegalArgumentException e) {
            System.out.printf("Whooooooo%n");
        } catch (IOException e) {
            System.out.printf("IOException");
        }
        System.out.printf("Hello!%n");
    }

    public ExceptionExample(String value) throws IOException {
        if (value == null) {
            throw new IllegalArgumentException();
        }
        System.out.printf("Hello from constructor");
    }

    public void print(String value) throws FileNotFoundException{
        if (value == null) {
            throw new FileNotFoundException();
        }
    }
}
