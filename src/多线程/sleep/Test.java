package 多线程.sleep;

public class Test {

    public static void main(String[] args) {
        SubThread4 t4 = new SubThread4();

        System.out.println("main__begin = " + System.currentTimeMillis());

         t4.start(); //开启新的线程

       // t4.run();//在 main 线程中调用实例方法 run(),没有开启新的线程

        System.out.println("main__end = " + System.currentTimeMillis());
    }
}
