package 多线程.volatilekw;

public class Test02 {

    public static void main(String[] args) throws InterruptedException {
        //main线程中开启10个子线程
        for (int i = 0; i < 100; i++) {
            new MyThread().start();
        }

        Thread.sleep(1000);
        System.out.println(MyThread.count);
    }

    static class MyThread extends Thread{
        volatile  public static  int count;
        public static void addCount(){
            for (int i = 0; i <1000 ; i++) {
                count++;
            }
            System.out.println(Thread.currentThread().getName() + " count=" + count);
        }

        @Override
        public void run() {
            addCount();
        }
    }
}
