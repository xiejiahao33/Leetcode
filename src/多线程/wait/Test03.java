package 多线程.wait;




import java.util.ArrayList;
import java.util.List;

public class Test03 {
    public static void main(String[] args) throws InterruptedException {

        //定义一个List集合存储String数据
        List<String> list = new ArrayList<>();

        //定义第一个线程，当list集合中元素的数量不等于5时线程等待
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (list){
                    if(list.size()!=5){
                        System.out.println("线程1开始等待: "+ System.currentTimeMillis());
                        try {
                            list.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        System.out.println("线程1开始唤醒: "+ System.currentTimeMillis());
                    }
                }
            }
        });


        //定义第二个线程，向list集合中添加元素
        Thread t2 =new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (list){
                    for (int i = 0; i <10 ; i++) {
                        System.out.println("线程2添加了第" + i + "个数据");
                        list.add("data--"+i);
                        if(list.size()==5){
                            list.notify();
                            System.out.println("线程2已经发现唤醒通知");
                        }
                        try {
                            Thread.sleep(1000);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        t1.start();

        Thread.sleep(3000);

        t2.start();

    }
}
