package 剑指offer;


/**
 * 给你一个英文句子，你要翻转句子中单词的顺序。注意，句子中的标点视为单词的一部分。
 * 原始句子的开头和结尾可能包含多余的空格，并且相邻单词之间也可能有多个空格。
 * 在翻转单词顺序后，句子的开头和结尾不能包含多余的空格，并且相邻单词之间也只允许有一个空格。
 */
public class _58转单词顺序 {

    public String reverseWords(String s) {
        if(s==null || s.length()==0) return null;
        char[] str = s.toCharArray();
        int p=0,q=0,end = str.length-1;
        while (end>0 && str[end]==' ') --end;
        while (q<end){
            //记录单词开始的下标
            int start = p;
            //跳过空格
            while (q<=end && str[q]==' ') ++q;

            //拷贝单词
            while (q<=end && str[q]!=' ') str[p++] = str[q++];

            //反转一个单词
            reverse(str,start,p-1);

            if(q<=end) str[p++] = ' ';
        }

        reverse(str,0,p-1);

        return new String(str,0,p);
    }


    private void reverse(char[] str, int i ,int j ){
        for (;i<j;++i,--j){
            char tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
        }
    }
}
