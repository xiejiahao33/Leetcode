package 动态规划;


/**
 * 划分型动态规划
 *
 */
public class _解码方法 {
    public int numDecodings(String ss) {
        char[] s = ss.toCharArray();
        int n = s.length;
        if(n==0) return 0;
        int [] f = new int[n+1]; //记录结果
        f[0] = 1;

        for(int i =1;i<=n;i++){
            f[i] = 0; //初始化

            int t = s[i-1] - '0';//字符的数字表示
            if(t>=1 && t <=9){
                f[i]+=f[i-1];
            }

            //字符串长度大于2的时候，需要考虑最后和倒数第二个字符的组合
            if(i>=2){
                //倒数2个数字
                t   = (s[i-2] - '0') * 10 + (s[i-1]-'0');
                if(t>=10 && t <=26)
                    f[i] += f[i-2];
            }
        }

        return f[n];
    }
}
