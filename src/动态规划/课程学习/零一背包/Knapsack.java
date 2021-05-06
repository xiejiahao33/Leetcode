package 动态规划.课程学习.零一背包;



class Knapsack {


    /**
     * 暴力解法
     */
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        return knapsackRecursive(profits,weights,capacity,0);
    }

    private int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex){

        if(currentIndex>= profits.length || capacity <= 0 ) return 0;

        int profit1 = 0;
        if(weights[currentIndex] <=capacity){
            profit1 = profits[currentIndex] + knapsackRecursive(profits,weights,
                    capacity-weights[currentIndex],currentIndex+1);
        }

        int profit2 = knapsackRecursive(profits,weights,capacity,currentIndex+1);

        return Math.max(profit1,profit2);
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