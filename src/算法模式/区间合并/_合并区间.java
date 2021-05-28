package 算法模式.区间合并;

import java.util.*;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 */

class Interval{
    int start;
    int end;

    public Interval(int start,int end){
        this.start = start;
        this.end = end;
    }
}
public class _合并区间 {

    public static List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()<2) return intervals;
        Collections.sort(intervals,(a,b)->Integer.compare(a.start,b.start));

        List<Interval> mergedIntervals = new LinkedList<Interval>();
        Iterator<Interval> intervalIterator = intervals.iterator();
        Interval interval = intervalIterator.next();
        int start = interval.start;
        int end = interval.end;

        while (intervalIterator.hasNext()){
            interval = intervalIterator.next();
            if(interval.start<=end){
                end = Math.max(interval.end,end);
            }else {
                mergedIntervals.add(new Interval(start,end));
                start = interval.start;
                end = interval.end;
            }
        }
        mergedIntervals.add(new Interval(start,end));
        return mergedIntervals;
    }


    public int[][] merge(int[][] intervals) {
        int[][] result = new int[intervals.length][2];
        int size = 0;
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);

        for (int[] in:intervals) {
            if(size==0 || result[size-1][1] < in[0]){
                result[size][0] = in[0];
                result[size][1] = in[1];
                size++;
            }else {
                result[size-1][1] = Math.max(result[size-1][1],in[1]);
            }
        }
        return Arrays.copyOf(result,size);
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1,4));
        input.add(new Interval(2,5));
        input.add(new Interval(7,9));
        System.out.println("Merged intervals");
        for (Interval interval:merge(input)) {
            System.out.println("[" + interval.start + "," + interval.end + "] ");
        }

        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(6,7));
        input.add(new Interval(2,4));
        input.add(new Interval(5,9));
        System.out.println("Merged intervals");
        for (Interval interval:merge(input)) {
            System.out.println("[" + interval.start + "," + interval.end + "] ");
        }

        System.out.println();
    }
}
