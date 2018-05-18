package javaConcurrency;

public class ThreadNew implements Runnable {

    @Override
    public void run() {

        try { // 延时0.5秒
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" Thread New ");
    }
}
