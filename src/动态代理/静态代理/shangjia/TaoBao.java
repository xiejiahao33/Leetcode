package 动态代理.静态代理.shangjia;

import 动态代理.静态代理.factory.UsbKingFactory;
import 动态代理.静态代理.service.UsbSell;

//代理金士顿U盘的销售商家
public class TaoBao implements UsbSell {

    //声明 商家代理的厂家具体是谁
    private UsbKingFactory factory = new UsbKingFactory();


    @Override
    //实现销售U盘功能
    public float sell(int amount) {
        //向厂家发送订单，告诉厂家，我买了U盘，厂家发货(拿货价)
        float price = factory.sell(amount);

        //商家需要加价，也就是代理要增加价格(增加功能)
        price+=25;
        System.out.println("返回一个优惠券和红包");
        return price;
    }
}
