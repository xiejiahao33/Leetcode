package 哈希表;


import java.util.HashSet;
import java.util.Set;

/**
 * 这个题目说的是，给你一个整数数组，你要判断数组中是否包含重复元素。
 * 如果数组中包含重复元素就返回 true，否则返回 false。
 * 比如说，给你的数组是：
 *1, 2, 4, 2
 *这个数组中有两个 2，包含重复元素，返回 true。
 *再比如说，给你的数组是：
 *4, 1, 2
 *在这个数组中，每个数字都只出现了一次，不存在重复元素，因此返回 false。
 */
public class _207数组中包含重复的元素 {
    public boolean containsDuplicate(int[] nums) {
        if(nums==null || nums.length==0) return false;


        Set<Integer> set = new HashSet<>();

        for (int i = 0; i <nums.length ; i++) {
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
        }

        return false;
    }
}
