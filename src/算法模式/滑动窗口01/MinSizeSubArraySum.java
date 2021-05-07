package 算法模式.滑动窗口01;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 并返回其长度。如果不存在符合条件的子数组，返回 0 。

 Input: [2, 1, 5, 2, 3, 2], S=7
 Output: 2
 Explanation: The smallest subarray with a sum greater than or equal to '7' is [5, 2].


 Input: [2, 1, 5, 2, 8], S=7
 Output: 1
 Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].


 Input: [3, 4, 1, 1, 6], S=8
 Output: 3
 Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1]
 or [1, 1, 6].
 */
public class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
        if(arr==null || arr.length==0) return 0;
        int windowSum=0,minLength = Integer.MAX_VALUE;
        int windowStart=0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum+=arr[windowEnd];

            //当窗口值大于等于S时移动窗口
            while (windowSum>=S){
                minLength = Math.min(minLength,windowEnd-windowStart+1);
                windowSum-=arr[windowStart];
                windowStart++;
            }
        }

        return minLength==Integer.MAX_VALUE ? 0 : minLength;
    }


    public static void main(String[] args) {
        int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);
    }
}
