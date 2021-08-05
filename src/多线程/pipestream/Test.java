package 多线程.pipestream;


import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/*
使用PipedInputStream和PipedOutStream管道字节流在线程之间传递数据
 */
public class Test {

    public static void main(String[] args) throws IOException {
        PipedInputStream inputStream = new PipedInputStream();
        PipedOutputStream outputStream = new PipedOutputStream();

        //输入管道流和输出管道流之间建立连接
        inputStream.connect(outputStream);


        //创建线程向管道流中写入数据
        new Thread(new Runnable() {
            @Override
            public void run() {
                writeData(outputStream);
            }
        }).start();

        //定义线程向管道流中输出数据
        new Thread(new Runnable() {
            @Override
            public void run() {
                readData(inputStream);
            }
        }).start();
    }

    //管道流中写入数据
    public static void writeData(PipedOutputStream out){
        try {
            for (int i=0;i<100;i++){
                String data = "" + i;
                out.write(data.getBytes());
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readData(PipedInputStream in){
        byte[] bytes = new byte[1024];
        //从管道输入字节流中读取字节保存=到字节数组中
        try {
            int len = in.read(bytes); //返回读到到字节数，如果没有读到任何数据返回-1
            while (len!=-1){
                System.out.println(new String(bytes,0,len));
                len = in.read(bytes); //继续读取数据
            }
            in.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
