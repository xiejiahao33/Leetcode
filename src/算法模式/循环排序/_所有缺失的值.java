package 算法模式.循环排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
 * 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 *
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 *
 * 输入：nums = [1,1]
 * 输出：[2]
 */
public class _所有缺失的值 {


    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();

        //保证数字在数组中正确的位置
        int i =0;
        while (i < nums.length){
            if(nums[i]!=nums[nums[i]-1]){
                swap(nums,i,nums[i]-1);
            }else i++;
        }

        //不符合条件的加入结果集
        for(i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                res.add(i+1);
            }
        }


        return res;
    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
