package 栈;

/**
 * 比如说，给你的数组是：
 0, 2, 0, 4, 0, 1, 2
下标 2 位置的盛水量是 2，下标 4 位置的盛水量是 2，下标 5 位置的盛水量是 1，因此总共的盛水量是：

 2 + 2 + 1 = 5
 */

public class _42Leetcode {


    // Time: O(n), Space: O(n)
    public int waterCanBeTrap(int[] height) {
        if (height==null || height.length==0) return 0;

        int res = 0,leftMax = -1,rightMax=-1;
        int [] d= new int[height.length]; //记录从左开始累计的最大雨水

        for (int i = 0; i < height.length; i++) {
            leftMax = Math.max(leftMax,height[i]);
            d[i] = leftMax;
        }


        for (int i = height.length-1; i >=0; i--) {
            rightMax = Math.max(rightMax,height[i]);
            d[i] = Math.min(rightMax,d[i]);
            res += d[i] - height[i];
        }
        return res;
    }


    // Time: O(n), Space: O(1)
    public int waterCanBeTrapO1(int[] height) {
        if (height==null || height.length==0) return 0;
        int res=0,leftMax= -1,rightMax=-1;
        int i=0,j=height.length-1;
        while (i<=j){
            leftMax = Math.max(leftMax,height[i]);
            rightMax = Math.max(rightMax,height[j]);

            if(leftMax<rightMax) res += (leftMax-height[i++]);
            else res += (rightMax-height[j--]);
        }

        return res;
    }
}
