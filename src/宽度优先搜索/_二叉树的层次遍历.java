package 宽度优先搜索;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给出一棵二叉树，返回其节点值的层次遍历（逐层从左往右访问）
 *
 * Example
 * 样例 1:
 *
 * 输入：{1,2,3}
 * 输出：[[1],[2,3]]
 * 解释：
 *    1
 *   / \
 *  2   3
 * 它将被序列化为{1,2,3}
 * 层次遍历
 * 样例 2:
 *
 * 输入：{1,#,2,3}
 * 输出：[[1],[2],[3]]
 * 解释：
 * 1
 *  \
 *   2
 *  /
 * 3
 * 它将被序列化为{1,#,2,3}
 * 层次遍历
 * Challenge
 * 挑战1：只使用一个队列去实现它
 *
 * 挑战2：用BFS算法来做
 */
public class _二叉树的层次遍历 {

    private static final int flag = 1;
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here

        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = q.size();
            for (int i =0; i<size ; i++ ){
                TreeNode node  = q.poll();
                tmp.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            result.add(tmp);
        }

        return result;
    }

    public static void main(String[] args) {
//        String s= "hello";
//        String t = new String("hello");
//        char c [] = {'h','e','l','l','o'};
//        System.out.println(t.equals(c));
        for(int i=0;i<100;i++){
            System.out.println();
        }
    }


}
