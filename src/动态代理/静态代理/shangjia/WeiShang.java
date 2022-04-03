package 动态代理.静态代理.shangjia;

import 动态代理.静态代理.factory.UsbKingFactory;
import 动态代理.静态代理.service.UsbSell;

public class WeiShang implements UsbSell {

    //声明 商家代理的厂家具体是谁
    private UsbKingFactory factory = new UsbKingFactory();

    @Override
    public float sell(int amount) {

        //微商代购
        float price = factory.sell(amount);

        //微商只增加1元
        price+=1;
        return price;
    }
}
