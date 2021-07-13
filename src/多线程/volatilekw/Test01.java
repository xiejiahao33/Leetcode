package 多线程.volatilekw;

public class Test01 {
    public static void main(String[] args) {
        PrintSring printSring = new PrintSring();


        //开启子线程,让子线程执行pringString对象的pringtStringMethod()方法。
        new Thread(new Runnable() {
            @Override
            public void run() {
                printSring.pringtStringMethod();
            }
        }).start();

        //main 线程睡眠1000毫秒
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("main线程中修改打印标志");
        printSring.setContinuePrint(false);
    }

    static class PrintSring{
        private volatile  boolean continuePrint = true;

        public PrintSring setContinuePrint(boolean continuePrint){
            this.continuePrint = continuePrint;
            return this;
        }

        public void pringtStringMethod(){
            System.out.println(Thread.currentThread().getName() +  "开始");
            while (continuePrint){

            }
            System.out.println(Thread.currentThread().getName() + "结束");
        }
    }
}
