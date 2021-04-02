package pat;

import java.util.Scanner;

public class _1001害死人不偿命的猜想 {



    public static boolean help(int n){
        if (n %2==0) return true;
        else return false;

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        while (n!=1){
            if(help(n)){
                n = n / 2 ;
            }else {
                n = (3*n+1) / 2;
            }

            count++;
        }

        System.out.println(count);
     }
}
