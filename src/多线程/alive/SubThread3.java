package 多线程.alive;

public class SubThread3 extends  Thread{


    @Override
    public void run() {
        System.out.println("run 方法,isalive=" + this.isAlive());
    }
}
