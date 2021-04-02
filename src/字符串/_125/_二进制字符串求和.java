package 字符串._125;

/**
 * 比如说，给你的两个字符串是：

 "1101"
 "111"

 它们求和后的二进制字符串是 "10100"。
 */

public class _二进制字符串求和 {
    public String addBinary(String a, String b) {
        int i = a.length()-1,j=b.length()-1,carry=0;//carry保存进位
        StringBuilder sb = new StringBuilder();//保存结果
        while (i>=0 || j>=0 || carry!=0){
            int sum = carry;
            if(i>=0) sum+=(a.charAt(i--)-'0');
            if(j>=0) sum+=(b.charAt(j--)-'0');
            sb.append(sum%2);
            carry = sum /2 ;
        }

        return  sb.reverse().toString();
    }

}
