package 排序算法;


/*
稳定排序 Time: O(n^2), Space: O(1)
插入排序是一种简单直观的排序算法。这个算法把数组分为有序区和无序区，、。
每次都从无序区中拿出一个元素，插入到有序区正确的位置上，使有序区保持有序。
不断重复这个操作，直到整个数组都有序。
 */


public class _插入排序 {

    public void sort(int[] arr){

        if (arr==null || arr.length==0) return;


        for (int i = 1; i <arr.length ; i++) {
            // 无序区第一个元素
            int cur = arr[i];
            //有序区最后一个元素
            int j = i-1;
            //有序区的元素比无序区大，则不断把有序区元素后移。
            while (j>=0 && arr[j]>cur){
                arr[j+1]  = arr[j];
                --j; //继续扫描有序区
            }
            arr[j+1] = cur; //插入元素
        }
    }


    public static void main(String[] args) {
        int [] test = {9,4,1,2,10,3};

        _插入排序 t1 = new _插入排序();
        t1.sort(test);
        for (int i = 0; i <test.length ; i++) {
            System.out.println(test[i]);
        }

    }
}
