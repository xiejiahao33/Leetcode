package 动态代理.静态代理.service;

// 表示功能的接口 厂家、商家都要完成的功能
public interface UsbSell {

    //定义方法 amount：一次购买的数量
    //返回一个u盘的价格
    float sell(int amount);
}
