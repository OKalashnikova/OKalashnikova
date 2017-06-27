package com.urise.webapp;

import com.urise.webapp.util.LazySingleton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by OK on 24.05.2017.
 */
public class MainConcurrency {
    public static final int THREAD_NUMBER = 10000;
    private static int counter;
    private final AtomicInteger atomicCounter = new AtomicInteger();

//    private static final Object LOCK = new Object();
//    private static final Lock lock = new ReentrantLock();
    private static final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private static final Lock WRITE_LOCK = reentrantReadWriteLock.writeLock();
    private static final Lock READ_LOCK = reentrantReadWriteLock.readLock();

    private static final ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat();
        }
    };

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

//        System.out.println(thread0.isDaemon());

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
        CountDownLatch latch = new CountDownLatch(THREAD_NUMBER);
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//        CompletionService completionService = new ExecutorCompletionService(executorService);


//         List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREAD_NUMBER; i++) {
            Future<Integer> future = executorService.submit(() -> {
//          Thread thread = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    mainConcurrency.inc();
                    System.out.println(threadLocal.get().format(new Date()));
                }
                latch.countDown();
                return 5;
            });
//            System.out.println(future.isDone());

//            thread.start();
//            threads.add(thread);
        }

//        threads.forEach(t -> {
//            try {
//                t.join(); // sozdali potok, ego zapustili, pri pomoschi "join()" zhdem, poka on ispolnitsa ves
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
        latch.await(10, TimeUnit.SECONDS);
        executorService.shutdown();
//        System.out.println("counter = " + counter);
        System.out.println(mainConcurrency.atomicCounter.get());
        //LazySingleton.getInstance();


 /*       final String lock1 = "lock1";
        final String lock2 = "lock2";
        deadLock(lock1, lock2);
        deadLock(lock2, lock1);
    }

    private static void deadLock(Object lock1, Object lock2){
        new Thread(() ->{
            System.out.println("Waiting " +lock1);
            synchronized (lock1){
                System.out.println("Holding " + lock1);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Waiting " +lock2);
                synchronized (lock2){
                    System.out.println("Holding " + lock2);
                }
            }
        }).start();    */
    }


    //chtobi zahodil tolko odin potok v metod: synchronized

    private void inc() {
       // synchronized (this) { // esli mi u objecta vizivaem metod, to "this" - eto ssilka na etot object
            //synchronized (MainConcurrency.class)
//            WRITE_LOCK.lock();
//            try {
            atomicCounter.incrementAndGet();
//                counter++;
//            } finally {
//                WRITE_LOCK.unlock();
//            }
 //       }
    }
}