package 排序算法;

/* 稳定排序   Time: O(n^2), Space: O(1)
冒泡排序的原理是，每一次遍历数组，都去不断地比较相邻的两个元素，如果它们的顺序不对，就交换这两个元素，
比如把较大的换到后面。第一次遍历可以把最大的元素确定下来，放在最后的位置。
第二次遍历可以确定第二大的元素，依次类推。
这样遍历 N 次后，整个数组就变成递增有序。
 */
public class _冒泡排序 {


    public void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void sort(int[] arr){

        if (arr==null || arr.length==0) return;

        int n = arr.length;
        for (int end = n-1; end>0; end--) {
            for (int i = 0; i <end; i++) {
                if(arr[i]>arr[i+1]){
                    swap(arr,i,i+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] test = {9,4,1,2,10,3};

        _冒泡排序 t1 = new _冒泡排序();
        t1.sort(test);
        for (int i = 0; i <test.length ; i++) {
            System.out.println(test[i]);
        }

    }
}
