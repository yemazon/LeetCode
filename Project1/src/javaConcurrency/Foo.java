/*
package javaConcurrency;

import edu.nyu.cs9053.homework9.Queue;

import java.util.LinkedList;

public class Foo {

    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<String>();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                //必须这么写
                while (!Thread.currentThread().isInterrupted()) {
                    //System.out.println("hello from " + Thread.currentThread().getName());

                    Runnable work = ((LinkedList) queue).pop();
                    if (work != null) {
                       try {
                           work.run();
                       } catch (RuntimeException re) {
                           System.out.println("daraole");
                       }
                    }
                }
            }
        });


//        race condition
//        thread.start();
//        thread.interrupt();
        thread.start();
    }
}
*/