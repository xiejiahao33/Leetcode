package 设计模式.多种模式.单例模式;


/**
 * 懒汉模式，线程不安全。
 */
public class LazySingleton {

    private static LazySingleton lazySingleton =null;

    private LazySingleton(){

    }

    public synchronized static LazySingleton getInstance(){
        if(lazySingleton==null){
            lazySingleton = new LazySingleton();
        }

        return lazySingleton;
    }
}
