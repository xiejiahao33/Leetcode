package 算法模式.滑动窗口01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
输入:
s: "cbaebabacd" p: "abc"

输出:
[0, 6]

解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。

 输入:
 s: "abab" p: "ab"

 输出:
 [0, 1, 2]
 解释:
 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 */
//和Permutation in a String 比较类似 修改部分代码即可
public class StringAnagrams {

    public static List<Integer> findStringAnagrams(String str,String pattern){
        if(str==null || str.length()==0 || pattern==null || str.length()<pattern.length()) return new ArrayList<>();
        int windowStart=0,matched=0;
        Map<Character,Integer> charFrequencyMap = new HashMap<>();

        for (char c:pattern.toCharArray()) {
            charFrequencyMap.put(c,charFrequencyMap.getOrDefault(c,0)+1);
        }


        List<Integer> resultIndices = new ArrayList<Integer>();

        for (int windowEnd = 0; windowEnd <str.length() ; windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if(charFrequencyMap.containsKey(rightChar)){
                charFrequencyMap.put(rightChar,charFrequencyMap.get(rightChar)-1);
                if(charFrequencyMap.get(rightChar)==0) matched++;
            }

            if(matched==charFrequencyMap.size()) resultIndices.add(windowStart);

            if(windowEnd>=pattern.length()-1){
                char leftChar = str.charAt(windowStart++);

                if(charFrequencyMap.containsKey(leftChar)){
                    if(charFrequencyMap.get(leftChar)==0) matched--;

                    charFrequencyMap.put(leftChar,charFrequencyMap.get(leftChar)+1);
                }

            }
        }




        return resultIndices;
    }

    public static void main(String[] args) {

        System.out.println("Length of the longest subtring: "+StringAnagrams.findStringAnagrams("ppqp","pq"));
        System.out.println("Length of the longest subtring: "+StringAnagrams.findStringAnagrams("abbcabc","abc"));
    }
}
