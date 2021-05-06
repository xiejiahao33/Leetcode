package 剑指offer;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、
 * "0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 */
public class _20表示数值的字符串 {

    public boolean isNumber(String s) {
        s  = s.trim();
        if(s.length()==0) return false;
        if(s.charAt(0)=='+' || s.charAt(0)=='-'){
            s  = s.substring(1);
        }

        s = s.replace('E','e');
        if(s.indexOf('e')>=0){
            int inxP = s.indexOf('e');
            String first = s.substring(0,inxP);
            String second= s.substring(inxP+1);
            if(second.length()>0){
                if(second.charAt(0)=='+' || second.charAt(0)=='-'){
                    second = second.substring(1);
                }
            }
            return validNumber(first) && validPureNumber(second);
        }
        return validNumber(s);
    }

    private boolean validNumber(String s){
        if(s.indexOf('.')>=0){
            int inxP = s.indexOf('.');
            String first = s.substring(0,inxP);
            String second= s.substring(inxP+1);
            if(first.length()>0 && second.length() >0){
                return  validPureNumber(first) && validPureNumber(second);
            }else if(second.length()>0){
                return validPureNumber(second);
            }else {
                return validPureNumber(first);
            }
        }
        return validPureNumber(s);
    }

    private boolean validPureNumber(String s){
        if(s.length()==0) return  false;
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i) <'0' || s.charAt(i) >'9') return false;
        }

        return true;
    }
}
