package 动态规划;

public class _最长上升连续子序列 {
    int res = 0;//全局变量,记录最后结果

    void help(int[] A){
        int [] f = new int[A.length];
        int i;
        for (i=0;i<A.length;++i){
            f[i] =1 ;

            if(i>0 && A[i-1] < A[i]){
                f[i]  = f[i-1] + 1;
            }

            if(f[i]>res) res = f[i];
        }
    }


    public int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here

        if(A.length==0 || A==null) return 0;


        help(A);

        int i,j,t;
        i = 0;
        j = A.length-1;
        while (i<j){
            t = A[i];
            A[i] = A[j];
            A[j] = t;
            ++i;
            --j;
        }


        help(A);




        return res;
    }
}
