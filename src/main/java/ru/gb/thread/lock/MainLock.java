package ru.gb.thread.lock;

// 2. Реализовать потокобезопасный счетчик с помощью интерфейса Lock.

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainLock {

    int count = 0;

    Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        MainLock mainLock = new MainLock();

       Thread t1 = new Thread(()->{
            for (int i = 0; i < 5 ; i++) {
                mainLock.countInc();
            }
        });


        Thread t2 = new Thread(()->{
            for (int i = 0; i < 5 ; i++) {
                mainLock.countDec();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("count "+ mainLock.count);
    }

    public void countInc(){
        lock.lock();
        System.out.println("Блокировка осуществлена ++");
        count++;
        System.out.println("Блокировка снята ++");
        lock.unlock();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void countDec(){
        lock.lock();
        System.out.println("Блокировка осуществлена --");
        count--;
        System.out.println("Блокировка снята --");
        lock.unlock();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
