package javaclassTest;

public class GiftGiver {

    public static void main(String[] args) {
        /*
        Echo<Number> numberEcho = new Echo<Number>();

        System.out.println(numberEcho.echo(10));
        System.out.println(numberEcho.echo(12d));
        System.out.println(numberEcho.echo(12L));


        //will not compile in Java5
        System.out.println(numberEcho.echo(new Echo<>()));

        BoundedEcho<Number> numberBoundedEcho = new BoundedEcho<>();

        System.out.println(numberBoundedEcho.echo(10));

        //System.out.println(numberBoundedEcho.echo(new BoundedEcho<Integer>()));
        */

        Gift<String> giftToU = new Gift<>("abc",12.3);

        GiftPrinter giftPrinter = new GiftPrinter();
        giftPrinter.print(giftToU);

    }
}
