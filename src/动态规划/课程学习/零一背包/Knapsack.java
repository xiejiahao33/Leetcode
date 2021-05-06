package 动态规划.课程学习.零一背包;



public class Knapsack {


    //暴力法的解法
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        // TODO: Write your code here
        Integer[][] dp = new Integer[profits.length][capacity+1];
        return knapsackRecursiveBruteForceDP1(dp,profits,weights,capacity,0);
    }

    //暴力解法的辅助函数
    private int knapsackRecursiveBruteForce(int[] profits, int[] weights, int capacity, int currentIndex){

        //边界判断
        if(currentIndex>=profits.length || capacity<=0) return 0;


        //在currentIndex处选择元素后进行递归调用
        //如果在currentIndex处元素的权重超出了容量，则不应处理此问题
        int profit1 = 0;
        if(weights[currentIndex]<=capacity){
            profit1 = profits[currentIndex] + knapsackRecursiveBruteForce(profits,weights,
                    capacity-weights[currentIndex],currentIndex+1);
        }

        //在排除currentIndex的元素之后进行递归调用
        int profit2 = knapsackRecursiveBruteForce(profits,weights,
                capacity,currentIndex+1);


        return Math.max(profit1,profit2);
    }


    //Top-down Dynamic Programming with Memoization
    private int knapsackRecursiveBruteForceDP1(Integer[][] dp, int[] profits, int[] weights, int capacity, int currentIndex) {

        //边界判断
        if(currentIndex>=profits.length || capacity <=0) return 0;

        //如果我们已经解决了类似的问题，请从内存中返回结果
        if(dp[currentIndex][capacity]!=null)  return dp[currentIndex][capacity];

        //在currentIndex处选择元素后进行递归调用
        //如果在currentIndex处元素的权重超出了容量，则不应处理此问题
        int profit1 = 0;
        if(weights[currentIndex]<=capacity){
            profit1 = profits[currentIndex] + knapsackRecursiveBruteForceDP1(dp,profits,weights,
                    capacity-weights[currentIndex],currentIndex+1);
        }

        //在排除currentIndex的元素之后进行递归调用
        int profit2 = knapsackRecursiveBruteForceDP1(dp,profits,weights,
                capacity,currentIndex+1);

        //记忆子问题的解
        dp[currentIndex][capacity] = Math.max(profit1,profit2);
        return dp[currentIndex][capacity];

    }


    //Bottom-up Dynamic Programming
    public int knapsackDp2(int[] profits, int[] weights, int capacity) {

        if (profits.length==0 || profits.length!=weights.length || capacity<=0) return 0;
        int n = profits.length;
        int[][] dp = new int[n][capacity+1];

        return 0;
    }


    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}