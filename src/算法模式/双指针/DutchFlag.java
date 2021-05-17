package 算法模式.双指针;


/**
给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 Input: [1, 0, 2, 1, 0]
 Output: [0 0 1 1 2]

 Input: [2, 2, 0, 1, 2, 0]
 Output: [0 0 1 2 2 2 ]

 */
public class DutchFlag {
    public static  void sortColors(int[] nums) {
        int low = 0,high = nums.length-1;
        for (int i = 0; i <=high;) {
            if(nums[i]==0){
                swap(nums,i,low);
                i++;
                low++;
            }
            else if (nums[i]==1){
                i++;
            }else {
                swap(nums,i,high);
                high--;
            }
        }
    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int [] arr = new int[] {2,2,0,1,2,0};
        // 0 2 0 1 2 2
        //
        DutchFlag.sortColors(arr);
        for (int num: arr) {
            System.out.println(num);
        }
    }
}
