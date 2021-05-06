package 哈希表;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *设计b并实现一个 TwoSum 类。他需要支持以下操作:add 和 find。
 add -把这个数添加到内部的数据结构。
 find -是否存在任意一对数字之和等于这个值
 */
public class _170_两数之和数据结构 {
//    /**
//     * @param number: An integer
//     * @return: nothing
//     */
//
//    private  ArrayList<Integer> arr = new ArrayList<>();
//
//
//    //O(1)
//    public void add(int number) {
//        // write your code here
//        arr.add(number);
//    }
//
//    /**
//     * @param value: An integer
//     * @return: Find if there exists any pair of numbers which sum is equal to the value.
//     */
//    //O(N)
//    public boolean find(int value) {
//        // write your code here
//
//        Set<Integer> set = new HashSet<>();
//
//        for (int num: arr) {
//            if(set.contains(value-num)) return true;
//            set.add(num);
//        }
//
//        return false;
//    }


    //如果大量的find操作，则用如下实现
    private List<Integer> arr = new ArrayList<>();

    private  HashSet<Integer>   set = new HashSet<>();


    public void add(int number) {
        // write your code here
        for (int num:arr){
            set.add(num+number);
        }
        arr.add(number);
    }

        public boolean find(int value) {

        if(set.contains(value)){
            return true;
        }else {
            return false;
        }
    }
}
