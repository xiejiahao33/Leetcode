package 多线程.producerstack;

public class ConsumerThread extends Thread{
    private MyStack stack;

    public ConsumerThread(MyStack stack) {

        this.stack = stack;
    }
    @Override
    public void run() {
        while (true){
            stack.pop();
        }
    }
}
