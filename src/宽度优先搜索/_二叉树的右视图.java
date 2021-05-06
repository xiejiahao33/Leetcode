package 宽度优先搜索;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 样例
 * 样例1
 *
 * 输入: {1,2,3,#,5,#,4}
 * 输出: [1,3,4]
 * 说明:
 *    1
 *  /   \
 * 2     3
 *  \     \
 *   5     4
 * 样例2
 *
 * 输入: {1,2,3}
 * 输出: [1,3]
 * 说明:
 *    1
 *  /   \
 * 2     3
 */
public class _二叉树的右视图 {
    public List<Integer> rightSideView(TreeNode root) {
        // write your code here
        if(root==null) return new ArrayList<Integer>();
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            result.add(q.peek().val);
            for (int i=0;i<size ;i++ ){
                TreeNode node = q.poll();
                if(node.right!=null) q.add(node.right);
                if(node.left!=null) q.add(node.left);
            }
        }
        return result;
    }
}
