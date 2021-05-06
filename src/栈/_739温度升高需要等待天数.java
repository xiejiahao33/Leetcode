package 栈;


import java.util.Stack;

/**
 * 这个题目说的是，给你一个不为空的整数数组，数组中的元素表示每天的温度。
 * 你要计算出，对于每一天来说，温度升高需要等待的天数。
 * 如果对于某一天，未来不存在比它更高的温度，就把它对应的等待天数设置为 0。
 *
 * 比如说，给你的温度数组是：

 1, 3, 1, 3, 2, 6

 对于每一天来说，温度升高需要等待的天数是：

 1, 4, 1, 2, 1, 0
 */
public class _739温度升高需要等待天数 {

    public int[] dailyTemperatures(int[] T) {

        int n = T.length;
        int [] res = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && T[s.peek()] <T[i]){
                int idx = s.pop();
                res[idx] = i - idx;
            }

            s.push(i);
        }


        return res;
    }


}
