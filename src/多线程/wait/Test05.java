package 多线程.wait;

public class Test05 {

    public static void main(String[] args) throws InterruptedException {
            SubThread t = new SubThread();
            t.start();
            Thread.sleep(2000); //主线程睡眠 2 秒, 确保子线程处于 Wait 等待状态
            t.interrupt();

    }
    private static final Object LOCK = new Object(); //定义常量作为锁对象
    static class SubThread extends Thread{
        @Override
        public void run() {
            synchronized (LOCK){

                try {
                    System.out.println("begin wait...");
                    LOCK.wait();
                    System.out.println("end wait..");
                } catch (InterruptedException e) {
                    System.out.println("wait 等待被中断了****");
                }
            }
        }
    }
}
