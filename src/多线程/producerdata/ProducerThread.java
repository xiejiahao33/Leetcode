package 多线程.producerdata;

/**
 * 定义线程磊模拟生产者
 */

public class ProducerThread extends Thread{
    //生产者生产数据就是调用 ValueOP 类的 setValue 方法给 value
    // 字段赋值
    private ValueOP obj;

    public ProducerThread(ValueOP obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        while (true){
            obj.setValue();
        }
    }
}
