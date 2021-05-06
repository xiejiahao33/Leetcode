package 哈希表;

import java.util.Arrays;

/**
 * 描述
 这个题目说的是，给你两个字符串 s 和 t，你要写函数判断 t 是否为 s 的一个变位词。
 其中，字符串只由小写字母组成。变位词指的是使用相同字母以不同顺序构成的单词。

 比如说，给你的字符串 s 和 t 是：
 s = "eat"
 t = "tea"

 这两个字符串都是由 a/e/t 这三个字母构成，因此 t 是 s 的一个变位词。
 如果 s 和 t 改成：

 s = "eat"
 t = "ten"

 "ten" 中的字符 n 不存在于字符串 s 中。因此，它不是 s 的一个变位词。
 */
public class _242变位词校验 {


    // Time: O(n*log(n)), Space: O(n)
    public boolean isAnagram(String s, String t) {

        if(s.length()!=t.length() || s==null || t==null ) return false;
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        for (int i = 0; i <s.length() ; i++) {
            if(sc[i]!=tc[i]) return false;
        }



        return true;
    }

    // Time: O(n), Space: O(1)
    public boolean isAnagramO1(String s, String t) {
        if(s.length()!=t.length() || s==null || t==null) return false;

        int[] arr = new int[26];

        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
            arr[t.charAt(i)-'a']--;
        }

        for(int i=0;i<26;i++){
            if(arr[i]!=0) return false;
        }

        return true;
    }
}
