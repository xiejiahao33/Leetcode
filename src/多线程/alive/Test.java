package 多线程.alive;



public class Test {
    public static void main(String[] args) {
        SubThread3 t3 = new SubThread3();

        //false,在启动线程之前
        System.out.println("begin=="+t3.isAlive());

        t3.start();
        //结果不一定,打印这一行时,如果 t3
        //线程还没结束就返回 true, 如果 t3 线程已结束,返回 false
        System.out.println("end=="+t3.isAlive());
    }
}
