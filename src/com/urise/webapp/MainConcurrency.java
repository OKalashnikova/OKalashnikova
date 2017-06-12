package com.urise.webapp;

import com.urise.webapp.util.LazySingleton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OK on 24.05.2017.
 */
public class MainConcurrency {
    public static final int THREAD_NUMBER = 10000;
    private static int counter;
    private static final Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());

        Thread thread0 = new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + " , " + getState());
                throw new IllegalStateException();
            }
        };
        thread0.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " , " + Thread.currentThread().getState());
            }

            private void inc() {
                synchronized (this) { // esli mi u objecta vizivaem metod, to "this" - eto ssilka na etot object
                    counter++;
                }
            }
        }).start();
        System.out.println(thread0.getState());

        final MainConcurrency mainConcurrency = new MainConcurrency();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREAD_NUMBER; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    mainConcurrency.inc();
                }
            });
            thread.start();
            threads.add(thread);
           // thread.join(); // sozdali potok, ego zapustili, pri pomoschi "join()" zhdem, poka on ispolnitsa ves
        }

        threads.forEach(t -> {
            try {
                t.join(); // sozdali potok, ego zapustili, pri pomoschi "join()" zhdem, poka on ispolnitsa ves
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("counter = " + counter);
        //LazySingleton.getInstance();
    }

    //chtobi zahodil tolko odin potok v metod: synchronized

    private synchronized void inc() {
       // synchronized (this) { // esli mi u objecta vizivaem metod, to "this" - eto ssilka na etot object
            //synchronized (MainConcurrency.class)
            counter++;
 //       }
    }
}