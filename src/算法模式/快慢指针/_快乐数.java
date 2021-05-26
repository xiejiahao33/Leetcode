package 算法模式.快慢指针;


/**
 * 编写一个算法来判断一个数 n 是不是快乐数。

 「快乐数」定义为：

 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 如果 可以变为  1，那么这个数就是快乐数。
 如果 n 是快乐数就返回 true ；不是，则返回 false 。

  输入：19
 输出：true
 解释：
 1^2 + 9^2 = 82
 8^2 + 2^2 = 68
 6^2 + 8^2 = 100
 1^2 + 0^2 + 0^2 = 1
 */
public class _快乐数 {
    public boolean isHappy(int n) {
        int slow= n,fast = n;
        do {
            slow = findSquareSum(n);
            fast = findSquareSum(slow);
        }while (slow!=fast);

        return slow==1;
    }

    private static int findSquareSum(int num){
        int sum=0,digit;
        while (num>0){
            digit = num % 10;
            sum+=digit * digit;
            num/= 10 ;
        }

        return sum;
    }
}
