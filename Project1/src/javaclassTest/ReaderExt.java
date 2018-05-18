package javaclassTest;

public class ReaderExt extends DefaultReader implements BookReader {

    public static void main(String[] args) {
        ReaderExt obj = new ReaderExt();

        obj.read(new Book("1"));

        System.out.print("");


    }

}
