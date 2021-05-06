package 深度优先搜索;

import java.util.ArrayList;
import java.util.List;

/**
 *这个题目说的是，给你一个不包含重复元素的整数数组，你要返回它所有可能的子集。
 * 比如说，给你的数组是：
 *
 * 1, 2, 4
 *
 * [1, 2, 4] 这三个数字可以形成的子集数量是 2^3 = 8 个：
 *
 * (),
 * (1),
 * (2),
 * (4),
 * (1, 2),
 * (1, 4),
 * (2, 4),
 * (1, 2, 4)
 */
public class _子集 {
    private void dfs(int start,List<Integer> elm,int[] nums, List<List<Integer>> result){
        result.add(new ArrayList<>(elm));
        for (int i=start;i<nums.length ;i++ ){
            elm.add(nums[i]);
            dfs(i+1,elm,nums,result);
            elm.remove(elm.size()-1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> elem = new ArrayList<>();
        dfs(0,elem, nums,result);
        return result;
    }
}
