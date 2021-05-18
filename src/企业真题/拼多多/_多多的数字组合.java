package 企业真题.拼多多;


import java.util.Scanner;

/**
 * 多多君最近在研究某种数字组合：
 定义为：每个数字的十进制表示中(0~9)，每个数位各不相同且各个数位之和等于N。
 满足条件的数字可能很多，找到其中的最小值即可。
 多多君还有很多研究课题，于是多多君找到了你--未来的计算机科学家寻求帮助。

 共一行，一个正整数N，如题意所示，表示组合中数字不同数位之和。
 （1 <= N <= 1,000）

 共一行，一个整数，表示该组合中的最小值。
 如果组合中没有任何符合条件的数字，那么输出-1即可。

 例子 1

 Input ：5
 Output： 5

 符合条件的数字有：5，14，23，32，41
 其中最小值为5

 例子 2 ：
 Input : 12
 Output: 39


 例子 3 ：
 Input : 50
 Output: -1
 没有符合条件的数字 (Ｔ▽Ｔ)

 */
public class _多多的数字组合 {
    public static int solution(int num){
        if (num<10) return num;
        if (num>45) return -1;

        int result = 0;
        int index = 0;
        for (int i = 9; i >0 && num!=0 ; i--) {
            if(num-i>=0){
                num -=i;
                result = (int)Math.pow(10,index) * i + result;
                index++;
            }
        }


        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();
        System.out.println(solution(n));
    }
}
