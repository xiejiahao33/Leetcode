package 二叉树;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 先中序遍历左子树，再访问根节点，再中序遍历右子树
 *
 * 比如说，给你的二叉树是：

   1
 /   \
 2    3
 \
  4
 /
 5

 你要返回的中序遍历结果是：2, 5, 4, 1, 3
 */
public class _中序遍历_ {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //递归写法
    private void inorder(TreeNode root, List<Integer> result){
        if (root==null) return;
        inorder(root.left,result);
        result.add(root.val);
        inorder(root.right,result);
    }

    public List<Integer> inorderTraversalRecursive1(TreeNode root){
        List<Integer> result = new ArrayList<>();
        inorder(root,result);
        return result;
    }

    //迭代写法
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> result = new ArrayList<>();

        while (!s.isEmpty() || root!=null ){
            while (root!=null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            result.add(root.val);
            root = root.right;

        }


        return result;
    }

    //分治写法
    public List<Integer> inorderTraversalRecursive2(TreeNode root) {

        if(root==null) return new ArrayList<>();

        List<Integer> left = inorderTraversalRecursive2(root.left);
        List<Integer> right= inorderTraversalRecursive2(root.right);

        left.add(root.val);
        left.addAll(right);

        return left;
    }

}
