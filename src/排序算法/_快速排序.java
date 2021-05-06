package 排序算法;


/**
 * 快速排序是由东尼·霍尔提出的一种高效的排序算法，简称快排。它的算法思想并不复杂，
 * 可以用 3 个步骤 6 个字来概括：选基、分割、递归。
 * 扩充成一句话就是：首先挑选基准值；然后分割数组，把小于基准值的元素放到基准值前面，
 * 大于基准值的元素放到基准值后面；最后递归地对小于基准值的子序列和大于基准值的子序列进行排序。
 */
public class _快速排序 {

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    private int lomutoPartition(int[] arr,int low,int high){
        int pivot = arr[high];
        int i = low;
        for (int j = low;j<high;++j){
            if(arr[j]<pivot) {
                swap(arr,i,j);
                ++i;
            }
        }

        swap(arr,i,high);

        return i;
    }

    private void lomutoSort(int[] arr, int low, int high){
        if(low<high){
            int k = lomutoPartition(arr,low,high);
            lomutoSort(arr,low,k-1);
            lomutoSort(arr,k+1,high);
        }
    }

    public void lomutoSort(int[] arr) {
        if (arr==null || arr.length==0) return;
        lomutoSort(arr,0,arr.length-1);
    }

}
