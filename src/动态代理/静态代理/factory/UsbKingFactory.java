package 动态代理.静态代理.factory;


import 动态代理.静态代理.service.UsbSell;

//目标类：金士顿厂家，不接受用户的单独购买
public class UsbKingFactory implements UsbSell {


    @Override
    public float sell(int amount) {
        //一个128G的是85元
        return 85.0f;
    }
}
