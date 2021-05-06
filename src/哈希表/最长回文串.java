package 哈希表;


/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。

 输入:
 "abccccdd"

 输出:
 7

 解释:
 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */

/**
 * 贪心算法思路
 * 1：记录每个字符串出现次数
 * 2：每一次把成对的字符（出现次数是偶数）放在前面和后面
 * 3：如果依旧存在单字符，放在中间
 */
public class 最长回文串 {
    public int longestPalindrome(String s) {

        if(s.length()==0 || s == null) return 0;

        int [] count = new int[128];

        for (int i = 0; i <s.length() ; i++) {
            count[s.charAt(i)] ++ ;
        }

        int res = 0;

        for (int i: count) {
            res += i/2 * 2;

            if(res %2 ==1 && i%2==1){
                res++;
            }
        }

        return res;
    }
}
