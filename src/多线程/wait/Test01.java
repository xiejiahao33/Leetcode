package 多线程.wait;


/**
 * 任何对象都可以调用wait()/notify()，但是需要放在同步代码块里面
 */
public class Test01 {
    public static void main(String[] args) {
        try{
            String text = "text";
            String anther = "hello";
            System.out.println("同步前的代码");
            synchronized (text){
                System.out.println("同步代码块开始");
               // text.wait(); //调用wait()方法后，当球线程就会等待，释放锁对象，当前线程需要被唤醒，如果没有唤醒就会一直等待
               anther.wait(); //不是锁对象调用就会产生java.lang.IllegalMonitorStateException
                System.out.println("wait后面的代码......");
            }
            System.out.println("同步代码块后面的代码");
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("main后面的其他代码");
    }
}
