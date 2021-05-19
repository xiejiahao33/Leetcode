package 算法模式.双指针;

/**
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，
 * 如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 请你找出符合题意的 最短 子数组，并输出它的长度。

 Input: [1, 2, 5, 3, 7, 10, 9, 12]
 Output: 5
 Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted


 Input: [1, 3, 2, 0, -1, 7, 10]
 Output: 5
 Explanation: We need to sort only the subarray [1, 3, 2, 0, -1] to make the whole array sorted


 Input: [1, 2, 3]
 Output: 0
 Explanation: The array is already sorted

 Input: [3, 2, 1]
 Output: 3
 Explanation: The whole array needs to be sorted.

 */
public class _最短无序连续子数组 {
    public int findUnsortedSubarray(int[] nums) {

        int low = 0,high = nums.length-1;

        while (low<nums.length-1 && nums[low] <=nums[low+1])
            low++;

        if(low==nums.length-1) return 0;

        while (high>0 &&nums[high] >=nums[high-1])
            high--;

        int subarrayMax = Integer.MIN_VALUE,subarrayMin = Integer.MAX_VALUE;

        for (int i = low; i <=high ; i++) {
            subarrayMax = Math.max(subarrayMax,nums[i]);
            subarrayMin = Math.min(subarrayMin,nums[i]);
        }

        while (low>0 && nums[low-1] > subarrayMin)
            low--;

        while (high<nums.length-1 && nums[high+1] < subarrayMax)
            high++;


        return high-low+1;
    }
}

