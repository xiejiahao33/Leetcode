package 算法模式.双指针;

/**
 *
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
   注意：如果对空文本输入退格字符，文本继续为空。

 输入：S = "ab#c", T = "ad#c"
 输出：true
 解释：S 和 T 都会变成 “ac”。


 输入：S = "ab##", T = "c#d#"
 输出：true
 解释：S 和 T 都会变成 “”。

 输入：S = "a##c", T = "#a#c"
 输出：true
 解释：S 和 T 都会变成 “c”。

 输入：S = "a#c", T = "b"
 输出：false
 解释：S 会变成 “c”，但 T 仍然是 “b”。

 */
public class BackspaceCompare {

    public static boolean backspaceCompare(String s, String t) {

        int index1 = s.length()-1,index2=t.length()-1;

        while (index1>=0 || index2 >=0){
            int i1 = getNextValidCharIndex(s,index1);
            int i2 = getNextValidCharIndex(t,index2);

            if(i1<0 && i2<0) return true;
            if(i1<0 || i2<0) return false;

            if(s.charAt(i1)!=t.charAt(i2)) return false;

            index1 = i1-1;
            index2 = i2-1;
        }

        return true;
    }

    private static int getNextValidCharIndex(String str,int index){
        int backspaceCount = 0;
        while (index>=0){
            if(str.charAt(index)=='#'){
                backspaceCount++;
            }else if(backspaceCount>0){
                backspaceCount--;
            }else break;

            index--;
        }
        return index;
    }


    public static void main(String[] args) {
        System.out.println(BackspaceCompare.backspaceCompare("xy#z","xzz#"));
        System.out.println(BackspaceCompare.backspaceCompare("xy#z","xyz#"));
        System.out.println(BackspaceCompare.backspaceCompare("xp#","xyz##"));
        System.out.println(BackspaceCompare.backspaceCompare("xywrrmp","xywrrmu#p"));
    }

}
