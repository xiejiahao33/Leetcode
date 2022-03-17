package 多线程.producerdata;

public class ConsumerThread extends Thread {
    //消费者使用数据, 就是使用 ValueOP 类的 value 字段值
    private ValueOP obj;
    public ConsumerThread(ValueOP obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        while (true){
            obj.getValue();
        }
    }
}
