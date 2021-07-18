package 设计模式.多种模式.单例模式;

public class DoubleCheckSingleton {

    //volatile保证可见性，避免重排序出现的问题
    private volatile  static DoubleCheckSingleton doubleCheckSingleton;

    private DoubleCheckSingleton(){};

    public static DoubleCheckSingleton getInstance(){
        if(doubleCheckSingleton!=null) return doubleCheckSingleton;
        synchronized (DoubleCheckSingleton.class){
            if(doubleCheckSingleton!=null){
                doubleCheckSingleton = new DoubleCheckSingleton();
            }
        }

        return doubleCheckSingleton;
    }
}
