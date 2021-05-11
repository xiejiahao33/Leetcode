package 算法模式.滑动窗口01;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。

 换句话说，第二个字符串的排列之一是第一个字符串的 子串 。

 Input: String="odicf", Pattern="dc"
 Output: false
 Explanation: No permutation of the pattern is present in the given string as a substring.


 Input: String="oidbcaf", Pattern="abc"
 Output: true
 Explanation: The string contains "bca" which is a permutation of the given pattern.

 Input: String="bcdxabcdy", Pattern="bcdyabcdx"
 Output: true
 Explanation: Both the string and the pattern are a permutation of each other.

 Input: String="aaacb", Pattern="abc"
 Output: true
 Explanation: The string contains "acb" which is a permutation of the given pattern.


 Create a HashMap to calculate the frequencies of all characters in the pattern.
 Iterate through the string, adding one character at a time in the sliding window.
 If the character being added matches a character in the HashMap, decrement its frequency in the map.
 If the character frequency becomes zero, we got a complete match.
 If at any time, the number of characters matched is equal to the number of distinct characters in the pattern (i.e., total characters in the HashMap), we have gotten our required permutation.
 If the window size is greater than the length of the pattern, shrink the window to make it equal to the size of the pattern.
 At the same time, if the character going out was part of the pattern, put it back in the frequency HashMap.
 */
public class StringPermutation {

    public static boolean findPermutation(String str,String pattern){
        if(str==null || str.length()==0 || pattern==null || str.length()<pattern.length()) return false;
        int windowStart=0,matched=0;
        Map<Character,Integer> charFrequencyMap = new HashMap<>();

        for (char c:pattern.toCharArray()) {
            charFrequencyMap.put(c,charFrequencyMap.getOrDefault(c,0)+1);
        }

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if(charFrequencyMap.containsKey(rightChar)){
                charFrequencyMap.put(rightChar,charFrequencyMap.get(rightChar)-1);

                if(charFrequencyMap.get(rightChar)==0) matched++;
            }

            if(matched==charFrequencyMap.size()) return true;

            if(windowEnd>=pattern.length()-1){
                char leftChar = str.charAt(windowStart++);
                if(charFrequencyMap.containsKey(leftChar)){
                    if(charFrequencyMap.get(leftChar)==0) matched--;

                    charFrequencyMap.put(leftChar,charFrequencyMap.get(leftChar)+1);
                }
            }
        }


        return false;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest subtring: "+StringPermutation.findPermutation("oidbcaf","abc"));
        System.out.println("Length of the longest subtring: "+StringPermutation.findPermutation("odicf","dc"));
        System.out.println("Length of the longest subtring: "+StringPermutation.findPermutation("bcdxabcdy","bcdyabcdx"));
        System.out.println("Length of the longest subtring: "+StringPermutation.findPermutation("aaacb","abc"));
    }
}
