package 多线程.wait;

public class Test02 {

    public static void main(String[] args) throws InterruptedException {

        String lock = "wkcto"; //定义一个字符串作为锁对象
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("线程1开始等待"+System.currentTimeMillis());

                    try {
                        lock.wait();//线程等待
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("线程1结束等待"+System.currentTimeMillis());
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                //notify()方法也需要在同步代码块中,由锁对象调用
                synchronized (lock){
                    System.out.println("线程2开始唤醒："+System.currentTimeMillis());

                    lock.notify(); //唤醒在 lock 锁对象上等待的某一个线程

                    System.out.println("线程 2 结束唤醒 : " + System.currentTimeMillis());
                }
            }
        });

        t1.start(); //开启 t1 线程,t1 线程等待

        Thread.sleep(3000); //main 线程睡眠 3 秒,确保 t1 入睡

        t2.start(); //t1 线程开启 3 秒后,再开启 t2 线程唤醒 t1 线程
    }
}
