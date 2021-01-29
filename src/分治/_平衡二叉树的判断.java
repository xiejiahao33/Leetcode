package 分治;


import java.util.Map;

/**
 * 描述
 * 这个题目说的是，给你一棵二叉树，你要判断它是否平衡。
 * 这里平衡指的是，对于树上任意一个节点，它的两棵子树的高度差不能大于 1。
 *
 * 比如说，给你的二叉树是：
 *
 *      1
 *    /   \
 *   2     4
 *        / \
 *       8  16
 *
 * 它的任意节点的左右子树高度差都不大于 1，因此它是一棵平衡二叉树。
 *
 * 再比如说，给你的二叉树是：
 *
 *      1
 *    /   \
 *   2     4
 *          \
 *           8
 *            \
 *            16
 *
 * 在这棵树中，根节点的左右子树高度差为 2，因此它不是一棵平衡二叉树。
 */


class ResultType{
    public boolean isBalanced;
    public int maxDepth;

    public ResultType(boolean isBalanced, int maxDepth) {
        this.isBalanced = isBalanced;
        this.maxDepth = maxDepth;
    }
}


public class _平衡二叉树的判断 {



    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }


    private ResultType helper(TreeNode root){
        if(root==null) return new ResultType(true,0);

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        if(!left.isBalanced || !right.isBalanced ) return new ResultType(false,-1);


        if(Math.abs(left.maxDepth-right.maxDepth)>1){
            return new ResultType(false,-1);
        }

        int depth = Math.max(left.maxDepth,right.maxDepth)+1;

        return new ResultType(true,depth);

    }
}
