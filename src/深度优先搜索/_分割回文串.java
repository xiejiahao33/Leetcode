package 深度优先搜索;

import java.util.List;

/**
 * 给定字符串 s, 需要将它分割成一些子串, 使得每个子串都是回文串.
 *
 * 返回所有可能的分割方案.
 *
 * 样例
 * 样例 1:
 *
 * 输入: "a"
 * 输出: [["a"]]
 * 解释: 字符串里只有一个字符, 也就只有一种分割方式 (就是它本身)
 * 样例 2:
 *
 * 输入: "aab"
 * 输出: [["aa", "b"], ["a", "a", "b"]]
 * 解释: 有两种分割的方式.
 *     1. 将 "aab" 分割成 "aa" 和 "b", 它们都是回文的.
 *     2. 将 "aab" 分割成 "a", "a" 和 "b", 它们全都是回文的.
 */
public class _分割回文串 {

    //第一种解法
    //辅助函数,判断是否是回文字符串
    private boolean isPalindrome(String s){
        for (int i=0,j=s.length()-1;i<j;i++,j--){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;
    }

    private void dfs(String s,int startIndex,List<String> partition){

    }

    public List<List<String>> partition(String s) {
        // write your code here



        return null;
    }
}
