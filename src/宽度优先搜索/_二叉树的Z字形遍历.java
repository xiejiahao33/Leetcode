package 宽度优先搜索;


import java.util.*;

/**
 * 这个题目说的是，给你一棵二叉树，要求你从根节点到叶子节点一层一层地进行 Z 字形遍历，
 * 也就是先从左向右访问一层节点，然后从右向左访问下一层节点。
 * 以这样的方式交替去访问二叉树上每一层节点，并且将访问的结果以二维数组的形式返回。
 * 比如说，给你的二叉树是：
 *
 *   1
 *  / \
 * 2   4
 *    / \
 *   8  16
 *
 * 它的 Z 字形遍历结果是：
 *
 * [
 *  [1],
 *  [4, 2],
 *  [8, 16]
 * ]
 */
public class _二叉树的Z字形遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        if(root==null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean right2left = false;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> tmp  = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node  = q.poll();
                tmp.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }

            if(right2left) Collections.reverse(tmp);
            result.add(tmp);
            right2left=!right2left;
        }
        return result;
    }
}
