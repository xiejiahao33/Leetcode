package 多线程.threadmethod;

public class SubThread1 extends Thread {

    public SubThread1(){
        System.out.println("构造方法打印当前线程的名称："+Thread.currentThread().getName());
    }


    @Override
    public void run() {
        System.out.println("run 方法打印当前线程的名称：" + Thread.currentThread().getName());
    }
}
