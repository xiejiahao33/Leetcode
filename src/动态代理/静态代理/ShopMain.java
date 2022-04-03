package 动态代理.静态代理;

import 动态代理.静态代理.shangjia.TaoBao;

public class ShopMain {
    public static void main(String[] args) {


        //创建代理的商家taobao对象
        TaoBao taoBao = new TaoBao();
        float price = taoBao.sell(1);
        System.out.println("通过淘宝的商家购买U盘单价:"+price);
    }
}
