package 排序算法;

import java.util.HashMap;
import java.util.Map;

/**
 * 堆排序是一种基于比较的排序算法。它的算法思想和选择排序相似，都是把数组分为有序区和无序区，
 * 每次都从无序区中取最大值或最小值放入有序区，
 * 直到整个数组有序。和选择排序的区别是，堆排序使用了一个二叉堆来组织无序区中的数据，
 * 以此减少从无序区中查找最值的时间。
 *二叉堆逻辑上是一棵完全二叉树，但实际上存储在一维数组中即可。
 *根据堆是最大堆还是最小堆的不同，具有不同的性质。在最大堆中，
 *树上任意节点的值都大于等于它的子节点。而在最小堆中，树上任意节点的值都小于等于它的子节点。
 */
public class _堆排序 {
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) {
        String s = "PATaaa";
        Map<Character, Integer> map = new HashMap<>();

        for (int j = 0; j < s.length(); j++) {
            if (!map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), 1);
            } else {
                map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
            }

        }

        for(Character key: map.keySet()){
            System.out.println(key + "：" + map.get(key));
        }



    }

}
