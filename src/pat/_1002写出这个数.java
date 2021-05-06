package pat;

import java.util.Scanner;



public class _1002写出这个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char [] sArr = s.toCharArray();
        String[] nian= {"ling","yi","er","san","si","wu","liu","qi","ba","jiu"};
        int sum = 0;
        for (int i = 0; i <sArr.length ; i++) {
            sum+=sArr[i]-'0';
        }

        String res = sum+"";//"135"
        char[] resArr = res.toCharArray();
        for (int i = 0; i <resArr.length ; i++) {
            if(i!=res.length()-1){
                System.out.print(nian[resArr[i]-'0'] + " ");
            }else{
                System.out.print(nian[resArr[i]-'0']);
            }

        }


    }
}
