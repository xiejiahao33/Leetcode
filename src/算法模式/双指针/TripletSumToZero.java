package 算法模式.双指针;


import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有和为 0 且不重复的三元组。
 * Input: [-3, 0, 1, 2, -1, 1, -2]
 Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
 Explanation: There are four unique triplets whose sum is equal to zero.

 Input: [-5, 2, -1, -2, 3]
 Output: [[-5, 2, 3], [-2, -1, 3]]
 Explanation: There are two unique triplets whose sum is equal to zero.


 输入：nums = [-1,0,1,2,-1,-4]
 输出：[[-1,-1,2],[-1,0,1]]

 输入：nums = []
 输出：[]

 输入：nums = [0]
 输出：[]

 */
public class TripletSumToZero {
    public static List<List<Integer>> searchTriplets(int[] arr){

        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);// [-4,-1,-1,0,1,2]

        for (int i = 0; i <arr.length-2 ; i++) {
            if(i>0 && arr[i]==arr[i-1]) continue;

            searchPair(arr,-arr[i],i+1,triplets);
        }

        return triplets;
    }


    private static void searchPair(int[] arr,int targetSum,int left,List<List<Integer>> triplets){

        int right = arr.length-1;
        while (left<right){
            int currentSum = arr[left]+arr[right];
            if(currentSum==targetSum){
                triplets.add(Arrays.asList(-targetSum,arr[left],arr[right]));
                left++;
                right--;
                while (left<right && arr[left]==arr[left-1]) left++;
                while (left<right && arr[right]==arr[right+1]) right--;
            }else if(targetSum>currentSum) left++;
             else right--;
        }
    }


    public static void main(String[] args) {
        System.out.println(TripletSumToZero.searchTriplets(new int[]{-3,0,1,2,-1,1,-2}));

    }
}


