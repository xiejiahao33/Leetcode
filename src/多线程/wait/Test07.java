package 多线程.wait;

/**
 * wait(long)
 */

public class Test07 {
    public static void main(String[] args) {
        final Object obj = new Object();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized ( obj ){
                    try {
                        System.out.println("thread begin wait");
                        obj.wait(5000); //如果5000毫秒内没有被唤醒 ,会自动唤醒
                        System.out.println("end wait....");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
    }
}