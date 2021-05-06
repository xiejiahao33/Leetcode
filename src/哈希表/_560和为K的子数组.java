package 哈希表;


import java.util.HashMap;
import java.util.Map;

/**
 * 比如说，给你的数组和 k 分别是：

 [1, 2, 1, -1]
 k = 3

 在给出的数组中，求和等于 3 的子数组有 3 个，分别是：

 [1, 2]
 [2, 1]
 [1, 2, 1, -1]

 因此，你要返回满足条件的子数组数量就是 3。
 */
public class _560和为K的子数组 {
    public int subarraySum(int[] nums, int k) {
        if(nums==null || nums.length==0) return 0;

        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);// 记录本身就是=k的前缀和
        int res = 0;
        int sum = 0;
        for (int num:nums) {
           sum+=num;
           res += map.getOrDefault(sum-k,0);
           int sumCount = map.getOrDefault(sum,0);
           map.put(sum,sumCount+1);
        }
        return res;
    }
}
