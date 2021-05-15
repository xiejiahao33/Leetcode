package 多线程.threadmethod;

public class Test01CurrentThread {
    public static void main(String[] args) {
        System.out.println("main 方 法 中 打 印 当 前 线 程 :" +
                Thread.currentThread().getName());

        //创建子线程, 调用SubThread1()构造方法, 在main线程中调用构造方法,所以构造
        //方法中 的当前线程就是 main 线程
        SubThread1 t1 =new SubThread1();
        t1.start();
        //t1.run(); //在 main 方法中直接调用 run()方法,没有开启新的线程,所以在 run方法中的当前线程就是 main 线程
    }
}
