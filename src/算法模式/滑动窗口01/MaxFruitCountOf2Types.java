package 算法模式.滑动窗口01;


import java.util.HashMap;
import java.util.Map;

/**
 * 在一排树中，第 i 棵树产生 tree[i] 型的水果。
 你可以从你选择的任何树开始，然后重复执行以下步骤：

 把这棵树上的水果放进你的篮子里。如果你做不到，就停下来。
 移动到当前树右侧的下一棵树。如果右边没有树，就停下来。
 请注意，在选择一颗树后，你没有任何选择：你必须执行步骤 1，然后执行步骤 2，然后返回步骤 1，然后执行步骤 2，依此类推，直至停止。

 你有两个篮子，每个篮子可以携带任何数量的水果，但你希望每个篮子只携带一种类型的水果。

 用这个程序你能收集的水果树的最大总量是多少？

 Input: Fruit=['A', 'B', 'C', 'A', 'C']
 Output: 3
 Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']


 Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
 Output: 5
 Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
 This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']

 */
public class MaxFruitCountOf2Types {

    //O(N)  O(1)-->space map存储水果的类别
    public static int findLength(char[] arr){
        if(arr==null || arr.length==0) return 0;
        int windowStart=0,maxLength=0;
        Map<Character,Integer> charFrequencyMap = new HashMap<>();

        //扩展范围[windowStart，windowEnd]
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            char rightChar = arr[windowEnd];
            charFrequencyMap.put(rightChar,charFrequencyMap.getOrDefault(rightChar,0)+1);

            //缩小滑动窗口，直到在map中剩下2个不同的字符为止
            while (charFrequencyMap.size()>2){
                char leftChar = arr[windowStart];
                charFrequencyMap.put(leftChar,charFrequencyMap.get(leftChar)-1);
                if(charFrequencyMap.get(leftChar)==0){
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++;
            }

            maxLength = Math.max(maxLength,windowEnd-windowStart+1);
        }

        return maxLength ;
    }

    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " + MaxFruitCountOf2Types.findLength(new char[]{'A','B','C','A','C'}));
        System.out.println("Maximum number of fruits: " + MaxFruitCountOf2Types.findLength(new char[]{'A','B','C','B','B','C'}));
    }
}
