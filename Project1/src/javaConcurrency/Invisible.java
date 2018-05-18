package javaConcurrency;

public class Invisible {

    private static boolean ready;

    private static int number;

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!ready) {
                    Thread.yield();
                }
                System.out.println(number);
            }
        });

        thread.start();
        number = 1000;
        ready = true;
    }
}
