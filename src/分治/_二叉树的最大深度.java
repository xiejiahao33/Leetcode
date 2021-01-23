package 分治;


/**
 * 给定一个二叉树，找出其最大深度。

 二叉树的深度为根节点到最远叶子节点的距离。

 样例
 样例 1:

 输入: tree = {}
 输出: 0
 样例解释: 空树的深度是0。
 样例 2:

 输入: tree = {1,2,3,#,#,4,5}
 输出: 3
 样例解释: 树表示如下，深度是3
 1
 / \
 2   3
 / \
 4   5
 */
public class _二叉树的最大深度 {

    public class TreeNode {
     public int val;
     public TreeNode left, right;
     public TreeNode(int val) {
         this.val = val;
         this.left = this.right = null;
    }
 }

    //分治算法
    public int maxDepth(TreeNode root) {
        // write your code here
        if(root==null) return 0;

        //divide
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        //merge
        return Math.max(left,right)+1;


    }

    //遍历算法
    private int depth; //存储全局的最大深度

    /**
     *
     * @param node 当前节点
     * @param curDepth  当前深度
     */
    private void helper(TreeNode node,int curDepth){
        if(node==null) return;

        if(curDepth>depth){
            depth = curDepth;
        }

        helper(node.left,curDepth+1);
        helper(node.right,curDepth+1);
    }


    public int maxDepthTraverse(TreeNode root){
        depth = 0;
        helper(root,1);
        return depth;
    }


}
