package 算法模式.双指针;

import java.util.Arrays;

/**
 * Given an array arr of unsorted numbers and a target sum,
 * count all triplets in it such that arr[i] + arr[j] + arr[k] < target
 * where i, j, and k are three different indices.
 * Write a function to return the count of such triplets.
 * example 1
 * Input: [-1, 0, 2, 3], target=3
 * Output: 2
 * Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
 *
 * example 2
 * Input: [-1, 4, 2, 1, 3], target=5
 * Output: 4
 * Explanation: There are four triplets whose sum is less than the target:
 * [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
 */
public class TripletWithSmallerSum {

    public static int searchTriplet(int[] arr, int target){
        //排序算法 O(N∗logN)
        Arrays.sort(arr);
        int count = 0;
        //遍历数组 O(N^3)
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right){
                int sum = arr[i] + arr[left] + arr[right];
                if (sum < target){
                    //这一步可以优化成一步 ---> O(N^2)
                    //count += right - left;
                    for (int j = right; j >left; j--) {
                        count++;
                    }
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return count;
    }



    public static void main(String[] args) {
        System.out.println(TripletWithSmallerSum.searchTriplet(new int[]{-1, 0, 2, 3}, 3));
        System.out.println(TripletWithSmallerSum.searchTriplet(new int[]{-1, 4, 2, 1, 3}, 5));
        System.out.println(TripletWithSmallerSum.searchTriplet(new int[]{1, 1, 1, 1, 1}, 4));
    }
}
