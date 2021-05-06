package 深度优先搜索;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个候选数字的集合 candidates 和一个目标值 target. 找到 candidates 中所有的和为 target 的组合.
 *
 * 在同一个组合中, candidates 中的某个数字不限次数地出现.
 *
 * 样例
 * 样例 1:
 *
 * 输入: candidates = [2, 3, 6, 7], target = 7
 * 输出: [[7], [2, 2, 3]]
 * 样例 2:
 *
 * 输入: candidates = [1], target = 3
 * 输出: [[1, 1, 1]]
 */
public class _数字组合 {


    private void  dfs(int[] candidates,int start,int target,
                      List<Integer> elem,List<List<Integer>> result){

        if(target==0) {
            result.add(new ArrayList<>(elem));
            return;
        }

        if(target<0){
            return;
        }

        for (int i=start;i<candidates.length;i++){
            elem.add(candidates[i]);
            dfs(candidates,i,target-candidates[i],elem,result);
            elem.remove(elem.size()-1);
        }

    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> elem = new ArrayList<>();
        dfs(candidates,0,target,elem,result);
        return result;
    }
}
