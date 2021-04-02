package 排序算法;

/** 稳定排序 Time: O(n*log(n)), Space: O(n)
 * 归并排序是由冯·诺伊曼提出的一种基于分治思想的高效排序算法
 * 它的算法思想是，把当前序列平分成两个子序列，
 * 然后递归地对子序列进行排序，最后把排序好的子序列再合并成一个有序的序列。
 */
public class _归并排序 {


    //辅助函数 合并2个有序数组 [low,mid] [mid+1,high]
    private void merge(int[] arr,int low ,int mid ,int high , int[] tmp){
        int i = low, j = mid+1,k=0; //k是tmp复制数组的索引下标
        while (i<=mid && j<=high){
            if(arr[i]<=arr[j]) tmp[k++] = arr[i++];
            else tmp[k++] = arr[j++];
        }
        //数组可能还没合并完
        while (i<=mid) tmp[k++] = arr[i++];
        while (j<=high) tmp[k++] = arr[j++];

        System.arraycopy(tmp,0,arr,low,k);
    }


    private void mergeSort(int[] arr,int low, int high,int[] tmp){
        if(low<high){
            int mid = low + (high-low)/2;
            mergeSort(arr,low,mid,tmp);
            mergeSort(arr,mid+1,high,tmp);
            merge(arr,low,mid,high,tmp);
        }
    }

    public void sortRecursive(int[] arr){
        if (arr==null || arr.length==0) return;;
        int [] tmp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,tmp);
    }

    public static void main(String[] args) {
        int [] test = {9,4,1,2,10,3,-5,100,200,-41,1,56,24,100};

        _归并排序 t1 = new _归并排序();
        t1.sortRecursive(test);
        for (int i = 0; i <test.length ; i++) {
            System.out.println(test[i]);
        }

    }
}
