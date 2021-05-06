package 二叉树;


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


public class _101二叉树是否堆成 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;

        return isSymmetricHelp(root.left,root.right);
    }

    boolean isSymmetricHelp(TreeNode s,TreeNode t){
        if(s!=null && t!=null)
            return s.val==t.val && isSymmetricHelp(s.left,t.right) && isSymmetricHelp(s.right,t.left);
        else return s==null && t==null;
    }
}
