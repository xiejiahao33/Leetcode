package 算法模式.滑动窗口01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * Input: String="aabccbb"
 Output: 3
 Explanation: The longest substring without any repeating characters is "abc".

 Input: String="abbbb"
 Output: 2
 Explanation: The longest substring without any repeating characters is "ab".


 Input: String="abccde"
 Output: 3
 Explanation: Longest substrings without any repeating characters are "abc" & "cde".


 */
public class NoRepeatSubString {
    public static int findLength(String  str){
            //解法1
//        if(str==null || str.length()==0) return 0;
//        int[] index = new int[256]; //记录字符最后出现的位置
//        Arrays.fill(index,-1);
//        int maxLen = 0;
//        for (int i = 0,j=0; j < str.length(); j++) {
//            i = Math.max(index[str.charAt(j)]+1,i);
//            maxLen = Math.max(maxLen,j-i+1);
//            index[str.charAt(j)]=j;
//        }

        //解法2  与解法1本质上是一样的，上面是数组，这边是HashMap
        if(str==null || str.length()==0) return 0;
        int windowStart =0,maxLength=0;
        Map<Character,Integer> charIndexMap = new HashMap<>();

        //扩展范围[windowStart，windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);

            //如果已经存在当前字符，缩小窗口方位
            if(charIndexMap.containsKey(rightChar)){

                //更新窗口start的位置，跳过rightChar在map中第一次出现的位置
                windowStart = Math.max(charIndexMap.get(rightChar)+1,windowStart);
            }
            //记录字符出现的最后一次的位置
            charIndexMap.put(rightChar,windowEnd);
            maxLength = Math.max(maxLength,windowEnd-windowStart+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest subtring: "+NoRepeatSubString.findLength("aabccbb"));
        System.out.println("Length of the longest subtring: "+NoRepeatSubString.findLength("abbbb"));
        System.out.println("Length of the longest subtring: "+NoRepeatSubString.findLength("abccde"));
    }
}
