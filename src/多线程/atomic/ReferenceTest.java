package 多线程.atomic;

import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class ReferenceTest {


    static AtomicReference<String> atomicReference  = new AtomicReference<>("abc");


    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(new Random().nextInt(20));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    if(atomicReference.compareAndSet("abc","def")){
                        System.out.println(Thread.currentThread().getName()+ "change abc to def");
                    }
                }
            }).start();
        }


        for (int i = 0; i <100 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(new Random().nextInt(20));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(atomicReference.compareAndSet("def","abc")){
                        System.out.println(Thread.currentThread().getName()+ "change def to abc");
                    }
                }
            }).start();
        }
    }
}
