package 多线程.producerdata;


/**
 * 测试一生产，一消费的情形
 */
public class Test {
    public static void main(String[] args) {
        ValueOP valueOP = new ValueOP();

        ProducerThread p = new ProducerThread(valueOP);
        ConsumerThread c = new ConsumerThread(valueOP);

        p.start();
        c.start();
    }
}
