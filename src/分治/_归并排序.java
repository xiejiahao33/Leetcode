package 分治;


/**
 * 归并排序是由冯·诺伊曼提出的一种基于分治思想的高效排序算法。
 * 它的算法思想是：
 * 把当前序列平分成两个子序列
 * 然后递归地对子序列进行排序
 * 最后把排序好的子序列再合并成一个有序的序列
 *
 */
public class _归并排序 {



    private static void showArray(int[] num) {
        for(int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
    }


    //合并2个数组并拷贝到原数组
    private void merge(int[] arr,int low,int mid, int high, int[] tmp){
        int i = low , j = mid+1,k=0; // i代表第一个数组开始索引，j代表第二个数组开始索引
        while (i<=mid && j<=high){
            if(arr[i]<=arr[j]) tmp[k++] = arr[i++];
            else tmp[k++] = arr[j++];
        }
        while (i<=mid)  tmp[k++] = arr[i++]; //第一个数组还没索引完
        while (j<=high) tmp[k++] = arr[j++];
        System.arraycopy(tmp,0,arr,low,k);
    }

    private void mergeSort(int[] arr,int low, int high,int[] tmp){
        if(low<high){
            int mid = low  + (high-low )/2;
            mergeSort(arr,low,mid,tmp);
            mergeSort(arr,mid+1,high,tmp);
            merge(arr,low,mid,high,tmp);
        }
    }
    public void sortRecursive(int[] arr){
        if(arr==null || arr.length==0) return;
        int[] tmp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,tmp);

    }

    public void sortIterative(int[] arr){
        if (arr == null || arr.length == 0) return;
        int n = arr.length;
        int[] tmp = new int[n];
        for (int len = 1; len < n; len = 2*len) {
            for (int low = 0; low < n; low += 2*len) {
                int mid = Math.min(low+len-1, n-1);
                int high = Math.min(low+2*len-1, n-1);
                merge(arr, low, mid, high, tmp);
            }
        }
    }



    public static void main(String[] args) {
        int[] num = {23, 64, 15, 3, 93, 30, 51, 28, 49, 66};

        System.out.println("排序前： ");
        showArray(num);

        _归并排序 test = new _归并排序();
        test.sortIterative(num);

        System.out.println("排序后： ");
        showArray(num);

    }

}
