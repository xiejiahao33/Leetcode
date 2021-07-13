package 多线程.cas;

public class CASTest {

    public static void main(String[] args) {
        CASCounter casCounter = new CASCounter();

        for (int i = 0; i <100000 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(casCounter.incrementAndGet());
                }
            }).start();
        }
    }

}

class CASCounter{


    volatile private long value;

    public long getValue(){return value;}


    private boolean compareAndSwap(long expectedValue, long newValue){
        //如果当前value的值与期望的expectedVAlue值一样,就把当前的Value字段替换为newValue值

        synchronized (this){
            if(value==expectedValue){
                value = newValue;
                return true;
            }else {
                return false;
            }
        }
    }

    //定义自增的方法

    public long incrementAndGet(){
        long oldValue;
        long newValue;
        do{
            oldValue = value;
            newValue = oldValue+1;
        }while (!compareAndSwap(oldValue,newValue));
        return newValue;
    }
}
