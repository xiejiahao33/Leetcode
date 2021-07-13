package 多线程.volatilekw;

import java.util.concurrent.atomic.AtomicInteger;

public class Test03 {

    public static void main(String[] args) throws InterruptedException {
        //main线程中开启10个子线程
        for (int i = 0; i < 100; i++) {
            new MyThread().start();
        }
        Thread.sleep(1000);
        System.out.println(MyThread.count.get());
    }

    static class MyThread extends Thread{

        //使用AtomicInteger对象

        private static AtomicInteger count = new AtomicInteger();

        public static void addCount(){
            for (int i = 0; i <1000 ; i++) {
                count.getAndIncrement();
            }
            System.out.println(Thread.currentThread().getName() + " count=" + count);
        }

        @Override
        public void run() {
            addCount();
        }
    }
}
