package 算法模式.滑动窗口01;


import java.util.Arrays;

/**
 * 给定输入 Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
 * 计算
 * 前五个数均值: (1+3+2+6-1)/5 => 2.2(1+3+2+6−1)/5=>2.2
 * 接下来五个数均值: (3+2+6-1+4)/5 => 2.8(3+2+6−1+4)/5=>2.8
 * 滑动下一个五个数均值:: (2+6-1+4+1)/5 => 2.4
 */

public class AverageOfSubarrayOfSizeK {


    //暴力法 O(N∗K)
    public static double[] findAverages(int K, int[] arr) {
        double[] result =new double[arr.length-K+1];
        for (int i = 0; i <=arr.length-K ; i++) {

            // 下K个元素的和
            double sum = 0;
            for (int j = i; j <i+K ; j++) {
                sum+=arr[j];
            }
            result[i] = sum/K;
        }
        return result;
    }

    //优化版本 滑动窗口 O(N)
    public static double[] findAveragesImprove(int K, int[] arr) {
        double[] result =new double[arr.length-K+1];
        double windowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum+=arr[windowEnd];//新增元素

            // 当窗口长度达到K后开始滑动窗口
            if(windowEnd>=K-1){
                result[windowStart] = windowSum / K;  // 计算均值
                windowSum -=arr[windowStart];// 减去窗口头部元素
                windowStart++; // 滑动窗口头
            }
        }

        return  result;
    }


    public static void main(String[] args) {
        double[] result = AverageOfSubarrayOfSizeK.findAveragesImprove(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
        System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
    }
}
