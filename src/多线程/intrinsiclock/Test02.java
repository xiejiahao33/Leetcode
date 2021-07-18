package 多线程.intrinsiclock;

public class Test02 {


    public static void main(String[] args) {
        //先创建 Test01 对象,通过对象名调用 mm()方法
        Test02 obj = new Test02();
        //一个线程调用 m1()方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.m1(); //使用的锁对象是 Test02.class
            }
            }).start();
            //另一个线程调用 sm2()方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                Test02.sm2(); //使用的锁对象是 Test02.class
            }
        }).start();
    }


    //定义方法,打印 100 行字符串
    public void m1(){
            //使用当前类的运行时类对象作为锁对象,可以简单的理解为把 Test02 类的字节码文件作为锁对象
        synchronized (Test02.class) {
            for (int i = 1; i <= 100; i++) {
                System.out.println(Thread.currentThread().getName() + " --> " + i);
                if ( i == 50){
                    Integer.parseInt("abc"); //把字符串转换为int 类型时,如果字符串不符合 数字格式会产生异常
                }
            }
        }
    }

    //使用 synchronized 修饰静态方法,同步静态方法, 默认运行时类Test06.class 作为锁对象
    public synchronized static void sm2(){
        for (int i = 1; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + " --> " + i);
        }
    }
}
