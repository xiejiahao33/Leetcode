package 多线程.interrupt;

public class SubThread2 extends Thread {


    @Override
    public void run() {
        super.run();
        for(int i = 1; i <= 10000; i++){
            //判断线程的中断标志,线程有 isInterrupted()方法,该方法返回线程的中断标志
            if ( this.isInterrupted() ){
                System.out.println("当前线程的中断标志为 true, 我要退出了");
                // break;
                // 中断循环, run()方法体执行完毕子线程运行完毕
                return; //直接结束当前 run()方法的执行
            }
            System.out.println("sub thread --> " + i);
        }
    }
}
