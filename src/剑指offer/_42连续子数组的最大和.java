package 剑指offer;

public class _42连续子数组的最大和 {

    public int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE,cur = 0;

        for (int i = 0; i <nums.length ; i++) {
            cur = cur<=0? nums[i] : (cur+nums[i]);
            max = Math.max(max,cur);
        }


        return max;
    }


}
