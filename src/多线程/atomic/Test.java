package 多线程.atomic;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        //通过线程模拟请求,在实际应用中可以在 ServletFiler 中调用 Indicator 计数器的相关方法
        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Indicator.getInstance().newRequestRecive();
                    int num  = new Random().nextInt();
                    if(num%2==0){ //偶数模拟成功
                        Indicator.getInstance().requestProcesSuces();
                    }else {
                        Indicator.getInstance().requestProcesFailure();
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }


        System.out.println( Indicator.getInstance().getRquestCount());//总的请求数

        System.out.println( Indicator.getInstance().getSucesCount()); //成功数
        System.out.println( Indicator.getInstance().getFailureCount()); //失败数

    }
}
