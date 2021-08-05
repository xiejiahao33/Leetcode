package 多线程.producerstack;

import java.util.ArrayList;
import java.util.List;

// 模拟栈
public class MyStack {
    private List list = new ArrayList();
    private static final int MAX = 1;

    //定义方法模拟入栈
    public synchronized void push() {
        //当栈中的数据已满 就等待
        while (list.size() >= MAX) {
            System.out.println(Thread.currentThread().getName() + " begin wait....");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String data = "data--" + Math.random();

        System.out.println(Thread.currentThread().getName() + "添加了数据: " + data);
        list.add(data);
        this.notifyAll();
    }


    //定义方法模拟出栈
    public synchronized void pop(){
    //如果没有数据就等待
        while (list.size() == 0 ){
            System.out.println(Thread.currentThread().getName() + " begin wait....");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace(); }
        }
        System.out.println( Thread.currentThread().getName() + "出栈数据:" + list.remove(0) );
        this.notifyAll();
    }
}
