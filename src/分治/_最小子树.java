package 分治;


/**
 * 给一棵二叉树, 找到和为最小的子树, 返回其根节点。输入输出数据范围都在int内。
 * 样例 1:
 *
 * 输入:
 * {1,-5,2,1,2,-4,-5}
 * 输出:1
 * 说明
 * 这棵树如下所示：
 *      1
 *    /   \
 *  -5     2
 *  / \   /  \
 * 1   2 -4  -5
 * 整颗树的和是最小的，所以返回根节点1.
 * 样例 2:
 *
 * 输入:
 * {1}
 * 输出:1
 * 说明:
 * 这棵树如下所示：
 *    1
 * 这棵树只有整体这一个子树，所以返回1.
 */
public class _最小子树 {


    private TreeNode subtree = null;
    private int subtreeSum = Integer.MAX_VALUE;

    public TreeNode findSubtree(TreeNode root) {
        helper(root);
        return subtree;
    }

    private int helper(TreeNode root){
        if(root==null){
            return 0;
        }

        //分而治之
        int sum = helper(root.left) +  helper(root.right) + root.val;
        if(sum< subtreeSum){
            subtreeSum = sum;
            subtree = root;
        }
        return sum;
    }
}
