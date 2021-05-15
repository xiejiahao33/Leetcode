package 多线程.createthread;

public class Test {
    public static void main(String[] args) {
//        System.out.println("main 线程");
//
//        //创建子线程对象
//        MyThread thread = new MyThread();
//
//
//        //启动线程
//        thread.start();
//
//        /*
//        调用线程的start()方法来启动线程,
//        启动线程的实质就是请求JVM运行相应的线程,
//        这个线程具体在什么时候运行由线程调度器(Scheduler)决定
//        注意:
//            start()方法调用结束并不意味着子线程开始运行
//            新开启的线程会执行run()方法如果开启了多个线程,
//            start()调用的顺序并不一定就是线程启动的顺序
//            多线程运行结果与代码执行顺序或调用顺序无关
//        */
//        System.out.println("main后面语句");



        //3)创建Runnable接口的实现类对象
        MyRunnable runnable=new MyRunnable();
        // 4)创建线程对象
        Thread thread =new Thread(runnable);
         //5)开启线程
        thread.start();

        //当前是main线程
        for(int i=1;i<=100;i++) {
            System.out.println("main==>"+i);
        }

        //有时调用Thread(Runnable)构造方法时,实参也会传递匿名内部类对象
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=100;i++){
                    System.out.println("sub------------------------------>"+i);
                }
            }
        });
        thread2.start();
    }
}
