package 多线程.intrinsiclock;

public class Test01 {


    public static void main(String[] args) throws InterruptedException {
        //开始子线程设置用户名和密码
        PublicValue publicValue = new PublicValue();
        SubThread t1 = new SubThread(publicValue);
        t1.start();

        Thread.sleep(100);
        publicValue.getValue();
    }



    //定义线程，设置用户名和密码
    static class SubThread extends Thread{
        private PublicValue publicValue;
        public SubThread(PublicValue publicValue){
            this.publicValue = publicValue;
        }

        @Override
        public void run() {
            publicValue.setValue("bjjhdas","123");
        }
    }

    static class PublicValue{
        private String name = "wkcto";
        private String pwd = "666";

        public synchronized void getValue(){
            System.out.println(Thread.currentThread().getName() + ",getter--name:" + name + ",--pwd:" + pwd);
        }

        public synchronized  void setValue(String name,String pwd){
            this.name = name;
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            this.pwd = pwd;
            System.out.println(Thread.currentThread().getName()+", setter --name " + name + ",--pwd:" + pwd);
        }
    }
}
