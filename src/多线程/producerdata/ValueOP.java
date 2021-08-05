package 多线程.producerdata;


/**
 * 定义一个操作数据的类
 */

public class ValueOP {

    private String value = "";

    //定义方法修改value字段的值
    public void setValue(){
        synchronized (this){

            //如果value不是空串就等待
            while (!value.equalsIgnoreCase("")){
                try {
                    this.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            //如果字符串上空串，则设置value字段的值
            String value = System.currentTimeMillis()+"-" + System.nanoTime();
            System.out.println("set 设置的值是: " + value);
            this.value=value;
            //在多生产者多消费者环境中,notify()不能保证是生产 者唤醒消费者,如果生产者唤醒的还是生产者可能会出现假死的情况
            this.notifyAll();
        }
    }





    //定义方法读取字段值
    public void getValue(){
    synchronized (this){

        //如果 value 是空串就等待
       while ( value.equalsIgnoreCase("")){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //不是空串,读取 字段值
        System.out.println("get 的值是: " + this.value);
        this.value = "";
        this.notifyAll();
        }
    }

}
