package 算法模式.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？
 * 找出所有满足条件且不重复的四元组。
 *
 * Input: [4, 1, 2, -1, 1, -3], target=1
 Output: [-3, -1, 1, 4], [-3, 1, 1, 2]
 Explanation: Both the quadruplets add up to the target.


 Input: [2, 0, -1, 1, -2, 2], target=2
 Output: [-2, 0, 2, 2], [-1, 0, 1, 2]
 Explanation: Both the quadruplets add up to the target.


 */
public class QuadrupleSumToTarget {
    public static  List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> quadruplets = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i <nums.length-3 ; i++) {
            if(i>0 && nums[i]==nums[i-1]) continue;


            for (int j = i+1; j <nums.length-2 ; j++) {
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                searchPair(nums,target,i,j,quadruplets);
            }
        }


        return quadruplets;
    }

    private static void searchPair(int[] arr,int targetSum,int first,
                                   int second,List<List<Integer>> quadruplets){
        int left =second+1;
        int right = arr.length-1;
        while (left<right){
            int sum = arr[first]+arr[second]+arr[left]+arr[right];
            if(targetSum==sum) {
                quadruplets.add(Arrays.asList(arr[first],arr[second],arr[left],arr[right]));
                left++;
                right--;

                while (left<right && arr[left]==arr[left-1]) left++;
                while (left<right && arr[right]==arr[right+1]) right--;
            }else if(targetSum>sum) left++;
             else right--;
        }


    }

    public static void main(String[] args) {
        System.out.println(QuadrupleSumToTarget.fourSum(new int[]{4,1,2,-1,1,-3},1));
    }
}
