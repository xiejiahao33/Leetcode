package 多线程.intrinsiclock;

public class Test06 {

    public static void main(String[] args) {
        //创建2个线程，分别调用mm()方法
        //创建Test01对象，通过对象调用mm()方法
        Test06 obj = new Test06();

        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.mm(); //使用的锁对象Test06.class
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Test06.mm2(); //使用的锁对象Test06.class
            }
        }).start();
    }

    public void mm(){
        ///使用当前类的运行时类对象作为锁对象,可以简单的理解为把Test06类的字节码文件作为锁对象
        synchronized (Test06.class){
            for (int i = 1; i <=100 ; i++) {
                System.out.println(Thread.currentThread().getName()+"-->"+i);
            }
        }
    }


    //使用 synchronized修饰静态方法,同步静态实例方法,默认当前运行类Test06.class作为锁对象
    public synchronized static void mm2(){
        for (int i = 1; i <=100 ; i++) {
            System.out.println(Thread.currentThread().getName()+"-->"+i);
        }
    }
}
