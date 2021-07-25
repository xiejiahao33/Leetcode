package 动态规划.课程学习.零一背包;



public class Knapsack {


    //暴力法的解法
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        Integer[][] dp = new Integer[profits.length][capacity+1];
        return knapsackRecursiveBruteForceDP1(dp,profits,weights,capacity,0);
    }

    //暴力解法的辅助函数  O(2^n)-->time  o(N)->Space
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


    //Top-down Dynamic Programming with Memoization  O(N∗C) --> time + space
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


    //Bottom-up Dynamic Programming  O(N∗C)
    public int knapsackDp2(int[] profits, int[] weights, int capacity) {

        if (profits.length==0 || profits.length!=weights.length || capacity<=0) return 0;
        int n = profits.length;
        int[][] dp = new int[n][capacity+1];

        //部分初始化
        //填充容量=0列，容量为0时,我们的利润为'0',
        for(int i = 0;i<n; i++){
            dp[i][0] = 0;
        }
        //如果我们只有一个重量，那么它会承受不超过重量的重量

        for (int c=0;c<=capacity;c++){
            if (weights[0] <=c){
                dp[0][c]= profits[0];
            }
        }

        //处理所有容量的所有子数组
        //dp[i][c] = max (dp[i-1][c], profits[i] + dp[i-1][c-weights[i]])
        for (int i =1; i< n ;i++){
            for (int c = 1;c<=capacity;c++){
                int profit1=0,profit2=0;

                //包含该项目（如果不超过容量）
                if(weights[i]<=c){
                    profit1 = profits[i] + dp[i-1][c-weights[i]];
                }

                //排除项目
                profit2 = dp[i-1][c];

                //选取最大
                dp[i][c] = Math.max(profit1,profit2);
            }
        }
        return dp[n-1][capacity];
    }



    //Bottom-up Dynamic Programming 优化空间版本 O(C)  即滚动数组
    private  int knapsackDp2Improve(int[] profits, int[] weights, int capacity) {
        // basic checks
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
            return 0;

        int n = profits.length;

        //我们只需要前一行即可找到最佳解决方案，总的来说，我们需要'2'行
        //上面的解决方案与以前的解决方案相似，唯一的区别是
        //如果使用`i`则使用`i％2`代替，如果使用'i-1'则使用`（i-1）％2`代替
        int[][] dp = new int[2][capacity+1];
        for (int c=0;c<=capacity;c++){
            if(weights[0]<=c){
                dp[0][c] = dp[1][c] = profits[0];
            }
        }

        //处理所有容量的所有子数组
        //dp[i][c] = max (dp[i-1][c], profits[i] + dp[i-1][c-weights[i]])
        for (int i = 1; i < n; i++) {
            for (int c = 0; c <=capacity; c++) {
                int profit1 = 0,profit2=0;

                if(weights[i]<=c){
                    profit1 = profits[i] + dp[(i-1)%2][c-weights[i]];
                }
                profit2 = dp[(i-1)%2][c];
                dp[(i%2)][c] = Math.max(profit1,profit2);
            }
        }
        return dp[(n-1)%2][capacity];
    }



    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = {6, 16, 10, 1};
        int[] weights = {2, 5, 3, 1};
        int maxProfit = ks.knapsackDp2Improve(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.knapsackDp2Improve(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}