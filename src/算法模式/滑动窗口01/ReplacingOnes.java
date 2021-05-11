package 算法模式.滑动窗口01;


/**
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 返回仅包含 1 的最长（连续）子数组的长度。

 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 输出：6
 解释：
 [1,1,1,0,0,1,1,1,1,1,1]
 粗体数字从 0 翻转到 1，最长的子数组长度为 6。

 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 输出：10
 解释：
 [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 */

public class ReplacingOnes {


    //time-->O(n)   space--->O(1)
    public static int findLength(int[] arr,int k){
        if(arr==null || arr.length==0) return 0;
        int windowStart=0,onesCount=0,maxLength=0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            if(arr[windowEnd]==1) onesCount++;

            //缩小窗口size
            while (windowEnd-windowStart+1-onesCount>k){
                if (arr[windowStart]==1) onesCount--;
                windowStart++;
            }
            maxLength = Math.max(maxLength,windowEnd-windowStart+1);
        }


        return maxLength;
    }


    public static void main(String[] args) {
        System.out.println(ReplacingOnes.findLength(new int[]{0,1,1,0,0,0,1,1,0,1,1},2));
        System.out.println(ReplacingOnes.findLength(new int[]{0,1,0,0,1,1,0,1,1,0,0,1,1},3));
    }
}
