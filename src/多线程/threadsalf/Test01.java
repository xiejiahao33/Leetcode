package 多线程.threadsalf;

import java.util.concurrent.atomic.AtomicInteger;

public class Test01 {

    public static void main(String[] args) {

        MyInt myInt =new MyInt();

        for (int i = 1; i <=2 ; i++) {
            new Thread((new Runnable() {
                @Override
                public void run() {
                    while (true){
                        System.out.println(Thread.currentThread().getName()+"->"+
                                myInt.getNum());
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            })).start();
        }
    }




    static class  MyInt{

        //java 中提供一个线程安全的AtomicInteget类，保证了操作的原子性
        AtomicInteger num = new AtomicInteger();
        public int getNum(){
            return num.getAndIncrement();
        }

    }
}
