package 算法模式.区间合并;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi]
 * 而secondList[j] = [startj, endj] 。每个区间列表都是成对 不相交 的，并且 已经排序 。
 *
 * 返回这 两个区间列表的交集 。
 *
 * 形式上，闭区间[a, b]（其中a <= b）表示实数x的集合，而a <= x <= b 。
 *
 * 两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。
 *
 *Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
 * Output: [2, 3], [5, 6], [7, 7]
 * Explanation: The output list contains the common intervals between the two lists.
 *
 *
 * Input: arr1=[[1, 3], [5, 7], [9, 12]], arr2=[[5, 10]]
 * Output: [5, 7], [9, 10]
 * Explanation: The output list contains the common intervals between the two lists.
 *
 */
public class _区间列表的交集 {
    public static Interval[] merge(Interval[] arr1,Interval[] arr2){
        //结果数组
        List<Interval> intervalsIntersection = new ArrayList<>();
        //遍历2个数组的指针
        int i=0,j=0;
        while (i<arr1.length && j < arr2.length){
            if((arr1[i].start >= arr2[j].start && arr1[i].start<=arr2[j].end)
            || (arr2[j].start >= arr1[i].start && arr2[j].start<=arr1[i].end)){
                intervalsIntersection.add(new Interval(Math.max(arr1[i].start,arr2[j].start),Math.min(arr1[i].end,arr2[j].end)));
            }
            if (arr1[i].end < arr2[j].end)
                i++;
            else
                j++;
        }
        return intervalsIntersection.toArray(new Interval[intervalsIntersection.size()]);
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i=0,j=0;

        while (i<firstList.length && j < secondList.length){
            //记录数组区间开端最大值,终端的最小值
            int start = Math.max(firstList[i][0],secondList[j][0]);
            int end =  Math.min(firstList[i][1],secondList[j][1]);

            //如果开端最大值小于等于终端最小值，说明存在交集
            if(start<=end){
                res.add(new int[]{start,end});
            }

            if(firstList[i][1] < secondList[j][1])
                i++;
            else
                j++;
        }

        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        Interval[] input1 = new Interval[] {new Interval(1,3),new Interval(5,6),new Interval(7,9)};
        Interval[] input2 = new Interval[] {new Interval(2,3),new Interval(5,7)};
        Interval[] result = merge(input1,input2);
        for (Interval interval:result) {
            System.out.println("[" + interval.start + "," + interval.end + "]");
        }
    }
}
