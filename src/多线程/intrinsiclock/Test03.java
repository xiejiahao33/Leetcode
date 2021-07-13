package 多线程.intrinsiclock;

public class Test03 {

    public static void main(String[] args) {
        //创建2个线程，分别调用mm()方法
        //创建Test01对象，通过对象调用mm()方法
        Test03 obj = new Test03();
        Test03 obj2 = new Test03();

        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.mm(); //使用的锁对象this就是obj对象
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                obj2.mm(); //使用的锁对象this也是obj对象
            }
        }).start();
    }


    public static final Object OBJ = new Object();//常量
    public void mm(){
        synchronized (OBJ){   //经常使用this当前对象作为锁对象
            for (int i = 1; i <=100 ; i++) {
                System.out.println(Thread.currentThread().getName()+"-->"+i);
            }
        }
    }
}
