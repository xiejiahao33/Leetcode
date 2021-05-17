package 算法模式.双指针;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * Input: [-2, 0, 1, 2], target=2
 Output: 1
 Explanation: The triplet [-2, 1, 2] has the closest sum to the target.


 Input: [-3, -1, 1, 2], target=1
 Output: 0
 Explanation: The triplet [-3, 1, 2] has the closest sum to the target.

 Input: [1, 0, 1, 1], target=100
 Output: 3
 Explanation: The triplet [1, 1, 1] has the closest sum to the target.

 */
public class TripletSumCloseToTarget {


    public static int searchTriplets(int[] arr,int targetSum){

        Arrays.sort(arr);
        int smallestDiff = Integer.MAX_VALUE;
        for (int i = 0; i <arr.length-2 ; i++) {
            int left = i+1;
            int right = arr.length-1;

            while (left<right){

                int targetDiff = targetSum-arr[left]-arr[right]-arr[i];
                if(targetDiff==0) return targetSum-targetDiff;
                if(Math.abs(targetDiff)<Math.abs(smallestDiff)) smallestDiff=targetDiff;
                if(targetDiff>0){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return targetSum-smallestDiff;
    }
}
