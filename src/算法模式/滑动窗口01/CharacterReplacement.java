package 算法模式.滑动窗口01;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。

 注意：字符串长度 和 k 不会超过 104。

 输入：s = "ABAB", k = 2
 输出：4
 解释：用两个'A'替换为两个'B',反之亦然。

 输入：s = "AABABBA", k = 1
 输出：4
 解释：
 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 子串 "BBBB" 有最长重复字母, 答案为 4

 */
public class CharacterReplacement {

    public static int findLength(String str,int k){
        if(str==null || str.length()==0) return 0;
        int windowStart =0,maxLength=0,maxRepeatLetterCount=0;

        //记录字符出现频率
        Map<Character,Integer> letterFrequencyMap = new HashMap<>();

        //扩展范围[windowStart，windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            letterFrequencyMap.put(rightChar,letterFrequencyMap.getOrDefault(rightChar,0)+1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount,letterFrequencyMap.get(rightChar));

            //当前的window是从start--->end, 其中有char重复了maxRepeatLetterCount
            //其他的char应该被替代，如果其他的char数量大于k，则需要缩小窗口
            if(windowEnd-windowStart+1-maxRepeatLetterCount > k){
                System.out.println("开始缩小窗口 "+ windowStart + letterFrequencyMap);
                char leftChar =str.charAt(windowStart);
                letterFrequencyMap.put(leftChar,letterFrequencyMap.get(leftChar)-1);
                windowStart++;
            }

            maxLength = Math.max(maxLength,windowEnd-windowStart+1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest subtring: "+CharacterReplacement.findLength("aabccbb",1));
        //System.out.println("Length of the longest subtring: "+CharacterReplacement.findLength("abbcb",1));
        //System.out.println("Length of the longest subtring: "+CharacterReplacement.findLength("abccde",1));
    }
}
