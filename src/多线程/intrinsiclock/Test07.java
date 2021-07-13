package 多线程.intrinsiclock;

public class Test07 {

    public static void main(String[] args) {
        Test07 obj = new Test07();

        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.doLongTimeTask();
            }
        }).start();


        new Thread(new Runnable(){
            @Override
            public void run() {
                obj.doLongTimeTask();
            }
        }).start();

    }

    public synchronized void doLongTimeTask(){
        try {
            System.out.println("Task begin");
            Thread.sleep(3000); //模拟任务需要3秒
                System.out.println("开始同步");
                for (int i = 1; i <=100; i++) {
                    System.out.println(Thread.currentThread().getName()+"-->"+i);
                }

            System.out.println("Task end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
