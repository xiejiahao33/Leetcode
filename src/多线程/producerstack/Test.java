package 多线程.producerstack;

//一生成一消费
public class Test {


    public static void main(String[] args) {
        MyStack stack = new MyStack();

        ProducerThread p1 = new ProducerThread(stack);
        ProducerThread p2 = new ProducerThread(stack);
        ProducerThread p3 = new ProducerThread(stack);
        ConsumerThread c1 = new ConsumerThread(stack);
        ConsumerThread c2 = new ConsumerThread(stack);
        ConsumerThread c3 = new ConsumerThread(stack);

        p1.setName("生产者 1 号");
        p2.setName("生产者 2 号");
        p3.setName("生产者 3 号");

        c1.setName("消费者 1 号");
        c2.setName("消费者 2 号");
        c3.setName("消费者 3 号");

        p1.start();
        p2.start();
        p3.start();
        c1.start();
        c2.start();
        c3.start();
    }


}
