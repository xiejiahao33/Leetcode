package 算法模式.双指针;


/**
 * 给你一个有序数组 nums,请你原地删除重复出现的,元素使每个元素只出现一次
 * 返回删除后数组的新长度。
 */
public class RemoveDuplicates {

    public static int remove(int[] arr){

        if(arr==null || arr.length==0) return 0;

        int slow = 1;
        for (int fast=1;fast<arr.length;fast++){
            if(arr[slow-1]!=arr[fast]){
                arr[slow] = arr[fast];
                slow++;
            }
        }



        return slow;
    }


    public static void main(String[] args) {

    }
}
