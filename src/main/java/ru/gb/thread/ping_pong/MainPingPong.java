package ru.gb.thread.ping_pong;

// 1. Реализовать программу, в которой два потока поочередно пишут ping и pong.

public class MainPingPong {
    final Object obj = new Object();

    public static void main(String[] args) {
        MainPingPong mainPingPong = new MainPingPong();
        Thread thread1 = new Thread(()->{
            for (int i = 0; i < 10 ; i++) {
                mainPingPong.ping();
            }
        });
        Thread thread2 = new Thread(()->{
            for (int i = 0; i < 10 ; i++) {
                mainPingPong.pong();
            }
        });

        thread1.start();
        thread2.start();

    }

    public void ping(){
        synchronized (obj){
            System.out.println("ping");
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void pong(){
        synchronized (obj){
            System.out.println("pong");
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
