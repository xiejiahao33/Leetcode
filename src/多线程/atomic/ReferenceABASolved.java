package 多线程.atomic;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * AtomicStampedReference 原子类可以解决 CAS 中的 ABA 问题
 * 在 AtomicStampedReference 原子类中有一个整数标记值 stamp, 每次执行 CAS 操作时,需
 要对比它的版本,即比较 stamp 的值
 */
public class ReferenceABASolved {
    //定义 AtomicStampedReference 引用操作"abc"字符串,指定初始化版本号为 0
    private static AtomicStampedReference<String> stampedReference =
            new AtomicStampedReference<>("abc", 0);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                stampedReference.compareAndSet("abc", "def",
                        stampedReference.getStamp(), stampedReference.getStamp()+1);
                System.out.println(Thread.currentThread().getName() + "--"
                        +stampedReference.getReference());
                stampedReference.compareAndSet("def", "abc",
                        stampedReference.getStamp(), stampedReference.getStamp()+1);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int stamp = stampedReference.getStamp(); //获得版本号
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println( stampedReference.compareAndSet("abc", "ggg", stamp,
                        stamp+1));
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println( stampedReference.getReference() );
    }
}
