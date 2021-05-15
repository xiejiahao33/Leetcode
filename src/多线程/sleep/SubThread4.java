package 多线程.sleep;

public class SubThread4 extends Thread {


    @Override
    public void run() {

        try {
            System.out.println("run, threadname=" + Thread.currentThread().getName()
                    + " ,begin= " + System.currentTimeMillis());

            Thread.sleep(2000);//当前线程睡眠 2000 毫秒

            System.out.println("run, threadname=" + Thread.currentThread().getName()
                    + " ,end= " + System.currentTimeMillis());


        } catch (InterruptedException e) {

            //在子线程的 run 方法中, 如果有受检异常(编译时异常)需要处理,只有选择捕
            //获处理,不能抛出处理
            e.printStackTrace();
        }
    }
}
