package 动态规划.课程学习.零一背包;


import java.util.HashSet;

/**
 *
 * 给定一组正数，请确定是否可以将其划分为两个子集，以使两个子集中的元素之和相等。
 *
 * Input: {1, 2, 3, 4}
 Output: True
 Explanation: The given set can be partitioned into two subsets with equal sum: {1, 4} & {2, 3}

 Input: {1, 1, 3, 4, 7}
 Output: True
 Explanation: The given set can be partitioned into two subsets with equal sum: {1, 3, 4} & {1, 7}

 Input: {2, 3, 4, 6}
 Output: False
 Explanation: The given set cannot be partitioned into two subsets with equal sum.
 *
 */
public class PartitionSet {


    //暴力解法
    public  boolean canPartition(int[] num) {
        int sum = 0;
        for (int i = 0; i <num.length ; i++) {
            sum+=num[i];
        }

        if(sum %2 !=0) return false;

        return canPartitionRecursive(num,sum/2,0);
    }
    //Time O(2^n)  Space O(n) 函数调用栈
    private boolean canPartitionRecursive(int[] num, int sum, int currentIndex) {
        if(sum==0) return true;
        if(num.length==0 || currentIndex >=num.length) return false;

        if(num[currentIndex]<=sum){
            if(canPartitionRecursive(num,sum-num[currentIndex],currentIndex+1)){
                return true;
            }
        }
        return canPartitionRecursive(num,sum,currentIndex+1);
    }

    //Top-down Dynamic Programming with Memoization
    public  boolean canPartitionDP1(int[] num) {
        int sum = 0;
        for (int i = 0; i <num.length ; i++) {
            sum+=num[i];
        }

        if(sum %2 !=0) return false;

        Boolean[][] dp = new Boolean[num.length][sum/2 + 1];

        return canPartitionRecursiveDp1(dp,num,sum/2,0);
    }

    //Time O(N*S)  Space O(N*S) N represents total numbers and S is the total sum of all the numbers.
    private boolean canPartitionRecursiveDp1(Boolean[][] dp ,int[] num, int sum, int currentIndex) {
        if(sum==0) return true;
        if(num.length==0 || currentIndex >=num.length) return false;

        //还未处理过类似的问题
        if(dp[currentIndex][sum]==null){
            //选择当前元素，递归循环下去
            //如果当前元素值过大，则不处理跳过
            if(num[currentIndex]<=sum){
                if(canPartitionRecursiveDp1(dp,num,sum-num[currentIndex],currentIndex+1)){
                    dp[currentIndex][sum]=true;
                    return true;
                }
            }
            //在排除currentIndex处的数字之后进行递归调用
            dp[currentIndex][sum] = canPartitionRecursiveDp1(dp,num,sum,currentIndex+1);
        }
        return dp[currentIndex][sum];
    }

    //Bottom-up Dynamic Programming
    public  boolean canPartitionDP2(int[] num) {
        int n = num.length;
        int sum = 0;
        for (int i = 0; i <n ; i++) {
            sum+=num[i];
        }
        if(sum %2 !=0) return false;

        // we are trying to find a subset of given numbers that has a total sum of ‘sum/2’.
        sum /= 2;

        boolean[][] dp = new boolean[n][sum + 1];

        for(int i=0; i < n; i++)
            dp[i][0] = true;

        // with only one number, we can form a subset only when the required sum is equal to its value
        for(int s=1; s <= sum ; s++) {
            dp[0][s] = (num[0] == s ? true : false);
        }

        for (int i = 1; i < n; i++) {
            for (int s = 1; s <=sum ; s++) {

                if(dp[i-1][s]){
                    dp[i][s] = dp[i-1][s];
                }else if(s>=num[i]){
                    dp[i][s] = dp[i-1][s-num[i]];
                }
            }
        }
        return dp[n-1][sum];
    }

    public static void main(String[] args) {
        PartitionSet ps = new PartitionSet();
        int[] num = {1, 2, 3, 4};
        System.out.println(ps.canPartitionDP2(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(ps.canPartitionDP2(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(ps.canPartitionDP2(num));


    }
}
