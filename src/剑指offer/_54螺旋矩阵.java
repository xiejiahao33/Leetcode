package 剑指offer;

import java.util.ArrayList;
import java.util.List;


/**
 * 这个题目说的是，给你一个 m x n 的矩阵，你要对它进行螺旋遍历，然后返回遍历结果。
 *比如说给你的矩阵 a 是：

 1, 2, 3
 4, 5, 6
 7, 8, 9

 螺旋遍历它得到：

 1, 2, 3, 6, 9, 8, 7, 4, 5

 因此你要返回以上序列。
 */
public class _54螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {

        if(matrix==null || matrix.length==0 || matrix[0]==null ||
                matrix[0].length==0) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        int top = 0,bottom = matrix.length-1,left = 0,right = matrix[0].length-1;

        while (true){
            for (int i = left; i <=right; i++) res.add(matrix[top][i]);
            if(++top>bottom) break;

            for (int i = top; i <=bottom; i++) res.add(matrix[i][right]);
            if(--right<left) break;

            for (int i = right; i >=left; i--) res.add(matrix[bottom][i]);
            if(top> --bottom) break;

            for (int i = bottom; i >=top; i--) res.add(matrix[i][left]);
            if(++left>right) break;

        }




        return res;
    }
}
