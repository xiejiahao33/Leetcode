package 多线程.intrinsiclock;

public class Test02 {

    public static void main(String[] args) {
        //创建2个线程，分别调用mm()方法
        //创建Test01对象，通过对象调用mm()方法
        Test02 obj = new Test02();
        Test02 obj2 = new Test02();

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

    public void mm(){
        synchronized (this){   //经常使用this当前对象作为锁对象
            for (int i = 1; i <=100 ; i++) {
                System.out.println(Thread.currentThread().getName()+"-->"+i);
            }
        }
    }

}
