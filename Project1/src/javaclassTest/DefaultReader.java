package javaclassTest;

public class DefaultReader implements BookReader {

    @Override public void read(String text) {
        System.out.println("text");
    }


    public void read(Book book) {
        System.out.print("fk u");
    }

}
