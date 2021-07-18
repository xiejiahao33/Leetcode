package 多线程.intrinsiclock;

public class Test03 {
    public static void main(String[] args) {
        SubThread t1 = new SubThread();
        t1.setName("a");
        t1.start();
        SubThread t2 = new SubThread();
        t2.setName("b");
        t2.start();
    }

    static class SubThread extends Thread{
        private static final Object lock1 = new Object();
        private static final Object lock2 = new Object();
        @Override
        public void run() {
            if ("a".equals(Thread.currentThread().getName())){
                synchronized (lock1){
                    System.out.println("a线程获得了lock1 锁,还需 要获得 lock2 锁");
                    synchronized (lock2){
                        System.out.println("a 线程获得 lock1 后又 获得了 lock2,可以想干任何想干的事");
                    }
                }
            }
            if ("b".equals(Thread.currentThread().getName())){
                synchronized (lock2){
                    System.out.println("b线程获得了lock2锁,还需 要获得 lock1 锁");
                    synchronized (lock1){
                        System.out.println("b 线程获得lock2后又 获得了 lock1,可以想干任何想干的事");
                    }
                }
            }
        }
    }
}

