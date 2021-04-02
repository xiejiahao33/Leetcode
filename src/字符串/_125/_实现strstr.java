package 字符串._125;


/**
 * 比如说，给你的两个字符串分别是：

 marvel studio 和 studio

 第二个字符串存在于第一个字符串中，于是你要返回它在第一个字符串中的开始下标 7。

 再比如说给你的字符串是：

 doctor strange 和 master

 第二个字符串没有在第一个字符串中出现，因此返回 -1。
 */
public class _实现strstr {
    public int strStr(String haystack, String needle) {
        if(haystack==null || needle==null) return -1;
        if(needle.length()==0) return 0;
        int m = haystack.length();//字符串1的长度
        int n = needle.length(); //字符串2的长度
        for (int i=0;i<=m-n;++i){ //遍历字符串1
            int j=0,k=i; //这里的j是用来遍历字符串2,k则是从字符串1当前位置开始遍历一个字符串2的长度
            for (;j<n && k<m && haystack.charAt(k)==needle.charAt(j); ++j, ++k); //遍历得到j的长度
            if(j==needle.length()) return i; //判断长度相等则是找到了字符串
        }

        return -1;
    }
}
