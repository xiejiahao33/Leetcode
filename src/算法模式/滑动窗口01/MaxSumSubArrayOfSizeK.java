package 算法模式.滑动窗口01;

/**
 * 给定一个正数数组和一个正数'k'，找到大小为'k'的任何连续子数组的最大和。
 * Input: [2, 1, 5, 1, 3, 2], k=3
   Output: 9
   Explanation: Subarray with maximum sum is [5, 1, 3].

   Input: [2, 3, 4, 1, 5], k=2
   Output: 7
   Explanation: Subarray with maximum sum is [3, 4].
 */
public class MaxSumSubArrayOfSizeK {

    //较为简单，只演示优化后的版本 O(N)
    public static int findMaxSumSubArray(int k, int[] arr) {
        int windowSum = 0, maxSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // 添加元素
            // 当窗口长度达到K后开始滑动窗口
            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart]; // 减去窗口头部元素
                windowStart++; //  滑动窗口头
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
    }
}
