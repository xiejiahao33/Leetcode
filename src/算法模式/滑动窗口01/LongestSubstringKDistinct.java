package 算法模式.滑动窗口01;


import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请找到其中最长的子字符串的长度，且最多包含K个不同的字符。
 * 您可以假定K小于或等于给定字符串的长度。
 *
 * Input: String="araaci", K=2
 Output: 4
 Explanation: The longest substring with no more than '2' distinct characters is "araa".

 Input: String="araaci", K=1
 Output: 2
 Explanation: The longest substring with no more than '1' distinct characters is "aa".


 Input: String="cbbebi", K=3
 Output: 5
 Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".

 */
public class LongestSubstringKDistinct {

    //O(N)-->time  O(K)--->space
    public static int findLength(String str, int k) {
        if(str==null || str.length()==0 || str.length()<k) return 0;
        int windowStart=0,maxLength=0;
        Map<Character,Integer> charFrequencyMap = new HashMap<>();

        //扩展范围[windowStart，windowEnd]
        for (int windowEnd = 0; windowEnd <str.length(); windowEnd++) {
            char rigthChar = str.charAt(windowEnd);
            charFrequencyMap.put(rigthChar,charFrequencyMap.getOrDefault(rigthChar,0)+1);

            //缩小滑动窗口，直到在map中剩下'k'个不同的字符为止
            while (charFrequencyMap.size()>k){
                char leftChar = str.charAt(windowStart);
                charFrequencyMap.put(leftChar,charFrequencyMap.get(leftChar)-1);
                if(charFrequencyMap.get(leftChar)==0){
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++;//缩小window
            }
            maxLength = Math.max(maxLength,windowEnd-windowStart+1);//记住到目前为止的最大长度
        }
        return maxLength;
    }


    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }
}
