package 多线程.intrinsiclock;

public class Test05 {

    public static void main(String[] args) {
        //创建2个线程，分别调用mm()方法
        //创建Test01对象，通过对象调用mm()方法
        Test05 obj = new Test05();

        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.mm(); //使用的锁对象this就是obj对象
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.mm2(); //使用的锁对象this也是obj对象
            }
        }).start();
    }

    public void mm(){
        synchronized (this){   //经常使用this当前对象作为锁对象
            for (int i = 1; i <=100 ; i++) {
                System.out.println(Thread.currentThread().getName()+"-->"+i);
            }
        }
    }


    //使用 synchronized修饰实例方法,同步实例方法,默认this作为锁对象
    public synchronized void mm2(){
        for (int i = 1; i <=100 ; i++) {
            System.out.println(Thread.currentThread().getName()+"-->"+i);
        }
    }
}
