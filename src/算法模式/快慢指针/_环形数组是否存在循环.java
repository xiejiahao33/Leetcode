package 算法模式.快慢指针;

/**
 *
 * 存在一个不含 0 的 环形 数组 nums ，每个 nums[i] 都表示位于下标 i 的角色应该向前或向后移动的下标个数：

 如果 nums[i] 是正数，向前 移动 nums[i] 步
 如果 nums[i] 是负数，向后 移动 nums[i] 步
 因为数组是 环形 的，所以可以假设从最后一个元素向前移动一步会到达第一个元素，而第一个元素向后移动一步会到达最后一个元素。


 输入：nums = [2,-1,1,2,2]
 输出：true
 解释：存在循环，按下标 0 -> 2 -> 3 -> 0 。循环长度为 3 。

 输入：nums = [-1,2]
 输出：false
 解释：按下标 1 -> 1 -> 1 ... 的运动无法构成循环，因为循环的长度为 1 。根据定义，循环的长度必须大于 1 。



 */
public class _环形数组是否存在循环 {
    public boolean circularArrayLoop(int[] nums) {

        for (int i = 0; i <nums.length ; i++) {
            boolean isForward = nums[i]>=0;
            int slow = i,fast = i;

            do {
                slow = findNextIndex(nums,isForward,slow);
                fast = findNextIndex(nums,isForward,fast);

                //快指针多走一步
                if(fast!=-1) fast = findNextIndex(nums,isForward,fast);

            }while (slow!=-1 && fast !=-1 && slow!=fast);

            if(slow!=-1 && slow==fast) return true;
        }



        return false;
    }


    private static int findNextIndex(int[] arr, boolean isForward,int currentIndex){
        boolean direction = arr[currentIndex] >=0;

        if(isForward !=direction) return -1;// 方向发生变化，直接返回

        int nextIndex = (currentIndex + arr[currentIndex]) % arr.length;

        if(nextIndex<0) nextIndex += arr.length;

        if(currentIndex==nextIndex) return -1 ;//防止单一元素循环

        return nextIndex;
    }

}
