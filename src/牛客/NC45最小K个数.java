package 牛客;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * 给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，
 * 则最小的4个数字是1,2,3,4。如果K>数组的长度，那么返回一个空的数组
 * Input:   [4,5,1,6,2,7,3,8],4
 * OutPut:  [1,2,3,4]
 */
public class NC45最小K个数 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        if(input==null || input.length==0 || input.length<k) return new ArrayList<>();

        ArrayList<Integer> res = new ArrayList<>();

        Arrays.sort(input);

        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }

        return res;
    }
}
