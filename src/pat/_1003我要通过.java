package pat;

import java.util.Scanner;

public class _1003我要通过 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str[] = new String[n];
        for (int i = 0; i <n ; i++) {
            str[i] = sc.next();
        }

        for (int i = 0; i < n; i++) {
            help(str[i]);
        }

    }

    public  static  void  help(String s ){
        int p=0,t=0; //记录P和T的索引
        int NumP=0,NumA=0,NumT=0;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == 'P') {
                NumP++;
                p = j;
            }
            if (s.charAt(j) == 'T') {
                NumT++;
                t = j;
            }

            if(s.charAt(j)=='A'){
                NumA++;
            }

        }

        if(NumA+NumP+NumT==s.length()&&NumP==1&& NumT ==1 && NumA!=0 && t-p!=1&&p*(t-p-1)==s.length()-t-1){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }

}
