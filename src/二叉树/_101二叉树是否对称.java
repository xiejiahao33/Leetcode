package 二叉树;


import java.util.Stack;

/**
 * 比如说，给你的二叉树是：

    1
  /   \
  2    2
 / \  / \
 4  8 8  4

 这棵二叉树是沿中轴线对称的，因此要返回 true。如果我去掉最后这个 4：

    1
  /   \
  2    2
 / \   /
 4  8 8

 就不对称了，这时就要返回 false。
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class _101二叉树是否对称 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;

        return isSymmetricHelp(root.left,root.right);
    }

    boolean isSymmetricHelp(TreeNode s,TreeNode t){
        if(s!=null && t!=null)
            return s.val==t.val && isSymmetricHelp(s.left,t.right) && isSymmetricHelp(s.right,t.left);
        else return s==null && t==null;
    }



    //非递归的解法
    public boolean isSymmetricIteration(TreeNode root) {
        if (root==null) return true;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);

        while (!stack.isEmpty()){
            TreeNode s = stack.pop(),t = stack.pop();
            if(s==null && t==null) continue;
            if(s==null || t==null) return  false;
            if(s.val!=t.val) return false;

            stack.push(s.left);
            stack.push(t.right);
            stack.push(s.right);
            stack.push(t.left);
        }
        return true;
    }

}
