package 算法模式.区间合并;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10]重叠。
 *
 输入：intervals = [], newInterval = [5,7]
 输出：[[5,7]]
 *
 *
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 *
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 *
 */
public class _插入区间 {
    public static List<Interval> insert(List<Interval> intervals,Interval newIntervals) {
        if(intervals==null || intervals.isEmpty()) return Arrays.asList(newIntervals);

        List<Interval> mergedIntervals = new ArrayList<>();

        //记录遍历intervals的“下标”
        int i =0;
        while (i<intervals.size() && intervals.get(i).end < newIntervals.start){
            mergedIntervals.add(intervals.get(i++));
        }

        while (i<intervals.size() && intervals.get(i).start <= newIntervals.end){
            newIntervals.start=Math.min(newIntervals.start,intervals.get(i).start);
            newIntervals.end = Math.max(newIntervals.end,intervals.get(i).end);
            i++;
        }

        //这个大区间加入结果集
        mergedIntervals.add(newIntervals);

        //未遍历到的也加入结果集合
        while (i<intervals.size()){
            mergedIntervals.add(intervals.get(i++));
        }

        return mergedIntervals;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] tmp = new int[intervals.length+1][2];
        int size = 0,p=0;
        for (; p < intervals.length  && intervals[p][1]< newInterval[0]; ++p) {
            tmp[size++] = intervals[p];
        }

        for (;p < intervals.length  && intervals[p][0]<=newInterval[1]; ++p){
            newInterval[0] = Math.min(newInterval[0],intervals[p][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[p][1]);
        }

        tmp[size++] = newInterval;

        for (;p<intervals.length;p++){
            tmp[size++] = intervals[p];
        }

        return Arrays.copyOf(tmp,size);
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1,3));
        input.add(new Interval(5,7));
        input.add(new Interval(8,12));
        System.out.println("Merged intervals");
        for (Interval interval:insert(input,new Interval(4,6))) {
            System.out.println("[" + interval.start + "," + interval.end + "] ");
        }

        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(1,3));
        input.add(new Interval(5,7));
        input.add(new Interval(8,12));
        System.out.println("Merged intervals");
        for (Interval interval:insert(input,new Interval(4,10))) {
            System.out.println("[" + interval.start + "," + interval.end + "] ");
        }

        System.out.println();
    }
}
