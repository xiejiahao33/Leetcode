package 多线程.interrupt;

public class Test02 {
    public static void main(String[] args) {
        SubThread2 t1 = new SubThread2();

        t1.start();//开启子线程


        //当前线程是 main 线程
        for(int i = 1; i<=10000; i++){
            System.out.println("main ==> " + i);
        }
        //中断子线程
        t1.interrupt();//仅仅是给子线程标记中断,
    }
}
