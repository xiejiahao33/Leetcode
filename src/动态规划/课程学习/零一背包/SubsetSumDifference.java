package 动态规划.课程学习.零一背包;

/**
 * 把正数数组分成2个子集，让它们的和的差集最小
 *
 * Input: {1, 2, 3, 9}
 * Output: 3
 * Explanation: We can partition the given set into two subsets where the minimum absolute difference
 * between the sum of numbers is '3'. Following are the two subsets: {1, 2, 3} & {9
 *
 * Input: {1, 2, 7, 1, 5}
 * Output: 0
 * Explanation: We can partition the given set into two subsets where the minimum absolute difference
 * between the sum of numbers is '0'. Following are the two subsets: {1, 2, 5} & {7, 1}.
 *
 * Input: {1, 3, 100, 4}
 * Output: 92
 * Explanation: We can partition the given set into two subsets where the minimum absolute difference
 * between the sum of numbers is '92'. Here are the two subsets: {1, 3, 4} & {100}.
 *
 *
 */

/**
 * 思路:
 * 1:使用DP维护一个数组记录使用数组来看能否达到 sum / 2  (一组数是sum/2,差则为0)
 * 2:若能，则差值为0，若不能，则选取最接近 sum /2 的那个子集
 */
public class SubsetSumDifference {
    public int canPartition(int[] num) {        // TODO: Write your code here
        int sum = 0;  //记录数组的和
        for (int i = 0; i <num.length ; i++) {
            sum+=num[i];
        }
        //记录状态
        boolean [][] dp = new boolean[num.length][sum/2 +1];
        for (int i = 0; i <num.length; i++) {
            dp[i][0] = true;//初始化第一列，和为0的子集可以轻易构造
        }

        //只有一个数字，只有当所需的总和等于该数字时，我们才能形成一个子集
        for (int s=1;s<=sum/2;s++){
            dp[0][s] = (num[0]==s? true : false);
        }

        for (int i = 1; i < num.length ; i++) {
            for (int s = 1; s <=sum/2; s++) {
                if(dp[i-1][s]){
                    dp[i][s] = dp[i-1][s];
                }else if(s>num[i]){
                    dp[i][s] = dp[i-1][s-num[i]];
                }
            }
        }

        int sum1 = 0;
        for (int i = sum/2; i >0; i--) {
            if(dp[num.length-1][i]){
                sum1 = i;
                break;
            }
        }

        int sum2 = sum -sum1;


        return Math.abs(sum1-sum2);

    }

    public static void main(String[] args) {
        SubsetSumDifference ps = new SubsetSumDifference();
        int[] num = {1, 2, 3, 9};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(ps.canPartition(num));
    }
}
